package proyectoPokemon;

import java.util.List;

import baseDeDatos.Especie;
import estados.Estado;
import estados.Sano;

public class Pokemon{
	
	private int vida, velocidad;
	private Estado estado;
	private Especie especie;

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
}
