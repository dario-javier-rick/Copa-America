package Logica;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Defensor extends Jugador{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String directorio = System.getProperty("user.home")
			+ "/Desktop/defensores.txt";

	public Defensor(String Nombre, String Seleccion, double Puntaje,
			int TarjetasAmarillas, int TarjetasRojas) 
	{
		super(Nombre, Seleccion, Puntaje, TarjetasAmarillas, TarjetasRojas);
	}

	@Override
	public void persistir() throws IOException {
		FileOutputStream fos = new FileOutputStream(directorio);
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeObject(this);
		out.close();

	}

	public static ArrayList<Defensor> getJugadores()  {
		return null;
		// TODO Auto-generated method stub
		
	}

	

}
