package proyectoPokemon;

import java.util.Random;

import mvp.Presentador;
import mvp.PresentadorMaquina;

public class Maquina extends Entrenador implements PresentadorMaquina{
	private Presentador presentadorMaquina = new Presentador();
	
	public Maquina() {
		setNombre("Blue");
	}

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

	/*METODOS PRESENTADOR*/
	public String pedirNombreMaquina() {
		return presentadorMaquina.pedirNombreMaquina();
	}
}
