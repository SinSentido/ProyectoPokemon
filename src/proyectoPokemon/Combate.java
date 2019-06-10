package proyectoPokemon;

import mvp.Presentador;
import mvp.PresentadorCombate;
import estados.Debilitado;
import estados.Sano;

public class Combate implements  PresentadorCombate {
	Presentador presentadorCombate = new Presentador();
	
	public void empezarCombate(Entrenador entrenador1, Entrenador entrenador2) {
		
		boolean combate = true;
		
		/**************COMENTAR ESTE BLOQUE PARA SALTAR LA INTRODUCCION DEL JUEGO**********************/
//		/*Se les asigna los nombres a los usuarios*/
//		usuario.setNombre(usuario.pedirNombreUsuario());
//		rival.setNombre(rival.pedirNombreMaquina());
//		
//		presentacionCombate(usuario.getNombre(), rival.getNombre());
		/**********************************************************************************************/
		
		/*Se les asigna los pokemon a los entrenadores*/
		entrenador1.darPokemon(3);
		entrenador2.darPokemon(3);		
		/*Se asignan los primeros pokemon de cada entrenador como los pokemon que van a luchar en primer lugar*/
		entrenador1.setPokemonCombatiente(entrenador1.getListaPokemon().get(0));
		entrenador2.setPokemonCombatiente(entrenador2.getListaPokemon().get(0));
		
		/*Comienza el combate*/
		do {
			/*Se muestran los pokemon del usuario*/
//			entrenador1.mostrarListaPokemon(entrenador1);
			
//			mostrarInicioCombate(entrenador1, entrenador2);
			do {
//				mostrarPokemonLuchando(entrenador1, entrenador2);
				
				if(!entrenador1.isDerrotado() && !entrenador2.isDerrotado()) {
					menuCombate(entrenador1, entrenador2);
					menuCombate(entrenador2, entrenador1);
					if(!entrenador1.isDerrotado() && !entrenador2.isDerrotado()) {
						efectuarTurno(entrenador1, entrenador2);
					}
				}
			}while(!entrenador1.isDerrotado() && !entrenador2.isDerrotado());
			
//			//Los entrenadores regresan a su estado normal
//			entrenador1.setDerrotado(false);
//			entrenador2.setDerrotado(false);
//			
//			//Se ejecuta el menu del final del juego
//			combate = menuFinDelJuego(entrenador1, entrenador2);
			
			combate = false;
			
		}while(combate);
	}
	
	private  void menuCombate(Entrenador entrenador, Entrenador entrenadorRival) {
		switch(entrenador.elegirOpcionCombate()) {
		case 1:
			entrenador.elegirSiguienteMovimiento(entrenador.getPokemonCombatiente(), entrenadorRival.getPokemonCombatiente());
			entrenador.setLuchando(true);
			entrenador.setCambiando(false);
			break;
				
		case 2:
			entrenador.cambiarPokemon(entrenador.getPokemonCombatiente());
			entrenador.setCambiando(true);
			entrenador.setLuchando(false);
			break;
		
		case 3:
			entrenador.setDerrotado(true);
			mostrarMensajeRendicion();
			break;
		}
	}
	
	private  void efectuarTurno(Entrenador entrenador1, Entrenador entrenador2) {	
		//Primero se realizan los cambios de los entrenadores que hayan decidido cambiar
		if(entrenador1.isCambiando()){
//			mostrarMensajeCambio(entrenador1);
		}	
		else if(entrenador2.isCambiando()) {
//			mostrarMensajeCambio(entrenador2);
		}
		
		//Despues de realizar los cambios se efectuan los ataques. Primero se comprueba la velocidad para ver 
		//quien ataca en primer lugar
		if(compararVelocidad(entrenador1.getPokemonCombatiente(), entrenador2.getPokemonCombatiente())) {			
			//El entrenador1 ataca primero
			ataqueEntrenador(entrenador1, entrenador2);
			ataqueEntrenador(entrenador2, entrenador1);
		}
		
		//El entrenador 2 ataca primero
		else {
			ataqueEntrenador(entrenador2, entrenador1);
			ataqueEntrenador(entrenador1, entrenador2);
		}
		
		//Al acabar el turno se aplican los efectos de los estados de los pokemon
		if(!entrenador1.isDerrotado() && !entrenador2.isDerrotado()) {
			resolverEstados(entrenador1, entrenador2);
		}
	}
	
	private void ataqueEntrenador(Entrenador entrenador, Entrenador rival) {		
		if(entrenador.isLuchando()) {
			entrenador.getPokemonCombatiente().getEstado()
				.atacar(entrenador.getPokemonCombatiente(), rival.getPokemonCombatiente());
			
			if(rival.getPokemonCombatiente().getEstado() instanceof Debilitado) {
				if(!comprobarPokemonVivos(rival)) {
					rival.setDerrotado(true);
					entrenador.setGanador(true);
//					mostrarMensajeFueraDeCombate(rival);
				}
				else {
					rival.setCambiando(true);
					rival.setLuchando(false);
					rival.cambiarPokemon(rival.getPokemonCombatiente());
//					mostrarMensajeCambio(rival);
				}
			}
		}
	}
	
