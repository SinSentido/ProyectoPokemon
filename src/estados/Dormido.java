package estados;

import mvp.Presentador;
import mvp.PresentadorDormido;
import proyectoPokemon.Pokemon;
import java.util.Random;

public class Dormido implements Estado, PresentadorDormido{
	
	private Random rdm = new Random();
	private Presentador presentadorDormido= new Presentador();
	private String nombre = "Dormido";
	private int maxTurnosDorm;
	private int contador = 0;

	public String getNombre() {
		return nombre;
	}

	public void atacar(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		if(contador == maxTurnosDorm) { //El pokemon se despierta
			contador = 1;
			
			//Se cambia el estado del pokemon a Sano
			pokemonAtacante.moveToSanoState();
			mostrarMensajeDespertar(pokemonAtacante);
			
			//El pokemon efectua el ataque
			pokemonAtacante.getEstado().atacar(pokemonAtacante, pokemonObjetivo);
		}
		else { //El pokemon no puede atacar porque sigue dormido
			mostrarMensajeAtacarDormido(pokemonAtacante);
		}
	}
	
	public void turnosDormido() {
		maxTurnosDorm = rdm.nextInt(5)+1;
	}

	/*METODOS PRESENTADOR*/
	public void mostrarMensajeAtacarDormido(Pokemon pokemon) {
		presentadorDormido.mostrarMensajeAtacarDormido(pokemon);
	}

	@Override
	public void mostrarMensajeDespertar(Pokemon pokemon) {
		presentadorDormido.mostrarMensajeDespertar(pokemon);
	}
	
	public void resolverEstado(Pokemon pokemon) {
		contador++;
	}
}
