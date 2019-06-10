package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseDeDatos.Database;
import estados.Dormido;
import proyectoPokemon.Pokemon;

class DormidoTest {

	/*Clases necesarias para hacer las pruebas*/
	private Pokemon pokemonAtacante = new Pokemon(Database.INSTANCE.getEspecies().get(14));
	
	/*Se prueba que el número de turnos dormido no sea menor de 1 ni mayor de 5*/
	@Test
	void testNumTurnos() {
		int maxTurnos;
		pokemonAtacante.setEstado(new Dormido());
		
		for(int i=0; i<100; i++) {
			((Dormido)pokemonAtacante.getEstado()).turnosDormido(); //Se asignan los turnos aleatorios al estado
	 		maxTurnos = ((Dormido)pokemonAtacante.getEstado()).getMaxTurnosDorm(); 
	 		assertTrue(maxTurnos >= 1 && maxTurnos <=5);
		}
	}
}

