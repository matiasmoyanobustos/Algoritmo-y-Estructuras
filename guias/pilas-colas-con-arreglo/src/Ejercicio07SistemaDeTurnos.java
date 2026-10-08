/*
Prompt inicial de OpenCode:
Implementá en Java 21 una clase independiente `Ejercicio07SistemaDeTurnos` que almacene nombres de personas en una cola simple `String[]` lineal de capacidad fija solicitada por consola. Incluí menú repetible para registrar persona (enqueue), atender a la siguiente (dequeue), consultar quién está primero (front), mostrar la fila y salir. Explicá FIFO: quien llegó primero debe atenderse primero; LIFO atendería a la última llegada y no respeta la espera. No asignes números de turno. Mantén `front`, `rear` y `size`; no desplaces ni reutilices huecos iniciales salvo que la cola quede vacía y reinicie índices. Si rear alcanza el final, encolar falla aunque haya huecos iniciales, tal como en una cola simple. Lleno/vacío debe producir `IllegalStateException`; el menú informa y continúa sin alterar estado. Capacidad cero válida. Incluí Javadoc, ejemplo de llegadas/atención, límites y complejidad O(1)/O(c). El prompt completo va como comentario inicial y al final registra si cambió.
*/
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 7 — Sistema de turnos FIFO.
 * <p>La primera persona que llega se atiende primero; una pila LIFO invertiría la prioridad.
 * Ejemplo: Ana, luego Luis; atender devuelve Ana y front pasa a Luis. Cola simple O(1) por
 * operación y O(c) de espacio; huecos iniciales no se reutilizan hasta vaciarla.</p>
 */
public class Ejercicio07SistemaDeTurnos {
    private final String[] fila;
    private int front = 0, rear = -1, size = 0;
    private Ejercicio07SistemaDeTurnos(int capacidad) { fila = new String[capacidad]; }
    /** Registra persona al final de la cola.
     * @param persona nombre
     * @throws IllegalStateException si no hay espacio físico al final
     */
    public void registrar(String persona) {
        if (rear == fila.length - 1) throw new IllegalStateException("La cola simple no tiene espacio al final.");
        if (size == 0) front = 0;
        fila[++rear] = persona; size++;
    }
    /** Atiende y retira a la primera persona.
     * @return persona atendida
     * @throws IllegalStateException si no hay personas esperando
     */
    public String atender() {
        if (size == 0) throw new IllegalStateException("No hay personas esperando.");
        String persona = fila[front]; fila[front++] = null; size--;
        if (size == 0) { front = 0; rear = -1; }
        return persona;
    }
    /** Consulta la primera persona sin retirarla.
     * @return nombre al frente
     * @throws IllegalStateException si la fila está vacía
     */
    public String primero() { if (size == 0) throw new IllegalStateException("No hay personas esperando."); return fila[front]; }
    private String estado() { return "Fila (primero → último): " + (size == 0 ? "[]" : Arrays.toString(Arrays.copyOfRange(fila, front, rear + 1))); }

    /** Ejecuta el menú de atención.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer c = leerEntero(sc, "Capacidad de la fila: "); if (c == null) return;
            if (c < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            Ejercicio07SistemaDeTurnos sistema = new Ejercicio07SistemaDeTurnos(c); boolean salir = false;
            while (!salir) {
                System.out.println("\n1 registrar persona | 2 atender siguiente | 3 consultar primero | 4 mostrar fila | 0 salir");
                Integer op = leerEntero(sc, "Opción: "); if (op == null) break;
                try {
                    switch (op) {
                        case 1 -> { System.out.print("Nombre: "); if (!sc.hasNextLine()) return; String p = sc.nextLine(); sistema.registrar(p); System.out.println("Registrada. " + sistema.estado()); }
                        case 2 -> System.out.println("Atendida: " + sistema.atender() + ". " + sistema.estado());
                        case 3 -> System.out.println("Primera: " + sistema.primero());
                        case 4 -> System.out.println(sistema.estado());
                        case 0 -> salir = true;
                        default -> System.out.println("Opción inexistente.");
                    }
                } catch (IllegalStateException e) { System.out.println("Operación no realizada: " + e.getMessage()); }
            }
        }
    }
    private static Integer leerEntero(Scanner sc, String m) {
        while (sc.hasNextLine()) { System.out.print(m); try { return Integer.valueOf(sc.nextLine().trim()); } catch (NumberFormatException e) { System.out.println("Ingresá un entero válido."); } }
        return null;
    }
}
// Prompt sin cambios.
