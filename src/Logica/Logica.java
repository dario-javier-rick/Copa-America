package Logica;

public class Logica {

	public static Equipo buscarSolucion(Arquero[] arqueros,
			Defensor[] defensores, Mediocampista[] mediocampistas,
			Delantero[] delanteros) {

		
		// Creo dos equipos vacíos
		Equipo posibleSolucion = new Equipo();
		Equipo mejorSolucion = new Equipo();

		
		// Iteraciones necesarias como máximo, en caso de testear por fuerza bruta
		int iteracionesNecesarias = arqueros.length * defensores.length
				* mediocampistas.length * delanteros.length;

		
		boolean valido = false;
		int iteraciones = 0;

		while (!valido && iteraciones < iteracionesNecesarias) {
			
			// Agrego jugador
			posibleSolucion.agregarJugador(null);
			
			// Si la combinación no es válida, corto el algoritmo
			if (verificarValidez(posibleSolucion)) 
			{
				if (posibleSolucion.getPuntajeTotal() > mejorSolucion.getPuntajeTotal()) 
				{
					// Si la combinación que arme es válida y tiene mejor puntaje, 
					// pasa a ser mejor solución
					mejorSolucion = posibleSolucion;
				}
			}
			
			iteraciones++;
		}

		return mejorSolucion;
	}

	private static boolean verificarValidez(Equipo solucion) {
		// Si no son 11 jugadores, corto algoritmo
		if (solucion.jugadores.length != 11)
			return false;

		// Si el armado no es 4-3-3, corto
		
		// Si hay mas de 2 tarjetas rojas, corto
		
		return true;
	}

}
