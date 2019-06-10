package categoria;

import java.util.Random;


import estados.Sano;
import mvp.Presentador;
import mvp.PresentadorEstadoDor;
import proyectoPokemon.Pokemon;

public class EstadoDor implements Categoria, PresentadorEstadoDor{
	private Presentador presentadorEstadoDor= new Presentador();
	private Random rdm = new Random(); 
	
	public void calcularDaño(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		if(rdm.nextInt(100) <= pokemonAtacante.getProximoMovimiento().getPrecision()) { //Si el ataque acierta
			if(!(pokemonObjetivo.getEstado() instanceof Sano)) {
//				mostrarMensajeYaTieneEstado(pokemonObjetivo);
			}
			else {
				pokemonObjetivo.moveToDormidoState();
			}
		}
		else {
//			mostrarMensajeFalloAtaque();
		}
	}

	
	/*METODOS PRESENTADOR*/
	public void mostrarMensajeFalloAtaque() {
		presentadorEstadoDor.mostrarMensajeFalloAtaque();
	}

	public void mostrarMensajeYaTieneEstado(Pokemon pokemon) {
		presentadorEstadoDor.mostrarMensajeYaTieneEstado(pokemon);
	}

}
