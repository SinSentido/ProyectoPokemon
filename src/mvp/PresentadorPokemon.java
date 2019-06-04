package mvp;

import proyectoPokemon.Pokemon;

public interface PresentadorPokemon {
	public void mostrarMensajeDormido(Pokemon pokemon);
	public void mostrarMensajeDebilitado(Pokemon pokemon);
	public void mostrarMensajeEnvenenado(Pokemon pokemon);
	public void mostrarMensajeParalizado(Pokemon pokemon);
}
