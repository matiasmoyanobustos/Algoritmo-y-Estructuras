/*
Prompt inicial de OpenCode:
Implementá en Java 21 una clase independiente `Ejercicio06ColaSimpleEnteros` con `ColaEnteros` basada en `int[]` lineal de capacidad fija ingresada por consola. Incluí `enqueue`, `dequeue`, `front`, `isEmpty`, `isFull` y `size`. Explicá que `front` apunta al elemento más antiguo y `rear` al último agregado; en vacío usa `front=0`, `rear=-1`, `size=0`; al primer enqueue ambos apuntan a 0. `enqueue` avanza rear y dequeue avanza front; cuando se elimina el último elemento, restaura el estado vacío. No desplaces ni reutilices huecos al inicio: esta cola simple tiene el límite que se verá en el ejercicio 9. Para espacio físico, está llena si no cabe al final del arreglo, incluso si hay huecos al inicio. Ofrecé menú repetible para todas las operaciones y salir. Lleno/vacío lanza `IllegalStateException`, capturada para continuar sin alterar estado. Capacidad cero está vacía y llena. Documentá invariantes, casos, entradas/salidas, O(1) por operación/O(c) espacio y prueba reproducible. Copiá este prompt al inicio y al final anotá cambios reales o que no hubo.
*/
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 6 — Cola lineal simple de enteros.
 * <p>front señala el más antiguo y rear el último insertado. La cola no da vuelta ni desplaza datos;
 * puede dejar huecos iniciales inutilizables hasta vaciarse por completo. Ejemplo: cap. 3, enqueue 4,
 * enqueue 8, dequeue devuelve 4, front devuelve 8. Operaciones O(1), espacio O(c).</p>
 */
public class Ejercicio06ColaSimpleEnteros {
    /** Cola simple de capacidad fija. */
    public static final class ColaEnteros {
        private final int[] datos;
        private int front = 0, rear = -1, size = 0;
        /** Construye la cola con una capacidad fija.
         * @param capacidad capacidad no negativa
         * @throws IllegalArgumentException si es negativa
         */
        public ColaEnteros(int capacidad) {
            if (capacidad < 0) throw new IllegalArgumentException("La capacidad no puede ser negativa.");
            datos = new int[capacidad];
        }
        /** Agrega al final físico.
         * @param valor entero agregado
         * @throws IllegalStateException si no hay posición disponible al final
         */
        public void enqueue(int valor) {
            if (isFull()) throw new IllegalStateException("No hay espacio al final del arreglo (cola simple).");
            if (size == 0) front = 0;
            datos[++rear] = valor; size++;
        }
        /** Retira el elemento más antiguo.
         * @return valor retirado
         * @throws IllegalStateException si está vacía
         */
        public int dequeue() {
            if (isEmpty()) throw new IllegalStateException("La cola está vacía.");
            int valor = datos[front++]; size--;
            if (size == 0) { front = 0; rear = -1; }
            return valor;
        }
        /** Consulta el valor más antiguo sin quitarlo.
         * @return elemento del frente
         * @throws IllegalStateException si está vacía
         */
        public int front() { if (isEmpty()) throw new IllegalStateException("La cola está vacía."); return datos[front]; }
        /** Indica si no hay elementos.
         * @return true si está vacía
         */
        public boolean isEmpty() { return size == 0; }
        /** Indica si no hay espacio físico al final.
         * @return true si rear llegó al último índice o la capacidad es cero
         */
        public boolean isFull() { return rear == datos.length - 1; }
        /** Devuelve la cantidad almacenada.
         * @return tamaño actual
         */
        public int size() { return size; }
        @Override public String toString() { return "front→rear " + (isEmpty() ? "[]" : Arrays.toString(Arrays.copyOfRange(datos, front, rear + 1))); }
    }
    private Ejercicio06ColaSimpleEnteros() { }
    /** Ejecuta menú para la cola lineal.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer c = leerEntero(sc, "Capacidad: "); if (c == null) return;
            if (c < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            ColaEnteros q = new ColaEnteros(c); boolean salir = false;
            while (!salir) {
                System.out.println("\n1 enqueue | 2 dequeue | 3 front | 4 isEmpty | 5 isFull | 6 size | 7 mostrar | 0 salir");
                Integer op = leerEntero(sc, "Opción: "); if (op == null) break;
                try {
                    switch (op) {
                        case 1 -> { Integer v = leerEntero(sc, "Entero: "); if (v == null) return; q.enqueue(v); System.out.println("Encolado. " + q); }
                        case 2 -> System.out.println("Retirado: " + q.dequeue() + " | " + q);
                        case 3 -> System.out.println("Frente: " + q.front());
                        case 4 -> System.out.println("Vacía: " + q.isEmpty());
                        case 5 -> System.out.println("Llena (sin espacio al final): " + q.isFull());
                        case 6 -> System.out.println("Tamaño: " + q.size());
                        case 7 -> System.out.println(q);
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
