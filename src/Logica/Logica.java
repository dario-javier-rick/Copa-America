package Logica;

import java.util.ArrayList;

public class Logica {

	// Solución implementada con backtracking

	static void buscarSolucion(Equipo equipo, int cantidadJugadores,
			ArrayList<Jugador> jugadoresTotales) {
		
		Equipo posibleSolucion = new Equipo();

		if (cantidadJugadores == 11) {
			if (equipo.getPuntajeTotal() > posibleSolucion.getPuntajeTotal()) // ?
			{
				// comparar equipo con el anterior. Guardar en memoria
				posibleSolucion = equipo;
			}

			return;
		}

		for (int i = 0; i < jugadoresTotales.size(); ++i) {
			// para cada jugador posible, ver si tiene sentido agregarlo
			if (verificarValidezBacktrack(equipo)) {
				equipo.agregarJugador(jugadoresTotales.get(i));

				buscarSolucion(posibleSolucion, cantidadJugadores + 1, jugadoresTotales);

				equipo.quitarJugador(jugadoresTotales.get(i));
			}
		}
	}

	private static boolean verificarValidezBacktrack(Equipo equipo) {

		int jugadoresMismaSeleccion = 0;
		int jugadoresTarjetasAmarillas = 0;
		int jugadoresTarjetasRojas = 0;

		for (Jugador jugador : equipo.jugadores) {
			// Sumar tarjetas 
		}

		if (!verificarArmado(equipo) || jugadoresMismaSeleccion > 5
				|| jugadoresTarjetasAmarillas > 3 || jugadoresTarjetasRojas > 1) {
			return false;
		}
		return true;
	}

	private static boolean verificarArmado(Equipo equipo) {
		int arqueros = 0;
		int defensores = 0;
		int mediocampistas = 0;
		int delanteros = 0;
		for (Jugador jugador : equipo.jugadores) {
			if (jugador.getClass() == Arquero.class)
				arqueros++;
			if (jugador.getClass() == Defensor.class)
				defensores++;
			if (jugador.getClass() == Mediocampista.class)
				mediocampistas++;
			if (jugador.getClass() == Delantero.class)
				delanteros++;
		}
		if (arqueros == 1 && defensores == 4 && mediocampistas == 3
				&& delanteros == 3)
			return true;
		else
			return false;
	}
}
