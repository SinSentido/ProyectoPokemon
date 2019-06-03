package estados;

import proyectoPokemon.Pokemon;

public interface Estado {
	
	public void atacar(Pokemon pokemonAtacante, Pokemon pokemonObjetivo);
	
	public void resolverEstado(Pokemon pokemon);
	
	public String getNombre();

}
