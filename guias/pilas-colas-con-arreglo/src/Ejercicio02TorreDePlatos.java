/*
Prompt inicial de OpenCode:
Implementá en Java 21 una clase independiente `Ejercicio02TorreDePlatos` que modele una torre de platos como una pila de `String` en un arreglo fijo de capacidad ingresada por consola. Ofrecé un menú repetible para agregar un plato arriba (`push`), retirar el superior (`pop`), consultar el de arriba (`peek`), mostrar la torre y salir. Explicá que se usa pila porque los platos obedecen LIFO: el último agregado queda arriba y es el primero accesible al retirar; una cola retiraría primero el plato más antiguo. Las operaciones sobre pila llena/vacía deben lanzar `IllegalStateException`, que el menú captura para continuar sin cambiar el estado. Permití capacidad cero. Mostrá el contenido actualizado. Documentá con Javadoc entradas/salidas, decisiones, casos límite y complejidad O(1) por operación/O(c) espacio, y agregá una prueba reproducible. Copiá este prompt íntegro al comienzo del fuente y al final informa si se ajustó o no.
*/
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 2 — Simulador de torre de platos.
 * <p>Se usa una pila LIFO: al apilar Plato A y luego Plato B, B queda arriba y es el primero que
 * puede retirarse. Una cola atendería el plato más antiguo, contrario al acceso a la cima.
 * Ejemplo: capacidad 2; agregar "Llano", "Hondo"; peek muestra Hondo y pop retira Hondo.
 * Operaciones de cima O(1), espacio O(c).</p>
 */
public class Ejercicio02TorreDePlatos {
    private final String[] platos;
    private int top = -1;
    private Ejercicio02TorreDePlatos(int capacidad) { platos = new String[capacidad]; }
    /** Agrega un plato a la cima.
     * @param plato nombre del plato
     * @throws IllegalStateException si la torre está llena
     */
    public void push(String plato) {
        if (top == platos.length - 1) throw new IllegalStateException("La torre está llena.");
        platos[++top] = plato;
    }
    /** Retira el plato superior.
     * @return plato retirado
     * @throws IllegalStateException si está vacía
     */
    public String pop() {
        if (top == -1) throw new IllegalStateException("No hay platos en la torre.");
        String resultado = platos[top]; platos[top--] = null; return resultado;
    }
    /** Consulta el plato superior sin retirarlo.
     * @return plato superior
     * @throws IllegalStateException si está vacía
     */
    public String peek() {
        if (top == -1) throw new IllegalStateException("No hay platos en la torre.");
        return platos[top];
    }
    private String estado() { return Arrays.toString(Arrays.copyOf(platos, top + 1)) + " (base → cima)"; }

    /** Inicia el simulador de torre.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer c = leerEntero(sc, "Capacidad de la torre: ");
            if (c == null) return;
            if (c < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            Ejercicio02TorreDePlatos torre = new Ejercicio02TorreDePlatos(c);
            boolean salir = false;
            while (!salir) {
                System.out.println("\n1 agregar plato | 2 retirar superior | 3 consultar superior | 4 mostrar torre | 0 salir");
                Integer op = leerEntero(sc, "Opción: "); if (op == null) break;
                try {
                    switch (op) {
                        case 1 -> { System.out.print("Nombre del plato: "); if (!sc.hasNextLine()) return; String p = sc.nextLine(); torre.push(p); System.out.println("Agregado: " + p + " | " + torre.estado()); }
                        case 2 -> System.out.println("Retirado: " + torre.pop() + " | " + torre.estado());
                        case 3 -> System.out.println("Arriba está: " + torre.peek());
                        case 4 -> System.out.println("Torre: " + torre.estado());
                        case 0 -> salir = true;
                        default -> System.out.println("Opción inexistente.");
                    }
                } catch (IllegalStateException error) { System.out.println("Operación no realizada: " + error.getMessage()); }
            }
        }
    }
    private static Integer leerEntero(Scanner sc, String mensaje) {
        while (sc.hasNextLine()) { System.out.print(mensaje); try { return Integer.valueOf(sc.nextLine().trim()); } catch (NumberFormatException e) { System.out.println("Ingresá un entero válido."); } }
        return null;
    }
}
// Prompt sin cambios.
