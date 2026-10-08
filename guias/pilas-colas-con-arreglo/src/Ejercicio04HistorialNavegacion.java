/*
Prompt inicial de OpenCode:
Implementá en Java 21 una clase independiente `Ejercicio04HistorialNavegacion` que almacene URLs en una pila de `String` con arreglo fijo y capacidad ingresada por consola. Ofrecé un menú repetible para visitar (push), volver (pop), consultar página actual (peek), mostrar las URLs almacenadas y salir. Cada visita apila la URL; volver quita la actual y deja como actual la anterior, si existe. No implementes navegación hacia adelante ni segunda pila. Explicá LIFO: la última página visitada es la primera en salir. Errores por pila llena o vacía lanzan `IllegalStateException`; capturalos en el menú y seguí sin corromper el historial. Permití capacidad cero. Incluí Javadoc con razonamiento, entradas/salidas, casos límite y O(1) por operación/O(c) espacio, más una secuencia de prueba reproducible. Copiá este prompt íntegro al inicio del fuente y registra al final si lo ajustaste o no.
*/
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 4 — Historial de navegación basado en pila LIFO.
 * <p>Una visita apila la URL y volver la desapila. Por ejemplo, visitar A y luego B deja B actual;
 * volver quita B y A vuelve a ser actual. No se implementa avanzar. Operaciones O(1), espacio O(c).</p>
 */
public class Ejercicio04HistorialNavegacion {
    private final String[] urls;
    private int top = -1;
    private Ejercicio04HistorialNavegacion(int capacidad) { urls = new String[capacidad]; }
    /** Registra una visita.
     * @param url dirección visitada
     * @throws IllegalStateException si el historial está lleno
     */
    public void visitar(String url) {
        if (top == urls.length - 1) throw new IllegalStateException("El historial está lleno.");
        urls[++top] = url;
    }
    /** Vuelve quitando la página actual.
     * @return URL que se abandonó
     * @throws IllegalStateException si no hay página actual
     */
    public String volver() {
        if (top < 0) throw new IllegalStateException("No hay página para volver.");
        String url = urls[top]; urls[top--] = null; return url;
    }
    /** Consulta la página actual.
     * @return URL actual
     * @throws IllegalStateException si el historial está vacío
     */
    public String actual() {
        if (top < 0) throw new IllegalStateException("El historial está vacío.");
        return urls[top];
    }
    private String estado() { return Arrays.toString(Arrays.copyOf(urls, top + 1)) + " (base → actual)"; }

    /** Inicia el menú del historial.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer c = leerEntero(sc, "Capacidad del historial: "); if (c == null) return;
            if (c < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            Ejercicio04HistorialNavegacion historial = new Ejercicio04HistorialNavegacion(c);
            boolean salir = false;
            while (!salir) {
                System.out.println("\n1 visitar URL | 2 volver | 3 página actual | 4 mostrar historial | 0 salir");
                Integer op = leerEntero(sc, "Opción: "); if (op == null) break;
                try {
                    switch (op) {
                        case 1 -> { System.out.print("URL: "); if (!sc.hasNextLine()) return; String url = sc.nextLine(); historial.visitar(url); System.out.println("Visitada. " + historial.estado()); }
                        case 2 -> { String anterior = historial.volver(); System.out.println("Se volvió desde " + anterior + (historial.top >= 0 ? "; página actual: " + historial.actual() : "; no quedan páginas") + "."); }
                        case 3 -> System.out.println("Página actual: " + historial.actual());
                        case 4 -> System.out.println("Historial: " + historial.estado());
                        case 0 -> salir = true;
                        default -> System.out.println("Opción inexistente.");
                    }
                } catch (IllegalStateException e) { System.out.println("Operación no realizada: " + e.getMessage()); }
            }
        }
    }
    private static Integer leerEntero(Scanner sc, String mensaje) {
        while (sc.hasNextLine()) { System.out.print(mensaje); try { return Integer.valueOf(sc.nextLine().trim()); } catch (NumberFormatException e) { System.out.println("Ingresá un entero válido."); } }
        return null;
    }
}
// Prompt sin cambios.
