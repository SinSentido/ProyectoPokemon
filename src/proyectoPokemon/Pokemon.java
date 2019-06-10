package proyectoPokemon;

import baseDeDatos.Especie;
import baseDeDatos.Movimiento;
import estados.Debilitado;
import estados.Dormido;
import estados.Envenenado;
import estados.Estado;
import estados.Paralizado;
import estados.Sano;
import mvp.Presentador;
import mvp.PresentadorPokemon;

public class Pokemon implements PresentadorPokemon{
	private Presentador presentadorPokemon = new Presentador();
	private int vida, velocidad;
	private Estado estado;
	private Especie especie;
	private Movimiento proximoMovimiento;
	
	private final Estado SANO = new Sano();
	private final Estado DORMIDO = new Dormido();
	private final Estado ENVENENADO = new Envenenado();
	private final Estado PARALIZADO = new Paralizado();
	private final Estado DEBILITADO = new Debilitado();

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
		estado = SANO;
	}
	
	public void moveToDormidoState() {
		estado = DORMIDO;
		((Dormido) DORMIDO).turnosDormido();
//		mostrarMensajeDormido(this);
	}
	
	public void moveToEnvenenadoState() {
		estado = ENVENENADO;
//		mostrarMensajeEnvenenado(this);
	}
	
	public void moveToParalizadoState() {
		estado = PARALIZADO;
		velocidad = especie.getVelocidad()/2;
//		mostrarMensajeParalizado(this);
	}
	
	public void moveToDebilitadoState() {
		estado = DEBILITADO;
//		mostrarMensajeDebilitado(this);
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((especie == null) ? 0 : especie.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (especie == null) {
			if (other.especie != null)
				return false;
		} else if (!especie.equals(other.especie))
			return false;
		return true;
	}
	
	/**/

	public void mostrarMensajeDebilitado(Pokemon pokemon) {
		presentadorPokemon.mostrarMensajePokemonDebilitado(pokemon);
	}
	
	public void mostrarMensajeDormido(Pokemon pokemon) {
		presentadorPokemon.mostrarMensajeDormido(pokemon);
	}
	
	public void mostrarMensajeEnvenenado(Pokemon pokemon) {
		presentadorPokemon.mostrarMensajeEnvenenado(pokemon);
	}
	
	public void mostrarMensajeParalizado(Pokemon pokemon) {
		presentadorPokemon.mostrarMensajeParalizado(pokemon);
	}
}
