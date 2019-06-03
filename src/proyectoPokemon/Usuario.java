package proyectoPokemon;

import mvp.Presentador;
import mvp.PresentadorEntrenador;

public class Usuario extends Entrenador{
	
	private PresentadorEntrenador presentadorEntrenador = new Presentador();
	
	public void cambiarPokemon(Pokemon pokemon) {
		boolean eleccionValida = false;
		Pokemon nuevoPokemon;
		do {
			nuevoPokemon = presentadorEntrenador.ejecutarMenuCambiarPokemon(this);
			//Si intenta cambiar el pokemon por el mismo pokemon
			if(nuevoPokemon.getEspecie().getNombre().equals(pokemon.getEspecie().getNombre())){ 
				presentadorEntrenador.cambiarAMismoPokemon();
			}
			//Si intenta cambiar por un pokemon debilitado
			else if(nuevoPokemon.getEstado().getNombre().equals("Debilitado")) {
				presentadorEntrenador.cambiarAPokemonDebilitado();
			}
			else {
				eleccionValida = true;
				pokemonCombatiente = nuevoPokemon;
			}
		}while(!eleccionValida);
	}

	public void elegirSiguienteMovimiento(Pokemon pokemon) {
		pokemon.setProximoMovimiento(presentadorEntrenador.ejecutarMenuMovimientos(pokemon));
	}
	
	public int elegirOpcionCombate() {
		return presentadorEntrenador.ejecutarMenuCombate();
	}
	
	public void setPokemonCombatiente(Pokemon pokemon) {
		pokemonCombatiente = pokemon;
	}
	
	public Pokemon getPokemonCombatiente() {
		return pokemonCombatiente;
	}
}
