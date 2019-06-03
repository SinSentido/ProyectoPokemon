package mvp;

import proyectoPokemon.Pokemon;

public interface PresentadorFisicoEspecial {
	
	public void mostrarMensajeFalloAtaque();
	public void mostrarMensajePokemonDebilitado(Pokemon pokemon);
	public void mostrarMensajeDañoAtaque(Pokemon pokemon, double daño);

}
