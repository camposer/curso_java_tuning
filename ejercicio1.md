# Ejercicio 1: Profiling

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

6.- De qué forma podría detectar un cuello de botella en `persona-web` ocasionado por la Base de Datos?

- Proponga su propuesta utilizando `jvisualvm`

7.- Cómo puede medir el rendimiento de las aplicaciones `persona-app` y `persona-web` desplegadas en una máquina remota.

- Utilice el ordenador de su compañero de al lado
- Las opciones de JMX las puede conseguir en el [siguiente artículo](http://blog.mattwoodward.com/2009/11/monitoring-tomcat-with-java-visualvm.html)

8.- Perfilar el Contenedor de Servlets (Tomcat) con [PSI Probe](https://github.com/psi-probe/psi-probe)

- Si desea controlar el Tomcat desde Eclipse, deberá crear un nuevo sevidor y configurar (haciendo doble clic sobre éste) la opción: Use tomcat installation (takes control of Tomcat installation)
- Para compilar: `mvn install -DskipTests`
- Las instrucciones de instalación las puede conseguir en la [wiki del proyecto](https://github.com/psi-probe/psi-probe/wiki)

9.- Perfilar la aplicación `persona-web` con [MessAdmin](http://messadmin.sourceforge.net/)

- Entre *PSI Probe* y *MessAdmin* cuál utilizaría dependiendo de cada caso?
