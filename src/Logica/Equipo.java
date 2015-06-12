package Logica;


public class Equipo {
	
	Jugador[] jugadores;
	private double puntajeTotal;

	// Constructor vacío requerido en la lógica
	public Equipo()
	{
		setPuntajeTotal(0);
	}
	
	
	public Equipo(Jugador[] jugadores)
	{
		this.jugadores = jugadores;
		for (Jugador jugador:jugadores)
		{
			setPuntajeTotal(puntajeTotal + jugador.getPuntaje());
		}
	}
	
	public void agregarJugador(Jugador jugador)
	{
		jugadores[jugadores.length] = jugador;
		setPuntajeTotal(puntajeTotal + jugador.getPuntaje());
	}

	public double getPuntajeTotal() {
		return puntajeTotal;
	}

	void setPuntajeTotal(double puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}

}
