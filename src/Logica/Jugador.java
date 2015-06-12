package Logica;

import java.io.Serializable;

public class Jugador implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String Nombre;
	String Seleccion;
	double Puntaje;
	TipoJugador Posicion;
	int TarjetasAmarillas;
	int TarjetasRojas;
	
	public Jugador(String Nombre, String Seleccion, double Puntaje,
			TipoJugador Posicion, int TarjetasAmarillas, int TarjetasRojas) {
		this.Nombre = Nombre;
		this.Seleccion = Seleccion;
		this.Puntaje = Puntaje;
		this.Posicion = Posicion;
		this.TarjetasAmarillas = TarjetasAmarillas;
		this.TarjetasRojas = TarjetasRojas;
	}


}
