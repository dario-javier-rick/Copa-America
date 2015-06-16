package Logica;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Mediocampista extends Jugador {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String directorio = System.getProperty("user.home")
			+ "/Desktop/mediocampistas.txt";

	public Mediocampista(String Nombre, String Seleccion, double Puntaje,
			int TarjetasAmarillas, int TarjetasRojas) {
		super(Nombre, Seleccion, Puntaje, TarjetasAmarillas, TarjetasRojas);
	}

	@Override
	public void persistir() throws IOException {
		FileOutputStream fos = new FileOutputStream(directorio);
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeObject(this);
		out.close();

		
	}

	void getJugadores() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
