package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

import baseDeDatos.Database;
import baseDeDatos.Especie;
import baseDeDatos.Movimiento;
import baseDeDatos.Tipo;
import categoria.Fisico;
import proyectoPokemon.Pokemon;

class FisicoTest {

	/*Clases necesarias para las pruebas*/
	private Pokemon pokemonAtacante = mock(Pokemon.class);
	private Pokemon pokemonObjetivo = new Pokemon(Database.INSTANCE.getEspecies().get(14));
	private Tipo tipo = mock(Tipo.class);
	private Especie especie = mock(Especie.class);
	private Movimiento proximoMovimiento = mock(Movimiento.class);
	
	private Fisico fisico = new Fisico();
	
	
	@Test
	public void testCalcularDañoFisico() {
		
		//Given
		/*Mockeamos el tipo del movimiento y del pokemon atacante Tipo = Bicho (es igual en los dos)*/
		when(tipo.getId()).thenReturn(2);
		
		/*Mockeamos los datos de la especie que necesitamos del pokemon atacante. Especie = Pinsir*/
		when(especie.getAtaque()).thenReturn(194);
		when(especie.getTipo()).thenReturn(tipo);
		
		/*Mockeamos el movimiento que se va a realizar Ataque = TijeraX*/
		when(proximoMovimiento.getPotencia()).thenReturn(85);
		when(proximoMovimiento.getPrecision()).thenReturn(100);
		when(proximoMovimiento.getTipo()).thenReturn(tipo);
		
		/*Mockeamos las propiedades necesarias del pokemonAtacante*/
		when(pokemonAtacante.getProximoMovimiento()).thenReturn(proximoMovimiento);
		when(pokemonAtacante.getEspecie()).thenReturn(especie);
		
		fisico.calcularDaño(pokemonAtacante, pokemonObjetivo);
		
		/*El ataque hace de 34 a 40 puntos de daño*/
		assertTrue(pokemonObjetivo.getVida()>=140 && pokemonObjetivo.getVida()<=146);
	}
}
