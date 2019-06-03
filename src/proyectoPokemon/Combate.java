package proyectoPokemon;

import mvp.Presentador;
import mvp.PresentadorCombate;
import estados.Sano;

public class Combate {
	
	public void empezarCombate(Entrenador usuario, Entrenador rival) {
		PresentadorCombate presentadorCombate = new Presentador();
		
		boolean combate = true;
		
		/*Se les asigna los nombres a los usuarios*/
//		usuario.setNombre(usuario.getPresentadorEntrenador().pedirNombreUsuario());
//		rival.setNombre(rival.getPresentadorEntrenador().pedirNombreMaquina());
//		
//		presentadorCombate.presentacionCombate(usuario.getNombre(), rival.getNombre());
		
		/*Se les asigna los pokemon a los entrenadores*/
		usuario.darPokemonAEntrenador(3);
		rival.darPokemonAEntrenador(3);		
		/*Se asignan los primeros pokemon de cada entrenador como los pokemon que van a luchar en primer lugar*/
		usuario.setPokemonCombatiente(usuario.getListaPokemon().get(0));
		rival.setPokemonCombatiente(rival.getListaPokemon().get(0));
		
		/*Se muestran los pokemon del usuario*/
		presentadorCombate.mostrarListaPokemon(usuario);

		/*Comienza el combate*/
		do {
			presentadorCombate.mostrarInicioCombate(usuario, rival);
			do {
				presentadorCombate.mostrarPokemonLuchando(usuario, rival);
				
				if(!usuario.isDerrotado() && !rival.isDerrotado()) {
					menuCombate(usuario);
					menuCombate(rival);
					if(!usuario.isDerrotado() && !rival.isDerrotado()) {
						efectuarTurno(usuario, rival);
					}
				}
			}while(!usuario.isDerrotado() && !rival.isDerrotado());
			
			//Los entrenadores regresan a su estado normal
			usuario.setDerrotado(false);
			rival.setDerrotado(false);
			
			// Se pregunta al usuario si quiere volver a jugar
			switch(presentadorCombate.mostrarMenuFinCombate()) {
			case 1: //Volver a jugar con los mismos pokemon
				reiniciarEstadisticasPokemon(usuario);
				reiniciarEstadisticasPokemon(rival);
				
				usuario.setPokemonCombatiente(usuario.getListaPokemon().get(0));
				rival.setPokemonCombatiente(rival.getListaPokemon().get(0));
				break;
			case 2: //Volver a jugar con pokemon diferentes
				usuario.getListaPokemon().removeAll(usuario.getListaPokemon());
				rival.getListaPokemon().removeAll(rival.getListaPokemon());
				
				usuario.darPokemonAEntrenador(3);
				rival.darPokemonAEntrenador(3);
				
				usuario.setPokemonCombatiente(usuario.getListaPokemon().get(0));
				rival.setPokemonCombatiente(rival.getListaPokemon().get(0));
				break;
			case 3: //Salir del juego
				combate = false;
			}
			
		}while(combate);
	}
	
	private static void menuCombate(Entrenador entrenador) {
		PresentadorCombate presentadorCombate = new Presentador();

		switch(entrenador.elegirOpcionCombate()) {
		case 1:
			entrenador.elegirSiguienteMovimiento(entrenador.getPokemonCombatiente());
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
			presentadorCombate.mostrarMensajeRendicion();
			break;
		}
	}
	
