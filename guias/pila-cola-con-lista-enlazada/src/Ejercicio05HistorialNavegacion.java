/*
Prompt inicial utilizado:
Implementá en Java 21 una clase independiente `Ejercicio05HistorialNavegacion` que modele el historial con una pila enlazada de URLs `String`, sin estructuras Java de colección. Implementá visitar (push), volver (pop), página actual (peek) e imprimir historial. La última página visitada es el tope y se retira primero al volver (LIFO); al volver dos veces retorna las páginas anteriores en orden. No agregues pila de avanzar ni lógica de navegador real. Sobre historial vacío, volver y consultar actual lanzan `IllegalStateException` clara. En main visita `https://inicio.test`, `https://busqueda.test`, `https://articulo.test`, imprime, vuelve una vez, consulta la página actual e imprime; además prueba retroceso/consulta vacíos con excepciones capturadas. Documenta operaciones O(1), impresión O(n), Javadoc y casos límite. Copia el prompt íntegro como comentario inicial y añade la nota veraz de ajustes en ese comentario.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 5 — Historial con pila enlazada.
 * <p>Visitar inicio, búsqueda y artículo deja el artículo actual; volver lo quita y revela la
 * búsqueda anterior. LIFO representa correctamente volver atrás. Visitar/volver/actual O(1),
 * imprimir O(n), almacenamiento O(n).</p>
 */
public class Ejercicio05HistorialNavegacion {
    private static final class Nodo { private final String url; private final Nodo siguiente; private Nodo(String u, Nodo s) { url = u; siguiente = s; } }
    private Nodo head;
    /** Construye un historial vacío. */
    public Ejercicio05HistorialNavegacion() { }
    /** Apila una URL visitada.
     * @param url página visitada
     */
    public void visitar(String url) { if (url == null) throw new IllegalArgumentException("La URL no puede ser null."); head = new Nodo(url, head); }
    /** Retrocede retirando la página actual.
     * @return URL retirada
     * @throws IllegalStateException si el historial está vacío
     */
    public String volver() { validar(); String url = head.url; head = head.siguiente; return url; }
    /** Consulta la página actual.
     * @return URL de la cima
     * @throws IllegalStateException si no hay páginas
     */
    public String paginaActual() { validar(); return head.url; }
    /** Imprime el historial desde actual a la más antigua.
     * @return URLs apiladas
     */
    public String imprimir() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.url).append(" -> "); return s.append("null").toString(); }
    private void validar() { if (head == null) throw new IllegalStateException("El historial está vacío."); }
    /** Prueba visitar, consultar y retroceder hasta vacío.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 5 — historial web"); Ejercicio05HistorialNavegacion h = new Ejercicio05HistorialNavegacion();
        h.visitar("https://inicio.test"); h.visitar("https://busqueda.test"); h.visitar("https://articulo.test");
        System.out.println("Historial actual→anterior: " + h.imprimir()); System.out.println("Página actual: " + h.paginaActual());
        System.out.println("Volver desde: " + h.volver() + "; ahora: " + h.paginaActual()); System.out.println("Historial: " + h.imprimir());
        h.volver(); h.volver();
        try { h.volver(); } catch (IllegalStateException e) { System.out.println("Volver sin páginas: " + e.getMessage()); }
        try { h.paginaActual(); } catch (IllegalStateException e) { System.out.println("Consultar vacío: " + e.getMessage()); }
    }
}
