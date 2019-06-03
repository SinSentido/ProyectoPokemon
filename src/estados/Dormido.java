package estados;

import mvp.Presentador;
import mvp.PresentadorEstado;
import proyectoPokemon.Pokemon;
import java.util.Random;

public class Dormido implements Estado{
	
	private Random rdm = new Random();
	private PresentadorEstado presentadorEstado= new Presentador();
	private String nombre = "Dormido";
	private int maxTurnosDorm;
	private int contador = 0;
	
	public Dormido() {
		maxTurnosDorm = rdm.nextInt(5)+1;
	}

	public String getNombre() {
		return nombre;
	}

	public void atacar(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		if(contador == maxTurnosDorm) { //El pokemon se despierta
			contador = 1;
			
			//Se cambia el estado del pokemon a Sano
			pokemonAtacante.setEstado(new Sano());
			presentadorEstado.mostrarMensajeDespertar(pokemonAtacante);
			
			//El pokemon efectua el ataque
			pokemonAtacante.getEstado().atacar(pokemonAtacante, pokemonObjetivo);
		}
		else { //El pokemon no puede atacar porque sigue dormido
			presentadorEstado.mostrarMensajeAtacarDormido(pokemonAtacante);
		}
		contador++;
	}
}
