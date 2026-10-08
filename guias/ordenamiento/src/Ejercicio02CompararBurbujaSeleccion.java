import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 2 — Comparar Bubble Sort y Selection Sort.
 * <p>Ambos ordenan ascendentemente y cuentan comparaciones entre valores e intercambios reales.
 * Bubble compara vecinos; Selection busca el menor del segmento restante. Tiempo O(n²) y espacio
 * adicional O(1) para cada uno. La entrada son enteros por consola; la salida incluye resultados y métricas.</p>
 */
public class Ejercicio02CompararBurbujaSeleccion {
    /** Métricas de un ordenamiento.
     * @param comparaciones comparaciones de valores
     * @param intercambios intercambios que cambiaron dos posiciones
     */
    public record Estadisticas(long comparaciones, long intercambios) { }

    private Ejercicio02CompararBurbujaSeleccion() { }

    /** Ordena el arreglo recibido con Bubble Sort.
     * @param arreglo arreglo a modificar; no puede ser null
     * @return cantidad de comparaciones e intercambios
     * @throws IllegalArgumentException si arreglo es null
     */
    public static Estadisticas bubbleSort(int[] arreglo) {
        validar(arreglo);
        long comparaciones = 0, intercambios = 0;
        for (int fin = arreglo.length - 1; fin > 0; fin--) {
            for (int i = 0; i < fin; i++) {
                comparaciones++;
                if (arreglo[i] > arreglo[i + 1]) {
                    intercambiar(arreglo, i, i + 1);
                    intercambios++;
                }
            }
        }
        return new Estadisticas(comparaciones, intercambios);
    }

    /** Ordena el arreglo recibido con Selection Sort.
     * @param arreglo arreglo a modificar; no puede ser null
     * @return cantidad de comparaciones e intercambios reales
     * @throws IllegalArgumentException si arreglo es null
     */
    public static Estadisticas selectionSort(int[] arreglo) {
        validar(arreglo);
        long comparaciones = 0, intercambios = 0;
        for (int inicio = 0; inicio < arreglo.length - 1; inicio++) {
            int indiceMenor = inicio;
            for (int i = inicio + 1; i < arreglo.length; i++) {
                comparaciones++;
                if (arreglo[i] < arreglo[indiceMenor]) indiceMenor = i;
            }
            if (indiceMenor != inicio) {
                intercambiar(arreglo, inicio, indiceMenor);
                intercambios++;
            }
        }
        return new Estadisticas(comparaciones, intercambios);
    }

    private static void validar(int[] arreglo) {
        if (arreglo == null) throw new IllegalArgumentException("El arreglo no puede ser null.");
    }

    private static void intercambiar(int[] arreglo, int a, int b) {
        int temporal = arreglo[a]; arreglo[a] = arreglo[b]; arreglo[b] = temporal;
    }

    /** Lee la entrada y compara ambos algoritmos sobre copias idénticas.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Cantidad de enteros: ");
            int n = entrada.nextInt();
            if (n < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa.");
            int[] original = new int[n];
            for (int i = 0; i < n; i++) { System.out.print("Valor " + (i + 1) + ": "); original[i] = entrada.nextInt(); }
            int[] burbuja = original.clone(), seleccion = original.clone();
            Estadisticas eBurbuja = bubbleSort(burbuja), eSeleccion = selectionSort(seleccion);
            System.out.println("Original: " + Arrays.toString(original));
            System.out.println("Bubble Sort: " + Arrays.toString(burbuja) + " | comparaciones=" + eBurbuja.comparaciones() + ", intercambios=" + eBurbuja.intercambios());
            System.out.println("Selection Sort: " + Arrays.toString(seleccion) + " | comparaciones=" + eSeleccion.comparaciones() + ", intercambios=" + eSeleccion.intercambios());
        } catch (java.util.InputMismatchException error) {
            System.out.println("Entrada inválida: ingresá únicamente números enteros.");
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
