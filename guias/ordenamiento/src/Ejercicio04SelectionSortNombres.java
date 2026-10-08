import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 4 — Selection Sort de nombres.
 * <p>Selecciona el menor texto de la parte no ordenada usando comparación lexicográfica
 * sin distinguir mayúsculas ({@link String#compareToIgnoreCase(String)}). No se aplican reglas
 * regionales. Tiempo O(n²), espacio adicional O(1). Lee nombres por línea completa y muestra entrada y resultado.</p>
 */
public class Ejercicio04SelectionSortNombres {
    private Ejercicio04SelectionSortNombres() { }

    /** Ordena los nombres in-place con Selection Sort.
     * @param nombres nombres que se ordenarán; no puede ser null ni contener null
     * @throws IllegalArgumentException si el arreglo o algún nombre es null
     */
    public static void ordenar(String[] nombres) {
        if (nombres == null) throw new IllegalArgumentException("El arreglo no puede ser null.");
        for (String nombre : nombres) if (nombre == null) throw new IllegalArgumentException("Los nombres no pueden ser null.");
        for (int inicio = 0; inicio < nombres.length - 1; inicio++) {
            int menor = inicio;
            for (int i = inicio + 1; i < nombres.length; i++) {
                if (nombres[i].compareToIgnoreCase(nombres[menor]) < 0) menor = i;
            }
            if (menor != inicio) {
                String temporal = nombres[inicio]; nombres[inicio] = nombres[menor]; nombres[menor] = temporal;
            }
        }
    }

    /** Lee nombres ingresados por consola y muestra el resultado.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Cantidad de nombres: ");
            int cantidad = Integer.parseInt(entrada.nextLine().trim());
            if (cantidad < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa.");
            String[] nombres = new String[cantidad];
            for (int i = 0; i < cantidad; i++) {
                System.out.print("Nombre " + (i + 1) + ": ");
                nombres[i] = entrada.nextLine();
            }
            System.out.println("Original: " + Arrays.toString(nombres));
            ordenar(nombres);
            System.out.println("Ordenado: " + Arrays.toString(nombres));
        } catch (NumberFormatException error) {
            System.out.println("Entrada inválida: la cantidad debe ser un entero.");
        } catch (IllegalArgumentException error) {
            System.out.println("Entrada inválida: " + error.getMessage());
        }
    }
}
