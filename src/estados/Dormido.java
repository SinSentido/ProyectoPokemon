package estados;

import mvp.Presentador;
import mvp.PresentadorEstado;
import proyectoPokemon.Pokemon;

public class Dormido implements Estado{
	
	private PresentadorEstado presentadorEstado= new Presentador();
	private String nombre = "Dormido";
	private int maxTurnosDorm = 5;
	private int contador = 1;

	public String getNombre() {
		return nombre;
	}

	public void atacar(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		contador++;
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
	}
}
