package mvp;

import proyectoPokemon.Pokemon;

public interface PresentadorEstadoDor {
	
	public void mostrarMensajeFalloAtaque();
	public void mostrarMensajeYaTieneEstado(Pokemon pokemon);
	public void mostrarMensajeDormido(Pokemon pokemon);

}
