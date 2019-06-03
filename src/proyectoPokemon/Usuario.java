package proyectoPokemon;

public class Usuario extends Entrenador{
	
	public void cambiarPokemon(Pokemon pokemon) {
		boolean eleccionValida = false;
		Pokemon nuevoPokemon;
		do {
			nuevoPokemon = ejecutarMenuCambiarPokemon(this);
			//Si intenta cambiar el pokemon por el mismo pokemon
			if(nuevoPokemon.getEspecie().getNombre().equals(pokemon.getEspecie().getNombre())){ 
				cambiarAMismoPokemon();
			}
			//Si intenta cambiar por un pokemon debilitado
			else if(nuevoPokemon.getEstado().getNombre().equals("Debilitado")) {
				cambiarAPokemonDebilitado();
			}
			else {
				eleccionValida = true;
				pokemonCombatiente = nuevoPokemon;
			}
		}while(!eleccionValida);
	}

	public void elegirSiguienteMovimiento(Pokemon pokemon) {
		pokemon.setProximoMovimiento(ejecutarMenuMovimientos(pokemon));
	}
	
	public int elegirOpcionCombate() {
		return ejecutarMenuCombate();
	}
	
	public void setPokemonCombatiente(Pokemon pokemon) {
		pokemonCombatiente = pokemon;
	}
	
	public Pokemon getPokemonCombatiente() {
		return pokemonCombatiente;
	}
}
