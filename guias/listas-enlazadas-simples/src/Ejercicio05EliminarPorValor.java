/*
Prompt inicial utilizado:
Implementá en Java 21 la clase independiente `Ejercicio05EliminarPorValor` con lista enlazada propia de enteros. Implementá boolean eliminar(int dato) que retire solo la primera aparición y retorne true, o false si falta. Contempla lista vacía, head, medio, último, duplicados y valor inexistente. Para head, avanza head; para otro nodo, el anterior debe apuntar al siguiente del eliminado. Decrementa size solo cuando elimina. Explica que Java no libera manualmente el objeto: al quedar inaccesible, el Garbage Collector podrá recuperarlo si no quedan referencias. Main demuestra cada caso con datos fijos y capturas de contenido/tamaño. No usar colecciones. Documenta recorrido O(n), espacio adicional O(1). Copia prompt íntegro al principio bajo el rótulo solicitado y consigna los ajustes reales al final.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 5. Elimina por valor solo la primera coincidencia.
 * <p>En [10,20,10], eliminar(10) deja [20,10] y size 2; el nodo se desconecta y queda
 * elegible para Garbage Collector cuando no haya otras referencias. Vacía/ausente devuelve false.
 * Tiempo O(n), espacio adicional O(1).</p>
*/
public class Ejercicio05EliminarPorValor {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int d) { dato = d; } }
    private Nodo head; private int size;
    /** Construye una lista inicialmente vacía. */
    public Ejercicio05EliminarPorValor() { }
    private void agregar(int d) { Nodo n = new Nodo(d); if (head == null) head = n; else { Nodo a = head; while (a.siguiente != null) a = a.siguiente; a.siguiente = n; } size++; }
    /** Quita la primera aparición del dato.
     * @param dato valor a quitar
     * @return true si fue eliminado
     */
    public boolean eliminar(int dato) {
        if (head == null) return false;
        if (head.dato == dato) { head = head.siguiente; size--; return true; }
        Nodo anterior = head;
        while (anterior.siguiente != null && anterior.siguiente.dato != dato) anterior = anterior.siguiente;
        if (anterior.siguiente == null) return false;
        anterior.siguiente = anterior.siguiente.siguiente; size--; return true;
    }
    private String mostrar() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.dato).append(" -> "); return s.append("null").toString(); }
    /** Prueba cabeza, medio, cola, duplicado, ausente y vacía.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        Ejercicio05EliminarPorValor l = new Ejercicio05EliminarPorValor();
        System.out.println("Ejercicio 5 — vacía: eliminar(1)=" + l.eliminar(1));
        for (int v : new int[]{10, 20, 30, 20, 40}) l.agregar(v);
        System.out.println("Inicial: " + l.mostrar() + ", size=" + l.size);
        for (int v : new int[]{10, 30, 40, 20, 99}) System.out.println("eliminar(" + v + ")=" + l.eliminar(v) + " → " + l.mostrar() + ", size=" + l.size);
    }
}
