package blackjack.app;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Consola consola = new Consola();
		GestorPartida gestor = new GestorPartida(consola);
		gestor.ejecutar();
	}
}