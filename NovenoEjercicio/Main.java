package NovenoEjercicio;

import java.util.Random;

/**
 * Busqueda del mayor elemento de una matriz de numeros enteros.
 *
 * <p>Este programa genera automaticamente una matriz de 4 filas y 5 columnas
 * con valores aleatorios entre 1 y 100, y encuentra el mayor elemento
 * utilizando dos ciclos anidados.</p>
 *
 * <p>El algoritmo recorre la matriz completa fila por fila, comparando cada
 * elemento con el maximo actual. Si el elemento actual es mayor, se actualiza
 * el maximo y se registra su posicion.</p>
 *
 * <p>El recorrido completo es necesario porque el mayor elemento puede estar
 * en cualquier posicion de la matriz. No hay un orden predefinido que permita
 * descartar regiones.</p>
 *
 * <p>Complejidad temporal: O(f * c) donde f es la cantidad de filas y c la
 * cantidad de columnas, porque siempre se deben recorrer todos los elementos.</p>
 *
 * <p>Complejidad espacial: O(1), porque solo se utilizan variables auxiliares
 * para el maximo, su posicion y los indices de los ciclos.</p>
 */
public class Main {
    private static final int CANTIDAD_FILAS = 4;
    private static final int CANTIDAD_COLUMNAS = 5;
    private static final int VALOR_MINIMO = 1;
    private static final int VALOR_MAXIMO = 100;

    /**
     * Genera la matriz, encuentra el mayor elemento y muestra la justificacion
     * y el analisis de complejidad.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[][] matriz = generarMatriz();

        System.out.println("Matriz generada:");
        mostrarMatriz(matriz);

        int[] resultado = encontrarMaximo(matriz);
        int maximo = resultado[0];
        int filaMaxima = resultado[1];
        int columnaMaxima = resultado[2];

        System.out.println("\nMayor elemento: " + maximo);
        System.out.println("Posicion: fila " + filaMaxima + ", columna "
                + columnaMaxima);

        System.out.println("\n--- Justificacion del recorrido completo ---");
        System.out.println("El mayor elemento puede estar en cualquier"
                + " posicion de la matriz. No hay");
        System.out.println("forma de determinar cual es el maximo sin"
                + " examinar cada elemento. A diferencia");
        System.out.println("de un vector ordenado, la matriz no tiene un"
                + " orden predefinido que permita");
        System.out.println("descartar regiones. Por eso es necesario"
                + " recorrer todos los elementos en");
        System.out.println("una sola pasada.");

        System.out.println("\n--- Complejidad ---");
        System.out.println("Temporal: O(f * c) - Se recorre la matriz"
                + " completa fila por fila.");
        System.out.println("Espacial: O(1) - Solo se utilizan variables"
                + " auxiliares (maximo, posicion e indices).");
    }

    /**
     * Genera una matriz con valores enteros aleatorios.
     *
     * <p>La matriz tiene 4 filas y 5 columnas, con valores entre 1 y 100.</p>
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
     * Encuentra el mayor elemento de la matriz y su posicion.
     *
     * <p>Este metodo recorre la matriz completa utilizando dos ciclos
     * anidados. El ciclo externo recorre las filas desde 0 hasta
     * filas-1. El ciclo interno recorre las columnas desde 0 hasta
     * columnas-1. Se inicializa el maximo con el primer elemento
     * matriz[0][0] y su posicion en [0][0]. En cada posicion, se
     * compara el elemento actual con el maximo. Si es mayor, se
     * actualiza el maximo y se registra la nueva posicion.</p>
     *
     * <p>El recorrido completo es necesario porque el mayor elemento
     * puede estar en cualquier posicion de la matriz. No hay un orden
     * predefinido que permita descartar regiones. A diferencia de un
     * vector ordenado donde el maximo se accede en O(1), aqui es
     * necesario examinar cada posicion.</p>
     *
     * <p>Complejidad temporal: O(f * c) donde f es la cantidad de filas
     * y c la cantidad de columnas, porque siempre se deben recorrer
     * todos los elementos.</p>
     *
     * <p>Complejidad espacial: O(1), porque solo se utilizan variables
     * auxiliares para el maximo, su posicion y los indices de los ciclos.</p>
     *
     * @param matriz matriz donde se buscara el mayor elemento
     * @return arreglo de tres posiciones: [maximo, filaMaxima, columnaMaxima]
     */
    private static int[] encontrarMaximo(int[][] matriz) {
        int maximo = matriz[0][0];
        int filaMaxima = 0;
        int columnaMaxima = 0;

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] > maximo) {
                    maximo = matriz[fila][columna];
                    filaMaxima = fila;
                    columnaMaxima = columna;
                }
            }
        }

        return new int[]{maximo, filaMaxima, columnaMaxima};
    }
}
