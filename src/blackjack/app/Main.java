package blackjack.app;

import blackjack.dominio.Partida;

public class Main {

	public static void main(String[] args) {
		Consola consola = new Consola();
		Partida partida;
		String nombre1, nombre2;
		boolean pedir1 = true, pedir2 = true;

		nombre1 = consola.leerTextoNoVacio("Introduce el nombre del primer jugador");
		nombre2 = consola.leerTextoNoVacio("Introduce el nombre del segundo jugador");
		partida = new Partida(nombre1, nombre2);
		partida.iniciarPartida();
		consola.escribirLinea("Ronda " + partida.getRonda());
		consola.escribirLinea(partida.getJugador1().toString());
		consola.escribirLinea(partida.getJugador2().toString());
		do {
			if (pedir1 == true) {
				pedir1 = consola.readBooleanUsingChar('p', 'f', "Jugador 1 escribe p para pedir o f para plantarte");
			}
			if (pedir2 == true) {
				pedir2 = consola.readBooleanUsingChar('p', 'f', "Jugador 2 escribe p para pedir o f para plantarte");
			}

			partida.pedirCarta(pedir1, pedir2);
			consola.escribirLinea("Ronda " + partida.getRonda());
			consola.escribirLinea(partida.getJugador1().toString());
			consola.escribirLinea(partida.getJugador2().toString());

		} while (!partida.finPartida(pedir1, pedir2));

		if (partida.getJugador1().puntuacion() > partida.getJugador2().puntuacion()
				&& partida.getJugador1().puntuacion() <= 21) {
			consola.escribirLinea(nombre1 + "gana!!");
		} else if (partida.getJugador2().puntuacion() > partida.getJugador1().puntuacion()
				&& partida.getJugador2().puntuacion() <= 21) {
			consola.escribirLinea(nombre1 + "gana!!");
		}
	}

}
