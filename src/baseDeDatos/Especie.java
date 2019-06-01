package baseDeDatos;

import java.util.*;

public class Especie {
	private int id, vida, ataque,defensa, atqesp, defesp, velocidad;
	private String nombre;
	private Tipo tipo, subtipo;
	private List<Movimiento> movimientos = new ArrayList<>();
	
	Especie(int id,  String nombre, int vida, int ataque, int defensa, int atqesp, int defesp, int velocidad, 
			Tipo tipo, Tipo subtipo, List<Movimiento> movimientos){
		this.id = id;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.atqesp = atqesp;
		this.defesp = defesp;
		this.velocidad = velocidad;
		this.nombre = nombre;
		this.tipo = tipo;
		this.subtipo = subtipo;
		this.movimientos.addAll(movimientos);
	}
	
	//metodos get
	public int getId() {
		return id;
	}
	
	public int getVida() {
		return vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getAtqesp() {
		return atqesp;
	}

	public int getDefesp() {
		return defesp;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public String getNombre() {
		return nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Tipo getSubtipo() {
		return subtipo;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

}
