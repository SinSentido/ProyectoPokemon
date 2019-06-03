package mvp;

import proyectoPokemon.Pokemon;

public interface PresentadorCategoria {
	
	public void mostrarMensajeFalloAtaque();
	public void mostrarMensajeDormido(Pokemon pokemon);
	public void mostrarMensajeEnvenenado(Pokemon pokemon);
	public void mostrarMensajeParalizado(Pokemon pokemon);
	public void mostrarMensajeDañoAtaque(Pokemon pokemon, double daño);
	public void mostrarMensajePokemonDebilitado(Pokemon pokemon);
	public void mostrarMensajeYaTieneEstado(Pokemon pokemon);

}
