package SegundoEjercicio;

import java.util.Arrays;
import java.util.Random;

/**
 * Genera un vector aleatorio, lo ordena con burbuja y busca un valor.
 *
 * <p>El vector y el valor buscado se generan automaticamente, por lo que no
 * es necesario ingresar datos por teclado. La posicion informada corresponde
 * al vector ordenado y utiliza indices desde cero.</p>
 *
 * <p>El ordenamiento burbuja tiene complejidad O(n) en el mejor caso cuando
 * el vector ya esta ordenado, y O(n^2) en el caso promedio y peor. La
 * busqueda lineal tiene complejidad O(1) en el mejor caso y O(n) en el caso
 * promedio y peor. El espacio adicional utilizado es O(1).</p>
 */
public class Main {
    private static final int CANTIDAD_ELEMENTOS = 10;
    private static final int VALOR_MINIMO = 1;
    private static final int VALOR_MAXIMO = 50;
    private static int posicionesRecorridas;

    /**
     * Genera los datos, ordena el vector, busca el valor e informa el resultado.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        Random random = new Random();
        int[] vector = generarVector(random);
        int valorBuscado = random.nextInt(VALOR_MAXIMO - VALOR_MINIMO + 1) + VALOR_MINIMO;

        System.out.println("Vector original: " + Arrays.toString(vector));
        ordenarBurbuja(vector);
        System.out.println("Vector ordenado: " + Arrays.toString(vector));
        System.out.println("Valor buscado: " + valorBuscado);

        int posicion = buscar(vector, valorBuscado);
        if (posicion >= 0) {
            System.out.println("Elemento encontrado en la posicion: " + posicion);
        } else {
            System.out.println("Elemento no encontrado.");
        }
        System.out.println("Posiciones recorridas: " + posicionesRecorridas);
    }

    /**
     * Genera un vector con valores enteros aleatorios.
     *
     * @param random generador de valores aleatorios
     * @return vector generado
     */
    private static int[] generarVector(Random random) {
        int[] vector = new int[CANTIDAD_ELEMENTOS];
        for (int indice = 0; indice < vector.length; indice++) {
            vector[indice] = random.nextInt(VALOR_MAXIMO - VALOR_MINIMO + 1) + VALOR_MINIMO;
        }
        return vector;
    }

    /**
     * Ordena el vector de menor a mayor usando el algoritmo burbuja.
     *
     * @param vector vector que se ordenara en el mismo arreglo
     */
    private static void ordenarBurbuja(int[] vector) {
        for (int limite = vector.length - 1; limite > 0; limite--) {
            boolean huboIntercambio = false;
            for (int indice = 0; indice < limite; indice++) {
                if (vector[indice] > vector[indice + 1]) {
                    int auxiliar = vector[indice];
                    vector[indice] = vector[indice + 1];
                    vector[indice + 1] = auxiliar;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) {
                break;
            }
        }
    }

    /**
     * Busca linealmente la primera aparicion del valor en el vector ordenado.
     *
     * @param vector vector ordenado donde se realizara la busqueda
     * @param valorBuscado valor que se desea encontrar
     * @return indice de la primera aparicion o {@code -1} si no existe
     */
    private static int buscar(int[] vector, int valorBuscado) {
        posicionesRecorridas = 0;
        for (int indice = 0; indice < vector.length; indice++) {
            posicionesRecorridas++;
            if (vector[indice] == valorBuscado) {
                return indice;
            }
        }
        return -1;
    }
}
