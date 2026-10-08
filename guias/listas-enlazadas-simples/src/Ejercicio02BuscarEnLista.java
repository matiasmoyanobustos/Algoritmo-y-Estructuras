/*
Prompt inicial utilizado:
Implementá en Java 21 la clase independiente `Ejercicio02BuscarEnLista`, con Nodo y lista simple propios de enteros, sin colecciones. Implementá boolean buscar(int dato) recorriendo desde head, siguiendo siguiente hasta encontrar el valor o null. Explicá que no hay acceso directo por índice como en un arreglo y por qué la búsqueda es secuencial O(n), con espacio adicional O(1). En main carga datos definidos, prueba primer elemento, elemento posterior, ausente y lista vacía, e imprime cada resultado. Documentá Javadoc, recorrido y casos. Copiá este prompt completo al inicio bajo “Prompt inicial utilizado:” y al final agrega “Ajustes realizados luego de la primera respuesta de OpenCode:” con “No hubo ajustes” o el detalle verdadero.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 2. Búsqueda secuencial en lista enlazada propia.
 * <p>En {@code 10 -> 20 -> 30}, buscar 10 y 30 da true; buscar 8 o buscar en la
 * lista vacía da false. No hay índice de acceso directo: se siguen referencias desde head.
 * Tiempo O(n), espacio adicional O(1).</p>
 */
public class Ejercicio02BuscarEnLista {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int dato) { this.dato = dato; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public Ejercicio02BuscarEnLista() { }
    private void agregar(int dato) { Nodo n = new Nodo(dato); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Busca un valor recorriendo los enlaces desde head.
     * @param dato valor objetivo
     * @return true si se encuentra
     */
    public boolean buscar(int dato) { for (Nodo a = head; a != null; a = a.siguiente) if (a.dato == dato) return true; return false; }
    private String imprimir() { StringBuilder s = new StringBuilder(); for (Nodo a = head; a != null; a = a.siguiente) s.append(a.dato).append(" -> "); return s.append("null").toString(); }
    /** Ejecuta pruebas de búsqueda exitosas, ausentes y lista vacía.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        Ejercicio02BuscarEnLista lista = new Ejercicio02BuscarEnLista(); lista.agregar(10); lista.agregar(20); lista.agregar(30);
        System.out.println("Ejercicio 2 — Lista: " + lista.imprimir() + ", size=" + lista.size);
        System.out.println("buscar(10): " + lista.buscar(10)); System.out.println("buscar(30): " + lista.buscar(30)); System.out.println("buscar(8): " + lista.buscar(8));
        System.out.println("buscar(10) en lista vacía: " + new Ejercicio02BuscarEnLista().buscar(10));
    }
}
