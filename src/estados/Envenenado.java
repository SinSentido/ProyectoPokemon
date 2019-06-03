package estados;

import mvp.Presentador;
import mvp.PresentadorEstado;
import proyectoPokemon.Pokemon;

public class Envenenado implements Estado{
	private PresentadorEstado presentadorEstado = new Presentador();
	private String nombre = "Envenenado";
	private int maxTurnosEnv = 5;
	private int contador = 1;
	
	public String getNombre() {
		return nombre;
	}

	public void atacar(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		contador++;
		
		//El pokemon ataca
		presentadorEstado.mostrarMensajeAtaque(pokemonAtacante);
		pokemonAtacante.getProximoMovimiento().getCategoria().calcularDaño(pokemonAtacante, pokemonObjetivo);
		
		//Despues de atacar se aplica o no el efecto del veneno
		if(contador == maxTurnosEnv) { //Se acaba el efecto del veneno
			pokemonAtacante.setEstado(new Sano());
			presentadorEstado.mostrarMensajeCurarVeneno(pokemonAtacante);
		}
		else { //El veneno hace efecto al pokemon (resta 1/8 de su vida máxima)
			pokemonAtacante.setVida(pokemonAtacante.getVida()-pokemonAtacante.getEspecie().getVida()/8);
			presentadorEstado.mostrarMensajeDañoVeneno(pokemonAtacante);
			
			//Si el veneno debilita al pokemon se cambia su estado a Debilitado
			if(pokemonAtacante.getVida() <= 0) {
				pokemonAtacante.setEstado(new Debilitado());
			}
		}
		
	}
}
