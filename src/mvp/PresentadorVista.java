package mvp;

import baseDeDatos.Movimiento;
import proyectoPokemon.Entrenador;
import proyectoPokemon.Pokemon;

public interface PresentadorVista {
	
	public String pedirNombreUsuario();
	public String pedirNombreMaquina();
	public void presentacionCombate(String nombreUsuario, String nombreRival);
	public void mostrarListaPokemon(Entrenador entrenador);
	public void mostrarInicioCombate(Entrenador usuario, Entrenador rival);
	public void mostrarMensajeRendirse();
	public void mostrarMensajeCambio(Entrenador entrenador);
	
	/*Menus*/
	public int ejecutarMenuCombate(Entrenador usuario, Entrenador rival);
	public Movimiento ejecutarMenuMovimientos(Pokemon pokemon);
	public Pokemon ejecutarMenuCambiarPokemon(Entrenador usuario);
}
