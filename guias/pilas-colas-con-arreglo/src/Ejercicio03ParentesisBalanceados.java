/*
Prompt inicial de OpenCode:
Implementá en Java 21 una clase independiente `Ejercicio03ParentesisBalanceados` que lea expresiones completas por línea y valide exclusivamente el balance de `(` y `)`. Usá un `char[]` con capacidad igual a la longitud de la expresión, como pila local, sin depender de otra clase del práctico. Al encontrar `(` apilalo; al encontrar `)`, si no hay abierto devolvé inválido, y si lo hay hacé pop; al final es válido solo si no hubo cierre sobrante y la pila quedó vacía. Ignorá los demás caracteres y no intentes validar sintaxis matemática. Incluí menú para probar expresiones y salir, y demostrá `(5 + 3) * (2 + 1)` como válida y `(5 + 3)) * (2 + 1` como inválida, además de vacío, anidados, cierre extra y apertura sobrante. Documentá razonamiento, entrada/salida, complejidad O(n) tiempo/O(n) espacio y ejemplos en Javadoc. Copiá este prompt completo al principio y agrega al final si se ajustó o no.
*/
import java.util.Scanner;

/**
 * Ejercicio 3 — Validación de paréntesis balanceados.
 * <p>Una pila char[] guarda los abiertos; cada cierre desapila uno. Solo se evalúan '(' y ')', no
 * toda la gramática matemática. Ejemplos: "(5 + 3) * (2 + 1)" válido; "(5 + 3)) * (2 + 1" inválido.
 * La cadena vacía y "((x))" son válidas. Tiempo O(n), espacio O(n).</p>
 */
public class Ejercicio03ParentesisBalanceados {
    private Ejercicio03ParentesisBalanceados() { }
    /** Determina si los paréntesis están balanceados.
     * @param expresion texto que se analizará
     * @return true si cada cierre tiene apertura previa y no quedan aperturas
     * @throws IllegalArgumentException si expresion es null
     */
    public static boolean estaBalanceada(String expresion) {
        if (expresion == null) throw new IllegalArgumentException("La expresión no puede ser null.");
        char[] pila = new char[expresion.length()];
        int top = -1;
        for (int i = 0; i < expresion.length(); i++) {
            char actual = expresion.charAt(i);
            if (actual == '(') pila[++top] = actual;
            else if (actual == ')') {
                if (top == -1) return false;
                top--; // El cierre actual consume la apertura más reciente (LIFO).
            }
        }
        return top == -1;
    }
    /** Menú para validar expresiones completas.
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean salir = false;
            while (!salir) {
                System.out.println("\n1 validar expresión | 2 probar ejemplos | 0 salir");
                System.out.print("Opción: "); if (!sc.hasNextLine()) break;
                String linea = sc.nextLine().trim();
                switch (linea) {
                    case "1" -> { System.out.print("Expresión: "); if (!sc.hasNextLine()) return; mostrar(sc.nextLine()); }
                    case "2" -> {
                        mostrar("(5 + 3) * (2 + 1)"); mostrar("(5 + 3)) * (2 + 1");
                        mostrar(""); mostrar("((x + 1) * (y))"); mostrar(")x("); mostrar("(x + 1");
                    }
                    case "0" -> salir = true;
                    default -> System.out.println("Opción inexistente.");
                }
            }
        }
    }
    private static void mostrar(String expresion) { System.out.println('"' + expresion + "\" → " + (estaBalanceada(expresion) ? "válida" : "inválida")); }
}
// Prompt sin cambios.
