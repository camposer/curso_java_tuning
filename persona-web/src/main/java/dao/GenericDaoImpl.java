package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDaoImpl<E, K> implements GenericDao<E, K> {
	@PersistenceContext
	protected EntityManager entityManager;
	protected Class<E> entidadClase;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		entidadClase = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void agregar(E entidad) {
		entityManager.persist(entidad);
	}

	@Override
	public void modificar(E entidad) {
		entityManager.merge(entidad);
	}

	@Override
	public void eliminar(K id) {
		E entidad = obtener(id);
		entityManager.remove(entidad);
	}

	@Override
	public E obtener(K id) {
		return entityManager.find(entidadClase, id);
	}

	@Override
	public List<E> obtenerTodos() {
		String query = "from " + entidadClase.getSimpleName() + " e";
		
		return entityManager
				.createQuery(query, entidadClase)
				.getResultList();
	}

}
