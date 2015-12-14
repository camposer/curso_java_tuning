package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.PersonaDao;
import model.Persona;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {
	@Autowired
	private PersonaDao personaDao;

	@Override
	public void agregarPersona(Persona p) {
		personaDao.agregar(p);
	}

	@Override
	public void modificarPersona(Persona p) {
		personaDao.modificar(p);
	}

	@Override
	public void eliminarPersona(Integer id) {
		personaDao.eliminar(id);
	}

	@Override
	public Persona obtenerPersona(Integer id) {
		return personaDao.obtener(id);
	}

	@Override
	public List<Persona> obtenerPersonas() {
		return personaDao.obtenerTodos();
	}

}
