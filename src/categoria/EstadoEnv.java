package categoria;

import java.util.Random;

import estados.Sano;
import mvp.Presentador;
import mvp.PresentadorEstadoEnv;
import proyectoPokemon.Pokemon;

public class EstadoEnv implements Categoria, PresentadorEstadoEnv{
	private Presentador presentadorEstadoEnv = new Presentador();
	private Random rdm = new Random(); 
	
	public void calcularDaño(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		if(rdm.nextInt(100) <= pokemonAtacante.getProximoMovimiento().getPrecision()) {
			if(!(pokemonObjetivo.getEstado() instanceof Sano)) {
//				mostrarMensajeYaTieneEstado(pokemonObjetivo);
			}
			else {
				pokemonObjetivo.moveToEnvenenadoState();
			}
		}
		else {
//			mostrarMensajeFalloAtaque();
		}
	}

	/*METODOS DEL PRESENTADOR*/
	public void mostrarMensajeFalloAtaque() {
		presentadorEstadoEnv.mostrarMensajeFalloAtaque();
	}

	public void mostrarMensajeYaTieneEstado(Pokemon pokemon) {
		presentadorEstadoEnv.mostrarMensajeYaTieneEstado(pokemon);
	}

}
