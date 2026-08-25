package QuintoEjercicio;

import java.util.Arrays;
import java.util.Random;

/**
 * Conteo de apariciones de un valor en un vector de numeros enteros.
 *
 * <p>Este programa genera automaticamente un vector de 15 numeros enteros con
 * valores aleatorios entre 1 y 20, y cuenta cuantas veces aparece un valor
 * determinado dentro de ese vector.</p>
 *
 * <p>El algoritmo recorre el vector completo desde la posicion 0 hasta la
 * ultima posicion, comparando cada elemento con el valor buscado. Cada vez
 * que los valores coinciden, se incrementa un contador.</p>
 *
 * <p>El vector no esta ordenado, por lo que los valores iguales pueden estar
 * distribuidos en cualquier posicion. Para garantizar un conteo exacto, es
 * necesario revisar cada posicion del vector. No se puede detener ante la
 * primera coincidencia porque podrian existir mas apariciones en posiciones
 * posteriores.</p>
 *
 * <p>Complejidad temporal: O(n) en todos los casos (mejor, promedio y peor),
 * porque siempre se recorre el vector completo. Complejidad espacial: O(1),
 * porque solo se utilizan variables auxiliares para el contador y el indice.</p>
 */
public class Main {
    private static final int CANTIDAD_ELEMENTOS = 15;
    private static final int VALOR_MINIMO = 1;
    private static final int VALOR_MAXIMO = 20;

    /**
     * Genera el vector, el valor buscado, ejecuta el conteo y muestra
     * la justificacion y el analisis de complejidad.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] vector = generarVector();
        int valorBuscado = generarValorBuscado();

        System.out.println("Vector generado: " + Arrays.toString(vector));
        System.out.println("Valor buscado: " + valorBuscado);

        int apariciones = contarApariciones(vector, valorBuscado);

        System.out.println("Apariciones del valor " + valorBuscado + ": "
                + apariciones);

        System.out.println("\n--- Justificacion del recorrido completo ---");
        System.out.println("El vector no esta ordenado, por lo que los valores"
                + " iguales pueden estar");
        System.out.println("distribuidos en cualquier posicion. Para garantizar"
                + " un conteo exacto, es");
        System.out.println("necesario revisar cada posicion del vector desde la"
                + " primera hasta la ultima.");
        System.out.println("No se puede detener ante la primera coincidencia"
                + " porque podrian existir");
        System.out.println("mas apariciones en posiciones posteriores.");

        System.out.println("\n--- Complejidad ---");
        System.out.println("Temporal: O(n) - Se recorre el vector una sola vez"
                + " en todos los casos.");
        System.out.println("Espacial: O(1) - Solo se utilizan variables"
                + " auxiliares (contador e indice).");
    }

    /**
     * Genera un vector con valores enteros aleatorios.
     *
     * <p>El vector contiene 15 elementos con valores entre 1 y 20. El rango
     * es menor que la cantidad de elementos, lo que garantiza por el
     * principio del palomar que al menos un valor se repetira.</p>
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
     * Genera el valor que se desea buscar dentro del vector.
     *
     * <p>El valor se genera dentro del mismo rango que los elementos del
     * vector (1 a 20). Esto permite que en algunas ejecuciones el valor
     * exista y en otras no, lo que hace interesante la comparacion de
     * ambos casos.</p>
     *
     * @return valor generado entre VALOR_MINIMO y VALOR_MAXIMO
     */
    private static int generarValorBuscado() {
        Random random = new Random();
        return random.nextInt(VALOR_MAXIMO - VALOR_MINIMO + 1) + VALOR_MINIMO;
    }

    /**
     * Cuenta cuantas veces aparece un valor en el vector.
     *
     * <p>Este algoritmo recorre el vector completo desde la posicion 0 hasta
     * la ultima posicion, comparando cada elemento con el valor buscado.
     * Cada vez que los valores coinciden, se incrementa un contador.</p>
     *
     * <p>El vector no esta ordenado, por lo que los valores iguales pueden
     * estar distribuidos en cualquier posicion. Para garantizar un conteo
     * exacto, es necesario revisar cada posicion del vector desde la
     * primera hasta la ultima. No se puede detener ante la primera
     * coincidencia porque podrian existir mas apariciones en posiciones
     * posteriores.</p>
     *
     * <p>Aunque el valor se encuentre en la primera posicion, el algoritmo
     * debe continuar recorriendo porque puede haber mas apariciones en
     * posiciones posteriores. Por eso todos los casos son O(n).</p>
     *
     * <p>Complejidad temporal: O(n) en todos los casos (mejor, promedio y
     * peor), porque siempre se recorre el vector completo.</p>
     *
     * <p>Complejidad espacial: O(1), porque solo se utiliza una variable
     * para el contador de apariciones y una variable para el indice del
     * ciclo. No se crea ninguna estructura de datos auxiliar.</p>
     *
     * @param vector vector donde se buscaran las apariciones
     * @param valorBuscado valor que se desea contar
     * @return cantidad de veces que aparece el valor en el vector
     */
    private static int contarApariciones(int[] vector, int valorBuscado) {
        int contador = 0;
        for (int indice = 0; indice < vector.length; indice++) {
            if (vector[indice] == valorBuscado) {
                contador++;
            }
        }
        return contador;
    }
}
