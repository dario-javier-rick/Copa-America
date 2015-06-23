package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Delantero extends Jugador {


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
	public static ArrayList<Delantero> getJugadores() {
		ArrayList<Delantero> jugadores = new ArrayList<Delantero>();
		try {
			FileInputStream streamIn = new FileInputStream(directorio);
			ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);
			jugadores = (ArrayList<Delantero>) objectinputstream.readObject();
			objectinputstream.close();
		} catch (IOException e) {
			// Si el archivo no existe, no encuentra jugadores, por lo tanto devuelvo array vacio
			return jugadores;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return jugadores;
	}

	private static boolean verificarExistenciaTXT() {
		if (!new File(directorio).isFile())
			return false;
		return true;
	}

}
