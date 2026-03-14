package blackjack.app;

import blackjack.dominio.Partida;

public class GestorPartida {
	private Consola consola;
	private Partida partida;
	private boolean modoConfigurado;
	private boolean modoPvp;
	private boolean nombresConfigurados;

	public GestorPartida(Consola consola) {
		this.consola = consola;
	}

	public void configurarPartida() {
		if (!modoConfigurado) {
			modoPvp = solicitarModo();
			modoConfigurado = true;
		}
	}

	private boolean solicitarModo() {
		return consola.readBooleanUsingChar('p', 'f', "p para jugar PVP f para jugar vs IA : ");
	}

	private int solicitarOpcion() {
		return consola.readIntInRange(1, 4);
	}

	private void solicitarNombres(Partida partida) {
		partida.getJugador1().setNombre(consola.leerTextoNoVacio("Introduce el nombre del primer jugador : "));

		if (modoPvp) {
			partida.getJugador2().setNombre(consola.leerTextoNoVacio("Introduce el nombre del segundo jugador : "));
		} else {
			partida.getJugador2().setNombre("Crupier");
		}
		nombresConfigurados = true;

	}

	private void crearPartida() {
		if (modoPvp) {
			partida = new Partida(null, null);
		} else {
			partida = new Partida(null);
		}
	}

	public void determinarGanador(Partida partida) {
		if ((partida.getJugador1().puntuacion() > partida.getJugador2().puntuacion()
				&& partida.getJugador1().puntuacion() <= 21)
				|| (partida.getJugador1().puntuacion() <= 21 && partida.getJugador2().puntuacion() > 21)) {
			consola.escribirLinea(partida.getJugador1().getNombre() + " gana!!");
		} else if ((partida.getJugador2().puntuacion() > partida.getJugador1().puntuacion()
				&& partida.getJugador2().puntuacion() <= 21)
				|| (partida.getJugador2().puntuacion() <= 21 && partida.getJugador1().puntuacion() > 21)) {
			consola.escribirLinea(partida.getJugador2().getNombre() + " gana!!");
		} else {
			consola.escribirLinea("Empate!!");
		}
		consola.escribirLinea(
				String.format("La siguiente carta era %s", partida.getBaraja().extraerCarta().toString()));
	}

}
