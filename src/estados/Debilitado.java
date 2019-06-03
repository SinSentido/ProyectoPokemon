package estados;

import proyectoPokemon.Pokemon;

public class Debilitado implements Estado{
	private String nombre = "Debilitado";
	
	public String getNombre() {
		return nombre;
	}

	//Un pokemon debilitado no puede atacar
	public void atacar(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
	}

	public void resolverEstado(Pokemon pokemon) {		
	}
}
