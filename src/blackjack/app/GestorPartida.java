package blackjack.app;

import blackjack.dominio.Crupier;
import blackjack.dominio.Partida;

public class GestorPartida {
	private Consola consola;
	private Partida partida;
	private boolean modoConfigurado;
	private boolean modoPvp;
	private boolean nombresConfigurados;
	private boolean seguirJugando;

	public GestorPartida(Consola consola) {
		this.consola = consola;
		modoConfigurado = false;
		nombresConfigurados = false;
		seguirJugando = true;
	}

	/***
	 * Ejecuta la partida
	 * 
	 * @throws InterruptedException Retraso para ver el juego del crupier
	 */
	public void ejecutar() throws InterruptedException {
		do {
			configurarPartida();
			if (modoPvp) {
				ejecucionPVP(partida);
			} else {
				ejecucionCrupier(partida);
			}
			determinarGanador(partida);
			mostrarSiguienteCarta(partida);
			elegirModo();
			if (modoConfigurado && nombresConfigurados && seguirJugando) {
				cambiarNombre();
			}
		} while (seguirJugando);
		consola.escribirLinea("\n¡Hasta pronto!");
	}

	private void configurarPartida() {
		if (modoConfigurado) {
			this.partida = crearPartida();
		}
		if (!modoConfigurado) {
			modoPvp = solicitarModo();
			modoConfigurado = true;
			if (nombresConfigurados) {
				this.partida = crearPartida();
			}
		}

		if (!nombresConfigurados) {
			this.partida = crearPartida();
			solicitarNombres(partida);
			nombresConfigurados = true;
		}
	}

	private boolean solicitarModo() {
		return consola.readBooleanUsingChar('p', 'f', "\n'p' para jugar PVP, 'f' para jugar vs IA: ");
	}

	private int solicitarOpcion(int min, int max, String mensaje) {
		return consola.leerEnteroRango(mensaje, min, max);
	}

	private void solicitarNombres(Partida partida) {
		partida.getJugador1().setNombre(consola.leerTextoNoVacio("Introduce el nombre del primer jugador: "));

		if (modoPvp) {
			partida.getJugador2().setNombre(consola.leerTextoNoVacio("Introduce el nombre del segundo jugador: "));
		} else {
			partida.getJugador2().setNombre("Crupier");
		}
		nombresConfigurados = true;
	}

	private Partida crearPartida() {
		if (modoPvp && !nombresConfigurados) {
			Partida partida = new Partida(null, null);

			return partida;
		} else if (!modoPvp && !nombresConfigurados) {
			Partida partida = new Partida(null);
			return partida;
		} else if (modoPvp && nombresConfigurados) {
			Partida partida = new Partida(this.partida.getJugador1().getNombre(),
					this.partida.getJugador2().getNombre());

			return partida;
		} else if (!modoPvp && nombresConfigurados) {
			Partida partida = new Partida(this.partida.getJugador1().getNombre());

			return partida;
		} else {
			return null;
		}

	}

	private void determinarGanador(Partida partida) {
		consola.escribirLinea("");
		if ((partida.getJugador1().puntuacion() > partida.getJugador2().puntuacion()
				&& partida.getJugador1().puntuacion() <= 21)
				|| (partida.getJugador1().puntuacion() <= 21 && partida.getJugador2().puntuacion() > 21)) {
			consola.escribirLinea(partida.getJugador1().getNombre() + " gana!!");
		} else if ((partida.getJugador2().puntuacion() > partida.getJugador1().puntuacion()
				&& partida.getJugador2().puntuacion() <= 21)
				|| (partida.getJugador2().puntuacion() <= 21 && partida.getJugador1().puntuacion() > 21)) {
			consola.escribirLinea(partida.getJugador2().getNombre() + " gana!!");
		} else {
			consola.escribirLinea("¡Empate!");
		}
	}

	private void mostrarSiguienteCarta(Partida partida) {
		consola.escribirLinea(
				String.format("La siguiente carta era %s", partida.getBaraja().extraerCarta().toString()));
	}

	private void ejecucionCrupier(Partida partida) throws InterruptedException {
		boolean pedir1 = true;
		boolean pedir2 = false;
		String nombre1 = partida.getJugador1().getNombre();
		partida.iniciarPartida();
		consola.escribirLinea("\n" + partida.toString());
		while (!partida.finPartida(pedir1, pedir2)) {
			if (pedir1 == true && partida.getJugador1().puntuacion() != 21) {
				pedir1 = cartaPregunta(nombre1);
			} else {
				pedir1 = false;
			}
			pedir2 = crupierJuega(partida, pedir1);

			partida.pedirCarta(pedir1, pedir2);
			consola.escribirLinea("\n" + partida.toString());
			Thread.sleep(2000);
		}
	}

	public void ejecucionPVP(Partida partida) {
		boolean pedir1 = true;
		boolean pedir2 = true;
		String nombre1 = partida.getJugador1().getNombre();
		String nombre2 = partida.getJugador2().getNombre();
		partida.iniciarPartida();
		consola.escribirLinea("\n" + partida.toString());
		while (!partida.finPartida(pedir1, pedir2)) {
			if (pedir1 == true && partida.getJugador1().puntuacion() != 21) {
				pedir1 = cartaPregunta(nombre1);
			} else {
				pedir1 = false;
			}
			if (pedir2 == true && partida.getJugador2().puntuacion() != 21) {
				pedir2 = cartaPregunta(nombre2);
			} else {
				pedir2 = false;
			}

			partida.pedirCarta(pedir1, pedir2);
			consola.escribirLinea("\n" + partida.toString());
		}
	}

	private boolean cartaPregunta(String nombre) {
		return consola.readBooleanUsingChar('p', 'f', nombre + " escribe 'p' para pedir o 'f' para plantarte: ");
	}

	private boolean crupierJuega(Partida partida, boolean pedir1) {
		boolean pedir2 = false;
		if (!pedir1) {
			if ((partida.getJugador1().puntuacion() > partida.getJugador2().puntuacion())) {
				pedir2 = true;
				((Crupier) partida.getJugador2()).setTurno(true);
			}
			if ((partida.getJugador1().puntuacion() < partida.getJugador2().puntuacion())
					|| (partida.getJugador1().puntuacion() == partida.getJugador2().puntuacion())) {
				pedir2 = false;
			}
			if (((partida.getJugador1().puntuacion() < partida.getJugador2().puntuacion()
					|| partida.getJugador1().puntuacion() == partida.getJugador2().puntuacion()) && pedir1 == false)) {
				((Crupier) partida.getJugador2()).setTurno(true);
			}
		}
		return pedir2;
	}

	private void elegirModo() {
		int opcion = solicitarOpcion(1, 3, "\n1 - Cambiar de modo\n2 - Mismo modo\n3 - Salir");

		switch (opcion) {
		case 1 -> modoConfigurado = false;
		case 2 -> modoConfigurado = true;
		case 3 -> seguirJugando = false;
		default -> consola.escribirLinea("Error desconocido");
		}
	}

	private void cambiarNombre() {
		boolean cambiar = consola.readBooleanUsingChar('s', 'n', "\n¿Quieres cambiar de nombres? (s/n): ");

		if (cambiar) {
			nombresConfigurados = false;
		}
	}
}