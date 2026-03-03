package blackjack.dominio;

public class Partida {
	private Baraja baraja;
	private Jugador jugador1;
	private Jugador jugador2;

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
}
