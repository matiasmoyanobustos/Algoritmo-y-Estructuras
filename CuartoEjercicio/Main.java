package CuartoEjercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Deteccion de elementos duplicados en un vector utilizando dos soluciones
 * diferentes y comparacion de su complejidad.
 *
 * <p>Este programa genera automaticamente un vector de 15 numeros enteros con
 * valores aleatorios entre 1 y 20. El principio del palomar garantiza que
 * existan duplicados porque hay mas posiciones (15) que valores posibles (20).</p>
 *
 * <p>Solucion 1 - Fuerza bruta: Compara cada par de elementos usando dos ciclos
 * anidados. Complejidad temporal O(n^2), espacial O(1).</p>
 *
 * <p>Solucion 2 - HashSet: Utiliza un conjunto para detectar duplicados al
 * intentar insertar un elemento ya existente. Complejidad temporal O(n),
 * espacial O(n).</p>
 */
public class Main {
    private static final int CANTIDAD_ELEMENTOS = 15;
    private static final int VALOR_MINIMO = 1;
    private static final int VALOR_MAXIMO = 20;

    /**
     * Genera el vector, ejecuta ambas soluciones y muestra la comparacion.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     */
    public static void main(String[] args) {
        int[] vector = generarVector();
        System.out.println("Vector generado: " + Arrays.toString(vector));

        System.out.println("\n--- Solucion 1: Fuerza bruta (ciclos anidados) ---");
        List<Integer> duplicadosFuerzaBruta = detectarDuplicadosFuerzaBruta(vector);
        System.out.println("Duplicados encontrados: " + duplicadosFuerzaBruta);

        System.out.println("\n--- Solucion 2: HashSet ---");
        List<Integer> duplicadosHashSet = detectarDuplicadosHashSet(vector);
        System.out.println("Duplicados encontrados: " + duplicadosHashSet);

        System.out.println("\n--- Comparacion de complejidad ---");
        System.out.println("Fuerza bruta:  Temporal O(n^2) | Espacial O(1)");
        System.out.println("HashSet:       Temporal O(n)   | Espacial O(n)");
    }

    /**
     * Genera un vector con valores enteros aleatorios.
     *
     * <p>Utiliza el principio del palomar: como hay 15 posiciones y solo 20
     * valores posibles (entre 1 y 20), al menos un valor se repetira. Esto
     * garantiza que ambas soluciones encuentren duplicados.</p>
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
     * Detecta duplicados usando fuerza bruta con dos ciclos anidados.
     *
     * <p>Compara cada elemento del vector con todos los elementos que lo siguen.
     * Para cada posicion i, recorre las posiciones j desde i+1 hasta el final.
     * Si vector[i] == vector[j], el valor es un duplicado. Se evita agregar
     * valores repetidos en la lista de resultados.</p>
     *
     * <p>Complejidad temporal: O(n^2) porque realiza n*(n-1)/2 comparaciones.
     * Complejidad espacial: O(1) adicional porque solo usa variables auxiliares
     * para los ciclos. Los duplicados se almacenan en una lista cuyo tamano
     * depende de la cantidad de duplicados encontrados.</p>
     *
     * @param vector vector donde se buscaran duplicados
     * @return lista con los valores que aparecen mas de una vez
     */
    private static List<Integer> detectarDuplicadosFuerzaBruta(int[] vector) {
        List<Integer> duplicados = new ArrayList<>();

        for (int i = 0; i < vector.length; i++) {
            boolean yaRegistrado = false;
            for (int k = 0; k < duplicados.size(); k++) {
                if (duplicados.get(k) == vector[i]) {
                    yaRegistrado = true;
                    break;
                }
            }

            if (!yaRegistrado) {
                for (int j = i + 1; j < vector.length; j++) {
                    if (vector[i] == vector[j]) {
                        duplicados.add(vector[i]);
                        break;
                    }
                }
            }
        }

        return duplicados;
    }

    /**
     * Detecta duplicados utilizando un HashSet.
     *
     * <p>Recorre el vector una sola vez. Para cada elemento, intenta agregarlo
     * al HashSet. Si el metodo add retorna false, significa que el elemento
     * ya existia en el conjunto y, por lo tanto, es un duplicado.</p>
     *
     * <p>Complejidad temporal: O(n) porque cada operacion en HashSet tiene
     * costo amortizado O(1) y se recorre el vector una sola vez.
     * Complejidad espacial: O(n) porque el HashSet puede almacenar hasta n
     * elementos si todos son unicos, o u elementos donde u es la cantidad
     * de valores unicos.</p>
     *
     * @param vector vector donde se buscaran duplicados
     * @return lista con los valores que aparecen mas de una vez
     */
    private static List<Integer> detectarDuplicadosHashSet(int[] vector) {
        List<Integer> duplicados = new ArrayList<>();
        HashSet<Integer> vistos = new HashSet<>();

        for (int indice = 0; indice < vector.length; indice++) {
            if (!vistos.add(vector[indice])) {
                boolean yaRegistrado = false;
                for (int k = 0; k < duplicados.size(); k++) {
                    if (duplicados.get(k) == vector[indice]) {
                        yaRegistrado = true;
                        break;
                    }
                }
                if (!yaRegistrado) {
                    duplicados.add(vector[indice]);
                }
            }
        }

        return duplicados;
    }
}
