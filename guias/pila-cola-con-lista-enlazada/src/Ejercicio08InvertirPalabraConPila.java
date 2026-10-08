/*
Prompt inicial utilizado:
Implementá en Java 21 una clase independiente `Ejercicio08InvertirPalabraConPila` que invierta un `String` usando una pila enlazada propia de caracteres. Apila cada carácter de izquierda a derecha y desapila para construir el resultado. Conserva mayúsculas, espacios y signos. Explica que LIFO hace salir primero el último carácter apilado. En main verifica `"algoritmo"` → `"omtirogla"`, cadena vacía, un carácter y un texto con espacios o mayúsculas. Separar método invertir de main, no usar `Stack`, colecciones ni arreglos para simular la pila. Documenta O(n) tiempo y O(n) espacio para longitud n y los casos. Incluye Javadoc y este prompt completo en comentario inicial seguido de la nota verdadera de ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 8 — Invertir palabra usando LIFO.
 * <p>Apilar de izquierda a derecha y desapilar devuelve los caracteres al revés: algoritmo →
 * omtirogla. Cadena vacía retorna vacía; una letra no cambia. Tiempo O(n), espacio O(n).</p>
 */
public class Ejercicio08InvertirPalabraConPila {
    private static final class Nodo { private final char dato; private final Nodo siguiente; private Nodo(char d, Nodo s) { dato = d; siguiente = s; } }
    private static final class PilaCaracteres {
        private Nodo top;
        private boolean isEmpty() { return top == null; }
        private void push(char c) { top = new Nodo(c, top); }
        private char pop() { if (isEmpty()) throw new IllegalStateException("La pila está vacía."); char c = top.dato; top = top.siguiente; return c; }
    }
    private Ejercicio08InvertirPalabraConPila() { }
    /** Invierte los caracteres usando una pila enlazada.
     * @param texto texto a invertir
     * @return caracteres en orden inverso
     * @throws IllegalArgumentException si texto es null
     */
    public static String invertir(String texto) {
        if (texto == null) throw new IllegalArgumentException("El texto no puede ser null.");
        PilaCaracteres pila = new PilaCaracteres(); for (int i = 0; i < texto.length(); i++) pila.push(texto.charAt(i));
        StringBuilder resultado = new StringBuilder(); while (!pila.isEmpty()) resultado.append(pila.pop()); return resultado.toString();
    }
    /** Demuestra palabra del enunciado y casos límite.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 8 — invertir con pila");
        for (String texto : new String[]{"algoritmo", "", "A", "Hola Mundo"}) System.out.println("\"" + texto + "\" → \"" + invertir(texto) + "\"");
    }
}
