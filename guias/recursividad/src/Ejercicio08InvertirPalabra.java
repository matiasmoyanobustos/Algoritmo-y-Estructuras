/* Prompt inicial utilizado: Implementá en Java 21 una clase independiente llamada `Ejercicio08InvertirPalabra` que invierta recursivamente un `String`. Antes del Javadoc de la clase, incluí como comentario el texto completo de este prompt. La cadena vacía y una cadena de un carácter son casos base. Para el caso recursivo, separá el primer carácter del resto, invertí el resto recursivamente y colocá el primer carácter al final del resultado mediante concatenación. Conservá exactamente los caracteres recibidos; no normalices espacios, mayúsculas ni signos. Rechazá `null` con `IllegalArgumentException` y aceptá la cadena vacía. El método devuelve el `String` invertido. Documentá consigna, estrategia, parámetros, resultado, error, tiempo O(n²) debido a la concatenación repetida y espacio O(n) de pila, además de las cadenas temporales creadas durante la reconstrucción. Separá la demostración en `main` y probá cadena vacía, un carácter y una palabra de varios caracteres. Comentá cómo se reconstruye la respuesta al retornar. Si cambiás este prompt, agregá al final del archivo un comentario que indique el cambio y su motivo. */

/**
 * Ejercicio 8 — Invertir una palabra.
 * <p>Consigna: devolver recursivamente un String con los caracteres de la palabra en orden inverso, preservando exactamente su contenido.</p>
 * <p>La cadena vacía y la de un carácter son casos base. En otro caso se invierte recursivamente el resto y, al retornar, se agrega al final el primer carácter.</p>
 * <p>Para n caracteres, el tiempo es O(n²) por las concatenaciones sucesivas; la pila ocupa O(n). La reconstrucción también crea cadenas temporales. Una cadena extremadamente larga puede consumir demasiada pila y memoria.</p>
 */
public class Ejercicio08InvertirPalabra {

    private Ejercicio08InvertirPalabra() { }

    /**
     * Devuelve la cadena recibida con sus caracteres en orden inverso.
     *
     * @param texto cadena que se desea invertir, sin normalizar sus caracteres
     * @return cadena invertida; si texto es vacía, devuelve la cadena vacía
     * @throws IllegalArgumentException si texto es null
     */
    public static String invertir(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("La cadena no puede ser null.");
        }
        if (texto.length() <= 1) {
            return texto;
        }

        char primerCaracter = texto.charAt(0);
        String restoInvertido = invertir(texto.substring(1));
        // La llamada resuelve primero el resto; al retornar se mueve el primer carácter al final.
        return restoInvertido + primerCaracter;
    }

    /**
     * Muestra los casos de cadena vacía, un carácter y una palabra.
     *
     * @param args argumentos de línea de comandos, no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 8 — Invertir una palabra");
        System.out.println("Cadena vacía -> [" + invertir("") + "]");
        System.out.println("'A' -> " + invertir("A"));
        System.out.println("'recursion' -> " + invertir("recursion"));
        try {
            invertir(null);
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
