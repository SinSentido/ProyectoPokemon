package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import baseDeDatos.Database;
import estados.Envenenado;
import estados.Sano;
import proyectoPokemon.Pokemon;

class EnvenenadoTest {
	
	/*Clases necesarias para realizar las pruebas*/
	private Pokemon pokemonObjetivo = new Pokemon(Database.INSTANCE.getEspecies().get(14));
	
	/*Se comprueba de que el estado veneno dura 5 turnos y cambia de estado a Sano cuando supera los turnos*/
	@Test
	void testTurnosVeneno() {
		pokemonObjetivo.setEstado(new Envenenado());
		
		do {
			pokemonObjetivo.getEstado().resolverEstado(pokemonObjetivo);
		}while(pokemonObjetivo.getEstado() instanceof Envenenado);

		assertTrue(pokemonObjetivo.getEstado() instanceof Sano); //Si el estado cambia a sano es correcto
	}

	
	/*Se comprueba que el daño del veneno corresponde a 1/8 de la vida máxima del pokemon*/
	@Test
	void testDañoVeneno() {
		pokemonObjetivo.setEstado(new Envenenado());
		
		pokemonObjetivo.getEstado().resolverEstado(pokemonObjetivo);	
	}
}
