package dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import config.DatabaseConfig;
import model.Persona;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@ActiveProfiles("test")
@Transactional
public class PersonaDaoTest {
	@PersistenceContext
	private EntityManager em;

	@Test
	public void agregar() {
		Persona p = new Persona();
		p.setNombre("Juan");
		p.setApellido("Pérez");
		p.setFechaNacimiento(new Date());
		em.persist(p);
		Assert.assertNotNull(p.getId());
	}

	@Test
	public void modificar() {
		Persona p1 = new Persona();
		p1.setNombre("Juan");
		p1.setApellido("Pérez");
		p1.setFechaNacimiento(new Date());
		em.persist(p1);

		Persona p2 = new Persona();
		p2.setId(1);
		p2.setNombre("Juanito");
		p2.setApellido("Pérez Prada");
		em.merge(p2);
		
		p2 = em.find(Persona.class, 1);
		Assert.assertEquals("Juanito", p2.getNombre());
		Assert.assertEquals("Pérez Prada", p2.getApellido());
	}
	
	@Test
	public void eliminar() {
		Persona p = new Persona();
		p.setNombre("Juan");
		p.setApellido("Pérez");
		p.setFechaNacimiento(new Date());
		em.persist(p);
		
		Assert.assertEquals(1, em.createQuery("from Persona p")
				.getResultList().size());

		em.remove(p);
		
		Assert.assertEquals(0, em.createQuery("from Persona p")
				.getResultList().size());
	}
}
