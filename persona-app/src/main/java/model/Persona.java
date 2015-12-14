package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the PERSONA database table.
 * 
 */
@Entity
@Table(name="PERSONA")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=50)
	private String apellido;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to Ordenador
	@OneToMany(mappedBy="persona")
	private List<Ordenador> ordenadores;

	public Persona() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ordenador> getOrdenadores() {
		return this.ordenadores;
	}

	public void setOrdenadores(List<Ordenador> ordenadores) {
		this.ordenadores = ordenadores;
	}

	public Ordenador addOrdenadore(Ordenador ordenadore) {
		getOrdenadores().add(ordenadore);
		ordenadore.setPersona(this);

		return ordenadore;
	}

	public Ordenador removeOrdenadore(Ordenador ordenadore) {
		getOrdenadores().remove(ordenadore);
		ordenadore.setPersona(null);

		return ordenadore;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", nombre="
				+ nombre + ", ordenadores=" + ordenadores + "]";
	}

}