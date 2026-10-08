/* Prompt inicial utilizado: Implementá en Java 21 una clase independiente llamada `Ejercicio09Palindromo` para determinar recursivamente si una palabra o frase es palíndromo. Antes del Javadoc de la clase, incluí como comentario el texto completo de este prompt. Ignorá diferencias entre mayúsculas y minúsculas y omití espacios en blanco al comparar. Conservá la puntuación y los acentos: no los elimines ni los transformes. Compará los extremos de la porción actual; si difieren, devolvé falso; si coinciden, reducí la porción eliminando ambos extremos. Cuando queden cero o un carácter, devolvé verdadero. Rechazá `null` con un error claro y aceptá la cadena vacía. Documentá consigna, normalización exacta, reducción, parámetros, resultado, error y complejidad temporal O(n) y espacial O(n) por las llamadas recursivas. Incluí pruebas con una palabra palíndroma, una frase palíndroma con espacios y mayúsculas, una palabra no palíndroma y la cadena vacía. No elimines puntuación ni acentos para forzar un resultado. Si cambiás este prompt, agregá al final del archivo un comentario que indique el cambio y su motivo. */

/**
 * Ejercicio 9 — Palíndromo.
 * <p>Consigna: determinar recursivamente si una palabra o frase se lee igual de izquierda a derecha y de derecha a izquierda.</p>
 * <p>La comparación ignora mayúsculas/minúsculas y omite espacios en blanco, pero conserva puntuación y acentos. Se comparan los extremos; ante una diferencia se devuelve falso y, si coinciden, se reduce el intervalo hacia el centro. Cero o un carácter restante es el caso base verdadero.</p>
 * <p>Complejidad: tiempo O(n) y espacio O(n) por las llamadas recursivas, donde n es la longitud UTF-16 de la cadena.</p>
 */
public class Ejercicio09Palindromo {

    private Ejercicio09Palindromo() { }

    /**
     * Determina recursivamente si el texto es palíndromo, ignorando espacios y diferencias de mayúsculas.
     *
     * @param texto palabra o frase a comprobar; se permiten cadenas vacías
     * @return true si es palíndromo bajo las reglas de comparación, false en caso contrario
     * @throws IllegalArgumentException si texto es null
     */
    public static boolean esPalindromo(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("La cadena no puede ser null.");
        }
        return compararExtremos(texto, 0, texto.length() - 1);
    }

    /**
     * Compara recursivamente extremos de la porción activa, omitiendo espacios.
     *
     * @param texto cadena examinada
     * @param inicio índice inicial de la porción
     * @param fin índice final de la porción
     * @return true si la porción satisface la condición de palíndromo
     */
    private static boolean compararExtremos(String texto, int inicio, int fin) {
        if (inicio >= fin) {
            return true;
        }
        if (Character.isWhitespace(texto.charAt(inicio))) {
            return compararExtremos(texto, inicio + 1, fin);
        }
        if (Character.isWhitespace(texto.charAt(fin))) {
            return compararExtremos(texto, inicio, fin - 1);
        }

        char izquierda = Character.toLowerCase(texto.charAt(inicio));
        char derecha = Character.toLowerCase(texto.charAt(fin));
        if (izquierda != derecha) {
            return false;
        }

        // Los extremos coinciden; se resuelve recursivamente la parte interior.
        return compararExtremos(texto, inicio + 1, fin - 1);
    }

    /**
     * Muestra ejemplos de palíndromos y no-palíndromos con las reglas indicadas.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 9 — Palíndromo");
        System.out.println("'radar': " + esPalindromo("radar"));
        System.out.println("'Anita lava la tina': " + esPalindromo("Anita lava la tina"));
        System.out.println("'casa': " + esPalindromo("casa"));
        System.out.println("Cadena vacía: " + esPalindromo(""));
        System.out.println("'a,ba' (se conserva la coma): " + esPalindromo("a,ba"));
        try {
            esPalindromo(null);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
