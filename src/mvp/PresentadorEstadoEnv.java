package mvp;

import proyectoPokemon.Pokemon;

public interface PresentadorEstadoEnv {
	
	public void mostrarMensajeFalloAtaque();
	public void mostrarMensajeYaTieneEstado(Pokemon pokemon);
	public void mostrarMensajePokemonDebilitado(Pokemon pokemon);
	public void mostrarMensajeEnvenenado(Pokemon pokemon);

}
