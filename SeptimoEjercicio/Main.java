package SeptimoEjercicio;

import java.util.Arrays;
import java.util.Random;

/**
 * Inversion de un vector de numeros enteros utilizando dos metodos diferentes.
 *
 * <p>Este programa genera automaticamente un vector de 10 numeros enteros con
 * valores aleatorios entre 1 y 20, y lo invierte utilizando dos soluciones
 * distintas para comparar sus caracteristicas.</p>
 *
 * <p>Solucion 1 - Vector auxiliar: Crea un nuevo vector del mismo tamano y
 * copia los elementos en orden inverso. Complejidad temporal O(n), espacial
 * O(n). Conserva el vector original intacto.</p>
 *
 * <p>Solucion 2 - In-place: Modifica el vector original directamente,
 * intercambiando elementos desde los extremos hacia el centro. Complejidad
 * temporal O(n), espacial O(1). No utiliza memoria adicional significativa.</p>
 */
public class Main {
    private static final int CANTIDAD_ELEMENTOS = 10;
    private static final int VALOR_MINIMO = 1;
    private static final int VALOR_MAXIMO = 20;

    /**
     * Genera el vector, ejecuta ambas soluciones de inversion y muestra
     * la comparacion entre ellas.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] vectorOriginal = generarVector();

        System.out.println("Vector original: "
                + Arrays.toString(vectorOriginal));

        System.out.println("\n--- Solucion 1: Vector auxiliar ---");
        int[] vectorCopia = Arrays.copyOf(vectorOriginal,
                vectorOriginal.length);
        int[] invertidoAuxiliar = invertirConAuxiliar(vectorCopia);
        System.out.println("Vector invertido: "
                + Arrays.toString(invertidoAuxiliar));

        System.out.println("\n--- Solucion 2: In-place"
                + " (intercambio desde extremos) ---");
        int[] vectorParaInPlace = Arrays.copyOf(vectorOriginal,
                vectorOriginal.length);
        invertirInPlace(vectorParaInPlace);
        System.out.println("Vector invertido: "
                + Arrays.toString(vectorParaInPlace));

        System.out.println("\n--- Comparacion de soluciones ---");
        System.out.println("Vector auxiliar:");
        System.out.println("  Temporal: O(n) | Espacial: O(n)");
        System.out.println("  Ventaja: Conserva el vector original intacto.");
        System.out.println("  Desventaja: Utiliza el doble de memoria.");

        System.out.println("\nIn-place:");
        System.out.println("  Temporal: O(n) | Espacial: O(1)");
        System.out.println("  Ventaja: No utiliza memoria adicional"
                + " significativa.");
        System.out.println("  Desventaja: Modifica el vector original"
                + " (se pierde el orden original).");
    }

    /**
     * Genera un vector con valores enteros aleatorios.
     *
     * <p>El vector contiene 10 elementos con valores entre 1 y 20.</p>
     *
     * @return vector generado con valores entre VALOR_MINIMO y VALOR_MAXIMO
     */
    private static int[] generarVector() {
        Random random = new Random();
        int[] vector = new int[CANTIDAD_ELEMENTOS];
        for (int indice = 0; indice < vector.length; indice++) {
            vector[indice] = random.nextInt(VALOR_MAXIMO - VALOR_MINIMO + 1)
                    + VALOR_MINIMO;
        }
        return vector;
    }

    /**
     * Invierte un vector utilizando un vector auxiliar.
     *
     * <p>Este metodo crea un nuevo vector del mismo tamano que el original
     * y copia los elementos en orden inverso. El primer elemento del original
     * queda en la ultima posicion del auxiliar, y asi sucesivamente.</p>
     *
     * <p>El vector original no se modifica. Se retorna un nuevo vector con
     * los elementos en orden inverso.</p>
     *
     * <p>Complejidad temporal: O(n), porque se recorre el vector original
     * una sola vez realizando una copia de cada elemento.</p>
     *
     * <p>Complejidad espacial: O(n), porque se crea un nuevo vector del
     * mismo tamano que el original.</p>
     *
     * <p>Cuando usar este enfoque: cuando se necesita conservar el vector
     * original intacto, cuando se requiere tener tanto el original como el
     * invertido simultaneamente, o cuando la memoria disponible es
     * suficiente para contener ambas copias.</p>
     *
     * @param vector vector que se desea invertir
     * @return nuevo vector con los elementos en orden inverso
     */
    private static int[] invertirConAuxiliar(int[] vector) {
        int n = vector.length;
        int[] auxiliar = new int[n];

        for (int i = 0; i < n; i++) {
            auxiliar[n - 1 - i] = vector[i];
        }

        return auxiliar;
    }

    /**
     * Invierte un vector modificandolo in-place (sin memoria adicional).
     *
     * <p>Este metodo modifica el vector original directamente, intercambiando
     * los elementos desde los extremos hacia el centro. Se intercambia el
     * elemento de la posicion inicio con el de la posicion fin, avanzando
     * hacia el centro hasta que los indices se crucen.</p>
     *
     * <p>El vector original se modifica directamente. No se crea ningun
     * vector auxiliar, solo se utiliza una variable temporal para el
     * intercambio.</p>
     *
     * <p>Complejidad temporal: O(n/2) que es O(n), porque se realizan
     * n/2 intercambios en el peor caso.</p>
     *
     * <p>Complejidad espacial: O(1), porque solo se utiliza una variable
     * temporal para el intercambio y dos variables para los indices.</p>
     *
     * <p>Cuando usar este enfoque: cuando la memoria es limitada y no se
     * puede duplicar el vector, cuando se trabaja con vectores muy grandes
     * donde la memoria es un recurso escaso, o cuando no es necesario
     * conservar el vector original.</p>
     *
     * @param vector vector que se desea invertir (se modifica in-place)
     */
    private static void invertirInPlace(int[] vector) {
        int inicio = 0;
        int fin = vector.length - 1;

        while (inicio < fin) {
            int temporal = vector[inicio];
            vector[inicio] = vector[fin];
            vector[fin] = temporal;

            inicio++;
            fin--;
        }
    }
}
