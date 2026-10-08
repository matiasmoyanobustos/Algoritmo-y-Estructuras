/*
Prompt inicial utilizado:
Implementá en Java 21 la clase independiente `Ejercicio07ModificarElemento` con una lista propia enlazada de enteros y método modificar(int posicion, int nuevoDato). Valida posición 0 <= posicion < size antes del recorrido y lanza IndexOutOfBoundsException sin alterar la lista si no es válida. Recorre desde head hasta el nodo, cambia solo su dato y conserva head, siguiente y size. Explica la diferencia entre modificar el dato y modificar la referencia al siguiente. Main demuestra un cambio válido y posiciones -1 y size, con estado antes/después. Sin colecciones; O(n) tiempo y O(1) espacio adicional. Documenta con Javadoc; copia este prompt exacto al comienzo y registra ajustes reales al final.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 7. Modifica el dato del nodo sin cambiar sus enlaces.
 * <p>Con [10,20,30], modificar(1,25) produce [10,25,30] y mantiene size=3. La validación
 * precede al recorrido; índices inválidos no alteran lista. Tiempo O(n), espacio adicional O(1).</p>
 */
public class Ejercicio07ModificarElemento {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public Ejercicio07ModificarElemento() { }
    private void agregar(int d) { Nodo n = new Nodo(d); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Reemplaza solo el dato almacenado en la posición.
     * @param posicion índice desde cero
     * @param nuevoDato valor nuevo
     * @throws IndexOutOfBoundsException si la posición no existe
     */
    public void modificar(int posicion, int nuevoDato) {
        if (posicion < 0 || posicion >= size) throw new IndexOutOfBoundsException("Posición " + posicion + " inválida para size=" + size + ".");
        Nodo actual = head; for (int i = 0; i < posicion; i++) actual = actual.siguiente;
        actual.dato = nuevoDato; // Cambia el contenido, no la referencia al nodo siguiente.
    }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Demuestra una modificación válida y el rechazo de índices inválidos.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        Ejercicio07ModificarElemento l = new Ejercicio07ModificarElemento(); for (int v : new int[]{10, 20, 30}) l.agregar(v);
        System.out.println("Ejercicio 7 — antes: " + l.mostrar() + ", size=" + l.size); l.modificar(1, 25);
        System.out.println("modificar(1,25): " + l.mostrar() + ", size=" + l.size);
        for (int p : new int[]{-1, l.size}) try { l.modificar(p, 99); } catch (IndexOutOfBoundsException e) { System.out.println("Rechazada: " + e.getMessage()); }
        System.out.println("Tras errores: " + l.mostrar() + ", size=" + l.size);
    }
}
