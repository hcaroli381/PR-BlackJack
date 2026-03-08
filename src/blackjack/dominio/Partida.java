package blackjack.dominio;

public class Partida {
	private Baraja baraja;
	private Jugador jugador1;
	private Jugador jugador2;
	private int ronda;
	/**
	 * Constructor que crea la baraja, la mezcla y crea a ambos jugadores
	 * @param nombre1 nombre del primer jugador
	 * @param nombre2 nombre del segundo jugador
	 */
	public Partida(String nombre1, String nombre2) {
		baraja = new Baraja();
		baraja.crearBaraja();
		baraja.barajar();

		jugador1 = new Jugador(nombre1);
		jugador2 = new Jugador(nombre2);
	}

	/**
	 * Reparte las dos primeras cartas a los dos jugadores
	 */
	public void iniciarPartida() {
		repartirCarta(jugador1);
		repartirCarta(jugador2);
		repartirCarta(jugador1);
		repartirCarta(jugador2);
	}

	/**
	 * crea una carta para darla a un jugador y eliminarla después
	 * @param jugador que recibirá la carta
	 */
	private void repartirCarta(Jugador jugador) {
		Carta carta = baraja.extraerCarta();
		jugador.recibirCarta(carta);
		baraja.eliminarCarta();
	}

	/**
	 * Reparte carta si el jugador la pide
	 * @param bJug1 comprueba que el jugador 1 quiera carta
	 * @param bJug2 comprueba que el jugador 2 quiera carta
	 */
	public void pedirCarta(boolean bJug1, boolean bJug2) {
		if (bJug1) {
			repartirCarta(jugador1);
		}
		if (bJug2) {
			repartirCarta(jugador2);
		}
		ronda = ronda + 1;
	}

	/**
	 * Dictamina si la partida ha terminado o sigue
	 * @param bJug1 comprueba que el jugador 1 siga jugando
	 * @param bJug2 comprueba que el jugador 2 siga jugando
	 * @return true si la partida finaliza, false si se sigue jugando
	 */
	public boolean finPartida(boolean bJug1, boolean bJug2) {
		if (!bJug1 && !bJug2) {
			return true;
		} else if (jugador1.puntuacion() > 21 || jugador2.puntuacion() > 21) {
			return true;
		} else {
			return false;
		}
	}

	public Baraja getBaraja() {
		return baraja;
	}

	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public int getRonda() {
		return ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	@Override
	public String toString() {
		return String.format("Ronda %d\n%s : %s %d puntos\n%s : %s %d puntos", ronda, jugador1.getNombre(),
				jugador1.getMano().toString(), jugador1.puntuacion(), jugador2.getNombre(),
				jugador2.getMano().toString(), jugador2.puntuacion());
	}
}