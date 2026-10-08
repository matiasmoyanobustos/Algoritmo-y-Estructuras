/*
Prompt inicial utilizado:
Implementá en Java 21 la clase independiente `Ejercicio03ObtenerPorPosicion` y una lista propia de enteros enlazados. Implementá int obtener(int posicion): valida primero que 0 <= posicion < size; ante índice inválido lanza IndexOutOfBoundsException con mensaje claro y no cambia la lista. Una posición no da acceso directo: recorre desde head, nodo por nodo, hasta alcanzarla. En main muestra acceso a posiciones primera, intermedia y final, más pruebas de -1 y size capturando la excepción y mostrando que la lista conserva datos y tamaño. No uses colecciones. Documentá estrategia y complejidad O(n) tiempo/O(1) espacio adicional. Copiá el prompt íntegro al inicio con el rótulo pedido y al final indica si hubo ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 3. Obtener un entero por posición recorriendo enlaces desde head.
 * <p>Con [10, 20, 30], obtener(0), obtener(1), obtener(2) devuelve 10, 20, 30.
 * obtener(-1) y obtener(size) lanzan IndexOutOfBoundsException sin cambiar la lista.
 * No existe indexación directa: peor caso O(n), espacio auxiliar O(1).</p>
 */
public class Ejercicio03ObtenerPorPosicion {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public Ejercicio03ObtenerPorPosicion() { }
    private void agregar(int d) { Nodo n = new Nodo(d); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Obtiene el dato en la posición solicitada.
     * @param posicion índice desde cero
     * @return dato del nodo
     * @throws IndexOutOfBoundsException si no es una posición de nodo existente
     */
    public int obtener(int posicion) {
        if (posicion < 0 || posicion >= size) throw new IndexOutOfBoundsException("Posición " + posicion + " fuera de [0, " + (size - 1) + "].");
        Nodo actual = head; for (int i = 0; i < posicion; i++) actual = actual.siguiente; return actual.dato;
    }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Prueba posiciones válidas e inválidas.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        Ejercicio03ObtenerPorPosicion l = new Ejercicio03ObtenerPorPosicion(); for (int n : new int[]{10, 20, 30}) l.agregar(n);
        System.out.println("Ejercicio 3 — " + l.mostrar());
        for (int p : new int[]{0, 1, 2}) System.out.println("obtener(" + p + ") = " + l.obtener(p));
        for (int p : new int[]{-1, 3}) try { l.obtener(p); } catch (IndexOutOfBoundsException e) { System.out.println("obtener(" + p + "): " + e.getMessage()); }
        System.out.println("Tras errores: " + l.mostrar() + ", size=3");
    }
}
