package OctavoEjercicio;

import java.util.Random;

/**
 * Suma de todos los elementos de una matriz de numeros enteros.
 *
 * <p>Este programa genera automaticamente una matriz de 4 filas y 5 columnas
 * con valores aleatorios entre 1 y 50, y calcula la suma de todos sus
 * elementos utilizando dos ciclos anidados.</p>
 *
 * <p>El algoritmo recorre la matriz fila por fila, de izquierda a derecha,
 * acumulando cada elemento en una variable suma. Simultaneamente, contabiliza
 * la cantidad de operaciones de suma realizadas.</p>
 *
 * <p>Complejidad temporal: O(f * c) donde f es la cantidad de filas y c la
 * cantidad de columnas, porque se realiza exactamente una operacion por
 * cada elemento de la matriz.</p>
 *
 * <p>Complejidad espacial: O(1), porque solo se utilizan variables auxiliares
 * para la suma acumulada, el contador de operaciones y los indices de los
 * ciclos.</p>
 */
public class Main {
    private static final int CANTIDAD_FILAS = 4;
    private static final int CANTIDAD_COLUMNAS = 5;
    private static final int VALOR_MINIMO = 1;
    private static final int VALOR_MAXIMO = 50;

    /**
     * Genera la matriz, calcula la suma, cuenta las operaciones y muestra
     * el analisis de complejidad.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[][] matriz = generarMatriz();

        System.out.println("Matriz generada:");
        mostrarMatriz(matriz);

        int[] resultado = sumarMatriz(matriz);
        int sumaTotal = resultado[0];
        int operaciones = resultado[1];

        System.out.println("\nSuma total de todos los elementos: "
                + sumaTotal);
        System.out.println("Operaciones de suma realizadas: "
                + operaciones);

        System.out.println("\n--- Complejidad ---");
        System.out.println("Temporal: O(f * c) - Se recorre la matriz"
                + " completa fila por fila.");
        System.out.println("Espacial: O(1) - Solo se utilizan variables"
                + " auxiliares (suma, contador e indices).");
    }

    /**
     * Genera una matriz con valores enteros aleatorios.
     *
     * <p>La matriz tiene 4 filas y 5 columnas, con valores entre 1 y 50.</p>
     *
     * @return matriz generada con valores entre VALOR_MINIMO y VALOR_MAXIMO
     */
    private static int[][] generarMatriz() {
        Random random = new Random();
        int[][] matriz = new int[CANTIDAD_FILAS][CANTIDAD_COLUMNAS];

        for (int fila = 0; fila < CANTIDAD_FILAS; fila++) {
            for (int columna = 0; columna < CANTIDAD_COLUMNAS; columna++) {
                matriz[fila][columna] = random.nextInt(
                        VALOR_MAXIMO - VALOR_MINIMO + 1) + VALOR_MINIMO;
            }
        }

        return matriz;
    }

    /**
     * Muestra la matriz formateada en la salida.
     *
     * <p>Cada fila se imprime en una linea, con los elementos alineados
     * entre corchetes.</p>
     *
     * @param matriz matriz que se desea mostrar
     */
    private static void mostrarMatriz(int[][] matriz) {
        for (int fila = 0; fila < matriz.length; fila++) {
            System.out.print("[");
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                System.out.printf("%3d", matriz[fila][columna]);
                if (columna < matriz[fila].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    /**
     * Calcula la suma de todos los elementos de la matriz y cuenta
     * las operaciones realizadas.
     *
     * <p>Este metodo recorre la matriz completa utilizando dos ciclos
     * anidados. El ciclo externo recorre las filas desde 0 hasta
     * filas-1. El ciclo interno recorre las columnas desde 0 hasta
     * columnas-1. En cada posicion, suma el elemento actual a la
     * variable acumuladora sumaTotal.</p>
     *
     * <p>Cada vez que se ejecuta la operacion de suma, se incrementa
     * un contador de operaciones. La cantidad final de operaciones
     * siempre es igual a filas * columnas.</p>
     *
     * <p>El recorrido completo es necesario porque la suma total
     * requiere visitar cada posicion de la matriz. No hay acceso
     * directo al resultado sin recorrer los datos. El orden de
     * recorrido fila por fila es natural y consistente con la forma
     * en que se almacenan las matrices en memoria.</p>
     *
     * <p>Complejidad temporal: O(f * c) donde f es la cantidad de filas
     * y c la cantidad de columnas, porque se realiza exactamente una
     * operacion por cada elemento de la matriz.</p>
     *
     * <p>Complejidad espacial: O(1), porque solo se utilizan variables
     * auxiliares para la suma acumulada, el contador de operaciones
     * y los indices de los ciclos.</p>
     *
     * @param matriz matriz de la cual se calculara la suma
     * @return arreglo de dos posiciones: [sumaTotal, operacionesRealizadas]
     */
    private static int[] sumarMatriz(int[][] matriz) {
        int sumaTotal = 0;
        int operaciones = 0;

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                sumaTotal += matriz[fila][columna];
                operaciones++;
            }
        }

        return new int[]{sumaTotal, operaciones};
    }
}
