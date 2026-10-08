/*
Prompt inicial utilizado:
Implementá en Java 21 una clase independiente `Ejercicio09ColaDeImpresion` con record `TrabajoImpresion(nombreArchivo, paginas, usuario)` y cola FIFO enlazada propia. Mantén nodos con referencias y `head`/`tail`; los datos del trabajo permanecen juntos. Implementa agregar/enqueue, imprimir próximo/dequeue, consultar próximo archivo y mostrar pendientes. Exige páginas > 0, rechazando con `IllegalArgumentException` claro cualquier trabajo con páginas no positivas antes de encolarlo. No simules impresora ni duración. En vacío imprimir/consultar debe lanzar `IllegalStateException`. En main encola `informe.pdf` (3 páginas, Ana) y `tarea.docx` (5, Luis), consulta el siguiente, muestra cola, retira primero y vuelve a mostrar; prueba un trabajo inválido y cola vacía con excepciones capturadas. Explica FIFO y O(1) enqueue/dequeue/front, O(n) impresión, O(n) espacio. Documenta casos/Javadoc y copia el prompt íntegro al inicio junto a una nota veraz de ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 9 — Cola FIFO de impresión.
 * <p>Se encolan informe.pdf (3 páginas, Ana) y tarea.docx (5, Luis); sale primero informe.pdf.
 * El trabajo conserva nombre, páginas y usuario unidos. Páginas debe ser positivo. Operaciones
 * de extremo O(1), impresión O(n), espacio O(n).</p>
 */
public class Ejercicio09ColaDeImpresion {
    /** Trabajo completo enviado a la impresora.
     * @param nombreArchivo archivo a imprimir
     * @param paginas cantidad positiva de páginas
     * @param usuario remitente
     */
    public record TrabajoImpresion(String nombreArchivo, int paginas, String usuario) {
        /** Valida datos obligatorios.
         * @throws IllegalArgumentException si falta texto o páginas no es positiva
         */
        public TrabajoImpresion {
            if (nombreArchivo == null || nombreArchivo.isBlank() || usuario == null || usuario.isBlank()) throw new IllegalArgumentException("Nombre de archivo y usuario son obligatorios.");
            if (paginas <= 0) throw new IllegalArgumentException("La cantidad de páginas debe ser positiva.");
        }
    }
    private static final class Nodo { private final TrabajoImpresion trabajo; private Nodo siguiente; private Nodo(TrabajoImpresion t) { trabajo = t; } }
    private Nodo head, tail;
    /** Construye una cola de impresión vacía. */
    public Ejercicio09ColaDeImpresion() { }
    /** Añade un trabajo al final FIFO.
     * @param trabajo trabajo válido
     * @throws IllegalArgumentException si es null
     */
    public void agregar(TrabajoImpresion trabajo) { if (trabajo == null) throw new IllegalArgumentException("El trabajo no puede ser null."); Nodo n = new Nodo(trabajo); if (head == null) head = tail = n; else { tail.siguiente = n; tail = n; } }
    /** Retira el próximo trabajo.
     * @return trabajo procesado
     * @throws IllegalStateException si no hay trabajos
     */
    public TrabajoImpresion imprimirProximo() { validar(); TrabajoImpresion t = head.trabajo; head = head.siguiente; if (head == null) tail = null; return t; }
    /** Consulta el archivo siguiente sin retirarlo.
     * @return nombre de archivo
     * @throws IllegalStateException si está vacía
     */
    public String proximoArchivo() { validar(); return head.trabajo.nombreArchivo(); }
    /** Muestra trabajos pendientes desde el más antiguo.
     * @return representación de la cola
     */
    public String mostrarPendientes() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.trabajo).append(" -> "); return s.append("null").toString(); }
    private void validar() { if (head == null) throw new IllegalStateException("No hay trabajos pendientes."); }
    /** Demuestra orden de trabajos, datos inválidos y cola vacía.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 9 — impresión FIFO"); Ejercicio09ColaDeImpresion q = new Ejercicio09ColaDeImpresion();
        q.agregar(new TrabajoImpresion("informe.pdf", 3, "Ana")); q.agregar(new TrabajoImpresion("tarea.docx", 5, "Luis"));
        System.out.println("Pendientes: " + q.mostrarPendientes() + "; próximo=" + q.proximoArchivo()); System.out.println("Impreso: " + q.imprimirProximo()); System.out.println("Pendientes: " + q.mostrarPendientes());
        try { new TrabajoImpresion("vacio.pdf", 0, "Ana"); } catch (IllegalArgumentException e) { System.out.println("Trabajo inválido: " + e.getMessage()); }
        q.imprimirProximo(); try { q.proximoArchivo(); } catch (IllegalStateException e) { System.out.println("Consulta vacía: " + e.getMessage()); }
    }
}
