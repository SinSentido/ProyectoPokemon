package proyectoPokemon;

public class Main {
	public static void main(String[] args) {
		Entrenador usuario = new Usuario();
		Entrenador rival= new Maquina(); 
		Combate combate = new Combate();
		
		combate.empezarCombate(usuario, rival);
	}
}
