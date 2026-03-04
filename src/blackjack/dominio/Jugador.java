package blackjack.dominio;

import java.util.ArrayList;
import java.util.List;

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

	public void recibirCarta(Carta carta) {
		mano.add(carta);
	}

}
