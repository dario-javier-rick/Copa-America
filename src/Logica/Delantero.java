package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Delantero extends Jugador {

	@Override
	public String toString() {
		return "Delantero [getPuntaje()=" + getPuntaje() + ", getNombre()="
				+ getNombre() + ", getSeleccion()=" + getSeleccion()
				+ ", getTarjetasAmarillas()=" + getTarjetasAmarillas()
				+ ", getTarjetasRojas()=" + getTarjetasRojas()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String directorio = System.getProperty("user.home")
			+ "/Desktop/delanteros.txt";

	public Delantero(String Nombre, String Seleccion, double Puntaje,
			int TarjetasAmarillas, int TarjetasRojas) {
		super(Nombre, Seleccion, Puntaje, TarjetasAmarillas, TarjetasRojas);
	}

	@Override
	public void persistir() throws IOException {
		ArrayList<Delantero> delanteros = new ArrayList<Delantero>();
		if (verificarExistenciaTXT()) 
			delanteros = getJugadores();

		
		delanteros.add(this);

		FileOutputStream fos = new FileOutputStream(directorio);
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeObject(delanteros);
		out.close();
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Delantero> getJugadores() throws IOException {
		ArrayList<Delantero> jugadores = null;
		ObjectInputStream objectinputstream = null;
		try {
			FileInputStream streamIn = new FileInputStream(directorio);
			objectinputstream = new ObjectInputStream(streamIn);
			jugadores = (ArrayList<Delantero>) objectinputstream.readObject();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (objectinputstream != null) {
				objectinputstream.close();
			}
		}

		return jugadores;
	}

	private static boolean verificarExistenciaTXT() {
		if (!new File(directorio).isFile())
			return false;
		return true;
	}

}
