package proyectoPokemon;

import baseDeDatos.Movimiento;
import mvp.Presentador;
import mvp.PresentadorUsuario;

public class Usuario extends Entrenador implements PresentadorUsuario{
	private Presentador presentadorUsuario = new Presentador();
	
	public Usuario() {
		setNombre("Red");
	}
	
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
				setPokemonCombatiente(nuevoPokemon);
			}
		}while(!eleccionValida);
	}

	public void elegirSiguienteMovimiento(Pokemon pokemon, Pokemon pokemonRival) {
		pokemon.setProximoMovimiento(ejecutarMenuMovimientos(pokemon));
	}
	
	public int elegirOpcionCombate() {
		return ejecutarMenuCombate();
	}
	
	/*METODOS PRESENTADOR*/
	public String pedirNombreUsuario() {
		return presentadorUsuario.pedirNombreUsuario();
	}
	
	public void cambiarAPokemonDebilitado() {
		presentadorUsuario.cambiarAPokemonDebilitado();
	}

	public void cambiarAMismoPokemon() {
		presentadorUsuario.cambiarAMismoPokemon();
	}

	public Pokemon ejecutarMenuCambiarPokemon(Entrenador usuario) {
		return presentadorUsuario.ejecutarMenuCambiarPokemon(usuario);
	}

	public Movimiento ejecutarMenuMovimientos(Pokemon pokemon) {
		return presentadorUsuario.ejecutarMenuMovimientos(pokemon);
	}

	public int ejecutarMenuCombate() {
		return presentadorUsuario.ejecutarMenuCombate();
	}
	
	public void mostrarListaPokemon(Entrenador entrenador) {
		presentadorUsuario.mostrarListaPokemon(entrenador);
	}
}
