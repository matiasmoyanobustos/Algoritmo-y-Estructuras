/* Prompt inicial utilizado: Implementá en Java 21 una clase independiente llamada `Ejercicio07SumarDigitos` que sume recursivamente los dígitos de un entero positivo. Antes del Javadoc de la clase, incluí como comentario el texto completo de este prompt. Obtené el último dígito mediante módulo 10 y reducí el número mediante división entera por 10. Usá como caso base un número de un solo dígito y devolvé ese dígito; en el caso recursivo, sumá el último dígito al resultado obtenido para el resto del número. Aceptá solo valores positivos y rechazá 0 o números negativos con un error claro. El método devuelve `int`. Documentá consigna, estrategia, parámetros, resultado, errores y complejidades temporal O(d) y espacial O(d) por la pila. Incluí pruebas con un dígito, varios dígitos y ceros internos. Comentá cómo se combinan los resultados al retornar; no uses ciclos para sumar. Si cambiás este prompt, agregá al final del archivo un comentario que indique el cambio y su motivo. */

/**
 * Ejercicio 7 — Sumar dígitos.
 * <p>Consigna: sumar recursivamente los dígitos de un entero positivo.</p>
 * <p>El caso base ocurre cuando queda un solo dígito y devuelve ese valor. En los demás casos, el módulo 10 obtiene el último dígito, la división entera por 10 reduce el número y, al retornar, se suman ambos resultados.</p>
 * <p>Complejidad para un número de d dígitos: tiempo O(d) y espacio O(d) debido a la pila de llamadas.</p>
 */
public class Ejercicio07SumarDigitos {

    private Ejercicio07SumarDigitos() { }

    /**
     * Suma los dígitos de un entero positivo mediante recursión.
     *
     * @param numero entero positivo
     * @return suma de sus dígitos decimales
     * @throws IllegalArgumentException si numero es cero o negativo
     */
    public static int sumar(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("El número debe ser un entero positivo.");
        }
        if (numero < 10) {
            return numero;
        }

        int ultimoDigito = numero % 10;
        int restoDelNumero = numero / 10;
        // Al retornar, se agrega el dígito separado a la suma del resto.
        return ultimoDigito + sumar(restoDelNumero);
    }

    /**
     * Muestra ejemplos con un dígito, varios dígitos y ceros internos.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 7 — Sumar dígitos");
        System.out.println("Suma de dígitos de 8: " + sumar(8));
        System.out.println("Suma de dígitos de 48321: " + sumar(48321));
        System.out.println("Suma de dígitos de 40506: " + sumar(40506));
        try {
            sumar(0);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
        try {
            sumar(-24);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
