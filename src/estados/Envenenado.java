package estados;

public class Envenenado implements Estado{
	private String nombre = "Envenenado";
	private int maxTurnosEnv = 5;
	private int contador = 0;
	
	public String getNombre() {
		return nombre;
	}
}
