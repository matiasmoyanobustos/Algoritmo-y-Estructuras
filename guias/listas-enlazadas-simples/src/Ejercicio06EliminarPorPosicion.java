/*
Prompt inicial utilizado:
Implementá en Java 21 la clase independiente `Ejercicio06EliminarPorPosicion` con lista enlazada simple propia de enteros y método void eliminarEnPosicion(int posicion). Valida primero 0 <= posicion < size; lanza IndexOutOfBoundsException clara sin modificar si es inválida. Posición cero actualiza head; en los demás casos recorre hasta el nodo anterior y enlaza anterior.siguiente con eliminado.siguiente. Actualiza size exactamente una vez. Explica cómo se localiza el anterior y se salta el nodo. Main prueba eliminación de inicio, medio y final, e índices -1 y size inválidos, mostrando que no hay cambios tras error. Sin colecciones; O(n) tiempo, O(1) espacio adicional. Incluye Javadoc, prompt completo como comentario inicial y nota honesta de ajustes al final.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 6. Elimina un nodo por posición actualizando la referencia anterior.
 * <p>Con [10,20,30,40], eliminarEnPosicion(0) da [20,30,40]; eliminarEnPosicion(1)
 * da [20,40]; eliminarEnPosicion(1) da [20]. Índices inválidos no cambian lista ni size.
 * Tiempo O(n), espacio adicional O(1).</p>
 */
public class Ejercicio06EliminarPorPosicion {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public Ejercicio06EliminarPorPosicion() { }
    private void agregar(int d) { Nodo n = new Nodo(d); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Elimina el nodo de la posición.
     * @param posicion índice desde cero
     * @throws IndexOutOfBoundsException si no está en [0,size)
     */
    public void eliminarEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= size) throw new IndexOutOfBoundsException("Posición " + posicion + " inválida para size=" + size + ".");
        if (posicion == 0) head = head.siguiente;
        else { Nodo anterior = head; for (int i = 0; i < posicion - 1; i++) anterior = anterior.siguiente;
            Nodo eliminado = anterior.siguiente; anterior.siguiente = eliminado.siguiente;
        }
        size--;
    }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Prueba posiciones válidas e inválidas.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        Ejercicio06EliminarPorPosicion l = new Ejercicio06EliminarPorPosicion(); for (int v : new int[]{10, 20, 30, 40}) l.agregar(v);
        System.out.println("Ejercicio 6 — inicial: " + l.mostrar());
        for (int p : new int[]{0, 1, 1}) { l.eliminarEnPosicion(p); System.out.println("eliminarEnPosicion(" + p + "): " + l.mostrar() + ", size=" + l.size); }
        for (int p : new int[]{-1, l.size}) try { l.eliminarEnPosicion(p); } catch (IndexOutOfBoundsException e) { System.out.println("Rechazada: " + e.getMessage()); }
        System.out.println("Tras errores: " + l.mostrar() + ", size=" + l.size);
    }
}
