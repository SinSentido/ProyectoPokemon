package estados;

import proyectoPokemon.Pokemon;
import java.util.Random;
import mvp.Presentador;
import mvp.PresentadorParalizado;

public class Paralizado implements Estado, PresentadorParalizado{
	private Random rdm = new Random();
	private Presentador presentadorParalizado = new Presentador();
	
	private String nombre = "Paralizado";
	
	public String getNombre() {
		return nombre;
	}
	
	public void atacar(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		
		if(rdm.nextInt(2) == 0) { //Si la paralisis hace efecto
//			mostrarMensajeAtacarParalizado(pokemonAtacante);
		}
		else { //Si la paralisis no hace efecto
//			mostrarMensajeAtaque(pokemonAtacante);
			pokemonAtacante.getProximoMovimiento().getCategoria().calcularDaño(pokemonAtacante, pokemonObjetivo);
		}	
	}

	public void resolverEstado(Pokemon pokemon) {
	}
	
	
	/*METODOS DEL PRESENTADOR*/
	public void mostrarMensajeAtaque(Pokemon pokemon) {
		presentadorParalizado.mostrarMensajeAtaque(pokemon);
	}

	public void mostrarMensajeAtacarParalizado(Pokemon pokemon) {
		presentadorParalizado.mostrarMensajeAtacarParalizado(pokemon);
	}
	

}
