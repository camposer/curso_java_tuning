package rest.to;

import java.util.List;

public class GetPersonasResponse extends Response {
	
	public GetPersonasResponse(List<Persona> personas) {
		super(Response.Status.SUCCESS);
		super.setData(personas);
	}
	
	public static class Persona {
		private Integer id;
		private String nombre;
		private String apellido;

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
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
	}
}
