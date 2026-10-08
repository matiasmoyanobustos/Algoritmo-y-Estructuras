/* Prompt inicial utilizado: Implementá en Java 21 una clase independiente llamada `Ejercicio03MultiplicacionRecursiva` que multiplique dos factores enteros no negativos usando recursión y sin usar el operador `*` en el algoritmo. Antes del Javadoc de la clase, incluí como comentario el texto completo de este prompt. Representá el producto como sumas repetidas: reducí el segundo factor en uno en cada llamada y sumá el primer factor al resultado recursivo. El caso base es segundo factor igual a 0 y debe devolver 0. El método debe devolver un `int`, rechazar factores negativos y documentar la consigna, parámetros, resultado, casos de error y complejidad temporal O(b) y espacial O(b), donde `b` es el segundo factor y el espacio corresponde a la pila. Separá el cálculo de `main`; probá cero en cada posición, un factor igual a 1 y dos factores positivos pequeños. Usá comentarios para explicar la reducción. Si cambiás este prompt, agregá al final del archivo un comentario que indique el cambio y su motivo. */

/**
 * Ejercicio 3 — Multiplicación mediante sumas.
 * <p>Consigna: calcular el producto de dos enteros no negativos sin usar el operador de multiplicación en el algoritmo, representándolo como sumas repetidas.</p>
 * <p>Se reduce el segundo factor b en cada llamada. El caso base b == 0 devuelve 0; en los demás casos se suma a al resultado de multiplicar recursivamente a por b - 1.</p>
 * <p>Complejidad: tiempo O(b) y espacio O(b) por la pila. El resultado debe caber en int y b debe ser suficientemente pequeño para la pila.</p>
 */
public class Ejercicio03MultiplicacionRecursiva {

    private Ejercicio03MultiplicacionRecursiva() { }

    /**
     * Calcula el producto como sumas repetidas, sin usar multiplicación en el algoritmo.
     *
     * @param primerFactor primer factor no negativo que se suma repetidamente
     * @param segundoFactor cantidad no negativa de sumas y parámetro que se reduce
     * @return el producto de los factores
     * @throws IllegalArgumentException si cualquiera de los factores es negativo
     */
    public static int multiplicar(int primerFactor, int segundoFactor) {
        if (primerFactor < 0 || segundoFactor < 0) {
            throw new IllegalArgumentException("Ambos factores deben ser enteros no negativos.");
        }
        if (segundoFactor == 0) {
            return 0;
        }

        // Una suma por llamada equivale a repetir el primer factor segundoFactor veces.
        return primerFactor + multiplicar(primerFactor, segundoFactor - 1);
    }

    /**
     * Muestra casos con cero, uno y factores positivos.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 3 — Multiplicación mediante sumas");
        System.out.println("0 por 7 = " + multiplicar(0, 7));
        System.out.println("7 por 0 = " + multiplicar(7, 0));
        System.out.println("6 por 1 = " + multiplicar(6, 1));
        System.out.println("4 por 3 = " + multiplicar(4, 3));
        try {
            multiplicar(-2, 3);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
