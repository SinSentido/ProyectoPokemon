package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import baseDeDatos.Database;
import baseDeDatos.Movimiento;
import categoria.EstadoPar;
import estados.Envenenado;
import proyectoPokemon.Pokemon;

class EstadoParTest {

	/*Creamos las clases necesarias para hacer las pruebas*/
	private Pokemon pokemonAtacante = mock(Pokemon.class);
	private Pokemon pokemonObjetivo = new Pokemon(Database.INSTANCE.getEspecies().get(14));
	private Movimiento proximoMovimiento = mock(Movimiento.class);
	
	private EstadoPar estadoPar = new EstadoPar();
	
	/*Si el estado del pokemon es sano*/
	@Test
	void testEstadoDor() {
		//Given
		/*Mockeamos el ataque*/
		when(proximoMovimiento.getPrecision()).thenReturn(100);
		
		/*Mockeamos el pokemonAtacante*/
		when(pokemonAtacante.getProximoMovimiento()).thenReturn(proximoMovimiento);
		
		estadoPar.calcularDaño(pokemonAtacante, pokemonObjetivo);
		
		/*El estado del pokemonObjetivo debería de cambiar a paralizado*/
		assertEquals(pokemonObjetivo.getEstado().getNombre(), "Paralizado");
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
		
		estadoPar.calcularDaño(pokemonAtacante, pokemonObjetivo);
		
		/*El estado del pokemon no debeŕia variar*/
		assertEquals(pokemonObjetivo.getEstado().getNombre(), "Envenenado");
	}
}
