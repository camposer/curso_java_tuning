package dao;

import org.springframework.stereotype.Repository;

import model.Persona;

@Repository
public class PersonaDaoImpl 
		extends GenericDaoImpl<Persona, Integer> 
		implements PersonaDao {

}
