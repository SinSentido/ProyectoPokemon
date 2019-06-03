package mvp;

import baseDeDatos.Movimiento;
import proyectoPokemon.Entrenador;
import proyectoPokemon.Pokemon;

public interface PresentadorVista {
	
	/********************************/
	/***********ENTRENADOR***********/
	
	public String pedirNombreUsuario();
	public String pedirNombreMaquina();
	public int ejecutarMenuCombate();
	public Movimiento ejecutarMenuMovimientos(Pokemon pokemon);
	public Pokemon ejecutarMenuCambiarPokemon(Entrenador usuario);
	public void cambiarAPokemonDebilitado();
	public void cambiarAMismoPokemon();
	
	
	
	/****************************/
	/***********ESTADO***********/
	
	public void mostrarMensajeAtaque(Pokemon pokemon);
	
	/*Dormido*/
	public void mostrarMensajeAtacarDormido(Pokemon pokemon);
	public void mostrarMensajeDespertar(Pokemon pokemon);
	
	/*Envenenado*/
	public void mostrarMensajeCurarVeneno(Pokemon pokemon);
	public void mostrarMensajeDañoVeneno(Pokemon pokemon);
	
	/*Paralizado*/
	public void mostrarMensajeAtacarParalizado(Pokemon pokemon);
	
	
	/******************************/
	/***********CATEGORIA**********/
	
	public void mostrarMensajeFalloAtaque();
	public void mostrarMensajeDormido(Pokemon pokemon);
	public void mostrarMensajeEnvenenado(Pokemon pokemon);
	public void mostrarMensajeParalizado(Pokemon pokemon);
	public void mostrarMensajeDañoAtaque(Pokemon pokemon, double daño);
	public void mostrarMensajeYaTieneEstado(Pokemon pokemon);
	
	
	/*****************************/
	/***********COMBATE***********/
	
	public void presentacionCombate(String nombreUsuario, String nombreRival);
	public void mostrarListaPokemon(Entrenador entrenador);
	public void mostrarInicioCombate(Entrenador usuario, Entrenador rival);
	public void mostrarMensajeRendirse();
	public void mostrarMensajeCambio(Entrenador entrenador);
	public void mostrarPokemonLuchando(Entrenador entrenador1, Entrenador entrenador2);
	public void mostrarMensajePokemonDebilitado(Pokemon pokemon);
	public void mostrarMensajeFueraDeCombate(Entrenador entrenador);
	public int mostrarMenuFinCombate();

}
