package web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Persona;
import service.PersonaService;
import web.editor.DateEditor;
import web.form.PersonaForm;
import web.validator.PersonaFormValidator;

@Controller
@RequestMapping("/persona*")
public class PersonaController {
	public static String RUTA_JSP = "/WEB-INF/jsp/persona/inicio.jsp";
	
	@Autowired
	private PersonaService personaService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private DateEditor dateEditor;
	@Autowired
	private PersonaFormValidator personaFormValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, dateEditor);
		binder.addValidators(personaFormValidator);
	}
	
	@ModelAttribute("personaForm")
	public PersonaForm getPersonaForm() {
		return new PersonaForm();
	}
	
	private void init(Model model) {
		model.addAttribute("personas", personaService.obtenerPersonas());
	}

	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String listar(Model model) {
		init(model);
		return RUTA_JSP;
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardar(
			Model model,
			@Valid @ModelAttribute("personaForm") PersonaForm personaForm, 
			BindingResult result) {
		
		if (!result.hasErrors()) {
			try {
				Persona p = modelMapper.map(personaForm, Persona.class);
				
				if (p.getId() != null)
					personaService.modificarPersona(p);
				else
					personaService.agregarPersona(p);
			} catch (Exception e) {
				e.printStackTrace();
				result.rejectValue("bd", null, "Error al guardar en la BD");
			}
		}
		
		if (!result.hasErrors())
			return "redirect:/persona/inicio.do";
		else {
			init(model);
			return RUTA_JSP;
		}
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	public String eliminar(@RequestParam Integer id, Model model) {
		List<String> errores = new ArrayList<>();
		
		try {
			personaService.eliminarPersona(id);
		} catch (Exception e) {
			e.printStackTrace();
			errores.add("Error al eliminar la persona de la BD");
		}
		
		if (errores.size() == 0) 
			return "redirect:/persona/inicio.do";
		else {
			init(model);
			model.addAttribute("errores", errores);
			return RUTA_JSP;
		}
	}

	@RequestMapping(value = "/mostrar", method = RequestMethod.GET)
	public String mostrar(@RequestParam Integer id, Model model) {
		List<String> errores = new ArrayList<>();
		
		try {
			Persona p = personaService.obtenerPersona(id);
			model.addAttribute(
					"personaForm",
					modelMapper.map(p, PersonaForm.class));
		} catch (Exception e) {
			e.printStackTrace();
			errores.add("Error al consultar persona de la BD");
		}
		
		if (errores.size() > 0) 
			model.addAttribute("errores", errores);

		init(model);
		return RUTA_JSP;
	}

}
