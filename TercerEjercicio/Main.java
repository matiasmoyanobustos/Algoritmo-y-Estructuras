package TercerEjercicio;

import java.util.Scanner;

/**
 * Busca un valor en un vector ordenado mediante busqueda binaria.
 *
 * <p>La busqueda binaria es mas eficiente que la busqueda lineal cuando el
 * vector esta ordenado porque descarta la mitad de los elementos restantes
 * en cada iteracion. Su complejidad es O(1) en el mejor caso y O(log n) en el
 * caso promedio y peor. La implementacion utiliza O(1) de espacio adicional.</p>
 *
 * <p>El programa tambien muestra la evolucion de {@code inicio},
 * {@code medio} y {@code fin}, y cuenta todas las apariciones del valor
 * encontrado.</p>
 */
public class Main {
    /**
     * Lee un vector ordenado y un valor desde la entrada estandar, y realiza
     * la busqueda binaria.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidadElementos = scanner.nextInt();
        int[] vector = new int[cantidadElementos];

        for (int indice = 0; indice < cantidadElementos; indice++) {
            vector[indice] = scanner.nextInt();
        }

        int valorBuscado = scanner.nextInt();
        int posicionEncontrada = buscarBinaria(vector, valorBuscado);

        if (posicionEncontrada == -1) {
            System.out.println("El valor no existe en el vector.");
        } else {
            int cantidadApariciones = contarApariciones(vector, posicionEncontrada, valorBuscado);
            System.out.println("Valor encontrado en la posicion: " + posicionEncontrada);
            System.out.println("Cantidad de apariciones: " + cantidadApariciones);
        }

        scanner.close();
    }

    /**
     * Busca un valor en un vector ordenado de menor a mayor.
     *
     * <p>En cada iteracion se muestran los limites del intervalo de busqueda,
     * el valor central y la decision tomada. Si el valor central es menor que
     * el buscado, se continua en la mitad derecha; si es mayor, en la mitad
     * izquierda.</p>
     *
     * @param vector vector ordenado donde se realizara la busqueda
     * @param valorBuscado valor que se desea encontrar
     * @return indice de una aparicion del valor o {@code -1} si no existe
     */
    private static int buscarBinaria(int[] vector, int valorBuscado) {
        int inicio = 0;
        int fin = vector.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            System.out.println("inicio=" + inicio + ", medio=" + medio + ", fin=" + fin
                    + ", valorMedio=" + vector[medio]);

            if (vector[medio] == valorBuscado) {
                System.out.println("Valor encontrado.");
                return medio;
            }

            if (vector[medio] < valorBuscado) {
                System.out.println("El valor central es menor: buscar en la mitad derecha.");
                inicio = medio + 1;
            } else {
                System.out.println("El valor central es mayor: buscar en la mitad izquierda.");
                fin = medio - 1;
            }
        }

        return -1;
    }

    /**
     * Cuenta las apariciones contiguas de un valor desde una posicion conocida.
     *
     * <p>Como el vector esta ordenado, las apariciones repetidas estan juntas.
     * Por eso se recorre hacia la izquierda y hacia la derecha desde la
     * posicion encontrada. El costo adicional es O(k), donde k es la cantidad
     * de apariciones.</p>
     *
     * @param vector vector ordenado que contiene el valor
     * @param posicionEncontrada posicion de una aparicion conocida
     * @param valorBuscado valor cuyas apariciones se contaran
     * @return cantidad total de apariciones del valor
     */
    private static int contarApariciones(int[] vector, int posicionEncontrada, int valorBuscado) {
        int cantidadApariciones = 1;

        for (int indice = posicionEncontrada - 1;
                indice >= 0 && vector[indice] == valorBuscado;
                indice--) {
            cantidadApariciones++;
        }

        for (int indice = posicionEncontrada + 1;
                indice < vector.length && vector[indice] == valorBuscado;
                indice++) {
            cantidadApariciones++;
        }

        return cantidadApariciones;
    }
}
