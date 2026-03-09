package blackjack.dominio;

/**
 * Número de la carta o figura junto a su valor
 */
public enum TipoCarta {
	AS(11), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), NUEVE(9), JOTA(10), REINA(10), REY(10);

	private int valor;

	TipoCarta(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public String toString() {
		if (this.name().equals(TipoCarta.AS.name())) {
			return "AS";
		} else if (this.name().equals(TipoCarta.JOTA.name())) {
			return "J";
		} else if (this.name().equals(TipoCarta.REINA.name())) {
			return "Q";
		} else if (this.name().equals(TipoCarta.REY.name())) {
			return "K";
		} else {
			return String.format("%d", valor);
		}

	}
}
