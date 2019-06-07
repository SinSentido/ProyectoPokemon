package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import baseDeDatos.Database;
import proyectoPokemon.Entrenador;
import proyectoPokemon.Pokemon;
import proyectoPokemon.Usuario;

class EntrenadorTest {

	/*Clases necesarias para hacer la prueba*/
	Entrenador entrenador = new Usuario();
	
	
	/*Se le piden 3 pokemon a la factoria*/
	@Test
	void testPedir3Pokemon() {
		entrenador.darPokemon(3);
		
		assertEquals(entrenador.getListaPokemon().size(), 3);
		assertFalse(comprobarRepetidos(entrenador.getListaPokemon()));
	}
	
	/*Se le pide 1 pokemon a la factoria*/
	@Test
	void testPedir1Pokemon() {
		entrenador.darPokemon(1);
		
		assertEquals(entrenador.getListaPokemon().size(), 1);
	}
	
	/*Se le piden todos pokemon a la factoria*/
	@Test
	void testPedirTodosLosPokemon() {
		int maxNumPokemon = Database.INSTANCE.getEspecies().size();
		entrenador.darPokemon(maxNumPokemon);
		
		assertEquals(entrenador.getListaPokemon().size(), maxNumPokemon);
		assertFalse(comprobarRepetidos(entrenador.getListaPokemon()));
	}
	
	/*Se le piden 0 o menos pokemon a la factoría*/
	@Test
	void testPedir0Pokemon() {
		assertThrows(IllegalArgumentException.class, () -> entrenador.darPokemon(0));
	}
	
	/*Se le piden más pokemon a la factoría de los que hay en la base de datos*/
	@Test
	void testPedir55Pokemon() {		
		int numPokemon = Database.INSTANCE.getEspecies().size()+1;
		assertThrows(IllegalArgumentException.class, () -> entrenador.darPokemon(numPokemon));
	}
	
	/*Metodo para comprobar que no hay pokemon repetidos*/
	private boolean comprobarRepetidos(List<Pokemon> listaPokemon) {
		boolean repetido = false;
		for(int i=0; i<listaPokemon.size(); i++) {
			for(int j=0; j<listaPokemon.size(); j++) {
				if(listaPokemon.get(i).equals(listaPokemon.get(j)) && i!=j) {
					repetido = true;
				}
			}
		}
		
		return repetido;
	}
}
