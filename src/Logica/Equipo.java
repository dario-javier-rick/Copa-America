package Logica;

import java.util.ArrayList;

public class Equipo{
	
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private double puntajeTotal;
	
	
	public Equipo()
	{
		setPuntajeTotal(0);
	}
	
	
	public void agregarJugador(Jugador jugador)
	{
		getJugadores().add(jugador);
		setPuntajeTotal(puntajeTotal + jugador.getPuntaje());
	}


	public void quitarJugador(Jugador jugador) {
		getJugadores().remove(jugador);
		setPuntajeTotal(puntajeTotal - jugador.getPuntaje());
	}

	public double getPuntajeTotal() {
		return puntajeTotal;
	}

	void setPuntajeTotal(double puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}


	public int getCantidadJugadores() {
		return getJugadores().size();
	}


	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}









}
