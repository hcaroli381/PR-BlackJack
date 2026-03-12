package blackjack.app;

import blackjack.dominio.Crupier;
import blackjack.dominio.Partida;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Consola consola = new Consola();
		Partida partida;
		String nombre1, nombre2;
		boolean pedir1 = true, pedir2 = true;
		boolean elegirModo;

		elegirModo = consola.readBooleanUsingChar('p', 'f', "p para jugar PVP f para jugar vs IA : ");
		consola.limpiar();
		if (elegirModo) {
			// partida con 2 jugadores reales

			nombre1 = consola.leerTextoNoVacio("Introduce el nombre del primer jugador : ");
			nombre2 = consola.leerTextoNoVacio("Introduce el nombre del segundo jugador : ");
			partida = new Partida(nombre1, nombre2);
			partida.iniciarPartida();
			consola.escribirLinea(partida.toString());
			while (!partida.finPartida(pedir1, pedir2)) {
				if (pedir1 == true && partida.getJugador1().puntuacion() != 21) {
					pedir1 = consola.readBooleanUsingChar('p', 'f',
							nombre1 + " escribe p para pedir o f para plantarte : ");
				} else {
					pedir1 = false;
				}
				if (pedir2 == true && partida.getJugador2().puntuacion() != 21) {
					pedir2 = consola.readBooleanUsingChar('p', 'f',
							nombre2 + " escribe p para pedir o f para plantarte : ");
				} else {
					pedir2 = false;
				}

				partida.pedirCarta(pedir1, pedir2);
				consola.escribirLinea(partida.toString());

			}
		} else {
			// partida contra el crupier
			pedir2 = false;
			nombre1 = consola.leerTextoNoVacio("Introduce el nombre del primer jugador : ");
			nombre2 = "Crupier";
			partida = new Partida(nombre1, false);
			partida.iniciarPartida();
			consola.escribirLinea(partida.toString());
			while (!partida.finPartida(pedir1, pedir2)) {
				if (pedir1 == true && partida.getJugador1().puntuacion() != 21) {
					pedir1 = consola.readBooleanUsingChar('p', 'f',
							nombre1 + " escribe p para pedir o f para plantarte : ");
				} else {
					pedir1 = false;
				}

				if ((partida.getJugador1().puntuacion() > partida.getJugador2().puntuacion())) {
					pedir2 = true;
					((Crupier) partida.getJugador2()).setTurno(true);
				}
				if ((partida.getJugador1().puntuacion() < partida.getJugador2().puntuacion())
						|| (partida.getJugador1().puntuacion() == partida.getJugador2().puntuacion())) {
					pedir2 = false;
				}
				if (((partida.getJugador1().puntuacion() < partida.getJugador2().puntuacion()) && pedir1 == false)) {
					((Crupier) partida.getJugador2()).setTurno(true);
				}

				partida.pedirCarta(pedir1, pedir2);
				consola.escribirLinea(partida.toString());
				// retraso para poder ver que hace el crupier
				Thread.sleep(2000);

			}
		}

		if ((partida.getJugador1().puntuacion() > partida.getJugador2().puntuacion()
				&& partida.getJugador1().puntuacion() <= 21)
				|| (partida.getJugador1().puntuacion() <= 21 && partida.getJugador2().puntuacion() > 21)) {
			consola.escribirLinea(nombre1 + " gana!!");
		} else if ((partida.getJugador2().puntuacion() > partida.getJugador1().puntuacion()
				&& partida.getJugador2().puntuacion() <= 21)
				|| (partida.getJugador2().puntuacion() <= 21 && partida.getJugador1().puntuacion() > 21)) {
			consola.escribirLinea(nombre2 + " gana!!");
		} else {
			consola.escribirLinea("Empate!!");
		}
		System.out.printf("La siguiente carta era %s", partida.getBaraja().extraerCarta().toString());
	}

}
