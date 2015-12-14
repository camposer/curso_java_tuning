package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import model.Persona;

@Controller
public class HolaMundoController {

	@RequestMapping("/holaMundo")
	public @ResponseBody String holaMundo() {
		return "Hola mundo";
	}
	
	@RequestMapping("/holaMundo1")
	public void holaMundo1(HttpServletResponse response) throws IOException {
		response.getWriter().println("Hola mundo");
	}

	@RequestMapping("/holaMundo2")
	public void holaMundo2(
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String nombre = request.getParameter("nombre");
		response.getWriter().println("Hola " + nombre);
	}

	@RequestMapping("/holaMundo3")
	public @ResponseBody String holaMundo3(@RequestParam String nombre) throws IOException {
		return "Hola " + nombre;
	}

	@RequestMapping("/holaMundo4")
	public String holaMundo4(
			@RequestParam String nombre, 
			Model model) throws IOException {
		
		model.addAttribute("nombre", nombre);
		return "/WEB-INF/jsp/holaMundo.jsp";
	}

	@RequestMapping("/holaMundo5")
	public ModelAndView holaMundo5(
			@RequestParam String nombre,
			HttpServletRequest request) throws IOException {
		return new ModelAndView("/WEB-INF/jsp/holaMundo.jsp", 
				"nombre", nombre);
	}

	@RequestMapping("/holaMundo6")
	public ModelAndView holaMundo6(Persona persona) throws IOException {
		return new ModelAndView("/WEB-INF/jsp/holaMundo.jsp", 
				"nombre", persona.getNombre());
	}

}
