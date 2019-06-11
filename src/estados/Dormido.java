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
		contador++;
		if(contador == maxTurnosDorm) {
			contador = 0;
			pokemonAtacante.moveToSanoState();
			mostrarMensajeDespertar(pokemonAtacante);
			pokemonAtacante.getEstado().atacar(pokemonAtacante, pokemonObjetivo);
		}
		
		else { //El pokemon no puede atacar porque sigue dormido
			mostrarMensajeAtacarDormido(pokemonAtacante);
		}
	}
	
	public int getMaxTurnosDorm() {
		return maxTurnosDorm;
	}
	
	public int getContador() {
		return contador;
	}
	
	public void turnosDormido() {
		maxTurnosDorm = rdm.nextInt(5)+1;
	}

	/*METODOS PRESENTADOR*/
	public void mostrarMensajeAtacarDormido(Pokemon pokemon) {
		presentadorDormido.mostrarMensajeAtacarDormido(pokemon);
	}

	public void mostrarMensajeDespertar(Pokemon pokemon) {
		presentadorDormido.mostrarMensajeDespertar(pokemon);
	}
	
	public void resolverEstado(Pokemon pokemon) {

	}
}
