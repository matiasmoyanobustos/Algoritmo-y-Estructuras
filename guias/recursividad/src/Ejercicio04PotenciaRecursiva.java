/* Prompt inicial utilizado: Implementá en Java 21 una clase independiente llamada `Ejercicio04PotenciaRecursiva` para calcular una potencia entera mediante recursión, sin usar `Math.pow`. Antes del Javadoc de la clase, incluí como comentario el texto completo de este prompt. Admití cualquier base `int` y un exponente no negativo. El caso base es exponente 0 y devuelve 1; por lo tanto, para esta función también `0` elevado a `0` devuelve 1. En el caso recursivo, reducí el exponente en uno y combiná la base con el resultado. El método devuelve `int`; rechazá exponentes negativos y usá ejemplos cuyos resultados quepan en `int`. En Javadoc documentá consigna, estrategia, parámetros, resultado, error y complejidades temporal O(e) y espacial O(e) por la pila. En `main`, probá exponente 0, exponente 1, base 0 con exponente positivo, base negativa con exponente positivo y una potencia positiva pequeña. Comentá el caso base y el retorno recursivo. Si cambiás este prompt, agregá al final del archivo un comentario que indique el cambio y su motivo. */

/**
 * Ejercicio 4 — Potencia.
 * <p>Consigna: calcular recursivamente una potencia entera sin usar Math.pow.</p>
 * <p>El caso base es exponente 0 y devuelve 1, también para 0 elevado a 0. Para un exponente positivo, se reduce en uno y se combina la base con el resultado de la llamada siguiente.</p>
 * <p>Complejidad: tiempo O(e) y espacio O(e) por la pila de llamadas. Se admiten resultados representables en int; la recursión no está pensada para exponentes grandes.</p>
 */
public class Ejercicio04PotenciaRecursiva {

    private Ejercicio04PotenciaRecursiva() { }

    /**
     * Calcula base elevada a exponente mediante multiplicaciones recursivas.
     *
     * @param base base entera de la potencia
     * @param exponente exponente no negativo
     * @return base elevada a exponente; devuelve 1 si el exponente es 0
     * @throws IllegalArgumentException si el exponente es negativo
     */
    public static int potencia(int base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente debe ser no negativo.");
        }
        if (exponente == 0) {
            return 1;
        }

        // Se reduce el exponente; la base se combina al retornar de la llamada más pequeña.
        return base * potencia(base, exponente - 1);
    }

    /**
     * Muestra casos límite y una potencia positiva pequeña.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 4 — Potencia");
        System.out.println("0^0 = " + potencia(0, 0));
        System.out.println("5^0 = " + potencia(5, 0));
        System.out.println("5^1 = " + potencia(5, 1));
        System.out.println("0^4 = " + potencia(0, 4));
        System.out.println("(-2)^3 = " + potencia(-2, 3));
        System.out.println("3^4 = " + potencia(3, 4));
        try {
            potencia(2, -1);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
