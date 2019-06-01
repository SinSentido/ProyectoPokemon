package mvp;

import baseDeDatos.Movimiento;
import proyectoPokemon.Entrenador;
import proyectoPokemon.Pokemon;

public class Presentador implements PresentadorEntrenador, PresentadorCombate{

	PresentadorVista presentadorVista = new Vista();
	
	/*Metodos PresentadorEntrenador*/
	public String pedirNombreUsuario() {	
		return presentadorVista.pedirNombreUsuario();
	}
	
	public String pedirNombreMaquina() {
		return presentadorVista.pedirNombreMaquina();
	}
	
	
	/*Metodos PresentadorCombate*/
	public void presentacionCombate(String nombreUsuario, String nombreRival) {
		presentadorVista.presentacionCombate(nombreUsuario, nombreRival);
	}
	
	public void mostrarListaPokemon(Entrenador entrenador) {
		presentadorVista.mostrarListaPokemon(entrenador);
	}

	public void mostrarInicioCombate(Entrenador usuario, Entrenador rival) {
		presentadorVista.mostrarInicioCombate(usuario, rival);
	}
	
	public void mostrarMensajeRendicion() {
		presentadorVista.mostrarMensajeRendirse();
	}
	
	public void mostrarMensajeCambio(Entrenador entrenador) {
		presentadorVista.mostrarMensajeCambio(entrenador);
	}

	
	
	/*Menus del combate*/
	public int ejecutarMenuCombate(Entrenador usuario, Entrenador rival) {
		return presentadorVista.ejecutarMenuCombate(usuario, rival);
	}

	public Movimiento ejecutarMenuMovimientos(Pokemon pokemon) {
		return presentadorVista.ejecutarMenuMovimientos(pokemon);
	}

	public Pokemon ejecutarMenuCambiarPokemon(Entrenador usuario) {
		return presentadorVista.ejecutarMenuCambiarPokemon(usuario);
	}
}
