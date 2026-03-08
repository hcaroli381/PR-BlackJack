package blackjack.dominio;
/**
 * Núcleo principal del blackjack, componente de la baraja
 */
public class Carta {
	private Palo palo;
	private TipoCarta tipo;
	/**
	 * Constructor de carta
	 * @param palo enum que elige entre diamantes/picas/corazones/treboles
	 * @param tipo numero/figura de la carta
	 */
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
		return String.format("%s%s", tipo.toString(), palo.toString());
	}
}
