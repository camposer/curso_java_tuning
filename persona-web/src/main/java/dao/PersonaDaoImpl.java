package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Persona;

@Repository
public class PersonaDaoImpl 
		extends GenericDaoImpl<Persona, Integer> 
		implements PersonaDao {

	@SuppressWarnings("unchecked")
	@Override
	public Pagina<Persona> obtenerTodos(int offset, int limit) {
		String query = "from Persona p";
		
		List<Persona> personas = entityManager
				.createQuery(query, entidadClase)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.getResultList();
		
		query = "select count(p) from Persona p";
		
		Long count = entityManager
				.createQuery(query, Long.class)
				.getSingleResult();
		
		return new Pagina(personas, count);
		
	}

}
