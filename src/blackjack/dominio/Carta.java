package blackjack.dominio;

public class Carta {
	private Palo palo;
	private TipoCarta tipo;

	public Carta(Palo palo, TipoCarta tipo) {
		this.setPalo(palo);
		this.setTipo(tipo);
	}

	public TipoCarta getTipo() {
		return tipo;
	}

	public void setTipo(TipoCarta tipo) {
		this.tipo = tipo;
	}

	public Palo getPalo() {
		return palo;
	}

	public void setPalo(Palo palo) {
		this.palo = palo;
	}

	public String toString() {
		return String.format("%s de %s", tipo.toString(), palo.toString());
	}
}
