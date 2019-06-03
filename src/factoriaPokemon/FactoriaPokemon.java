package factoriaPokemon;

import baseDeDatos.Database;
import proyectoPokemon.Pokemon;

public abstract class FactoriaPokemon {
	
	protected Database database = Database.INSTANCE;
	
	public abstract Pokemon generarPokemon(int idEspecie);
	
	public int getNumeroEspecies() {
		return database.getEspecies().size();
	}
}
