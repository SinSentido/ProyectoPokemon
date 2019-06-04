package proyectoPokemon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import baseDeDatos.Movimiento;
import factoriaPokemon.FactoriaPokemon;
import factoriaPokemon.GenerarPokemon;
import mvp.Presentador;
import mvp.PresentadorEntrenador;

public abstract class Entrenador implements PresentadorEntrenador{
	
	private Presentador presentadorEntrenador = new Presentador();
	private String nombre;
	private boolean luchando, cambiando, derrotado=false;

	private List<Pokemon> listaPokemon = new ArrayList<>();
	private Pokemon pokemonCombatiente;
	
	public abstract void cambiarPokemon(Pokemon pokemon);
	
	public abstract void elegirSiguienteMovimiento(Pokemon pokemon);
	
	public abstract int elegirOpcionCombate();
	
	/*Metodo para asignar X pokemon a un entrenador*/	
	public void darPokemon(int numPokemon){
		Random rdm = new Random();
		FactoriaPokemon factoriaPokemon = new GenerarPokemon();
		Set<Pokemon> pokemon = new HashSet<>();
		
		do {
			pokemon.add(factoriaPokemon.generarPokemon(rdm.nextInt(factoriaPokemon.getNumeroEspecies())+1));
		}while(pokemon.size() < numPokemon);
		
		listaPokemon.addAll(pokemon);
	}
	
	
	/*GETTERS Y SETTERS*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
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
	
	public boolean isDerrotado() {
		return derrotado;
	}

	public void setDerrotado(boolean derrotado) {
		this.derrotado = derrotado;
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
	
	/*METODOS PRESENTADOR*/
	public String pedirNombreUsuario() {
		return presentadorEntrenador.pedirNombreUsuario();
	}

	public String pedirNombreMaquina() {
		return presentadorEntrenador.pedirNombreMaquina();
	}

	public void cambiarAPokemonDebilitado() {
		presentadorEntrenador.cambiarAPokemonDebilitado();
	}

	public void cambiarAMismoPokemon() {
		presentadorEntrenador.cambiarAMismoPokemon();
	}

	public Pokemon ejecutarMenuCambiarPokemon(Entrenador usuario) {
		return presentadorEntrenador.ejecutarMenuCambiarPokemon(usuario);
	}

	public Movimiento ejecutarMenuMovimientos(Pokemon pokemon) {
		return presentadorEntrenador.ejecutarMenuMovimientos(pokemon);
	}

	public int ejecutarMenuCombate() {
		return presentadorEntrenador.ejecutarMenuCombate();
	}
}
