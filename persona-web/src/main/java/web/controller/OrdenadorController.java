package web.controller;

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

import model.Ordenador;
import model.Persona;
import service.OrdenadorService;
import service.PersonaService;
import web.form.OrdenadorForm;
import web.validator.OrdenadorFormValidator;

@Controller
@RequestMapping("/ordenador*")
public class OrdenadorController {
	private static final String RUTA_JSP = "/WEB-INF/jsp/ordenador/inicio.jsp";
	
	@Autowired
	private PersonaService personaService;
	@Autowired
	private OrdenadorService ordenadorService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private OrdenadorFormValidator ordenadorFormValidator;
	
	private void init(Model model) {
		model.addAttribute("personas", personaService.obtenerPersonas());
		model.addAttribute("ordenadores", ordenadorService.obtenerOrdenadores());
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(ordenadorFormValidator);
	}
	
	@ModelAttribute("ordenadorForm")
	public OrdenadorForm getOrdenadorForm() {
		return new OrdenadorForm();
	}
	
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String inicio(Model model) {
		init(model);
		return RUTA_JSP;
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardar(
			Model model,
			@Valid @ModelAttribute("ordenadorForm") OrdenadorForm ordenadorForm, 
			BindingResult result) {
		
		if (!result.hasErrors()) {
			try {
				Ordenador o = modelMapper.map(ordenadorForm, Ordenador.class);
				o.setPersona(new Persona(ordenadorForm.getPersonaId()));
				
				if (o.getId() != null)
					ordenadorService.modificarOrdenador(o);
				else
					ordenadorService.agregarOrdenador(o);
			} catch (Exception e) {
				e.printStackTrace();
				result.rejectValue("bd", null, "Error al guardar en la BD");
			}
		}
		
		if (!result.hasErrors())
			return "redirect:/ordenador/inicio.do";
		else {
			init(model);
			return RUTA_JSP;
		}
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	public String eliminar(Model model,
			@RequestParam Integer id,
			@ModelAttribute("ordenadorForm") OrdenadorForm ordenadorForm, // Cada vez que quiero utlilzar el binding result  
			BindingResult result) {
		
		try {
			ordenadorService.eliminarOrdenador(id);
		} catch (Exception e) {
			e.printStackTrace();
			result.rejectValue("bd", null, "Error al eliminar el ordenador de la BD");
		}
		
		if (!result.hasErrors()) 
			return "redirect:/ordenador/inicio.do";
		else {
			init(model);
			return RUTA_JSP;
		}
	}
	
	@RequestMapping(value = "/mostrar", method = RequestMethod.GET)
	public String mostrar(Model model,
			@RequestParam Integer id,
			@ModelAttribute("ordenadorForm") OrdenadorForm ordenadorForm, // Cada vez que quiero utlilzar el binding result  
			BindingResult result) {
		
		try {
			Ordenador o = ordenadorService.obtenerOrdenador(id);
			
			ordenadorForm = 
					modelMapper.map(o, OrdenadorForm.class);
			ordenadorForm.setPersonaId(o.getPersona().getId());
			model.addAttribute("ordenadorForm", ordenadorForm);
		} catch (Exception e) {
			e.printStackTrace();
			result.rejectValue("bd", null, "Error al consulta el ordenador de la BD");
		}
		
		init(model);
		return RUTA_JSP;
	}
}
