package categoria;

import java.util.Random;
import mvp.Presentador;
import mvp.PresentadorCategoria;
import proyectoPokemon.Pokemon;

public class EstadoPar implements Categoria{
	private PresentadorCategoria presentadorCategoria = new Presentador();
	private Random rdm = new Random(); 
	
	public void calcularDaño(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		if(rdm.nextInt(100) <= pokemonAtacante.getProximoMovimiento().getPrecision()) {
			if(!pokemonObjetivo.getEstado().getNombre().equals("Sano")) {
				presentadorCategoria.mostrarMensajeYaTieneEstado(pokemonObjetivo);
			}
			else {
				pokemonObjetivo.moveToParalizadoState();
				presentadorCategoria.mostrarMensajeParalizado(pokemonObjetivo);	
			}
		}
		else {
			presentadorCategoria.mostrarMensajeFalloAtaque();
		}
	}
}
