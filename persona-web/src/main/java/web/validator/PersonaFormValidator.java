package web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import web.form.PersonaForm;

@Component
public class PersonaFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(PersonaForm.class);
	}

	@Override
	public void validate(Object obj, Errors errores) {
		PersonaForm personaForm = (PersonaForm) obj; 
		
		if (personaForm.getNombre() == null || 
				personaForm.getNombre().trim().equals(""))
			errores.rejectValue("nombre", null, "Nombre inválido");
		
		if (personaForm.getApellido() == null || 
				personaForm.getApellido().trim().equals(""))
			errores.rejectValue("apellido", null, "Apellido inválido");
	}

}
