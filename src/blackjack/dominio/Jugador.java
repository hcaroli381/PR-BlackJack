package blackjack.dominio;

import java.util.ArrayList;
import java.util.List;
/**
 * Usuarios del programa
 */
public class Jugador {
	private String nombre;
	private List<Carta> mano;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.mano = new ArrayList<>();

	}

	public List<Carta> getMano() {
		return mano;
	}

	public void setMano(List<Carta> mano) {
		this.mano = mano;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * utilizado para saber quien va ganando o gana al final, restando 10 si tenemos un as y nos pasamos
	 * @return puntuacion de ese momento
	 */
	public int puntuacion() {
		int puntuacion = 0;
		int ases = 0;
		for (int i = 0; i < mano.size(); i++) {
			puntuacion += mano.get(i).getTipo().getValor();
			if (mano.get(i).getTipo().equals(TipoCarta.AS)) {
				ases++;
			}
			if (ases > 0 && puntuacion > 21) {
				puntuacion = puntuacion - 10;
				ases--;
			}
		}
		return puntuacion;
	}
	
	/**
	 * Recibir una carta como jugador
	 * @param carta a recibir
	 */
	public void recibirCarta(Carta carta) {
		mano.add(carta);
	}

	@Override
	public String toString() {
		return String.format("%s : %s %d puntos", this.nombre, this.mano.toString(), this.puntuacion());
	}

}