	//Metodo para comparar la velocidad entre dos pokemon
	private boolean compararVelocidad(Pokemon pokUsuario, Pokemon pokRival) {
		return pokUsuario.getVelocidad()>pokRival.getVelocidad();
	}
	
	//Metodo para comprobar si a un entrenador le quedan pokemon vivos
	private boolean comprobarPokemonVivos(Entrenador entrenador) {
		boolean pokemonVivos = false;
		for(Pokemon e : entrenador.getListaPokemon()) {
			if(!(e.getEstado() instanceof Debilitado)) {
				pokemonVivos = true;
			}
		}
		return pokemonVivos;
	}
	
	/*Metodo que aplica los efectos de los estados y comprueba si el pokemon se debilita o no*/
	private void resolverEstados(Entrenador entrenador1, Entrenador entrenador2) {
		entrenador1.getPokemonCombatiente().getEstado().resolverEstado(entrenador1.getPokemonCombatiente());
		
		if(entrenador1.getPokemonCombatiente().getEstado() instanceof Debilitado) {
			if(!comprobarPokemonVivos(entrenador1)) {
				entrenador1.setDerrotado(true);
//				mostrarMensajeFueraDeCombate(entrenador1);
			}
			else {
				entrenador1.cambiarPokemon(entrenador1.getPokemonCombatiente());
//				mostrarMensajeCambio(entrenador1);
			}
		}
		
		entrenador2.getPokemonCombatiente().getEstado().resolverEstado(entrenador2.getPokemonCombatiente());
		
		if(entrenador2.getPokemonCombatiente().getEstado() instanceof Debilitado) {
			if(!comprobarPokemonVivos(entrenador2)) {
				entrenador2.setDerrotado(true);
//				mostrarMensajeFueraDeCombate(entrenador2);
			}
			else {
				entrenador2.cambiarPokemon(entrenador2.getPokemonCombatiente());
//				mostrarMensajeCambio(entrenador2);
			}
		}
	}
	
	private boolean menuFinDelJuego(Entrenador entrenador1, Entrenador entrenador2) {
		// Se pregunta al usuario si quiere volver a jugar
		switch(mostrarMenuFinCombate()) {
		case 1: //Volver a jugar con los mismos pokemon
			curarPokemon(entrenador1);
			curarPokemon(entrenador2);
			
			entrenador1.setPokemonCombatiente(entrenador1.getListaPokemon().get(0));
			entrenador2.setPokemonCombatiente(entrenador2.getListaPokemon().get(0));
			break;
		case 2: //Volver a jugar con pokemon diferentes
			entrenador1.getListaPokemon().removeAll(entrenador1.getListaPokemon());
			entrenador2.getListaPokemon().removeAll(entrenador2.getListaPokemon());
			
			entrenador1.darPokemon(3);
			entrenador2.darPokemon(3);
			
			entrenador1.setPokemonCombatiente(entrenador1.getListaPokemon().get(0));
			entrenador2.setPokemonCombatiente(entrenador2.getListaPokemon().get(0));
			break;
		case 3: //Salir del juego
			return false;
		}
		return true;
	}
	
	//Metodo para reiniciar las estadisticas de todos los pokemon de un entrenador.
	private void curarPokemon(Entrenador entrenador) {
		for(Pokemon e : entrenador.getListaPokemon()) {
			e.setEstado(new Sano());
			e.setVida(e.getEspecie().getVida());
			e.setVelocidad(e.getEspecie().getVelocidad());
		}
	}

	
	/*METODOS DE LA INTERFAZ DEL PRESENTADOR*/
	public void presentacionCombate(String nombreUsuario, String nombreRival) {
		presentadorCombate.presentacionCombate(nombreUsuario, nombreRival);
	}

	public void mostrarInicioCombate(Entrenador usuario, Entrenador rival) {
		presentadorCombate.mostrarInicioCombate(usuario, rival);
	}

	public void mostrarMensajeRendicion() {
		presentadorCombate.mostrarMensajeRendicion();
	}

	public void mostrarMensajeCambio(Entrenador entrenador) {
		presentadorCombate.mostrarMensajeCambio(entrenador);
	}

	public void mostrarPokemonLuchando(Entrenador entrenador1, Entrenador entrenador2) {
		presentadorCombate.mostrarPokemonLuchando(entrenador1, entrenador2);
	}

	public void mostrarMensajeFueraDeCombate(Entrenador entrenador) {
		presentadorCombate.mostrarMensajeFueraDeCombate(entrenador);
	}

	public int mostrarMenuFinCombate() {
		return presentadorCombate.mostrarMenuFinCombate();
	}
}
