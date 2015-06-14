package Logica;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Defensor extends Jugador{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Defensor(String Nombre, String Seleccion, double Puntaje,
			int TarjetasAmarillas, int TarjetasRojas) 
	{
		super(Nombre, Seleccion, Puntaje, TarjetasAmarillas, TarjetasRojas);
	}

	@Override
	void persistir() throws IOException {
		FileOutputStream fos = new FileOutputStream(System
				.getProperty("user.home")
				+ "/Desktop/defensores.txt");
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeObject(this);
		out.close();

	}

}