	private static void efectuarTurno(Entrenador entrenador1, Entrenador entrenador2) {	
		PresentadorCombate presentadorCombate = new Presentador();
		
		//Primero se realizan los cambios de los entrenadores que hayan decidido cambiar
		if(entrenador1.isCambiando() || entrenador2.isCambiando()){
			cambioPokemon(entrenador1);
			cambioPokemon(entrenador2);
		}	
		
		//Despues de realizar los cambios se efectuan los ataques. Primero se comprueba la velocidad para ver 
		//quien ataca en primer lugar
		if(compararVelocidad(entrenador1.getPokemonCombatiente(), entrenador2.getPokemonCombatiente())) {
			
			ataqueEntrenador(entrenador1, entrenador2);
		
			//Si al atacar se debilita un pokemon se comprueba que el entrenador tiene más pokemon para 
			//continuar con el combate. En caso contrario el entrenador pierde.
			if(entrenador2.getPokemonCombatiente().getEstado().getNombre().equals("Debilitado")) {	
				if(!comprobarPokemonVivos(entrenador2)) {
					presentadorCombate.mostrarMensajeFueraDeCombate(entrenador2);
					entrenador2.setDerrotado(true);
				}
				
				//Si tiene otros pokemon vivos el entrenador cambia de pokemon 
				else {
					entrenador2.cambiarPokemon(entrenador2.getPokemonCombatiente());
					entrenador2.setCambiando(true);
					entrenador2.setLuchando(false);
					cambioPokemon(entrenador2);
				}
			}
		
			else {
				ataqueEntrenador(entrenador2, entrenador1);
				if(entrenador1.getPokemonCombatiente().getEstado().getNombre().equals("Debilitado")) {
					if(!comprobarPokemonVivos(entrenador1)) {
						entrenador1.setDerrotado(true);
						presentadorCombate.mostrarMensajeFueraDeCombate(entrenador1);
					}
					else {
						entrenador1.cambiarPokemon(entrenador1.getPokemonCombatiente());
						entrenador1.setCambiando(true);
						entrenador1.setLuchando(false);
						cambioPokemon(entrenador1);
					}
				}
			}
		}
		
		else {
			ataqueEntrenador(entrenador2, entrenador1);
			if(entrenador1.getPokemonCombatiente().getEstado().getNombre().equals("Debilitado")) {
				if(!comprobarPokemonVivos(entrenador1)) {
					entrenador1.setDerrotado(true);
					presentadorCombate.mostrarMensajeFueraDeCombate(entrenador1);
				}
				else {
					entrenador1.cambiarPokemon(entrenador1.getPokemonCombatiente());
					entrenador1.setCambiando(true);
					entrenador1.setLuchando(false);
					cambioPokemon(entrenador1);
				}
			}
			else {
				ataqueEntrenador(entrenador1, entrenador2);
				if(entrenador2.getPokemonCombatiente().getEstado().getNombre().equals("Debilitado")) {
					if(!comprobarPokemonVivos(entrenador2)) {
						entrenador2.setDerrotado(true);
						presentadorCombate.mostrarMensajeFueraDeCombate(entrenador2);
					}
					else {
						entrenador2.cambiarPokemon(entrenador2.getPokemonCombatiente());
						entrenador2.setCambiando(true);
						entrenador2.setLuchando(false);
						cambioPokemon(entrenador2);
					}
				}
			}
		}
	}
	
	private static void cambioPokemon(Entrenador entrenador) {
		PresentadorCombate presentadorCombate = new Presentador();
		if(entrenador.isCambiando()) {
			presentadorCombate.mostrarMensajeCambio(entrenador);
		}
	}
	
	private static void ataqueEntrenador(Entrenador entrenador, Entrenador rival) {		
		if(entrenador.isLuchando()) {
			entrenador.getPokemonCombatiente().getEstado()
				.atacar(entrenador.getPokemonCombatiente(), rival.getPokemonCombatiente());
		}
	}
	
	private static boolean compararVelocidad(Pokemon pokUsuario, Pokemon pokRival) {
		return pokUsuario.getVelocidad()>pokRival.getVelocidad()?true:false;
	}
	
	private static boolean comprobarPokemonVivos(Entrenador entrenador) {
		boolean pokemonVivos = false;
		for(Pokemon e : entrenador.getListaPokemon()) {
			if(!e.getEstado().getNombre().equals("Debilitado")) {
				pokemonVivos = true;
			}
		}
		return pokemonVivos;
	}
	
	private static void reiniciarEstadisticasPokemon(Entrenador entrenador) {
		for(Pokemon e : entrenador.getListaPokemon()) {
			e.setEstado(new Sano());
			e.setVida(e.getEspecie().getVida());
			e.setVelocidad(e.getEspecie().getVelocidad());
		}
	}
}
