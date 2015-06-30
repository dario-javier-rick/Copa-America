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

	// abstract ArrayList<Jugador> getJugadores() throws IOException;

	public double getPuntaje() {
		return this.Puntaje;
	}

	void setPuntaje(double puntaje) {
		this.Puntaje = puntaje;
	}

	public String getNombre() {
		return this.Nombre;
	}

	void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getSeleccion() {
		return this.Seleccion;
	}

	void setSeleccion(String seleccion) {
		this.Seleccion = seleccion;
	}

	public int getTarjetasAmarillas() {
		return this.TarjetasAmarillas;
	}

	void setTarjetasAmarillas(int tarjetasAmarillas) {
		this.TarjetasAmarillas = tarjetasAmarillas;
	}

	public int getTarjetasRojas() {
		return this.TarjetasRojas;
	}

	void setTarjetasRojas(int tarjetasRojas) {
		this.TarjetasRojas = tarjetasRojas;
	}

	@Override
	public String toString() {
		return this.getNombre().toString() + ", "
				+ this.getClass().getSimpleName() + ", "
				+ this.getSeleccion().toString() + ", " + this.getPuntaje()
				+ " Puntos, " + this.getTarjetasAmarillas()
				+ " Tarjetas amarillas , " + this.getTarjetasRojas()
				+ " Tarjetas rojas";
	}

}
