package dao;

import java.util.List;

public interface GenericDao<E, K> {
	void agregar(E entidad);
	void modificar(E entidad);
	void eliminar(K id);
	E obtener(K id);
	List<E> obtenerTodos();
}
