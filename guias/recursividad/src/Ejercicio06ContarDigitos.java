/* Prompt inicial utilizado: Implementá en Java 21 una clase independiente llamada `Ejercicio06ContarDigitos` para contar recursivamente los dígitos de un entero positivo. Antes del Javadoc de la clase, incluí como comentario el texto completo de este prompt. Reducí el número mediante división entera por 10. El caso base es un valor menor que 10, que tiene un dígito; cada llamada recursiva devuelve 1 más que el conteo del número reducido. Aceptá solo valores positivos y rechazá 0 o números negativos con un error claro. El método devuelve `int`. Documentá consigna, reducción, parámetros, resultado, error y complejidades temporal O(d) y espacial O(d), siendo `d` la cantidad de dígitos. Separá el método de `main` y probá un dígito, varios dígitos y un número con ceros internos. No uses ciclos para contar. Si cambiás este prompt, agregá al final del archivo un comentario que indique el cambio y su motivo. */

/**
 * Ejercicio 6 — Contar dígitos.
 * <p>Consigna: contar recursivamente los dígitos de un entero positivo.</p>
 * <p>El caso base es un valor menor que 10, que contiene un dígito. En cada caso recursivo la división entera por 10 elimina el último dígito y la llamada suma 1 al conteo restante.</p>
 * <p>Complejidad para un número de d dígitos: tiempo O(d) y espacio O(d) por la pila. La recursión no es adecuada para profundidades excesivas.</p>
 */
public class Ejercicio06ContarDigitos {

    private Ejercicio06ContarDigitos() { }

    /**
     * Cuenta los dígitos de un entero positivo mediante división recursiva por 10.
     *
     * @param numero entero positivo
     * @return cantidad de dígitos decimales de numero
     * @throws IllegalArgumentException si numero es cero o negativo
     */
    public static int contar(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El número debe ser un entero positivo.");
        }
        if (numero < 10) {
            return 1;
        }

        // La división entera elimina el dígito final y reduce el problema.
        return 1 + contar(numero / 10);
    }

    /**
     * Muestra ejemplos de uno y varios dígitos, incluidos ceros internos.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 6 — Contar dígitos");
        System.out.println("7 tiene " + contar(7) + " dígito(s).");
        System.out.println("48321 tiene " + contar(48321) + " dígitos.");
        System.out.println("40506 tiene " + contar(40506) + " dígitos.");
        try {
            contar(0);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
        try {
            contar(-24);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
