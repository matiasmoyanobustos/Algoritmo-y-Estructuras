/*
Prompt inicial utilizado:
Implementá en Java 21 la clase independiente `Ejercicio04InsertarEnPosicion` con lista enlazada simple propia de enteros. Implementá void insertarEnPosicion(int dato, int posicion), permitiendo 0 <= posicion <= size; 0 es inicio, size final e intermedios se insertan entre nodos. Valida antes de cambiar estado y lanza IndexOutOfBoundsException si es inválida. En inserción intermedia preserva el enlace en orden: nuevo.siguiente = actual.siguiente; después actual.siguiente = nuevo. Explica que alterar primero el enlace anterior sin guardar el siguiente desconecta el resto de la lista. Incrementa size una sola vez. Main demuestra insertar en lista vacía, inicio, medio, final y casos inválidos sin cambios. Sin colecciones; documenta complejidad O(n). Copiá este prompt completo al inicio y al final informa los ajustes reales o que no hubo.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 4. Inserción en una posición válida de la lista.
 * <p>Partiendo de [20, 40], insertar(10,0), insertar(30,2), insertar(50,4) produce
 * [10, 20, 30, 40, 50]. Se conserva primero el enlace siguiente del nodo actual antes de
 * conectarlo al nuevo. Índices inválidos no alteran estado. Recorrido O(n), enlace O(1).</p>
 */
public class Ejercicio04InsertarEnPosicion {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public Ejercicio04InsertarEnPosicion() { }
    /** Inserta antes de la posición especificada.
     * @param dato dato nuevo
     * @param posicion índice entre cero y size inclusive
     * @throws IndexOutOfBoundsException si posición no pertenece a [0,size]
     */
    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0 || posicion > size) throw new IndexOutOfBoundsException("Posición " + posicion + " fuera de [0, " + size + "].");
        Nodo nuevo = new Nodo(dato);
        if (posicion == 0) { nuevo.siguiente = head; head = nuevo; }
        else { Nodo actual = head; for (int i = 0; i < posicion - 1; i++) actual = actual.siguiente;
            // Primero se conserva la cadena restante; luego el anterior queda enlazado al nuevo.
            nuevo.siguiente = actual.siguiente; actual.siguiente = nuevo;
        }
        size++;
    }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Demuestra inserciones al inicio, medio, final y errores de índice.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        Ejercicio04InsertarEnPosicion l = new Ejercicio04InsertarEnPosicion(); l.insertarEnPosicion(20, 0); l.insertarEnPosicion(40, 1);
        l.insertarEnPosicion(10, 0); l.insertarEnPosicion(30, 2); l.insertarEnPosicion(50, l.size);
        System.out.println("Ejercicio 4 — " + l.mostrar() + ", size=" + l.size);
        for (int p : new int[]{-1, l.size + 1}) try { l.insertarEnPosicion(99, p); } catch (IndexOutOfBoundsException e) { System.out.println("Inserción rechazada: " + e.getMessage()); }
        System.out.println("Sin cambios: " + l.mostrar() + ", size=" + l.size);
    }
}
