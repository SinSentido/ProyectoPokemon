package mvp;

import proyectoPokemon.Pokemon;

public interface PresentadorEstadoEnv {
	
	public void mostrarMensajeFalloAtaque();
	public void mostrarMensajeYaTieneEstado(Pokemon pokemon);
}
