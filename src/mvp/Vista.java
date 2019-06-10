package mvp;

import static keyboard.Keyboard.*;
import java.util.concurrent.TimeUnit;

import baseDeDatos.Movimiento;
import keyboard.Keyboard.Limit;
import proyectoPokemon.Entrenador;
import proyectoPokemon.Pokemon;


public class Vista implements PresentadorVista{
	
	/**************************************/
	/***********VISTA ENTRENADOR***********/
	
	/*Metodo para pedir el nombre del usuario al principio*/
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
	
	//Metodo para pedir el nombre del entrenador máquina
	public String pedirNombreMaquina() {
		String nombre;
		
		efectoEscrito("\nEste es tu rival. ¿Cómo decias que se llamaba?\n", 30);
		nombre = readString();
		pausaDramatica();
		efectoEscrito("Es cierto, se llamaba " + nombre + ".\n", 30);
		pausaDramatica();
		
		return nombre;
	}
	
	/*Metodo para que el entrenador usuario elija que hacer en cada turno*/
	public int ejecutarMenuCombate() {
		System.out.printf("%n¿Que quieres hacer?"
				+ "%n1. Luchar"
				+ "%n2. Cambiar pokemon"
				+ "%n3. Rendirse%n");
		
		return readNumberInRange(1, 3, Limit.MAX_MIN_INCLUDED);
	}
	
	/*Metodo para que el entrenador usuario elija que movimiento quiere hacer*/
	public Movimiento ejecutarMenuMovimientos(Pokemon pokemon) {
		int opcion, contador = 1;
		
		System.out.printf("%nAtaques de %s:%n", mostrarNombrePokemon(pokemon));
		for(Movimiento e : pokemon.getEspecie().getMovimientos()) {
			System.out.printf("%d. %s%n",contador, e.getNombre());
			contador++;
		}
		
		opcion = readNumberInRange(1, 4, Limit.MAX_MIN_INCLUDED);
		
		return pokemon.getEspecie().getMovimientos().get(opcion-1);
	};
	
	/*Metodo para que el entrenador usuario elija un pokemon para cambiar*/
	public Pokemon ejecutarMenuCambiarPokemon(Entrenador usuario) {
		int opcion;
		
		System.out.printf("%n¿Qué pokemon quieres sacar?"); 
		mostrarListaPokemon(usuario);

		opcion = readNumberInRange(1, usuario.getListaPokemon().size(), Limit.MAX_MIN_INCLUDED);
		
		return usuario.getListaPokemon().get(opcion-1);
	}
	
	/*Metodo que informa al usuario que está intentando sacar un pokemon debilitado*/
	public void cambiarAPokemonDebilitado() {
		efectoEscrito("No puedes elegir a un pokemon debilitado\n", 30);
	}
	
	/*Metodo que informa al usuario que está intentando sacar al mismo pokemon que está en combate*/
	public void cambiarAMismoPokemon() {
		efectoEscrito("No puedes elegir al mismo pokemon\n", 30);
	}
	
	
	/**********************************/
	/***********VISTA ESTADO***********/
	
	
	/*Dormido*/
	public void mostrarMensajeAtacarDormido(Pokemon pokemon) {
		efectoEscrito(mostrarNombrePokemon(pokemon) + " no puede atacar porque está dormido\n", 30);
	}
	
	public void mostrarMensajeDespertar(Pokemon pokemon) {
		efectoEscrito(mostrarNombrePokemon(pokemon) + " se ha despertado y ya puede atacar\n", 30);
	}
	
	/*Envenenado*/
	public void mostrarMensajeCurarVeneno(Pokemon pokemon) {
		efectoEscrito("\n" + mostrarNombrePokemon(pokemon) + " ya no está envenenado.\n", 30);
	}
	
	public void mostrarMensajeDañoVeneno(Pokemon pokemon) {
		efectoEscrito("\n" + mostrarNombrePokemon(pokemon) + " sufre daño por el veneno.\n", 30);
	}
	
	/*Paralizado*/
	public void mostrarMensajeAtacarParalizado(Pokemon pokemon) {
		efectoEscrito("\n" + mostrarNombrePokemon(pokemon) + " está paralizado y no puede atacar.\n", 30);
	}
	
	
	/*************************************/
	/***********VISTA CATEGORIA***********/
	
	/*Mensaje que se muestra cuando falla un ataque*/
	public void mostrarMensajeFalloAtaque() {
		efectoEscrito("El ataque ha fallado\n", 30);
	}
	
	/*Mensaje que se muestra cuando un ataque duerme a un pokemon*/
	public void mostrarMensajeDormido(Pokemon pokemon) {
		efectoEscrito(mostrarNombrePokemon(pokemon) + " se ha dormido\n", 30);
	}
	
	/*Mensaje que se muestra cuando un ataque envenena a un pokemon*/
	public void mostrarMensajeEnvenenado(Pokemon pokemon) {
		efectoEscrito(mostrarNombrePokemon(pokemon) + " está envenenado\n", 30);
	}
	
