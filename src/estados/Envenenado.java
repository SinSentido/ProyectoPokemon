package estados;

import mvp.Presentador;
import mvp.PresentadorEnvenenado;
import proyectoPokemon.Pokemon;

public class Envenenado implements Estado, PresentadorEnvenenado{
	private Presentador presentadorEnvenenado = new Presentador();
	private String nombre = "Envenenado";
	private int maxTurnosEnv = 5;
	private int contador = 0;
	
	public String getNombre() {
		return nombre;
	}

	public void atacar(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		//El pokemon ataca
//		mostrarMensajeAtaque(pokemonAtacante);
		pokemonAtacante.getProximoMovimiento().getCategoria().calcularDaño(pokemonAtacante, pokemonObjetivo);
	}
	
	public void resolverEstado(Pokemon pokemon) {
		//Despues de atacar se aplica o no el efecto del veneno
		if(contador == maxTurnosEnv) { //Se acaba el efecto del veneno
			pokemon.moveToSanoState();
//			mostrarMensajeCurarVeneno(pokemon);
		}
		else { //El veneno hace efecto al pokemon (resta 1/8 de su vida máxima)
			pokemon.setVida(pokemon.getVida()-pokemon.getEspecie().getVida()/8);
//			mostrarMensajeDañoVeneno(pokemon);
			
			//Si el veneno debilita al pokemon se cambia su estado a Debilitado
			if(pokemon.getVida() <= 0) {
				pokemon.moveToDebilitadoState();
			}
		}
		contador++;
	}


	/*METODOS DEL PRESENTADOR*/
	public void mostrarMensajeAtaque(Pokemon pokemon) {
		presentadorEnvenenado.mostrarMensajeAtaque(pokemon);
	}

	public void mostrarMensajeCurarVeneno(Pokemon pokemon) {
		presentadorEnvenenado.mostrarMensajeCurarVeneno(pokemon);
	}

	public void mostrarMensajeDañoVeneno(Pokemon pokemon) {
		presentadorEnvenenado.mostrarMensajeDañoVeneno(pokemon);
	}
}
