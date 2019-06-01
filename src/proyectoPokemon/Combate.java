package proyectoPokemon;

import mvp.Presentador;
import mvp.PresentadorCombate;
import java.util.Random;

import factoriaPokemon.FactoriaPokemon;
import factoriaPokemon.GenerarPokemon;

public class Combate {
	public static void main(String[] args) {
		Random rdm = new Random();
		PresentadorCombate presentadorCombate = new Presentador();
		FactoriaPokemon factoriaPokemon = new GenerarPokemon();
		
		Entrenador usuario = new Usuario();
		Entrenador rival= new Maquina(); 
		
		boolean combate = true;
		
		/*Se les asigna los nombres a los usuarios*/
		usuario.setNombre(usuario.getPresentadorEntrenador().pedirNombreUsuario());
		rival.setNombre(rival.getPresentadorEntrenador().pedirNombreMaquina());
		
		presentadorCombate.presentacionCombate(usuario.getNombre(), rival.getNombre());
		
		/*Se les asigna los pokemon a los entrenadores*/
		for(int i=0; i<3; i++) {
			usuario.getListaPokemon().add(factoriaPokemon.generarPokemon(rdm.nextInt(factoriaPokemon.getNumeroEspecies())+1));
			rival.getListaPokemon().add(factoriaPokemon.generarPokemon(rdm.nextInt(factoriaPokemon.getNumeroEspecies())+1));
		}
		
		/*Se asignan los primeros pokemon de cada entrenador como los pokemon que van a luchar en primer lugar*/
		usuario.setPokemonCombatiente(usuario.getListaPokemon().get(0));
		rival.setPokemonCombatiente(rival.getListaPokemon().get(0));
		
		/*Se muestran los pokemon del usuario*/
		presentadorCombate.mostrarListaPokemon(usuario);
		
		/*****COMIENZA EL COMBATE******/
		do {
			presentadorCombate.mostrarInicioCombate(usuario, rival);
			
			switch(presentadorCombate.ejecutarMenuCombate(usuario, rival)) {
			case 1:
				usuario.setProximoMovimiento(presentadorCombate.ejecutarMenuMovimientos(usuario.getPokemonCombatiente()));
				usuario.setLuchando(true);
				usuario.setCambiando(false);
				break;
				
			case 2:
				usuario.setPokemonCombatiente(presentadorCombate.ejecutarMenuCambiarPokemon(usuario));
				usuario.setCambiando(true);
				usuario.setLuchando(false);
				break;
		
			case 3:
				presentadorCombate.mostrarMensajeRendicion();
				combate = false;
				break;
			}
			
			efectuarTurno(usuario, rival);
		}while(combate);
		

	}
	
	private static void efectuarTurno(Entrenador entrenador1, Entrenador entrenador2) {	
		PresentadorCombate presentadorCombate = new Presentador();
		
		if(entrenador1.isCambiando() || entrenador2.isCambiando()){
			cambioPokemon(entrenador1);
			cambioPokemon(entrenador2);
		}	
		else {
			if(compararVelocidad(entrenador1.getPokemonCombatiente(), entrenador2.getPokemonCombatiente())) {
				turnoLuchaEntrenador(entrenador1, entrenador2);
				turnoLuchaEntrenador(entrenador2, entrenador1);
			}
			else {
				turnoLuchaEntrenador(entrenador2, entrenador1);
				turnoLuchaEntrenador(entrenador1, entrenador2);
			}
		}
	}
	
	private static void cambioPokemon(Entrenador entrenador) {
		PresentadorCombate presentadorCombate = new Presentador();
		if(entrenador.isCambiando()) {
			presentadorCombate.mostrarMensajeCambio(entrenador);
		}
	}
	
	private static void turnoLuchaEntrenador(Entrenador entrenador, Entrenador rival) {
		PresentadorCombate presentadorCombate = new Presentador();
		
		if(entrenador.isLuchando()) {
			
		}
	}
	
	private static boolean compararVelocidad(Pokemon pokUsuario, Pokemon pokRival) {
		return pokUsuario.getVelocidad()>pokRival.getVelocidad()?true:false;
	}
}
