package Logica;

import java.io.IOException;
import java.io.Serializable;

public abstract class Jugador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Nombre;
	private String Seleccion;
	private double Puntaje;
	private int TarjetasAmarillas;
	private int TarjetasRojas;
	

	public Jugador(String Nombre, String Seleccion, double Puntaje,
			int TarjetasAmarillas, int TarjetasRojas) {
		this.setNombre(Nombre);
		this.setSeleccion(Seleccion);
		this.setPuntaje(Puntaje);
		this.setTarjetasAmarillas(TarjetasAmarillas);
		this.setTarjetasRojas(TarjetasRojas);
	}

	abstract void persistir() throws IOException;

	public double getPuntaje() {
		return Puntaje;
	}


	void setPuntaje(double puntaje) {
		Puntaje = puntaje;
	}


	public String getNombre() {
		return Nombre;
	}


	void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getSeleccion() {
		return Seleccion;
	}


	void setSeleccion(String seleccion) {
		Seleccion = seleccion;
	}


	public int getTarjetasAmarillas() {
		return TarjetasAmarillas;
	}


	void setTarjetasAmarillas(int tarjetasAmarillas) {
		TarjetasAmarillas = tarjetasAmarillas;
	}

	
	public int getTarjetasRojas() {
		return TarjetasRojas;
	}


	void setTarjetasRojas(int tarjetasRojas) {
		TarjetasRojas = tarjetasRojas;
	}

}
