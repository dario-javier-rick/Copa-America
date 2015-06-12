package Logica;

import java.util.ArrayList;

public class Equipo {

	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private final int cantidadMaxima = 11;
	
	public Equipo()
	{
		
	}
	
	public void agregarJugador(Jugador jugador) throws Exception
	{
		if (jugadores.size() < cantidadMaxima)
			this.jugadores.add(jugador);
		else
			throw new Exception("El equipo está completo");
	}
}
