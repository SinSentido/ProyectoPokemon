package mvp;

import proyectoPokemon.Pokemon;

public interface PresentadorEstadoPar {

	public void mostrarMensajeFalloAtaque();
	public void mostrarMensajeYaTieneEstado(Pokemon pokemon);
	public void mostrarMensajeParalizado(Pokemon pokemon);

}
