package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-09T16:50:05.014+0200")
@StaticMetamodel(Ordenador.class)
public class Ordenador_ {
	public static volatile SingularAttribute<Ordenador, Integer> id;
	public static volatile SingularAttribute<Ordenador, String> nombre;
	public static volatile SingularAttribute<Ordenador, String> serial;
	public static volatile SingularAttribute<Ordenador, Persona> persona;
}
