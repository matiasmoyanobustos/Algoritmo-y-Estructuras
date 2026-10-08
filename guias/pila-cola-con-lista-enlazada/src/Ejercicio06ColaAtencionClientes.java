/*
Prompt inicial utilizado:
Implementá en Java 21 una clase independiente `Ejercicio06ColaAtencionClientes` con un record/clase `Cliente` que tenga nombre, número de turno y motivo de consulta. Almacena objetos completos en una cola enlazada propia con `head` y `tail`, sin colecciones. Implementa registrar/encolar, atender/desencolar, consultar quién sigue y mostrar la fila. FIFO: el cliente que llegó primero se atiende primero. En vacío, atender y consultar lanzan `IllegalStateException`; al atender al único cliente, head y tail quedan null. En main registra Ana (turno 101, depósitos), Bruno (102, tarjeta), consulta, atiende al primero, imprime la fila, atiende al restante e intenta atender vacío. Comprueba que atributos permanecen juntos y que se conserva orden de llegada. Enqueue/dequeue/front O(1), imprimir O(n). Incluye Javadoc, sin dependencias, prompt inicial completo y nota veraz de ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 6 — Cola FIFO de atención bancaria.
 * <p>Ana turno 101 se registra antes que Bruno 102; consultar muestra Ana y atenderla conserva
 * Bruno al frente. Cada Cliente mantiene nombre, turno y motivo juntos. Operaciones de extremo O(1),
 * impresión O(n), espacio O(n). Vacío al retirar/consultar lanza IllegalStateException.</p>
 */
public class Ejercicio06ColaAtencionClientes {
    /** Datos asociados de cada cliente.
     * @param nombre nombre de la persona
     * @param turno número asignado
     * @param motivo motivo de consulta
     */
    public record Cliente(String nombre, int turno, String motivo) { }
    private static final class Nodo { private final Cliente cliente; private Nodo siguiente; private Nodo(Cliente c) { cliente = c; } }
    private Nodo head, tail; private int size;
    /** Construye una fila de atención vacía. */
    public Ejercicio06ColaAtencionClientes() { }
    /** Registra un cliente al final.
     * @param cliente cliente completo
     * @throws IllegalArgumentException si es null
     */
    public void registrar(Cliente cliente) { if (cliente == null) throw new IllegalArgumentException("El cliente no puede ser null."); Nodo n = new Nodo(cliente); if (head == null) head = tail = n; else { tail.siguiente = n; tail = n; } size++; }
    /** Atiende y retira el primero.
     * @return cliente atendido
     * @throws IllegalStateException si la fila está vacía
     */
    public Cliente atender() { validar(); Cliente c = head.cliente; head = head.siguiente; size--; if (head == null) tail = null; return c; }
    /** Consulta al próximo cliente.
     * @return cliente al frente
     * @throws IllegalStateException si la fila está vacía
     */
    public Cliente quienSigue() { validar(); return head.cliente; }
    /** Imprime la fila en orden de llegada.
     * @return cadena de clientes
     */
    public String imprimir() { StringBuilder s = new StringBuilder(); for (Nodo n = head; n != null; n = n.siguiente) s.append(n.cliente).append(" -> "); return s.append("null").toString(); }
    private void validar() { if (head == null) throw new IllegalStateException("No hay clientes en espera."); }
    /** Prueba orden, campos asociados y fila vacía.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 6 — atención bancaria"); Ejercicio06ColaAtencionClientes q = new Ejercicio06ColaAtencionClientes();
        q.registrar(new Cliente("Ana", 101, "Depósitos")); q.registrar(new Cliente("Bruno", 102, "Tarjeta"));
        System.out.println("Fila: " + q.imprimir()); System.out.println("Sigue: " + q.quienSigue()); System.out.println("Atendido: " + q.atender());
        System.out.println("Fila restante: " + q.imprimir()); System.out.println("Atendido: " + q.atender() + "; vacía=" + (q.size == 0));
        try { q.atender(); } catch (IllegalStateException e) { System.out.println("Atención vacía: " + e.getMessage()); }
        try { q.quienSigue(); } catch (IllegalStateException e) { System.out.println("Consulta vacía: " + e.getMessage()); }
    }
}
