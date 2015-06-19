package Logica;

import java.util.ArrayList;

public class Equipo{
	
	ArrayList<Jugador> jugadores;
	private double puntajeTotal;

	
	public Equipo()
	{
		setPuntajeTotal(0);
	}
	
	
	public void agregarJugador(Jugador jugador)
	{
		jugadores.add(jugador);
		setPuntajeTotal(puntajeTotal + jugador.getPuntaje());
	}


	public void quitarJugador(Jugador jugador) {
		jugadores.remove(jugador);
		setPuntajeTotal(puntajeTotal - jugador.getPuntaje());
	}

	public double getPuntajeTotal() {
		return puntajeTotal;
	}

	void setPuntajeTotal(double puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}






}
