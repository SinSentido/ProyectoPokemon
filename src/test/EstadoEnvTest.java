package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import baseDeDatos.Database;
import baseDeDatos.Movimiento;
import categoria.EstadoEnv;
import estados.Dormido;
import proyectoPokemon.Pokemon;

class EstadoEnvTest {

	/*Creamos las clases necesarias para hacer las pruebas*/
	private Pokemon pokemonAtacante = mock(Pokemon.class);
	private Pokemon pokemonObjetivo = new Pokemon(Database.INSTANCE.getEspecies().get(14));
	private Movimiento proximoMovimiento = mock(Movimiento.class);
	
	private EstadoEnv estadoEnv = new EstadoEnv();
	
	/*Si el estado del pokemon es sano*/
	@Test
	void testEstadoDor() {
		//Given
		/*Mockeamos el ataque*/
		when(proximoMovimiento.getPrecision()).thenReturn(100);
		
		/*Mockeamos el pokemonAtacante*/
		when(pokemonAtacante.getProximoMovimiento()).thenReturn(proximoMovimiento);
		
		estadoEnv.calcularDaño(pokemonAtacante, pokemonObjetivo);
		
		/*El estado del pokemonObjetivo debería de cambiar a envenenado*/
		assertEquals(pokemonObjetivo.getEstado().getNombre(), "Envenenado");
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
		pokemonObjetivo.setEstado(new Dormido());
		
		estadoEnv.calcularDaño(pokemonAtacante, pokemonObjetivo);
		
		/*El estado del pokemon no debeŕia variar*/
		assertEquals(pokemonObjetivo.getEstado().getNombre(), "Dormido");
	}

}
