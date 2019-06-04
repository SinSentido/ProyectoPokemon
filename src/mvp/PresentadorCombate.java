package mvp;

import proyectoPokemon.Entrenador;

public interface PresentadorCombate {
	public void presentacionCombate(String nombreUsuario, String nombreRival);
	public void mostrarInicioCombate(Entrenador usuario, Entrenador rival);
	public void mostrarMensajeRendicion();
	public void mostrarMensajeCambio(Entrenador entrenador);
	public void mostrarPokemonLuchando(Entrenador entrenador1, Entrenador entrenador2);
	public void mostrarMensajeFueraDeCombate(Entrenador entrenador);
	public int mostrarMenuFinCombate();

}
