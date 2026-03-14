# PR - Blackjack

Mi juego es simple, nos empezará preguntando si queremos jugar contra otro jugador o VS la IA

![inicio](./assets/imgs/Captura%20de%20pantalla%202026-03-14%20123245.png)

Luego nos dará a elegir 1 o 2 nombres según el modo de juego elegido

![inicio](./assets/imgs/Captura%20de%20pantalla%202026-03-14%20123333.png)

## Reglas

Estas normas se aplican siempre, independientemente del modo elegido.

    El Objetivo: Sumar 21 puntos o acercarse lo máximo posible sin pasarse. Si un jugador supera los 21, pierde automáticamente.

    Valor de las Cartas:

        Las figuras (J, Q, K) valen 10 puntos.

        El As es dinámico: vale 11 puntos, pero si el jugador se pasa de 21, el As pasa a valer 1 punto automáticamente.

        El resto de cartas conservan su valor numérico.

   - Reparto Inicial: En cada partida se reparten obligatoriamente dos cartas visibles a cada participante.

   - Empate: Si ambos jugadores terminan con la misma puntuación (y ninguno se ha pasado), la partida se considera empate.


## VS otro jugador
  Transparencia Total: Todas las cartas repartidas son visibles para ambos jugadores desde el principio.

    Decisión a Ciegas (Simultaneidad): Para evitar que el Jugador 2 decida basándose en lo que hizo el Jugador 1:

        El programa solicita la intención de ambos antes de repartir.

        Si ambos piden carta, se reparten. Si uno se planta, solo el otro sigue recibiendo hasta que él también decida plantarse.

    Equidad de Victoria: ambos jugadores tienen libertad total para plantarse con la puntuación que deseen.

    Ganador: Solo se comparan las manos cuando ambos han confirmado que no quieren más cartas o uno de ellos ha superado los 21.

![inicio](./assets/imgs/Captura%20de%20pantalla%202026-03-14%20123414.png)
![inicio](./assets/imgs/Captura%20de%20pantalla%202026-03-14%20123426.png)

>>Debemos pedir la opción a ambos a la vez para que ninguno tenga ventaja

## VS IA
    Visibilidad Limitada: El jugador recibe sus dos cartas boca arriba. El Crupier recibe una carta boca arriba y la segunda boca abajo (en tu código, el toString del Crupier oculta la segunda carta con un * si no es su turno).

    Turno del Jugador: El jugador es el único que toma decisiones activas primero. Puede pedir cartas de una en una hasta plantarse o pasarse.

    Turno de la IA (Regla de la Casa): Una vez el jugador se planta, el Crupier revela su carta oculta.

        La IA pide carta si el jugador tiene más puntuación.

        La IA se planta si está empatada o ya tiene más puntuación que el jugador.

    Ventaja del Crupier: Si el jugador se pasa de 21, pierde inmediatamente antes de que el Crupier revele su juego.
![inicio](./assets/imgs/Captura%20de%20pantalla%202026-03-14%20123608.png)


## Extra
Al acabar la partida se nos mostrara cual era la siguiente carta que tocaba, para saber que hubiera pasado si no nos hubiésemos plantado, por ejemplo.
![inicio](./assets/imgs/Captura%20de%20pantalla%202026-03-14%20123618.png)

## Al terminar
Tenemos 3 opciones :
1.  Jugar a otro modo de juego
2.  Jugar al mismo modo de juego 
3.  Salir

![inicio](./assets/imgs/Captura%20de%20pantalla%202026-03-14%20124221.png)

### Opción 1 
Volvemos al principio del juego.

### Opción 2
Nos preguntará si continuamos con los mismos nombres o queremos cambiarlos.

### Opción 3
El juego termina!!



