package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import baseDeDatos.Database;
import baseDeDatos.Movimiento;
import categoria.EstadoDor;
import estados.Envenenado;
import proyectoPokemon.Pokemon;

class EstadoDorTest {
	
	/*Creamos las clases necesarias para hacer las pruebas*/
	private Pokemon pokemonAtacante = mock(Pokemon.class);
	private Pokemon pokemonObjetivo = new Pokemon(Database.INSTANCE.getEspecies().get(14));
	private Movimiento proximoMovimiento = mock(Movimiento.class);
	
	private EstadoDor estadoDor = new EstadoDor();
	
	/*Si el estado del pokemon es sano*/
	@Test
	void testEstadoDor() {
		//Given
		/*Mockeamos el ataque*/
		when(proximoMovimiento.getPrecision()).thenReturn(100);
		
		/*Mockeamos el pokemonAtacante*/
		when(pokemonAtacante.getProximoMovimiento()).thenReturn(proximoMovimiento);
		
		estadoDor.calcularDaño(pokemonAtacante, pokemonObjetivo);
		
		assertEquals(pokemonObjetivo.getEstado().getNombre(), "Dormido");
	}
	
	/*Si el estado del pokemon es diferente de sano*/
	@Test
	void testEstadoDorDiferenteSano() {
		//Given
		/*Mockeamos el ataque*/
		when(proximoMovimiento.getPrecision()).thenReturn(100);
		
		/*Mockeamos el pokemonAtacante*/
		when(pokemonAtacante.getProximoMovimiento()).thenReturn(proximoMovimiento);
		
		/*Le ponemos al pokemon objetivo un estado diferente a Sano*/
		pokemonObjetivo.setEstado(new Envenenado());
		
		estadoDor.calcularDaño(pokemonAtacante, pokemonObjetivo);
		
		assertEquals(pokemonObjetivo.getEstado().getNombre(), "Envenenado");
	}
}
