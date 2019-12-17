package examen_uf1;

public class Alumno {

	private String Apellido1;
	private String Apellido2;
	private String Nombre;
	private String telefono;
	private String curso;
	
	
	public Alumno(String apellido1, String apellido2, String nombre, String telefono, String curso) {
		super();
		Apellido1 = apellido1;
		Apellido2 = apellido2;
		Nombre = nombre;
		this.telefono = telefono;
		this.curso = curso;
	}


	public String getApellido1() {
		return Apellido1;
	}


	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}


	public String getApellido2() {
		return Apellido2;
	}


	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	@Override
	public String toString() {
		return "Alumno [Apellido1=" + Apellido1 + ", Apellido2=" + Apellido2 + ", Nombre=" + Nombre + ", telefono="
				+ telefono + ", curso=" + curso + "]";
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	
}
