package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import baseDeDatos.Database;
import baseDeDatos.Especie;
import baseDeDatos.Movimiento;
import baseDeDatos.Tipo;
import categoria.Especial;
import proyectoPokemon.Pokemon;

class EspecialTest {

	/*Clases necesarias para las pruebas*/
	private Pokemon pokemonAtacante = mock(Pokemon.class);
	private Pokemon pokemonObjetivo = new Pokemon(Database.INSTANCE.getEspecies().get(14));
	private Tipo tipo = mock(Tipo.class);
	private Especie especie = mock(Especie.class);
	private Movimiento proximoMovimiento = mock(Movimiento.class);
	
	private Especial especial = new Especial();
	
	@Test
	public void testCalcularDañoEspecial() {
		//Given
		/*Mockeamos el tipo del ataque y del pokemon atacante. Tipo = Agua (es igual en los dos)*/
		when(tipo.getId()).thenReturn(1);
		
		/*Mockeamos los datos de la especie que necesitamos del pokemon atacante. Especie = Cloyster*/
		when(especie.getAtqesp()).thenReturn(150);
		when(especie.getTipo()).thenReturn(tipo);
		
		/*Mockeamos el movimiento que se va a realizar. Movimiento = Surf*/
		when(proximoMovimiento.getPotencia()).thenReturn(90);
		when(proximoMovimiento.getPrecision()).thenReturn(100);
		when(proximoMovimiento.getTipo()).thenReturn(tipo);
		
		/*Mockeamos las propiedades necesarias del pokemonAtacante*/
		when(pokemonAtacante.getProximoMovimiento()).thenReturn(proximoMovimiento);
		when(pokemonAtacante.getEspecie()).thenReturn(especie);
		
		especial.calcularDaño(pokemonAtacante, pokemonObjetivo);
		
		/*El ataque hace de 63 a 74 puntos de daño*/
		assertTrue(pokemonObjetivo.getVida()>=106 && pokemonObjetivo.getVida()<=117);
	}

}
