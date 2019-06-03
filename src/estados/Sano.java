package estados;

import mvp.Presentador;
import mvp.PresentadorEstado;
import proyectoPokemon.Pokemon;

public class Sano implements Estado{
	private PresentadorEstado presentadorEstado = new Presentador();
	private String nombre = "Sano";
	
	public String getNombre() {
		return nombre;
	}
	
	public void atacar(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		presentadorEstado.mostrarMensajeAtaque(pokemonAtacante);
		pokemonAtacante.getProximoMovimiento().getCategoria().calcularDaño(pokemonAtacante, pokemonObjetivo);
	}

}
