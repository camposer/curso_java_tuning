package dao;

import java.util.List;

import model.Persona;

public interface PersonaDao extends GenericDao<Persona, Integer> {
	Pagina<Persona> obtenerTodos(int offset, int limit);
}
