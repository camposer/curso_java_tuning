package rest.controller;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Persona;
import rest.editor.DateEditor;
import rest.to.GetPersonasResponse;
import rest.to.PostPersonaRequest;
import rest.to.PutPersonaRequest;
import service.PersonaService;

@RestController
@RequestMapping("/personas*")
public class PersonaRestController {
	@Autowired
	private PersonaService personaService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private DateEditor dateEditor;	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	/*
	 * GET /personas
	 * Accept: application/json
	 */
	@RequestMapping(method = RequestMethod.GET,
			produces = {"application/json", "text/xml"})
	public @ResponseBody GetPersonasResponse obtenerPersonas() {
		Type listType = new TypeToken<List<GetPersonasResponse.Persona>>() {}.getType();
		List<GetPersonasResponse.Persona> personas = 
				modelMapper.map(personaService.obtenerPersonas(), listType);

		return new GetPersonasResponse(personas);
	}
	
	/*
	 * DELETE /personas/1
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		personaService.eliminarPersona(id);
	}

	/*
	 * POST /personas
	 * Content-Type: application/json
	 * {
	 * "nombre": "uno",
	 * "apellido": "uno",
	 * "fechaNacimiento": 2000
	 * }
	 */
	@RequestMapping(method = RequestMethod.POST,
			consumes = "application/json")
	public void agregar(@RequestBody PostPersonaRequest request) {
		Persona p = modelMapper.map(request, Persona.class);
		personaService.agregarPersona(p);
	}

	/*
	 * PUT /personas/1
	 * Content-Type: application/json
	 * {
	 * "nombre": "uno",
	 * "apellido": "uno",
	 * "fechaNacimiento": 2000
	 * }
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.PUT,
			consumes = "application/json")
	public void modificar(
			@PathVariable Integer id,
			@RequestBody PutPersonaRequest request) {
		Persona p = modelMapper.map(request, Persona.class);
		p.setId(id);
		personaService.modificarPersona(p);
	}
}





