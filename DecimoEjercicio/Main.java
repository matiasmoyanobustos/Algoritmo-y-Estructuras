package DecimoEjercicio;

import java.util.Random;

/**
 * Algoritmo de ordenamiento Bubble Sort para un vector de numeros enteros.
 *
 * <p>Este programa genera automaticamente un vector de 10 numeros enteros
 * con valores aleatorios entre 1 y 50, y lo ordena de menor a mayor
 * utilizando el algoritmo Bubble Sort.</p>
 *
 * <p>Bubble Sort compara elementos adyacentes y los intercambia si estan
 * en el orden incorrecto. Utiliza una optimizacion con bandera que permite
 * finalizar anticipadamente si no hay intercambios en una pasada.</p>
 *
 * <p>Bubble Sort es adecuado para fines didacticos porque es facil de
 * entender e implementar. Sin embargo, su complejidad O(n^2) lo hace
 * ineficiente para grandes volumenes de datos.</p>
 *
 * <p>Mejor caso: O(n) cuando el vector ya esta ordenado (con optimizacion).
 * Caso promedio: O(n^2) con muchas comparaciones e intercambios.
 * Peor caso: O(n^2) cuando el vector esta ordenado en sentido inverso.
 * Espacio adicional: O(1) porque el ordenamiento es in-place.</p>
 */
public class Main {
    private static final int CANTIDAD_ELEMENTOS = 10;
    private static final int VALOR_MINIMO = 1;
    private static final int VALOR_MAXIMO = 50;

    /**
     * Genera el vector, lo ordena con Bubble Sort y muestra las estadisticas
     * y el analisis de complejidad.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] vector = generarVector();

        System.out.println("Vector original:");
        mostrarVector(vector);

        int comparaciones = 0;
        int intercambios = 0;

        int n = vector.length;
        for (int limite = n - 1; limite > 0; limite--) {
            boolean huboIntercambio = false;

            for (int j = 0; j < limite; j++) {
                comparaciones++;

                if (vector[j] > vector[j + 1]) {
                    int temporal = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temporal;

                    intercambios++;
                    huboIntercambio = true;
                }
            }

            if (!huboIntercambio) {
                break;
            }
        }

        System.out.println("\nVector ordenado:");
        mostrarVector(vector);

        System.out.println("\nEstadisticas:");
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Intercambios: " + intercambios);

        System.out.println("\n--- Justificacion ---");
        System.out.println("Bubble Sort es adecuado para fines didacticos"
                + " porque es facil de entender");
        System.out.println("e implementar. Sin embargo, su complejidad"
                + " O(n^2) lo hace ineficiente para");
        System.out.println("grandes volumenes de datos. Para vectores de"
                + " mas de 1000 elementos, se");
        System.out.println("recomienda usar algoritmos como Quick Sort o"
                + " Merge Sort con complejidad");
        System.out.println("O(n log n).");

        System.out.println("\n--- Complejidad ---");
        System.out.println("Mejor caso:    O(n)   - Vector ya ordenado"
                + " (con optimizacion).");
        System.out.println("Caso promedio: O(n^2) - Muchas comparaciones"
                + " e intercambios.");
        System.out.println("Peor caso:     O(n^2) - Vector ordenado en"
                + " sentido inverso.");
        System.out.println("Espacial:      O(1)   - Ordenamiento in-place"
                + " sin estructuras auxiliares.");
    }

    /**
     * Genera un vector con valores enteros aleatorios.
     *
     * <p>El vector contiene 10 elementos con valores entre 1 y 50.</p>
     *
     * @return vector generado con valores entre VALOR_MINIMO y VALOR_MAXIMO
     */
    private static int[] generarVector() {
        Random random = new Random();
        int[] vector = new int[CANTIDAD_ELEMENTOS];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = random.nextInt(VALOR_MAXIMO - VALOR_MINIMO + 1)
                    + VALOR_MINIMO;
        }
        return vector;
    }

    /**
     * Muestra el vector formateado en la salida.
     *
     * <p>Los elementos se imprimen entre corchetes, separados por coma.</p>
     *
     * @param vector vector que se desea mostrar
     */
    private static void mostrarVector(int[] vector) {
        System.out.print("[");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
            if (i < vector.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
