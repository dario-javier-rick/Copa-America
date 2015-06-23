package Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Defensor extends Jugador{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String directorio = System.getProperty("user.home")
			+ "/Desktop/defensores.txt";

	public Defensor(String Nombre, String Seleccion, double Puntaje,
			int TarjetasAmarillas, int TarjetasRojas) 
	{
		super(Nombre, Seleccion, Puntaje, TarjetasAmarillas, TarjetasRojas);
	}

	@Override
	public void persistir() throws IOException {
		ArrayList<Defensor> defensores = new ArrayList<Defensor>();
		if (verificarExistenciaTXT())
			defensores = getJugadores();

		defensores.add(this);
		
		FileOutputStream fos = new FileOutputStream(directorio);
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeObject(defensores);
		out.close();
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Defensor> getJugadores() {
		ArrayList<Defensor> jugadores = new ArrayList<Defensor>();
		try {
			FileInputStream streamIn = new FileInputStream(directorio);
			ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);
			jugadores = (ArrayList<Defensor>) objectinputstream.readObject();
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
