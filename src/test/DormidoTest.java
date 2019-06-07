package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseDeDatos.Database;
import estados.Dormido;
import estados.Sano;
import proyectoPokemon.Pokemon;

class DormidoTest {

	/*Clases necesarias para hacer las pruebas*/
	private Pokemon pokemonAtacante = new Pokemon(Database.INSTANCE.getEspecies().get(14));
	
	/*Se prueba que el estado dormido dura de 1 a 5 turnos y que al finalizar cambia el estado a Sano*/
	@Test
	void testTurnosDormido() {
		int cont = 0;
		pokemonAtacante.setEstado(new Dormido()); //Suponiendo que el estado del pokemon es dormido
		((Dormido)pokemonAtacante.getEstado()).turnosDormido(); //Se asignan los turnos aleatorios al estado
 		int maxTurnos = ((Dormido)pokemonAtacante.getEstado()).getMaxTurnosDorm(); 
 		
		do {
			if(pokemonAtacante.getEstado() instanceof Dormido) {
				cont++;
			}
			pokemonAtacante.getEstado().resolverEstado(pokemonAtacante);
		}while(pokemonAtacante.getEstado() instanceof Dormido);	
		
		
		//Se comprueba que el número de turnos transcurridos sea el mismo que el número máximo de turnos dormido
		assertEquals(maxTurnos, cont);
		//Se comprueba que el estado se cambia correctamente a sano
		assertTrue(pokemonAtacante.getEstado() instanceof Sano); 
	}
	
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

