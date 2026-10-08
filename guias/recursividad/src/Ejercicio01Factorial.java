/* Prompt inicial utilizado: Implementá en Java 21 una clase independiente llamada `Ejercicio01Factorial` para calcular el factorial de un entero no negativo mediante recursión. Antes del Javadoc de la clase, incluí como comentario el texto completo de este prompt. En el Javadoc de clase incluí la consigna, una explicación de por qué el problema es recursivo, el caso base (`n` igual a 0 o 1 devuelve 1), el caso recursivo (multiplicar `n` por el factorial de `n - 1`) y las complejidades temporal O(n) y espacial O(n) por la pila de llamadas. El método público debe devolver un `int`, documentar sus parámetros y resultado, y rechazar valores negativos con un error claro. Separá el cálculo de `main`; probá 0, 1 y un valor pequeño cuyo factorial quepa en `int`. Usá comentarios para explicar la reducción y el retorno de las llamadas, sin usar ciclos ni bibliotecas de factorial. Si cambiás este prompt, agregá al final del archivo un comentario que indique el cambio y su motivo. */

/**
 * Ejercicio 1 — Factorial.
 * <p>Consigna: implementar una función recursiva que calcule el factorial de un entero no negativo.</p>
 * <p>El problema es recursivo porque el factorial de n se define usando el factorial de n - 1. Los casos base n == 0 y n == 1 devuelven 1; para n mayor, el caso recursivo devuelve n multiplicado por factorial(n - 1).</p>
 * <p>Complejidad: tiempo O(n) y espacio O(n) debido a la pila de llamadas. El rango de int limita los resultados representables (12! es el mayor factorial positivo que cabe en int); la profundidad de pila también limita entradas grandes.</p>
 */
public class Ejercicio01Factorial {

    private Ejercicio01Factorial() { }

    /**
     * Calcula el factorial de un entero no negativo de forma recursiva.
     *
     * @param n entero no negativo cuyo factorial se calculará
     * @return el factorial de n
     * @throws IllegalArgumentException si n es negativo
     */
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para enteros negativos en este ejercicio.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }

        // Cada llamada reduce n hasta llegar a 1; al retornar se combinan los productos pendientes.
        return n * factorial(n - 1);
    }

    /**
     * Muestra ejemplos de factorial dentro del rango de int y el rechazo de negativos.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 1 — Factorial");
        System.out.println("0! = " + factorial(0));
        System.out.println("1! = " + factorial(1));
        System.out.println("5! = " + factorial(5));
        try {
            factorial(-1);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
