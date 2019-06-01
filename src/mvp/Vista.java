package mvp;

import static keyboard.Keyboard.*;
import java.util.concurrent.TimeUnit;

import baseDeDatos.Movimiento;
import keyboard.Keyboard.Limit;
import proyectoPokemon.Entrenador;
import proyectoPokemon.Pokemon;


public class Vista implements PresentadorVista{
	
	public String pedirNombreUsuario() {
		String nombre;
		boolean aceptar = false;
		
		efectoEscrito("Hola, bienvenido al mundo pokemon. Antes de empezar con tu primer combate dime...", 30);
		pausaDramatica();
		do {
		efectoEscrito("\n¿cuál es tu nombre?\n", 30);
		nombre = readString();
		
		efectoEscrito("\nAh... ¿así que te llamas " + nombre + "?", 30);
		aceptar = readBoolean("");
		}while(!aceptar);
		
		return nombre;
	}
	
	public String pedirNombreMaquina() {
		String nombre;
		
		efectoEscrito("\nEste es tu rival. ¿Cómo decias que se llamaba?\n", 30);
		nombre = readString();
		pausaDramatica();
		efectoEscrito("Es cierto, se llamaba " + nombre + ".\n", 30);
		pausaDramatica();
		
		return nombre;
	}
	
	public void presentacionCombate(String nombreUsuario, String nombreRival) {
		boolean reglas = false;
		
		efectoEscrito("\nVuestra aventura pokemon está a punto de comenzar."
				+ "\nA continuación recibireis cada uno tres pokemon "
				+ "\naleatorios y luchareis entre vosotros. " + nombreUsuario + ","
				+ "\n" + nombreRival + ", os deseo mucha suerte en vuestra aventura.\n", 30);
		pausaDramatica(); 
		pausaDramatica();
		
		efectoEscrito("\nESPERAR!!!", 10);
		pausaDramatica();
		efectoEscrito("\nCasi lo olvido. Antes de que cojais a vuestros pokemon y "
				+ "\nos pongais a luchar, ¿quereis que os recuerde"
				+ "\nlas reglas de un combate pokemon?", 30);
		reglas = readBoolean("");
		
		if(reglas) {
			leerReglas();
		}
		
		efectoEscrito("\nEso es todo. Ya podeis coger vuestros pokemon.\n", 30);
		pausaDramatica();
	}
	
	private void leerReglas() {
		efectoEscrito("Viene bien repasar lo básico de vez en cuando...", 30);
		pausaDramatica();
		efectoEscrito("\nCada entrenador cuenta con tres pokemon, el primer pokemon"
				+ "\nde cada uno será el que salga a luchar en primer lugar."
				+ "\nCada pokemon tiene 4 ataques que pueden herir o hacer cambiar de"
				+ "\nestado al rival. Si un pokemon pierde toda su salud se debilitará"
				+ "\ny no podrá continuar peleando. El primer entrenador en quedarse sin"
				+ "\npokemon perderá el combate.\n", 30);
		pausaDramatica();
	}
	
	public void mostrarInicioCombate(Entrenador usuario, Entrenador rival) {
		efectoEscrito("\nComienza el combate entre " + usuario.getNombre() + " y " + rival.getNombre() + "\n", 30);
		pausaDramatica();
		efectoEscrito("\nHas sacado a " + mostrarNombrePokemon(usuario.getPokemonCombatiente()) + "\n", 30);
		efectoEscrito("\n" + rival.getNombre() + " ha sacado a " 
				+ mostrarNombrePokemon(rival.getPokemonCombatiente()) + "\n", 30);
	}
	
	public void mostrarListaPokemon(Entrenador entrenador) {
		int contador = 1;
		
		System.out.printf("%nPokemon de %s:%n", entrenador.getNombre());
		for(Pokemon e : entrenador.getListaPokemon()) {
			System.out.printf("%d [%s]%n", contador, mostrarNombrePokemon(e));
			contador++;
		}
	}

	public String mostrarNombrePokemon(Pokemon pokemon) {
		return String.format("[%s]", pokemon.getEspecie().getNombre());
	}
	
	public String mostrarVidaPokemon(Pokemon pokemon) {
		return String.format("[%d / %d]", pokemon.getVida(), pokemon.getEspecie().getVida());
	}
	
	public String mostrarEstadoPokemon(Pokemon pokemon) {
		return String.format("[%s]", pokemon.getEstado());
	}
	
	public String mostrarDatosPokemon(Pokemon pokemon) {
		return String.format("%s %s %s", mostrarNombrePokemon(pokemon)
				,mostrarEstadoPokemon(pokemon)
				,mostrarVidaPokemon(pokemon));
	}
	
	public void mostrarMensajeRendirse() {
		efectoEscrito("Te has rendido y has perdido el combate", 30);
	}
	
	public void mostrarMensajeCambio(Entrenador entrenador) {
		efectoEscrito(entrenador.getNombre() + " guarda a su pokemon y saca a " 
				+ mostrarNombrePokemon(entrenador.getPokemonCombatiente()), 30);
	}
	
	
	/*MENUS DEL JUEGO*/
	public int ejecutarMenuCombate(Entrenador usuario, Entrenador rival) {
		System.out.printf("%nTu pokemon: %s%n %nPokemon rival: %s%n"
				,mostrarDatosPokemon(usuario.getPokemonCombatiente())
				,mostrarDatosPokemon(rival.getPokemonCombatiente()));
		
		System.out.printf("%n¿Que quieres hacer?"
				+ "%n1. Luchar"
				+ "%n2. Cambiar pokemon"
				+ "%n3. Rendirse%n");
		
		return readNumberInRange(1, 3, Limit.MAX_MIN_INCLUDED);
	}
	
	public Movimiento ejecutarMenuMovimientos(Pokemon pokemon) {
		int opcion;
		
		System.out.printf("%nAtaques de %s:", mostrarNombrePokemon(pokemon));
		for(Movimiento e : pokemon.getEspecie().getMovimientos()) {
			System.out.printf("%n%s", e.getNombre());
		}
		
		opcion = readNumberInRange(1, 4, Limit.MAX_MIN_INCLUDED);
		
		return pokemon.getEspecie().getMovimientos().get(opcion);
	};
	
	public Pokemon ejecutarMenuCambiarPokemon(Entrenador usuario) {
		int opcion;
		
		System.out.printf("%n¿Qué pokemon quieres sacar?"); 
		mostrarListaPokemon(usuario);

		opcion = readNumberInRange(1, usuario.getListaPokemon().size(), Limit.MAX_MIN_INCLUDED);
		
		return usuario.getListaPokemon().get(opcion-1);
	}
	
	
	/*OTROS METODOS*/
	/*Metodo para escribir el texto letra por letra*/
	private void efectoEscrito(String texto, long milisegundos) {
		for(int i=0; i<texto.length(); i++) {
			System.out.printf("%s", texto.charAt(i));
			try {
				TimeUnit.MILLISECONDS.sleep(milisegundos);
			}
			catch(InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*Metodo para hacer una pausa*/
	private void pausaDramatica() {
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
