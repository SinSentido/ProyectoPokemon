package proyectoPokemon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseDeDatos.Database;
import factoriaPokemon.FactoriaPokemon;
import factoriaPokemon.GenerarPokemon;

public abstract class Entrenador{
	private String nombre;
	private boolean luchando, cambiando, derrotado=false, ganador=false;

	private List<Pokemon> listaPokemon = new ArrayList<>();
	private Pokemon pokemonCombatiente;
	
	public abstract void cambiarPokemon(Pokemon pokemon);
	
	public abstract void elegirSiguienteMovimiento(Pokemon pokemon, Pokemon pokemonRival);
	
	public abstract int elegirOpcionCombate();
	
	/*Metodo para asignar X pokemon a un entrenador*/	
	public void darPokemon(int numPokemon){
		FactoriaPokemon factoriaPokemon = new GenerarPokemon();
		Set<Pokemon> pokemon = new HashSet<>();
		
		if(numPokemon > Database.INSTANCE.getEspecies().size() || numPokemon <= 0 ) {
			throw new IllegalArgumentException("El número de pokemon no repetidos no puede ser superior al número"
					+ "de pokemon en la base de datos o menor de 1");
		}
		
		do {
			pokemon.add(factoriaPokemon.generarPokemon());
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
	
	public boolean isGanador() {
		return ganador;
	}
	
	public void setGanador(boolean ganador) {
		this.ganador = ganador;
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
}
