package rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Ordenador;
import rest.to.GetOrdenadoresResponse;
import rest.to.PostOrdenadorRequest;
import rest.to.PutOrdenadorRequest;
import service.OrdenadorService;

@RestController
@RequestMapping("/ordenadores*")
public class OrdenadorRestController {
	@Autowired
	private OrdenadorService ordenadorService;
	@Autowired
	private ModelMapper modelMapper;

	/*
	 * GET /ordenadores
	 * Accept: application/json
	 */
	@RequestMapping(method = RequestMethod.GET,
			produces = {"application/json", "text/xml"})
	public @ResponseBody GetOrdenadoresResponse obtenerOrdenadores() {
		Type listType = new TypeToken<List<GetOrdenadoresResponse.Ordenador>>() {}.getType();
		List<GetOrdenadoresResponse.Ordenador> ordenadores = 
				modelMapper.map(ordenadorService.obtenerOrdenadores(), listType);

		return new GetOrdenadoresResponse(ordenadores);
	}
	
	/*
	 * DELETE /ordenadores/1
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		ordenadorService.eliminarOrdenador(id);
	}

	/*
	 * POST /ordenadores
	 * Content-Type: application/json
	 * {
	 * "nombre": "uno",
	 * "apellido": "uno",
	 * "persona": {
	 *   "id": 1
	 * }
	 * }
	 */
	@RequestMapping(method = RequestMethod.POST,
			consumes = "application/json")
	public void agregar(@RequestBody PostOrdenadorRequest request) {
		Ordenador o = modelMapper.map(request, Ordenador.class);
		ordenadorService.agregarOrdenador(o);
	}

	/*
	 * PUT /ordenadores/1
	 * Content-Type: application/json
	 * {
	 * "nombre": "uno",
	 * "apellido": "uno",
	 * "persona": {
	 *   "id": 1
	 * }
	 * }
	 */
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.PUT,
			consumes = "application/json")
	public void modificar(
			@PathVariable Integer id,
			@RequestBody PutOrdenadorRequest request) {
		Ordenador o = modelMapper.map(request, Ordenador.class);
		o.setId(id);
		ordenadorService.modificarOrdenador(o);
	}
}





