package mvp;

import proyectoPokemon.Pokemon;

public interface PresentadorCategoria {
	




	public void mostrarMensajeDañoAtaque(Pokemon pokemon, double daño);
	public void mostrarMensajeFalloAtaque();
	public void mostrarMensajePokemonDebilitado(Pokemon pokemon);
	public void mostrarMensajeYaTieneEstado(Pokemon pokemon);

}
