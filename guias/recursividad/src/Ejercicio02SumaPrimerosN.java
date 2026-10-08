/* Prompt inicial utilizado: Implementá en Java 21 una clase independiente llamada `Ejercicio02SumaPrimerosN` que sume recursivamente los enteros desde `n` hasta 1. Antes del Javadoc de la clase, incluí como comentario el texto completo de este prompt. Documentá en Javadoc la consigna, por qué `suma(n)` se reduce a `n + suma(n - 1)`, el caso base `n == 0` que devuelve 0 y las complejidades temporal O(n) y espacial O(n) por la pila. El método público debe devolver un `int`, rechazar entradas negativas con un error claro y documentar parámetros y resultado. Incluí un `main` separado con pruebas para 0, 1 y un valor positivo pequeño. Explicá mediante comentarios cómo cada llamada reduce el problema y cómo se combinan los resultados; no uses ciclos para calcular la suma. Si cambiás este prompt, agregá al final del archivo un comentario que indique el cambio y su motivo. */

/**
 * Ejercicio 2 — Suma de los primeros N números.
 * <p>Consigna: sumar recursivamente los enteros desde n hasta 1.</p>
 * <p>El caso base es n == 0, que devuelve 0. Para n positivo, suma(n) es n + suma(n - 1): cada llamada reduce n y, al regresar, agrega su valor a la suma parcial.</p>
 * <p>Complejidad: tiempo O(n) y espacio O(n) por la pila de llamadas. El resultado debe caber en int y una entrada grande puede exceder la profundidad disponible.</p>
 */
public class Ejercicio02SumaPrimerosN {

    private Ejercicio02SumaPrimerosN() { }

    /**
     * Suma todos los enteros desde n hasta 1 mediante recursión.
     *
     * @param n límite superior no negativo
     * @return suma de los enteros desde n hasta 1, o 0 si n es 0
     * @throws IllegalArgumentException si n es negativo
     */
    public static int sumarHastaUno(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El límite debe ser un entero no negativo.");
        }
        if (n == 0) {
            return 0;
        }

        // La suma parcial se completa al retornar desde sumaHastaUno(n - 1).
        return n + sumarHastaUno(n - 1);
    }

    /**
     * Muestra ejemplos de suma y el rechazo de un valor negativo.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 2 — Suma de los primeros N números");
        System.out.println("Suma hasta 0: " + sumarHastaUno(0));
        System.out.println("Suma hasta 1: " + sumarHastaUno(1));
        System.out.println("Suma hasta 5: " + sumarHastaUno(5));
        try {
            sumarHastaUno(-2);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
