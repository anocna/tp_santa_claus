#Programación Concurrente

**** PROBLEMA :
Santa Claus pasa su tiempo de descanso, durmiendo, en su casa del Polo Norte. Para poder despertarlo, se ha de cumplir una de las dos condiciones siguientes:
1. Que todos los renos de los que dispone, nueve en total, hayan vuelto de vacaciones.
2. Que algunos de sus duendes necesiten su ayuda para fabricar un juguete.
3. Para permitir que Santa Claus pueda descansar, los duendes han acordado despertarle si tres de ellos tienen problemas a la hora de fabricar un juguete.
4. En el caso de que un grupo de tres duendes estén siendo ayudados por Santa, el resto de los duendes con problemas tendrán que esperar a que Santa termine de ayudar al primer grupo.
5. En caso de que haya duendes esperando y todos los renos hayan vuelto devacaciones, entonces Santa Claus decidirá preparar el trineo y repartir los
regalos, ya que su entrega es más importante que la fabricación de otros juguetes que podría esperar al año siguiente. El último reno en llegar ha de
despertar a Santa mientras el resto de los renos esperan antes de ser enganchados al trineo.
- Simular el funcionamiento con una función aleatoria.

**** SOLUCION:
El código simula la coordinación de duendes y renos que requieren la interacción con Papá Noel para prestar ayuda o tener que repartir regalos. 
Los duendes y renos incrementan contadores y Papá Noel realiza acciones específicas cuando se alcanzan los limites establecidos, tres duendes pidiendo ayuda o que los nueve renos vuelvan de vacaciones.
El programa se ejecuta a través de la clase "Main", que crea una instancia de la clase "Controlador" y llama al método "controlador()" en esa instancia, 
esta clase mencionada crea arreglos de duendes y renos, y realiza iteraciones para seleccionar aleatoriamente un duende que necesite ayuda o un reno que vuelva
de vacaciones y crear su hilo correspondiente, incrementando su respectivo contador en la instancia de "PapaNoel". En la clase "PapaNoel" está la lógica principal.
Tiene métodos para despertar, incrementar los contadores de renos y duendes, realizando acciones específicas cuando se alcanzan los límites
establecidos, utilizando la sincronización y notificación para coordinar las acciones entre los hilos. –
