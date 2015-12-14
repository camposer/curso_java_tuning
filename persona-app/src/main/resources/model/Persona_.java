package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-09T16:50:05.131+0200")
@StaticMetamodel(Persona.class)
public class Persona_ {
	public static volatile SingularAttribute<Persona, Integer> id;
	public static volatile SingularAttribute<Persona, String> apellido;
	public static volatile SingularAttribute<Persona, Date> fechaNacimiento;
	public static volatile SingularAttribute<Persona, String> nombre;
	public static volatile ListAttribute<Persona, Ordenador> ordenadores;
}
