package categoria;

import java.util.Random;

import estados.Sano;
import mvp.Presentador;
import mvp.PresentadorEstadoPar;
import proyectoPokemon.Pokemon;

public class EstadoPar implements Categoria, PresentadorEstadoPar{
	private Presentador presentadorEstadoPar = new Presentador();
	private Random rdm = new Random(); 
	
	public void calcularDaño(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		if(rdm.nextInt(100) <= pokemonAtacante.getProximoMovimiento().getPrecision()) {
			if(!(pokemonObjetivo.getEstado() instanceof Sano)) {
//				mostrarMensajeYaTieneEstado(pokemonObjetivo);
			}
			else {
				pokemonObjetivo.moveToParalizadoState();
			}
		}
		else {
//			mostrarMensajeFalloAtaque();
		}
	}

	/*METODOS*/
	public void mostrarMensajeFalloAtaque() {
		presentadorEstadoPar.mostrarMensajeFalloAtaque();
	}

	public void mostrarMensajeYaTieneEstado(Pokemon pokemon) {
		presentadorEstadoPar.mostrarMensajeYaTieneEstado(pokemon);
	}
}
