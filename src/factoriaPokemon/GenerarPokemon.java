package factoriaPokemon;

import proyectoPokemon.Pokemon;
import java.util.Random;

import baseDeDatos.Database;

public class GenerarPokemon extends FactoriaPokemon{
	
	public Pokemon generarPokemon(){
		Random rdm = new Random();
		return new Pokemon(Database.INSTANCE.getEspecies().get(rdm.nextInt(Database.INSTANCE.getEspecies().size())+1));
	}

}
