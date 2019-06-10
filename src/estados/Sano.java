package estados;

import mvp.Presentador;
import mvp.PresentadorSano;
import proyectoPokemon.Pokemon;

public class Sano implements Estado, PresentadorSano{
	private Presentador presentadorSano = new Presentador();
	private String nombre = "Sano";
	
	public String getNombre() {
		return nombre;
	}
	
	public void atacar(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
//		mostrarMensajeAtaque(pokemonAtacante);
		pokemonAtacante.getProximoMovimiento().getCategoria().calcularDaño(pokemonAtacante, pokemonObjetivo);
	}
	
	public void resolverEstado(Pokemon pokemon) {
		
	}
	
	/*METODOS PRESENTADOR*/
	public void mostrarMensajeAtaque(Pokemon pokemon) {
		presentadorSano.mostrarMensajeAtaque(pokemon);
	}

}
