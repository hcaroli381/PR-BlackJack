package blackjack.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
	public List<Carta> baraja = new ArrayList();

	public void crearBaraja() {
		baraja.clear();
		for (Palo p : Palo.values()) {
			for (TipoCarta tipo : TipoCarta.values()) {
				baraja.add(new Carta(p, tipo));
			}
		}
	}

	public void barajar() {
		Collections.shuffle(baraja);
	}

	public Carta extraerCarta() {
		if (baraja.isEmpty()) {
			return null;
		}
		return baraja.getFirst();
	}

	public void eliminarCarta() {
		baraja.remove(0);
	}
}
