package mvp;

import baseDeDatos.Movimiento;
import proyectoPokemon.Entrenador;
import proyectoPokemon.Pokemon;

public interface PresentadorEntrenador {
	
	public String pedirNombreUsuario();
	public String pedirNombreMaquina();
	
	public void cambiarAPokemonDebilitado();
	public void cambiarAMismoPokemon();
	
	public Pokemon ejecutarMenuCambiarPokemon(Entrenador usuario);
	public Movimiento ejecutarMenuMovimientos(Pokemon pokemon);
	public int ejecutarMenuCombate();

}