	/*Mensaje que se muestra cuando un ataque paraliza a un pokemon*/
	public void mostrarMensajeParalizado(Pokemon pokemon) {
		efectoEscrito(mostrarNombrePokemon(pokemon) + " está paralizado\n", 30);
	}
	
	public void mostrarMensajeDañoAtaque(Pokemon pokemon, double daño) {
		efectoEscrito(mostrarNombrePokemon(pokemon) + " recibe " + (int)daño + " puntos de daño\n", 30);
	}
	
	public void mostrarMensajePokemonDebilitado(Pokemon pokemon) {
		efectoEscrito("\n" + mostrarNombrePokemon(pokemon) + " se ha debilitado\n", 30);
		pausaDramatica();
	}
	
	public void mostrarMensajeYaTieneEstado(Pokemon pokemon) {
		efectoEscrito("\n" + mostrarNombrePokemon(pokemon) + " ya esta " 
				+ pokemon.getEstado().getNombre() + "\n", 30);	
	}
	
	/***********************************/
	/***********VISTA COMBATE***********/
	
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
		efectoEscrito("\n*****Comienza el combate entre " + usuario.getNombre() 
				+ " y " + rival.getNombre() + "*****\n", 30);
		pausaDramatica();
		efectoEscrito("\n" + usuario.getNombre() + " ha sacado a " + mostrarNombrePokemon(usuario.getPokemonCombatiente()) + "\n", 30);
		pausaDramatica();
		efectoEscrito("\n" + rival.getNombre() + " ha sacado a " 
				+ mostrarNombrePokemon(rival.getPokemonCombatiente()) + "\n", 30);
		pausaDramatica();
	}
	
	public void mostrarListaPokemon(Entrenador entrenador) {
		int contador = 1;
		
		System.out.printf("%nPokemon de %s:%n", entrenador.getNombre());
		for(Pokemon e : entrenador.getListaPokemon()) {
			System.out.printf("%d [%s]%n", contador, mostrarNombrePokemon(e));
			contador++;
		}
	}
	
	public void mostrarPokemonLuchando(Entrenador entrenador1, Entrenador entrenador2) {
		System.out.printf("%nPokemon de %s: %s%nPokemon de %s: %s%n"
				,entrenador1.getNombre()
				,mostrarDatosPokemon(entrenador1.getPokemonCombatiente())
				,entrenador2.getNombre()
				,mostrarDatosPokemon(entrenador2.getPokemonCombatiente()));
	}

	public void mostrarMensajeRendirse() {
		efectoEscrito("\nTe has rendido y has perdido el combate\n", 30);
	}
	
	public void mostrarMensajeCambio(Entrenador entrenador) {
		efectoEscrito(entrenador.getNombre() + " guarda a su pokemon y saca a " 
				+ mostrarNombrePokemon(entrenador.getPokemonCombatiente()) + "\n", 30);
	}
	
	public void mostrarMensajeAtaque(Pokemon pokemon) {
		efectoEscrito("\n" + mostrarNombrePokemon(pokemon) + " ha utilizado " 
				+ pokemon.getProximoMovimiento().getNombre() + "\n", 30);
	}
	
	public void mostrarMensajeFueraDeCombate(Entrenador entrenador) {
		efectoEscrito("\nA " +entrenador.getNombre() + " no le quedan más pokemon. Está fuera de combate.\n", 30);
	}
	
	public int mostrarMenuFinCombate() {
		pausaDramatica();
		System.out.printf("%n-----FIN DEL COMBATE-----%n"
				+ "1. Volver a jugar con los mismo pokemon%n"
				+ "2. Volver a jugar con otros pokemon%n"
				+ "3. Salir del juego%n");
		
		return readNumberInRange(1, 3, Limit.MAX_MIN_INCLUDED);
	}
	
	
	/*********************************************************/
	/***********OTRAS FUNCIONALIDADES PARA LA VISTA***********/
	
	/*Metodos para mostrar los datos de los pokemon*/
	//Para mostrar el nombre de un pokemon
	private String mostrarNombrePokemon(Pokemon pokemon) {
		return String.format("[%s]", pokemon.getEspecie().getNombre());
	}
	
	//Para mostrar la vida de un pokemon
	private String mostrarVidaPokemon(Pokemon pokemon) {
		return String.format("[%d / %d]", pokemon.getVida(), pokemon.getEspecie().getVida());
	}
	
	//Para mostrar el estado de un pokemon
	private String mostrarEstadoPokemon(Pokemon pokemon) {
		return String.format("[%s]", pokemon.getEstado().getNombre());
	}
	
	//Para mostrar todos los datos del pokemon
	private String mostrarDatosPokemon(Pokemon pokemon) {
		return String.format("%s%s%s", mostrarNombrePokemon(pokemon)
				,mostrarEstadoPokemon(pokemon)
				,mostrarVidaPokemon(pokemon));
	}
	
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
