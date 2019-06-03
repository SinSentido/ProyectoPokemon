package proyectoPokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import factoriaPokemon.FactoriaPokemon;
import factoriaPokemon.GenerarPokemon;
import mvp.Presentador;
import mvp.PresentadorEntrenador;

public abstract class Entrenador {
	
	private PresentadorEntrenador presentadorEntrenador = new Presentador();
	private String nombre;
	private boolean luchando, cambiando, derrotado=false;

	protected List<Pokemon> listaPokemon = new ArrayList<>();
	protected Pokemon pokemonCombatiente;
	
	public abstract void cambiarPokemon(Pokemon pokemon);
	
	public abstract void elegirSiguienteMovimiento(Pokemon pokemon);
	
	public abstract int elegirOpcionCombate();
	
	
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
	
	public PresentadorEntrenador getPresentadorEntrenador() {
		return presentadorEntrenador;
	}
	
	public void setPokemonCombatiente(Pokemon pokemon) {
		pokemonCombatiente = pokemon;
	}
	
	public Pokemon getPokemonCombatiente() {
		return pokemonCombatiente;
	}
	
	/*Metodo para asignar X pokemon a un entrenador*/
	public void darPokemonAEntrenador(int numPokemon) {
		FactoriaPokemon factoriaPokemon = new GenerarPokemon();
		Random rdm = new Random();
		
		boolean pokemonRepetido = false;
		
		//Asigno tantos pokemon como se han indicado por parametro al entrenador indicado por parametro.
		for(int i=0; i<numPokemon; i++) {
			do {
				pokemonRepetido = false;
				listaPokemon.add(
						factoriaPokemon.generarPokemon(rdm.nextInt(factoriaPokemon.getNumeroEspecies())+1));
				
				//Se comprueba que el pokemon dado no coincide con ninguno de la lista
				for (int j=0; j<i; j++) {
					if(listaPokemon.get(i).getEspecie().getNombre()
							.equals(listaPokemon.get(j).getEspecie().getNombre())) {
						pokemonRepetido = true;
					}
				}
				//Si el pokemon esta repetido se borra
				if(pokemonRepetido) {
					listaPokemon.remove(i);
				}
			}while(pokemonRepetido);
		}
	}

}
