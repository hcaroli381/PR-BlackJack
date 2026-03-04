package blackjack.dominio;

public class Partida {
	private Baraja baraja;
	private Jugador jugador1;
	private Jugador jugador2;
	private int ronda;

	public Partida(String nombre1, String nombre2) {
		baraja = new Baraja();
		baraja.crearBaraja();
		baraja.barajar();

		jugador1 = new Jugador(nombre1);
		jugador2 = new Jugador(nombre2);
	}

	public void iniciarPartida() {
		repartirCarta(jugador1);
		repartirCarta(jugador2);
		repartirCarta(jugador1);
		repartirCarta(jugador2);
	}

	private void repartirCarta(Jugador jugador) {
		Carta carta = baraja.extraerCarta();
		jugador.recibirCarta(carta);
		baraja.eliminarCarta();
	}

	public void pedirCarta(boolean bJug1, boolean bJug2) {
		if (bJug1) {
			repartirCarta(jugador1);
		}
		if (bJug2) {
			repartirCarta(jugador2);
		}
		ronda = ronda + 1;
	}

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
}
