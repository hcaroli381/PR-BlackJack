package blackjack.app;

import java.util.Scanner;

/**
 * Clase de la capa de aplicación que centraliza la entrada y salida de datos
 * por consola.
 */
public class Consola {
	Scanner sc;

	/**
	 * Crea un objeto Consola e inicializa el lector de entrada estándar.
	 */
	public Consola() {
		this.sc = new Scanner(System.in);
	}

	/**
	 * Cierra el recurso Scanner asociado a la entrada estándar. Debe llamarse al
	 * finalizar la ejecución del programa.
	 */
	public void cerrar() {
		this.sc.close();
	}

	/**
	 * Muestra un texto por consola seguido de un salto de línea.
	 *
	 * @param texto Texto que se desea mostrar.
	 */
	public void escribirLinea(String texto) {
		System.out.println(texto);
	}

	/**
	 * Muestra un texto por consola sin salto de línea.
	 *
	 * @param texto Texto que se desea mostrar.
	 */
	public void escribir(String texto) {
		System.out.print(texto);
	}

	// TODO: Métodos que debéis realizar vosotros.
	// **IMPORTANTE** No podéis usar "print", ni "println" de aquí en adelante,
	// pero si hacer llamadas a métodos ya creados como "escribir" y
	// "escribirLinea".

	/**
	 * Muestra un mensaje por consola y lee una línea de texto introducida por el
	 * usuario.
	 *
	 * @param mensaje Mensaje que se muestra antes de la lectura.
	 * @return Texto introducido por el usuario, sin espacios iniciales ni finales.
	 */
	public String leerTexto(String mensaje) {
		escribirLinea(mensaje);
		mensaje = sc.nextLine();
		return mensaje.trim();
	}

	/**
	 * Muestra un mensaje por consola y lee un texto no vacío. Si el usuario
	 * introduce una cadena vacía o solo con espacios, se vuelve a pedir el dato.
	 *
	 * @param mensaje Mensaje que se muestra antes de la lectura.
	 * @return Texto no vacío introducido por el usuario.
	 */
	public String leerTextoNoVacio(String mensaje) {
		do {
			escribirLinea(mensaje);
			mensaje = sc.nextLine();
		} while (mensaje.trim().equals(""));
		;
		return mensaje;
	}

	/**
	 * Muestra un mensaje por consola y lee un número entero. Si el valor
	 * introducido no es un entero válido, se vuelve a pedir.
	 *
	 * @param mensaje Mensaje que se muestra antes de la lectura.
	 * @return Número entero introducido por el usuario.
	 */
	public int leerEntero(String mensaje) {
		int resultado = 0;
		boolean hayError = true;
		if (mensaje != null && !mensaje.isEmpty()) {
			escribir(mensaje);
		}
		do {
			try {
				resultado = Integer.parseInt(sc.nextLine().trim());
				hayError = false;
			} catch (Exception e) {
				escribirLinea("Error: Introduce un número entero válido.");
			}
		} while (hayError);
		return resultado;
	}

	/**
	 * Lee un número entero dentro de un rango determinado. Si el número está fuera
	 * del rango, se vuelve a solicitar.
	 *
	 * @param mensaje Mensaje que se muestra antes de la lectura.
	 * @param min     Valor mínimo permitido (incluido).
	 * @param max     Valor máximo permitido (incluido).
	 * @return Número entero dentro del rango indicado.
	 */
	public int leerEnteroRango(String mensaje, int min, int max) {
		int valor;
		do {
			valor = leerEntero(mensaje);
			if (valor < min || valor > max) {
				escribir(mensaje);
			}
		} while (valor < min || valor > max);
		return valor;
	}

	/***
	 * Lee un caracter
	 * 
	 * @return
	 */
	public char readChar() {
		String s;
		boolean hayError = true;
		char c = ' ';

		do {
			try {
				s = sc.nextLine().trim();

				if (s.length() != 1) {
					System.err.println("Error: Debes introducir exactamente un carácter.");
					sc.nextLine();
				} else {
					c = s.charAt(0);
					hayError = false;
				}

			} catch (Exception e) {
				System.err.println("Error: Ocurrió un problema al leer la entrada.");
				sc.nextLine();
				hayError = true;
			}
		} while (hayError);

		return c;
	}

	/***
	 * Lee dos caracteres
	 * 
	 * @param affirmativeValue caracter true
	 * @param negativeValue    caracter false
	 * @param mensaje          mensaje a mostrar
	 * @return depende de la opcion escogida true/false
	 */
	public boolean readBooleanUsingChar(char affirmativeValue, char negativeValue, String mensaje) {
		char c;
		escribir(mensaje);

		do {
			c = readChar();
			if (c != affirmativeValue && c != negativeValue) {
				System.err.printf("Opción no válida. Introduce %c o %c: ", affirmativeValue, negativeValue);
			}

		} while (c != affirmativeValue && c != negativeValue);
		return (c == affirmativeValue);
	}

	public void limpiar() {

	}

	/***
	 * Lee un rango de enteros
	 * 
	 * @param lowerBound minimo
	 * @param upperBound max
	 * @param mensaje    mensaje a mostrar
	 * @return entero escogido
	 */
	public int readIntInRange(int lowerBound, int upperBound, String mensaje) {
		int valor;
		escribir(mensaje);
		do {
			valor = leerEntero("");
			if (valor < lowerBound || valor > upperBound) {
				System.err.printf("Error: %d no está entre %d y %d. Inténtalo de nuevo: ", valor, lowerBound,
						upperBound);
			}
		} while (valor < lowerBound || valor > upperBound);
		return valor;
	}
}
