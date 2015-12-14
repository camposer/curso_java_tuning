# Ejercicio 1

1.- Utilizando `jmap` genere un dump de la memoria *heap* de las aplicaciones `persona-app` y `persona-web`. 

- Compare los tamaños
- Utilizando `jhat` extraiga información del dump generado
- Analice el dump utilizando `jvisualvm`

2.- Utilizando `jstack` genere un dump de la memoria *stack* de las aplicaciones `persona-app` y `persona-web`.

- Compare los tamaños
- Utilizando `jhat` extraiga información del dump generado
- Analice el dump utilizando `jvisualvm`

NOTA: Puede observar alguna relación entre ambos dumps?

3.- Cambie el método `eliminar` de `GenericDaoImpl` por la siguiente implementación:

```
	public void eliminar(K id) {
		String jql = "delete from " + entidadClase.getSimpleName()
			+ " t where t.id = " + id;
		javax.persistence.Query q = entityManager
				.createQuery(jql);
		q.executeUpdate();
	}

```

- Cuál implementación es mejor?
- Ver resultados con sampling y profiling

4.- Cambie el método `listar` de `GenericDaoImpl` por la siguiente implementación:

```
	public List<E> obtenerTodos() {
		String query = "SELECT * FROM " + entidadClase.getSimpleName();
		
		return entityManager
				.createNativeQuery(query, entidadClase)
				.getResultList();
	}
```

- Cuál implementación es mejor?
- Ver resultados con sampling y profiling

5.- Si tuviese 80M de personas en BD, cómo podría mejorar el rendimiento de la aplicación? 

- Proponga e implemente su propuesta
- Mida el rendimiento (con pocos resultados)
