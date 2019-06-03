package categoria;

import java.util.Random;
import estados.Dormido;
import mvp.Presentador;
import mvp.PresentadorCategoria;
import proyectoPokemon.Pokemon;

public class EstadoDor implements Categoria{
	private PresentadorCategoria presentadorCategoria = new Presentador();
	private Random rdm = new Random(); 
	
	public void calcularDaño(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		if(rdm.nextInt(100) <= pokemonAtacante.getProximoMovimiento().getPrecision()) { //Si el ataque acierta
			if(!pokemonObjetivo.getEstado().getNombre().equals("Sano")) {
				presentadorCategoria.mostrarMensajeYaTieneEstado(pokemonObjetivo);
			}
			else {
				pokemonObjetivo.setEstado(new Dormido());
				presentadorCategoria.mostrarMensajeDormido(pokemonObjetivo);
			}
		}
		else {
			presentadorCategoria.mostrarMensajeFalloAtaque();
		}
	}
}
