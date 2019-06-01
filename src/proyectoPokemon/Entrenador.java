package proyectoPokemon;

import java.util.ArrayList;
import java.util.List;

import baseDeDatos.Movimiento;
import mvp.Presentador;
import mvp.PresentadorEntrenador;

public class Entrenador {
	
	private PresentadorEntrenador presentadorEntrenador = new Presentador();
	protected String nombre;
	private Movimiento proximoMovimiento;
	private boolean luchando, cambiando;

	private List<Pokemon> listaPokemon = new ArrayList<>();
	private Pokemon pokemonCombatiente;
	
	public Entrenador(){
	}

	
	/*GETTERS Y SETTERS*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setProximoMovimiento(Movimiento proximoAtaque) {
		this.proximoMovimiento = proximoAtaque;
	}
	
	public Movimiento getProximoMovimiento() {
		return proximoMovimiento;
	}
	
	public boolean isLuchando() {
		return luchando;
	}

	public void setLuchando(boolean lucha) {
		this.luchando = lucha;
	}

	public boolean isCambiando() {
		return cambiando;
	}

	public void setCambiando(boolean cambia) {
		this.cambiando = cambia;
	}
	
	public List<Pokemon> getListaPokemon(){
		return listaPokemon;
	}
	
	public void setPokemonCombatiente(Pokemon pokemon) {
		pokemonCombatiente = pokemon;
	}
	
	public Pokemon getPokemonCombatiente() {
		return pokemonCombatiente;
	}
	
	public PresentadorEntrenador getPresentadorEntrenador() {
		return presentadorEntrenador;
	}

}
