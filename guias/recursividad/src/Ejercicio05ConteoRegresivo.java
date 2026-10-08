/* Prompt inicial utilizado: Implementá en Java 21 una clase independiente llamada `Ejercicio05ConteoRegresivo` que imprima recursivamente desde un entero no negativo `n` hasta 0, inclusive. Antes del Javadoc de la clase, incluí como comentario el texto completo de este prompt. La operación imprime la secuencia y no necesita devolver un valor. Usá 0 como caso base; imprimí el valor actual antes de llamar recursivamente con `n - 1`. Rechazá valores negativos para evitar no alcanzar el caso base. Documentá en Javadoc la consigna, los casos base y recursivo y las complejidades temporal O(n) y espacial O(n) por la pila. En `main`, probá 0 y un valor positivo pequeño. Explicá en un comentario que cambiar `n - 1` por `n + 1` aleja la ejecución del caso base; no ejecutes esa variante porque no termina normalmente y puede agotar la pila. Si cambiás este prompt, agregá al final del archivo un comentario que indique el cambio y su motivo. */

/**
 * Ejercicio 5 — Conteo regresivo.
 * <p>Consigna: imprimir recursivamente los valores desde n hasta 0, inclusive. Es un procedimiento de impresión, por lo que no devuelve un resultado.</p>
 * <p>El caso base es 0. En el caso recursivo se imprime el valor actual y se llama con n - 1, acercándose al caso base. Usar n + 1 en su lugar alejaría la llamada del caso base y causaría recursión sin terminación normal; esa variante no se ejecuta.</p>
 * <p>Complejidad para n >= 0: tiempo O(n) y espacio O(n) por la pila de llamadas.</p>
 */
public class Ejercicio05ConteoRegresivo {

    private Ejercicio05ConteoRegresivo() { }

    /**
     * Imprime n, n - 1, ... hasta 0 mediante recursión.
     *
     * @param n valor inicial no negativo
     * @throws IllegalArgumentException si n es negativo
     */
    public static void imprimirHastaCero(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El conteo inicial debe ser no negativo.");
        }

        System.out.println(n);
        if (n == 0) {
            return;
        }

        // n - 1 avanza hacia el caso base; n + 1 se alejaría de él y no se utiliza.
        imprimirHastaCero(n - 1);
    }

    /**
     * Ejecuta ejemplos de conteo desde cero y desde un valor positivo pequeño.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 5 — Conteo regresivo desde 0:");
        imprimirHastaCero(0);
        System.out.println("Conteo regresivo desde 4:");
        imprimirHastaCero(4);
        try {
            imprimirHastaCero(-1);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
