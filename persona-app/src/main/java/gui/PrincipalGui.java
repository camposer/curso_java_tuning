package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.Persona;
import service.PersonaService;

@Component
@Transactional // Mantendrá la sesión abierta en esta clase y no fallará al listar los ordenadores de la persona
public class PrincipalGui {
	private static final int AGREGAR = 0;
	private static final int MODIFICAR = 1;
	private static final String PATRON = "yyyy-MM-dd";
	private Scanner scanner;
	
	@Autowired
	private PersonaService personaService;
	
	public PrincipalGui() {
		this.scanner = new Scanner(System.in);
	}
	
	public void iniciar() {
		while (true) {
			System.out.println();
			System.out.println("1. Agregar");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Listar");
			System.out.println("5. Salir");
			
			String opcion = scanner.nextLine();
			
			if (opcion.equals("1"))
				guardar(AGREGAR);
			else if (opcion.equals("2"))
				guardar(MODIFICAR);
			else if (opcion.equals("3"))
				eliminar();
			else if (opcion.equals("4"))
				listar();
			else if (opcion.equals("5"))
				break;

		}
	}

	private void eliminar() {
		System.out.print("Id? ");
		Integer id = Integer.parseInt(scanner.nextLine());
		
		personaService.eliminarPersona(id);
	}

	private void listar() {
		List<Persona> personas = personaService.obtenerPersonas();
		
		if (personas != null) for (Persona p : personas)
			System.out.println(p);
	}

	private void guardar(int operacion) {
		Persona p = new Persona();
		
		if (operacion == MODIFICAR) {
			System.out.print("Id? ");
			p.setId(Integer.parseInt(scanner.nextLine()));
		}
		
		System.out.print("Nombre? ");
		p.setNombre(scanner.nextLine());
		System.out.print("Apellido? ");
		p.setApellido(scanner.nextLine());
		System.out.print("Fecha de nacimiento? ");
		try {
			p.setFechaNacimiento(new SimpleDateFormat(PATRON)
					.parse(scanner.nextLine()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if (operacion == AGREGAR)
			personaService.agregarPersona(p);
		else if (operacion == MODIFICAR)
			personaService.modificarPersona(p);
		
	}
}
