package mvp;

import baseDeDatos.Movimiento;
import proyectoPokemon.Entrenador;
import proyectoPokemon.Pokemon;

public class Presentador {

	PresentadorVista presentadorVista = new Vista();
	
	
	/***************************************************/
	/***********Metodos PresentadorEntrenador***********/
	
	public String pedirNombreUsuario() {	
		return presentadorVista.pedirNombreUsuario();
	}
	
	public String pedirNombreMaquina() {
		return presentadorVista.pedirNombreMaquina();
	}
	
	public int ejecutarMenuCombate() {
		return presentadorVista.ejecutarMenuCombate();
	}

	public Movimiento ejecutarMenuMovimientos(Pokemon pokemon) {
		return presentadorVista.ejecutarMenuMovimientos(pokemon);
	}

	public Pokemon ejecutarMenuCambiarPokemon(Entrenador usuario) {
		return presentadorVista.ejecutarMenuCambiarPokemon(usuario);
	}
	
	public void cambiarAPokemonDebilitado() {
		presentadorVista.cambiarAPokemonDebilitado();
	}
	
	public void cambiarAMismoPokemon() {
		presentadorVista.cambiarAMismoPokemon();
	}
	
	/*************************************************/
	/************Metodos PresentadorEstado************/	

	
	public void mostrarMensajeAtaque(Pokemon pokemon) {
		presentadorVista.mostrarMensajeAtaque(pokemon);
	}
	
	/*Dormido*/
	public void mostrarMensajeAtacarDormido(Pokemon pokemon) {
		presentadorVista.mostrarMensajeAtacarDormido(pokemon);
	}
	
	public void mostrarMensajeDespertar(Pokemon pokemon) {
		presentadorVista.mostrarMensajeDespertar(pokemon);
	}
	
	/*Envenenado*/
	public void mostrarMensajeCurarVeneno(Pokemon pokemon) {
		presentadorVista.mostrarMensajeCurarVeneno(pokemon);
	}
	
	public void mostrarMensajeDañoVeneno(Pokemon pokemon) {
		presentadorVista.mostrarMensajeDañoVeneno(pokemon);
	}
	
	/*Paralizado*/
	public void mostrarMensajeAtacarParalizado(Pokemon pokemon) {
		presentadorVista.mostrarMensajeAtacarParalizado(pokemon);
	}
	
	
	/**************************************************/
	/***********Metodos PresentadorCategoria***********/
	
	public void mostrarMensajeFalloAtaque() {
		presentadorVista.mostrarMensajeFalloAtaque();
	}
	
	public void mostrarMensajeDormido(Pokemon pokemon) {
		presentadorVista.mostrarMensajeDormido(pokemon);
	}
	
	public void mostrarMensajeEnvenenado(Pokemon pokemon) {
		presentadorVista.mostrarMensajeEnvenenado(pokemon);
	}
	
	public void mostrarMensajeParalizado(Pokemon pokemon) {
		presentadorVista.mostrarMensajeParalizado(pokemon);
	}
	
	public void mostrarMensajeDañoAtaque(Pokemon pokemon, double daño) {
		presentadorVista.mostrarMensajeDañoAtaque(pokemon, daño);
	}
	
	public void mostrarMensajeYaTieneEstado(Pokemon pokemon) {
		presentadorVista.mostrarMensajeYaTieneEstado(pokemon);
	}
	
	
	
	/************************************************/
	/***********Metodos PresentadorCombate***********/
	
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
	
	public void mostrarPokemonLuchando(Entrenador entrenador1, Entrenador entrenador2) {
		presentadorVista.mostrarPokemonLuchando(entrenador1, entrenador2);
	}
	
	public void mostrarMensajeFueraDeCombate(Entrenador entrenador) {
		presentadorVista.mostrarMensajeFueraDeCombate(entrenador);
	}
	
	public void mostrarMensajePokemonDebilitado(Pokemon pokemon) {
		presentadorVista.mostrarMensajePokemonDebilitado(pokemon);
	}
	
	public int mostrarMenuFinCombate() {
		return presentadorVista.mostrarMenuFinCombate();
	}

}
