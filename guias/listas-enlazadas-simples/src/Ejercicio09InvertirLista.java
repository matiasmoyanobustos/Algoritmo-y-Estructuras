/*
Prompt inicial utilizado:
Implementá en Java 21 la clase independiente `Ejercicio09InvertirLista` con lista enlazada propia de enteros y método invertir() in-place. Usa referencias anterior, actual y siguiente: guarda siguiente antes de cambiar actual.siguiente, invierte el enlace y avanza; al finalizar actualiza head a la nueva cabeza. Explica que si se sobrescribe el enlace antes de guardar siguiente se pierde el resto de la lista. No crees otra lista; size no cambia. Main demuestra lista vacía, un nodo y 10 -> 20 -> 30 -> 40 -> null transformándose en 40 -> 30 -> 20 -> 10 -> null. Sin colecciones; O(n) tiempo/O(1) espacio adicional. Documenta Javadoc y casos. Copia el prompt entero al inicio y declara ajustes verdaderos al final.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 9. Invierte los enlaces in-place usando anterior, actual y siguiente.
 * <p>{@code 10 -> 20 -> 30 -> 40 -> null} se vuelve
 * {@code 40 -> 30 -> 20 -> 10 -> null}; lista vacía y un nodo no cambian. Guardar siguiente
 * antes de invertir actual.siguiente evita perder el resto. size no cambia; O(n) tiempo/O(1) espacio.</p>
 */
public class Ejercicio09InvertirLista {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public Ejercicio09InvertirLista() { }
    private void agregar(int d) { Nodo n = new Nodo(d); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Invierte los enlaces sin crear otra lista.
     */
    public void invertir() {
        Nodo anterior = null, actual = head;
        while (actual != null) {
            Nodo siguiente = actual.siguiente; // Guardar el resto antes de cambiar el enlace.
            actual.siguiente = anterior;
            anterior = actual; actual = siguiente;
        }
        head = anterior;
    }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Demuestra inversión en listas vacía, un nodo y varios nodos.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        Ejercicio09InvertirLista vacia = new Ejercicio09InvertirLista(); vacia.invertir(); System.out.println("Ejercicio 9 — vacía: " + vacia.mostrar());
        Ejercicio09InvertirLista una = new Ejercicio09InvertirLista(); una.agregar(5); una.invertir(); System.out.println("Un nodo: " + una.mostrar());
        Ejercicio09InvertirLista dos = new Ejercicio09InvertirLista(); dos.agregar(10); dos.agregar(20); dos.invertir(); System.out.println("Dos nodos: " + dos.mostrar());
        Ejercicio09InvertirLista l = new Ejercicio09InvertirLista(); for (int v : new int[]{10, 20, 30, 40}) l.agregar(v);
        System.out.println("Antes: " + l.mostrar() + ", size=" + l.size); l.invertir(); System.out.println("Después: " + l.mostrar() + ", size=" + l.size);
    }
}
