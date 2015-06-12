package Logica;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Arquero extends Jugador {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Arquero(String Nombre, String Seleccion, double Puntaje,
			int TarjetasAmarillas, int TarjetasRojas) {
		super(Nombre, Seleccion, Puntaje, TarjetasAmarillas, TarjetasAmarillas);
	}
	
	@Override public void persistir() throws IOException
	{
		FileOutputStream fos = new FileOutputStream(System
				.getProperty("user.home")
				+ "/Desktop/arqueros.txt");
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeObject(this);
		out.close();

	}

}
