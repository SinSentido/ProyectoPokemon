package proyectoPokemon;

import baseDeDatos.Especie;
import baseDeDatos.Movimiento;
import estados.Debilitado;
import estados.Dormido;
import estados.Envenenado;
import estados.Estado;
import estados.Paralizado;
import estados.Sano;

public class Pokemon{
	
	private int vida, velocidad;
	private Estado estado;
	private Especie especie;
	private Movimiento proximoMovimiento;
	
	private final Estado sano = new Sano();
	private final Estado dormido = new Dormido();
	private final Estado envenenado = new Envenenado();
	private final Estado paralizado = new Paralizado();
	private final Estado debilitado = new Debilitado();

	public Pokemon(Especie especie) {
		this.vida = especie.getVida();
		this.velocidad = especie.getVelocidad();
		this.especie = especie;
		estado = new Sano();
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Especie getEspecie() {
		return especie;
	}
	
	public void setProximoMovimiento(Movimiento proximoAtaque) {
		this.proximoMovimiento = proximoAtaque;
	}
	
	public Movimiento getProximoMovimiento() {
		return proximoMovimiento;
	}
	
	public void moveToSanoState() {
		estado = sano;
		velocidad = especie.getVelocidad();
	}
	
	public void moveToDormidoState() {
		estado = dormido;
	}
	
	public void moveToEnvenenadoState() {
		estado = envenenado;
	}
	
	public void moveToParalizadoState() {
		estado = paralizado;
		velocidad = especie.getVelocidad()/2;
	}
	
	public void moveToDebilitadoState() {
		estado = debilitado;
	}
}
