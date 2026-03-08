package blackjack.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Se encarga de crear las 52 cartas del juego junto con las funciones de extraer y eliminar carta
 */
public class Baraja {
	private List<Carta> baraja = new ArrayList();
	
	/**
	 * Constructor que borra la anterior y crea la baraja completa
	 */
	public void crearBaraja() {
		baraja.clear();
		for (Palo p : Palo.values()) {
			for (TipoCarta tipo : TipoCarta.values()) {
				baraja.add(new Carta(p, tipo));
			}
		}
	}
	/**
	 * Mezcla la baraja
	 */
	public void barajar() {
		Collections.shuffle(baraja);
	}
	/**
	 * Se coge la primera carta de la baraja
	 * @return primera carta de la baraja
	 */
	public Carta extraerCarta() {
		if (baraja.isEmpty()) {
			return null;
		}
		return baraja.getFirst();
	}
	/**
	 * Elimina la primera carta de la baraja(usado para que la carta no pueda repetirse)
	 */
	public void eliminarCarta() {
		baraja.remove(0);
	}
}
