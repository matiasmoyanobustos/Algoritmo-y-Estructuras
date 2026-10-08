/*
Prompt inicial de OpenCode:
Implementá en Java 21 una clase independiente `Ejercicio01PilaEnteros` con una clase `PilaEnteros` que use un `int[]` de capacidad fija ingresada por consola. Implementá `push`, `pop`, `peek`, `isEmpty`, `isFull` y `size`. Explicá que `top` es el índice del elemento superior, comienza en -1, aumenta al insertar y disminuye al quitar; el tamaño es `top + 1`. La pila es LIFO. `push` sobre llena y `pop`/`peek` sobre vacía deben lanzar `IllegalStateException` sin alterar estado. Permití capacidad cero y definí vacía y llena como verdaderas para ella. Ofrecé un menú repetible para todas las operaciones y salir; capturá errores de operación y continuá. Incluí Javadoc con complejidad O(1) por operación y O(c) espacio, ejemplo de uso y casos lleno/vacío. Copiá este prompt completo como comentario inicial y terminá el archivo indicando que no hubo cambios al prompt, salvo que realmente debas modificarlo; en ese caso explica el cambio.
*/
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 1 — Pila de enteros de capacidad fija.
 * <p>Usa un arreglo y el índice {@code top}, que vale -1 cuando está vacía. Push incrementa top;
 * pop devuelve el elemento y decrementa top. Es LIFO. Todas las operaciones son O(1), con O(c)
 * espacio para capacidad c. Ejemplo: capacidad 2, push(7), push(4), peek()=4, pop()=4, size()=1.</p>
 */
public class Ejercicio01PilaEnteros {
    /** Pila de enteros implementada con un arreglo fijo. */
    public static final class PilaEnteros {
        private final int[] elementos;
        private int top = -1;

        /** Construye una pila con capacidad fija.
         * @param capacidad cantidad máxima de elementos; debe ser no negativa
         * @throws IllegalArgumentException si capacidad es negativa
         */
        public PilaEnteros(int capacidad) {
            if (capacidad < 0) throw new IllegalArgumentException("La capacidad no puede ser negativa.");
            elementos = new int[capacidad];
        }
        /** Apila un entero.
         * @param valor valor a guardar
         * @throws IllegalStateException si la pila está llena
         */
        public void push(int valor) {
            if (isFull()) throw new IllegalStateException("La pila está llena.");
            elementos[++top] = valor;
        }
        /** Retira y devuelve el elemento superior.
         * @return elemento retirado
         * @throws IllegalStateException si está vacía
         */
        public int pop() {
            if (isEmpty()) throw new IllegalStateException("La pila está vacía.");
            return elementos[top--];
        }
        /** Consulta el elemento superior sin retirarlo.
         * @return elemento superior
         * @throws IllegalStateException si está vacía
         */
        public int peek() {
            if (isEmpty()) throw new IllegalStateException("La pila está vacía.");
            return elementos[top];
        }
        /** Indica si no contiene elementos.
         * @return true si está vacía
         */
        public boolean isEmpty() { return top == -1; }
        /** Indica si no puede aceptar más elementos.
         * @return true si está llena; también true con capacidad cero
         */
        public boolean isFull() { return top == elementos.length - 1; }
        /** Devuelve la cantidad actual de elementos.
         * @return tamaño
         */
        public int size() { return top + 1; }
        /** Devuelve la capacidad máxima.
         * @return capacidad del arreglo
         */
        public int capacity() { return elementos.length; }
        /** @return representación del segmento ocupado, desde el fondo hasta top */
        @Override public String toString() { return Arrays.toString(Arrays.copyOf(elementos, size())); }
    }

    private Ejercicio01PilaEnteros() { }

    /** Ejecuta el menú interactivo.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Integer capacidad = leerEntero(scanner, "Capacidad: ");
            if (capacidad == null) return;
            if (capacidad < 0) { System.out.println("La capacidad debe ser no negativa."); return; }
            PilaEnteros pila = new PilaEnteros(capacidad);
            boolean salir = false;
            while (!salir) {
                System.out.println("\n1 push | 2 pop | 3 peek | 4 isEmpty | 5 isFull | 6 size | 7 mostrar | 0 salir");
                Integer opcion = leerEntero(scanner, "Opción: ");
                if (opcion == null) break;
                try {
                    switch (opcion) {
                        case 1 -> { Integer valor = leerEntero(scanner, "Entero: "); if (valor == null) return; pila.push(valor); System.out.println("Apilado: " + valor); }
                        case 2 -> System.out.println("Desapilado: " + pila.pop());
                        case 3 -> System.out.println("Superior: " + pila.peek());
                        case 4 -> System.out.println("Vacía: " + pila.isEmpty());
                        case 5 -> System.out.println("Llena: " + pila.isFull());
                        case 6 -> System.out.println("Tamaño: " + pila.size());
                        case 7 -> System.out.println("Fondo → superior: " + pila);
                        case 0 -> salir = true;
                        default -> System.out.println("Opción inexistente.");
                    }
                } catch (IllegalStateException error) { System.out.println("Operación no realizada: " + error.getMessage()); }
            }
        }
    }

    private static Integer leerEntero(Scanner scanner, String mensaje) {
        while (scanner.hasNextLine()) {
            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();
            try { return Integer.valueOf(linea); }
            catch (NumberFormatException error) { System.out.println("Ingresá un número entero válido."); }
        }
        return null;
    }
}

// Prompt sin cambios.
