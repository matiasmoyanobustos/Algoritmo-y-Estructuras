/*
Prompt inicial utilizado:
Implementá en Java 21 una clase independiente `Ejercicio10ListaDoblementeEnlazadaGenerica` con `ListaDoblementeEnlazada<T>` y `Nodo<T>`. Cada nodo mantiene `anterior` y `siguiente`; la lista mantiene `head`, `tail` y `size`. Implementa insertar al inicio, insertar al final, eliminar la primera coincidencia por igualdad con `Objects.equals` (devuelve boolean), imprimir hacia adelante desde head e imprimir hacia atrás desde tail. Explica ambos enlaces y casos de eliminación: cabeza, cola, nodo intermedio, elemento único y dato ausente. Mantén invariantes: head.anterior null y tail.siguiente null; vacía implica head y tail null; al eliminar el único nodo actualiza ambos. Complejidad inserción en extremos O(1), eliminación por valor O(n), recorridos O(n), espacio O(n). En main prueba vacía, insertar Integer y String en instancias genéricas separadas, recorrido en ambas direcciones, eliminar inicio/medio/final, ausente y último nodo. No uses colecciones. Incluye Javadoc y este prompt íntegro en un comentario inicial seguido por la nota real de ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
import java.util.Objects;

/**
 * Ejercicio 10 — Lista doblemente enlazada genérica.
 * <p>Cada nodo enlaza al anterior y al siguiente; head/tail permiten recorridos en ambos sentidos.
 * Se demuestra con Integer y String.
 * Se prueban eliminaciones en extremos, medio, único nodo y dato ausente. Insertar en extremos
 * O(1), buscar/eliminar por dato e imprimir O(n), espacio O(n).</p>
 */
public class Ejercicio10ListaDoblementeEnlazadaGenerica {
    /** Nodo genérico con referencias bidireccionales.
     * @param <T> tipo del dato
     */
    public static final class Nodo<T> {
        private final T dato; private Nodo<T> anterior, siguiente;
        private Nodo(T dato) { this.dato = dato; }
    }
    /** Lista doblemente enlazada genérica.
     * @param <T> tipo almacenado
     */
    public static final class ListaDoblementeEnlazada<T> {
        private Nodo<T> head, tail; private int size;
        /** Construye una lista doblemente enlazada vacía. */
        public ListaDoblementeEnlazada() { }
        /** Inserta un valor como primer nodo.
         * @param dato elemento nuevo
         */
        public void insertarAlInicio(T dato) {
            Nodo<T> n = new Nodo<>(dato); n.siguiente = head;
            if (head == null) tail = n; else head.anterior = n;
            head = n; size++;
        }
        /** Inserta un valor como último nodo.
         * @param dato elemento nuevo
         */
        public void insertarAlFinal(T dato) {
            Nodo<T> n = new Nodo<>(dato); n.anterior = tail;
            if (tail == null) head = n; else tail.siguiente = n;
            tail = n; size++;
        }
        /** Elimina la primera coincidencia.
         * @param dato valor que se busca
         * @return true si se encontró y eliminó
         */
        public boolean eliminar(T dato) {
            Nodo<T> actual = head;
            while (actual != null && !Objects.equals(actual.dato, dato)) actual = actual.siguiente;
            if (actual == null) return false;
            if (actual.anterior == null) head = actual.siguiente; else actual.anterior.siguiente = actual.siguiente;
            if (actual.siguiente == null) tail = actual.anterior; else actual.siguiente.anterior = actual.anterior;
            size--; return true;
        }
        /** Imprime desde head hasta tail.
         * @return datos hacia adelante
         */
        public String imprimirHaciaAdelante() { StringBuilder s = new StringBuilder(); for (Nodo<T> n = head; n != null; n = n.siguiente) s.append(n.dato).append(" <-> "); return s.append("null").toString(); }
        /** Imprime desde tail hasta head.
         * @return datos hacia atrás
         */
        public String imprimirHaciaAtras() { StringBuilder s = new StringBuilder(); for (Nodo<T> n = tail; n != null; n = n.anterior) s.append(n.dato).append(" <-> "); return s.append("null").toString(); }
        /** Indica si la lista está vacía.
         * @return true si ambos extremos están vacíos
         */
        public boolean isEmpty() { return head == null; }
        /** Devuelve el número de nodos.
         * @return tamaño actual
         */
        public int size() { return size; }
    }
    private Ejercicio10ListaDoblementeEnlazadaGenerica() { }

    /** Demuestra recorridos y eliminación de todos los casos estructurales.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 10 — lista doblemente enlazada");
        ListaDoblementeEnlazada<Integer> l = new ListaDoblementeEnlazada<>();
        System.out.println("Vacía: " + l.isEmpty() + ", adelante=" + l.imprimirHaciaAdelante() + ", atrás=" + l.imprimirHaciaAtras());
        l.insertarAlFinal(20); System.out.println("Único: " + l.imprimirHaciaAdelante() + "; eliminar único=" + l.eliminar(20) + ", vacía=" + l.isEmpty());
        l.insertarAlInicio(20); l.insertarAlInicio(10); l.insertarAlFinal(30); l.insertarAlFinal(40);
        System.out.println("Lista: " + l.imprimirHaciaAdelante()); System.out.println("Reversa: " + l.imprimirHaciaAtras());
        System.out.println("Eliminar cabeza 10=" + l.eliminar(10) + ": " + l.imprimirHaciaAdelante());
        System.out.println("Eliminar medio 30=" + l.eliminar(30) + ": " + l.imprimirHaciaAdelante());
        System.out.println("Eliminar cola 40=" + l.eliminar(40) + ": " + l.imprimirHaciaAdelante());
        System.out.println("Eliminar ausente 99=" + l.eliminar(99) + "; size=" + l.size());
        System.out.println("Eliminar último nodo 20=" + l.eliminar(20) + "; vacía=" + l.isEmpty() + ", size=" + l.size());
        ListaDoblementeEnlazada<String> nombres = new ListaDoblementeEnlazada<>(); nombres.insertarAlInicio("Ana"); nombres.insertarAlFinal("Luis");
        System.out.println("String adelante: " + nombres.imprimirHaciaAdelante() + "; atrás: " + nombres.imprimirHaciaAtras());
    }
}
