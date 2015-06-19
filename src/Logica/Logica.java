package Logica;

public class Logica {

	public static Equipo buscarSolucion(Arquero[] arqueros,
			Defensor[] defensores, Mediocampista[] mediocampistas,
			Delantero[] delanteros) {

		// Declaro la mejor solución
		Equipo mejorSolucion = new Equipo();

		// Iteraciones necesarias como máximo, en caso de testear por fuerza
		// bruta
		int iteracionesNecesarias = arqueros.length * defensores.length
				* mediocampistas.length * delanteros.length;

		int iteraciones = 0;

		while (iteraciones < iteracionesNecesarias) {

			// Declaro una posible soluciòn
			Equipo posibleSolucion = new Equipo();

			// Le agrego jugadores en las posiciones requeridas
			posibleSolucion.agregarJugadores(arqueros, defensores,
					mediocampistas, delanteros, iteraciones);

			// Si la combinación no es válida, corto el algoritmo
			if (verificarValidez(posibleSolucion)) {
				if (posibleSolucion.getPuntajeTotal() > mejorSolucion
						.getPuntajeTotal()) {
					// Si la combinación que arme es válida y tiene mejor
					// puntaje,
					// pasa a ser mejor solución
					mejorSolucion = posibleSolucion;
				}
			}
			iteraciones++;
		}
		return mejorSolucion;
	}

	private static boolean verificarValidez(Equipo solucion) {
		// Si hay mas de 2 tarjetas rojas corto, etc

		return true;
	}

	// ------------------------------------
	// Por backtracking
	static void buscarSolucion(Equipo equipo, int jugadores,
			Arquero[] arqueros, Defensor[] defensores,
			Mediocampista[] mediocampistas, Delantero[] delanteros) {

		if (jugadores == 11)
			// comparar equipo con el anterior. Guardar en memoria
			return;

		for (int i = 0; i < arqueros.length + defensores.length
				+ mediocampistas.length + delanteros.length; ++i) {

			// para cada jugador posible, ver si tiene sentido agregarlo
			if (verificarValidezBacktrack(equipo)) // Si cumple condiciones
			{
				// agregar al equipo actual un jugador
				equipo.agregarJugador(null);

				buscarSolucion(equipo, jugadores + 1, arqueros, defensores,
						mediocampistas, delanteros);
				// Sacar el mismo jugador
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
