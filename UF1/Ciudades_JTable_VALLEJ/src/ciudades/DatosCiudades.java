package ciudades;

public class DatosCiudades {
	
	public String nombre="";
	public String provincia="";
	public int habitantes;
	public int metro2;
	
	// Constructos de datos ciudades.
	public DatosCiudades(String nombre, String provincia, int habitantes, int metro2) {
		this.nombre=nombre;
		this.provincia=provincia;
		this.habitantes=habitantes;
		this.metro2=metro2;
	}
	
	// Constructor vacio.
	public DatosCiudades() {
	}
}