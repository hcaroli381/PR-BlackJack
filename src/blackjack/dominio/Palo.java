package blackjack.dominio;
/**
 * Distintos palos posibles de una carta
 */
public enum Palo {
	DIAMANTES('♦'), PICAS('♠'), TREBOLES('♣'), CORAZONES('♥');

	private char simbolo;

	Palo(char simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public String toString() {
		return String.format("%c", simbolo);
	}
}
