package proyectoPokemon;

import java.util.Random;

public class Maquina extends Entrenador{

	private Random rdm = new Random();

	public void cambiarPokemon(Pokemon pokemon) {
		do {
			setPokemonCombatiente(getListaPokemon().get(rdm.nextInt(3)));
		}while(getPokemonCombatiente().getEstado().getNombre().equals("Debilitado"));
	}

	public void elegirSiguienteMovimiento(Pokemon pokemon) {
		pokemon.setProximoMovimiento(pokemon.getEspecie().getMovimientos().get(rdm.nextInt(4)));
	}

	public int elegirOpcionCombate() {
		return 1;
	}
}
