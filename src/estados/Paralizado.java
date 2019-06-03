package estados;

import proyectoPokemon.Pokemon;
import java.util.Random;
import mvp.Presentador;
import mvp.PresentadorEstado;

public class Paralizado implements Estado{
	private Random rdm = new Random();
	private PresentadorEstado presentadorEstado = new Presentador();
	
	private String nombre = "Paralizado";
	
	public String getNombre() {
		return nombre;
	}

	public void atacar(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		
		if(rdm.nextInt(2) == 0) { //Si la paralisis hace efecto
			presentadorEstado.mostrarMensajeAtacarParalizado(pokemonAtacante);
		}
		else { //Si la paralisis no hace efecto
			presentadorEstado.mostrarMensajeAtaque(pokemonAtacante);
			pokemonAtacante.getProximoMovimiento().getCategoria().calcularDaño(pokemonAtacante, pokemonObjetivo);
		}
		
	}

}
