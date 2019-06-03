package baseDeDatos;

public class Tipo {
	
	private int id;
	private String nombre;
	
	Tipo(int id, String nombre){
		this.id =id;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
}
