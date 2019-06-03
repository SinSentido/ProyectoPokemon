package categoria;

import java.util.Random;

import baseDeDatos.Database;
import baseDeDatos.Movimiento;
import estados.Debilitado;
import mvp.Presentador;
import mvp.PresentadorCategoria;
import proyectoPokemon.Pokemon;

public class Especial implements Categoria{
	private PresentadorCategoria presentadorCategoria = new Presentador();
	private Random rdm = new Random(); 
	
	/*variables para guardar los valores que se aplicaran en la formula*/
	private double n, a, p, d, b, e, v, daño;
	
	public void calcularDaño(Pokemon pokemonAtacante, Pokemon pokemonObjetivo) {
		if(rdm.nextInt(100)+1 <= pokemonAtacante.getProximoMovimiento().getPrecision()) { //Si acierta el ataque
			//Asigno el valor a las variables de la formula
			n = 50; //Nivel del pokemon
			a = pokemonAtacante.getEspecie().getAtqesp(); //Ataque especial del pokemon
			p = pokemonAtacante.getProximoMovimiento().getPotencia(); //Potencia del ataque
			d = pokemonObjetivo.getEspecie().getDefesp(); //Defensa especial del pokemon
			b = pokemonAtacante.getProximoMovimiento().getTipo() //Bonificacion
					.equals(pokemonAtacante.getEspecie().getTipo())?1.5:1; 
			e = calcularEfectividad(pokemonAtacante.getProximoMovimiento(), pokemonObjetivo); //Efectividad del ataque
			v = (double)rdm.nextInt(100-85)+85; //Variacion del ataque (aleatorio entre 85 y 100)
			
			daño = aplicarFormulaDaño();
			pokemonObjetivo.setVida(pokemonObjetivo.getVida()-(int)daño);
			presentadorCategoria.mostrarMensajeDañoAtaque(pokemonObjetivo, daño);
			
			//Se comprueba si el pokemon se ha debilitado y si es el caso se cambia su estado.
			if(pokemonObjetivo.getVida() <= 0) {
				pokemonObjetivo.setEstado(new Debilitado());
				presentadorCategoria.mostrarMensajePokemonDebilitado(pokemonObjetivo);
			}
		}
		else { //si falla el ataque
			presentadorCategoria.mostrarMensajeFalloAtaque();
		}
		
	}
	
	private double calcularEfectividad(Movimiento movimiento, Pokemon pokemonObjetivo) {
		return Database.INSTANCE.getEfectividades().get(movimiento.getTipo().getId())
						.get(pokemonObjetivo.getEspecie().getTipo().getId());
	}
	
	private double aplicarFormulaDaño() {		
		return 0.01*b*e*v*(((0.2*n+1)*a*p)/(25*d)+2);
	}
}
