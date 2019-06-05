package baseDeDatos;

import java.util.Map;

import categoria.Categoria;

public class Movimiento {
	
	private int id, potencia, precision;
	private String nombre;
	private Categoria categoria;
	private Tipo tipo;
	private final Map<Integer, Double> efectividades;
	
	public Movimiento( int id, String nombre, int potencia, int precision, Categoria categoria, Tipo tipo,
			Map<Integer, Double> efectividades){
		this.id = id;
		this.nombre = nombre;
		this.potencia = potencia;
		this.precision = precision;
		this.categoria = categoria;
		this.tipo = tipo;
		this.efectividades = efectividades;
	}

	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getPotencia() {
		return potencia;
	}

	public int getPrecision() {
		return precision;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Tipo getTipo() {
		return tipo;
	}
}
