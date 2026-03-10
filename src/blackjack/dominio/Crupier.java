package blackjack.dominio;

public class Crupier extends Jugador {
	private boolean turno;

	public Crupier(String nombre, boolean turno) {
		super("Crupier");
		this.turno = turno;
	}

	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		if (turno = false) {
			return String.format("[%s , *]", getMano().getFirst().toString());
		} else {
			return super.toString();
		}
	}
}
