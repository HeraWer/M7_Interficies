package ciudades;

public class DatosCiudades {
	
	public String nombre="";
	public String provincia="";
	public Float habitantes;
	public Float metro2;
	
	// Constructos de datos ciudades.
	public DatosCiudades(String nombre, String provincia, Float habitantes, Float metro2) {
		this.nombre=nombre;
		this.provincia=provincia;
		this.habitantes=habitantes;
		this.metro2=metro2;
	}
	
	// Constructor vacio.
	public DatosCiudades() {
	}
}