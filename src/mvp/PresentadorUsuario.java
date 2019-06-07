package mvp;

import baseDeDatos.Movimiento;
import proyectoPokemon.Entrenador;
import proyectoPokemon.Pokemon;

public interface PresentadorUsuario {
	
	public String pedirNombreUsuario();
	public void cambiarAPokemonDebilitado();
	public void cambiarAMismoPokemon();
	public void mostrarListaPokemon(Entrenador entrenador);
	public Pokemon ejecutarMenuCambiarPokemon(Entrenador usuario);
	public Movimiento ejecutarMenuMovimientos(Pokemon pokemon);
	public int ejecutarMenuCombate();
}
