package mvp;

import proyectoPokemon.Pokemon;

public interface PresentadorEnvenenado {
	
	public void mostrarMensajeAtaque(Pokemon pokemon);
	public void mostrarMensajeCurarVeneno(Pokemon pokemon);
	public void mostrarMensajeDañoVeneno(Pokemon pokemon);

}
