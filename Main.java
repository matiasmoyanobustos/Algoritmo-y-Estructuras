import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Encuentra el valor minimo de un vector de numeros enteros.
 *
 * <p>El algoritmo realiza un unico recorrido lineal: conserva el menor valor
 * encontrado hasta el momento y lo actualiza cuando encuentra un valor menor.
 * No es necesario ordenar el vector, porque para obtener solamente el minimo
 * alcanza con comparar todos sus elementos. Ordenarlo agregaria trabajo
 * innecesario y tendria una complejidad habitual de {@code O(n log n)}.</p>
 *
 * <p>La complejidad temporal del recorrido es {@code O(n)} y la complejidad
 * espacial adicional es {@code O(1)}. La entrada contiene primero la cantidad
 * de elementos y luego los valores del vector. Se supone que el vector no
 * esta vacio.</p>
 */
public class Main {
    /**
     * Lee el vector desde la entrada estandar, calcula su minimo y lo imprime.
     *
     * @param args argumentos de la linea de comandos, no utilizados
     * @throws IOException si ocurre un error al leer la entrada estandar
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int cantidadElementos = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int minimo = Integer.parseInt(tokenizer.nextToken());

        for (int indice = 1; indice < cantidadElementos; indice++) {
            int valorActual = Integer.parseInt(tokenizer.nextToken());
            if (valorActual < minimo) {
                minimo = valorActual;
            }
        }

        System.out.println(minimo);
    }
}
