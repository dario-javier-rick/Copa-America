package Logica;

import java.util.ArrayList;

public class Logica {

	// Solución implementada con backtracking

	public static void buscarSolucion(Equipo equipo, int cantidadJugadores,
			ArrayList<Jugador> jugadoresTotales) {

		Equipo posibleSolucion = new Equipo();

		if (cantidadJugadores == 11) {
			if (equipo.getPuntajeTotal() > posibleSolucion.getPuntajeTotal()) // ?
			{
				posibleSolucion = equipo;
			}
			return;
		}

		for (int i = 0; i < jugadoresTotales.size(); ++i) {
			if (verificarValidez(equipo)) {
				equipo.agregarJugador(jugadoresTotales.get(i));
				buscarSolucion(posibleSolucion, cantidadJugadores + 1,
						jugadoresTotales);
				equipo.quitarJugador(jugadoresTotales.get(i));
			}
		}
	}

	private static boolean verificarValidez(Equipo equipo) {

		if (!verificarArmado(equipo) || !verificarJugadoresPorSeleccion(equipo)
				|| !verificarTarjetasAmarillas(equipo)
				|| !verificarTarjetasRojas(equipo)) {
			return false;
		}
		return true;
	}

	private static boolean verificarArmado(Equipo equipo) {
		int arqueros = 0;
		int defensores = 0;
		int mediocampistas = 0;
		int delanteros = 0;
		for (Jugador jugador : equipo.getJugadores()) {
			if (jugador.getClass() == Arquero.class)
				arqueros++;
			if (jugador.getClass() == Defensor.class)
				defensores++;
			if (jugador.getClass() == Mediocampista.class)
				mediocampistas++;
			if (jugador.getClass() == Delantero.class)
				delanteros++;
		}
		if (arqueros <= 1 && defensores <= 4 && mediocampistas <= 3
				&& delanteros <= 3)
			return true;
		else
			return false;
	}

	private static boolean verificarJugadoresPorSeleccion(Equipo equipo) {
		int jugadoresPorSeleccion = 0;
		for (int i = 0; i < equipo.getCantidadJugadores(); i++) {
			for (int j = i; j < equipo.getCantidadJugadores(); j++) {

			}
		}
		if (jugadoresPorSeleccion > 5)
			return false;
		return true;
	}

	private static boolean verificarTarjetasRojas(Equipo equipo) {
		int tarjetasRojas = 0;
		for (Jugador jugador : equipo.getJugadores()) {
			tarjetasRojas = tarjetasRojas + jugador.getTarjetasRojas();
		}
		if (tarjetasRojas > 1)
			return false;
		return true;
	}

	private static boolean verificarTarjetasAmarillas(Equipo equipo) {
		int jugadoresConAmarillas = 0;
		for (Jugador jugador : equipo.getJugadores()) {
			if (jugador.getTarjetasAmarillas() > 0)
				jugadoresConAmarillas++;
		}
		if (jugadoresConAmarillas > 3)
			return false;
		return true;
	}

}
