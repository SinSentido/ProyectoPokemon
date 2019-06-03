package mvp;

import proyectoPokemon.Pokemon;

public interface PresentadorEstado {

	public void mostrarMensajeAtaque(Pokemon pokemon);
	
	/*Dormido*/
	public void mostrarMensajeAtacarDormido(Pokemon pokemon);
	public void mostrarMensajeDespertar(Pokemon pokemon);
	
	/*Envenenado*/
	public void mostrarMensajeCurarVeneno(Pokemon pokemon);
	public void mostrarMensajeDañoVeneno(Pokemon pokemon);
	
	/*Paralizado*/
	public void mostrarMensajeAtacarParalizado(Pokemon pokemon);
}
