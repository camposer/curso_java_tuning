package dao;

import org.springframework.stereotype.Repository;

import model.Ordenador;

@Repository
public class OrdenadorDaoImpl 
		extends GenericDaoImpl<Ordenador, Integer>
		implements OrdenadorDao {

}
