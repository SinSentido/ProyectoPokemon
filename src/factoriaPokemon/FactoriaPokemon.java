package factoriaPokemon;

import java.util.Map;

import baseDeDatos.Database;
import baseDeDatos.Especie;
import proyectoPokemon.Pokemon;

public abstract class FactoriaPokemon {
	
	private Map<Integer, Especie> especies = Database.INSTANCE.getEspecies();
	
	public abstract Pokemon generarPokemon(int idEspecie);
	
	public Map<Integer, Especie> getEspecies(){
		return especies;
	}
	
	public int getNumeroEspecies() {
		return especies.size();
	}
}
