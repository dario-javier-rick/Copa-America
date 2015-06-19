package Logica;

import java.util.ArrayList;

public class Logica {

	// Solución implementada con backtracking
	
	static void buscarSolucion(Equipo equipo, int jugadores,
			ArrayList<Arquero> arqueros, ArrayList<Defensor> defensores,
			ArrayList<Mediocampista> mediocampistas,
			ArrayList<Delantero> delanteros) {

		if (jugadores == 11) {
			if (equipo.getPuntajeTotal() > 1) // ?
			{
				// comparar equipo con el anterior. Guardar en memoria
			}

			return;
		}

		for (int i = 0; i < arqueros.size() + defensores.size()
				+ mediocampistas.size() + delanteros.size(); ++i) {
			// para cada jugador posible, ver si tiene sentido agregarlo
			if (verificarValidezBacktrack(equipo)) {
				equipo.agregarJugador(null);

				buscarSolucion(equipo, jugadores + 1, arqueros, defensores,
						mediocampistas, delanteros);

				equipo.quitarJugador(null);
			}
		}
	}

	private static boolean verificarValidezBacktrack(Equipo equipo) {

		int jugadoresMismaSeleccion = 0;
		int jugadoresTarjetasAmarillas = 0;
		int jugadoresTarjetasRojas = 0;

		for (Jugador jugador : equipo.jugadores) {

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
