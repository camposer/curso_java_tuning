package rest.to;

import java.util.List;

public class GetOrdenadoresResponse extends Response {
	
	public GetOrdenadoresResponse(List<Ordenador> ordenadores) {
		super(Response.Status.SUCCESS);
		setData(ordenadores);
	}
	
	public static class Ordenador {
		private Integer id;
		private String nombre;
		private String serial;
		private Persona persona;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getSerial() {
			return serial;
		}
		public void setSerial(String serial) {
			this.serial = serial;
		}
		public Persona getPersona() {
			return persona;
		}
		public void setPersona(Persona persona) {
			this.persona = persona;
		}
	}
	
	public static class Persona {
		private Integer id;
		private String nombre;

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	}
}
