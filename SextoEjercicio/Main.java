package SextoEjercicio;

import java.util.Arrays;
import java.util.Random;

/**
 * Comparacion de igualdad entre dos vectores de numeros enteros.
 *
 * <p>Este programa genera automaticamente dos vectores de 10 numeros enteros
 * con valores aleatorios entre 1 y 20, y determina si son iguales, es decir,
 * si contienen los mismos elementos en las mismas posiciones.</p>
 *
 * <p>El algoritmo compara ambos vectores posicion por posicion. Si en alguna
 * posicion los elementos difieren, el algoritmo finaliza inmediatamente
 * indicando que los vectores no son iguales. Esta finalizacion anticipada
 * permite obtener el mejor caso en O(1) cuando la diferencia esta en la
 * primera posicion.</p>
 *
 * <p>El segundo vector se genera como una copia del primero con una posicion
 * modificada aleatoriamente para garantizar que exista al menos un caso
 * observable de diferencia.</p>
 *
 * <p>Mejor caso: O(1) cuando la diferencia esta en la primera posicion.
 * Caso promedio: O(n) porque la diferencia puede estar en cualquier posicion.
 * Peor caso: O(n) cuando los vectores son completamente iguales.
 * Espacio adicional: O(1) porque solo se utilizan variables auxiliares.</p>
 */
public class Main {
    private static final int CANTIDAD_ELEMENTOS = 10;
    private static final int VALOR_MINIMO = 1;
    private static final int VALOR_MAXIMO = 20;

    /**
     * Genera los dos vectores, ejecuta la comparacion y muestra el analisis
     * de complejidad.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] vector1 = generarVector();
        int[] vector2 = generarCopiaModificada(vector1);

        System.out.println("Vector 1: " + Arrays.toString(vector1));
        System.out.println("Vector 2: " + Arrays.toString(vector2));
        System.out.println();

        int posicionDiferencia = buscarPrimeraDiferencia(vector1, vector2);

        if (posicionDiferencia >= 0) {
            System.out.println("Los vectores NO son iguales.");
            System.out.println("Diferencia encontrada en la posicion "
                    + posicionDiferencia + ": vector1="
                    + vector1[posicionDiferencia] + ", vector2="
                    + vector2[posicionDiferencia]);
        } else {
            System.out.println("Los vectores son iguales.");
            System.out.println("No se encontraron diferencias en ninguna"
                    + " posicion.");
        }

        System.out.println("\n--- Complejidad ---");
        System.out.println("Mejor caso:    O(1) - La diferencia esta en la"
                + " primera posicion.");
        System.out.println("Caso promedio: O(n) - La diferencia puede estar"
                + " en cualquier posicion.");
        System.out.println("Peor caso:     O(n) - Los vectores son"
                + " completamente iguales.");
        System.out.println("Espacial:      O(1) - Solo se utilizan variables"
                + " auxiliares (indice y longitudes).");
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
     * Genera una copia del vector con una posicion modificada aleatoriamente.
     *
     * <p>Este metodo garantiza que el segundo vector sea diferente al primero,
     * lo que permite observar el comportamiento de deteccion de diferencias.
     * Se selecciona una posicion aleatoria y se le asigna un valor diferente
     * al original.</p>
     *
     * @param original vector original del cual se creara la copia modificada
     * @return copia del vector con una posicion modificada
     */
    private static int[] generarCopiaModificada(int[] original) {
        Random random = new Random();
        int[] copia = Arrays.copyOf(original, original.length);

        int posicion = random.nextInt(original.length);
        int valorOriginal = original[posicion];

        int nuevoValor;
        do {
            nuevoValor = random.nextInt(VALOR_MAXIMO - VALOR_MINIMO + 1)
                    + VALOR_MINIMO;
        } while (nuevoValor == valorOriginal);

        copia[posicion] = nuevoValor;
        return copia;
    }

    /**
     * Busca la primera posicion donde los dos vectores difieren.
     *
     * <p>Este algoritmo compara ambos vectores simultaneamente, posicion por
     * posicion. Si en alguna posicion los elementos difieren, el algoritmo
     * finaliza inmediatamente retornando la posicion de la diferencia
     * (finalizacion anticipada).</p>
     *
     * <p>La finalizacion anticipada es posible porque la igualdad de vectores
     * requiere que todos los elementos coincidan en todas las posiciones. Si
     * un solo par de elementos difiere, la condicion de igualdad ya no se
     * cumple y no es necesario revisar el resto del vector.</p>
     *
     * <p>A diferencia del conteo de apariciones donde se debe recorrer todo
     * el vector porque pueden haber mas apariciones, aqui una sola diferencia
     * es suficiente para determinar el resultado.</p>
     *
     * <p>Mejor caso: O(1) cuando la diferencia esta en la primera posicion
     * o cuando los vectores tienen longitudes diferentes.
     * Caso promedio: O(n) porque la diferencia puede estar en cualquier
     * posicion, y en promedio se recorre la mitad del vector.
     * Peor caso: O(n) cuando los vectores son completamente iguales y se
     * debe recorrer todo el vector para confirmarlo.</p>
     *
     * <p>Espacio adicional: O(1) porque solo se utiliza una variable para
     * el indice del ciclo y las longitudes de los vectores.</p>
     *
     * @param vector1 primer vector a comparar
     * @param vector2 segundo vector a comparar
     * @return la posicion de la primera diferencia, o -1 si los vectores
     *         son iguales
     */
    private static int buscarPrimeraDiferencia(int[] vector1, int[] vector2) {
        int longitud = vector1.length;

        for (int indice = 0; indice < longitud; indice++) {
            if (vector1[indice] != vector2[indice]) {
                return indice;
            }
        }

        return -1;
    }
}
