/*
Prompt inicial utilizado:
Implementá en Java 21 la clase independiente `Ejercicio08ContarOcurrencias` con lista enlazada simple propia de enteros y método int contarOcurrencias(int dato). Recorre desde head hasta null y suma cada coincidencia; no cortes al encontrar la primera, pues se necesita el total. Usa en main la secuencia 10 -> 20 -> 10 -> 30 -> 10 y comprueba que contar 10 devuelve 3; también prueba valor ausente y lista vacía. No uses colecciones. Explica recorrido completo, casos y complejidad O(n) tiempo/O(1) espacio adicional en Javadoc. Copia el prompt íntegro al comienzo y añade al final la nota real de ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 8. Cuenta todas las apariciones de un entero.
 * <p>En {@code 10 -> 20 -> 10 -> 30 -> 10 -> null}, contar 10 devuelve 3; contar 99 y
 * contar en lista vacía devuelven 0. No se detiene en la primera coincidencia. Tiempo O(n),
 * espacio adicional O(1).</p>
 */
public class Ejercicio08ContarOcurrencias {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public Ejercicio08ContarOcurrencias() { }
    private void agregar(int d) { Nodo n = new Nodo(d); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Cuenta todas las coincidencias recorriendo la lista completa.
     * @param dato valor que se contará
     * @return número de apariciones
     */
    public int contarOcurrencias(int dato) { int cuenta = 0; for (Nodo n = head; n != null; n = n.siguiente) if (n.dato == dato) cuenta++; return cuenta; }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Ejecuta conteo para repetidos, ausentes y lista vacía.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        Ejercicio08ContarOcurrencias l = new Ejercicio08ContarOcurrencias(); for (int v : new int[]{10, 20, 10, 30, 10}) l.agregar(v);
        System.out.println("Ejercicio 8 — " + l.mostrar() + ", size=" + l.size); System.out.println("contarOcurrencias(10) = " + l.contarOcurrencias(10));
        System.out.println("contarOcurrencias(99) = " + l.contarOcurrencias(99));
        System.out.println("En lista vacía: " + new Ejercicio08ContarOcurrencias().contarOcurrencias(10));
    }
}
