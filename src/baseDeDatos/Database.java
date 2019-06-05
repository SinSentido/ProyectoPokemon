package baseDeDatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import categoria.Categoria;
import categoria.Especial;
import categoria.EstadoDor;
import categoria.EstadoEnv;
import categoria.EstadoPar;
import categoria.Fisico;

public enum Database {
	
	INSTANCE;
	
	private Map<Integer, Movimiento> movimientos = new HashMap<>();
	private Map<Integer, Especie> especies = new HashMap<>();
	private Map<Integer, Map<Integer, Double>> efectividades = new HashMap<>();
	private Map<Integer, Tipo> tipos = new HashMap<>();
	
	Database(){
		cargarTipos();
		cargarEfectividades();
		cargarMovimientos();
		cargarEspecies();
	}
	
	/*Metodos get para recuperar los mapas*/
	public Map<Integer, Movimiento> getMovimientos() {
		return movimientos;
	}

	public Map<Integer, Especie> getEspecies() {
		return especies;
	}

	public Map<Integer, Map<Integer, Double>> getEfectividades() {
		return efectividades;
	}

	public Map<Integer, Tipo> getTipos() {
		return tipos;
	}
	
	/*Metodos para cargar los datos en sus mapas correspondientes*/
	
	private void cargarEfectividades() {//carga los datos de las efectividades en el mapa efectividades
		Stream<String> linea;
		try(BufferedReader objReader=new BufferedReader(new FileReader("FicheroEfectividades.csv"))){
			linea=objReader.lines();
			efectividades = linea.map(s -> s.split(";"))
					.collect(Collectors.groupingBy(array -> Integer.parseInt(array[0]) 
							,Collectors.toMap(clave -> Integer.parseInt(clave[1])
									,valor -> Double.parseDouble(valor[2]))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void cargarTipos() { //carga los datos de los tipos en el mapa tipos
		Stream<String> linea;
		try(BufferedReader objReader=new BufferedReader(new FileReader("FicheroTipos.csv"))){
			linea=objReader.lines();
				tipos = linea.map(s -> s.split(";"))
						.collect(Collectors.toMap( array -> Integer.parseInt(array[0]),  
								array -> new Tipo(Integer.parseInt(array[0]), array[1])));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void cargarMovimientos() { //carga los datos de los movimientos en el mapa movimientos
		Stream<String> linea;
		try(BufferedReader objReader=new BufferedReader(new FileReader("FicheroMovimientos.csv"))){
			linea=objReader.lines();
			movimientos = linea.map(s -> s.split(";"))
					.collect(Collectors.toMap(clave -> Integer.parseInt(clave[0]),
							valor -> new Movimiento(Integer.parseInt(valor[0]),  valor[1], Integer.parseInt(valor[2]),
							Integer.parseInt(valor[3]), elegirCategoria(valor[4]), 
							tipos.get(Integer.parseInt(valor[5])),
							efectividades.get(Integer.parseInt(valor[5])))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void cargarEspecies() { //carga los datos de las especies en el mapa especies
		Stream<String> linea;
		try(BufferedReader objReader=new BufferedReader(new FileReader("FicheroEspecies.csv"))){
			linea=objReader.lines();
			especies = linea.map(s -> s.split(";"))
					.collect(Collectors.toMap(clave-> Integer.parseInt(clave[0]), 
								valor -> new Especie(
										Integer.parseInt(valor[0]), //id
										valor[1], //nombre	 		
										Integer.parseInt(valor[2]), //vida	
										Integer.parseInt(valor[3]), //ataque
										Integer.parseInt(valor[4]), //defensa
										Integer.parseInt(valor[5]), //ataque especial
										Integer.parseInt(valor[6]), //defensa especial
										Integer.parseInt(valor[7]), //velocidad
										tipos.get(Integer.parseInt(valor[8])), //tipo
										valor[9].equals("")?null:tipos.get(Integer.parseInt(valor[9])), //subtipo
										Arrays.asList(  //movimientos
												movimientos.get(Integer.parseInt(valor[10])),
												movimientos.get(Integer.parseInt(valor[11])),
												movimientos.get(Integer.parseInt(valor[12])),
												movimientos.get(Integer.parseInt(valor[13])))))); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private Categoria elegirCategoria(String categoria) {
		Categoria estado = null;
		
		if(categoria.equals("FISICO")) {
			estado = new Fisico();
		}
		else if(categoria.equals("ESPECIAL")) {
			estado = new Especial();
		}
		else if(categoria.equals("ESTADOENV")) {
			estado = new EstadoEnv();
		}
		else if(categoria.equals("ESTADOPAR")) {
			estado = new EstadoPar();
		}
		else if(categoria.equals("ESTADODOR")) {
			estado = new EstadoDor();
		}
		
		return estado;
	}
	
}
