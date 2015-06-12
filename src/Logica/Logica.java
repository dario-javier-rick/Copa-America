package Logica;

public class Logica {

	public static Equipo buscarSolucion(Arquero[] arqueros,
			Defensor[] defensores, Mediocampista[] mediocampistas,
			Delantero[] delanteros) {

		// Declaro la mejor soluci�n
		Equipo mejorSolucion = new Equipo();

		// Iteraciones necesarias como m�ximo, en caso de testear por fuerza
		// bruta
		int iteracionesNecesarias = arqueros.length * defensores.length
				* mediocampistas.length * delanteros.length;

		int iteraciones = 0;

		while (iteraciones < iteracionesNecesarias) {

			// Declaro una posible soluci�n
			Equipo posibleSolucion = new Equipo();

			// Le agrego jugadores en las posiciones requeridas
			posibleSolucion.agregarJugadores(arqueros, defensores,
					mediocampistas, delanteros, iteraciones);

			// Si la combinaci�n no es v�lida, corto el algoritmo
			if (verificarValidez(posibleSolucion)) {
				if (posibleSolucion.getPuntajeTotal() > mejorSolucion
						.getPuntajeTotal()) {
					// Si la combinaci�n que arme es v�lida y tiene mejor
					// puntaje,
					// pasa a ser mejor soluci�n
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
	static void buscarSolucion(Equipo equipo, int jugadores) {
		if (jugadores == 11)
			return;

		for (int i = 0; i < 10; ++i) {
			if (true) // Si cumple condiciones
			{
				// agregar al equipo actual un jugador
				buscarSolucion(equipo, jugadores + 1);
				// Sacar jugador
			}
		}
	}
}
