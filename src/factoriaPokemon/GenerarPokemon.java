package factoriaPokemon;

import proyectoPokemon.Pokemon;

public class GenerarPokemon extends FactoriaPokemon{

	
	public Pokemon generarPokemon(int idEspecie){	
		return new Pokemon(database.getEspecies().get(idEspecie));
	}

}
