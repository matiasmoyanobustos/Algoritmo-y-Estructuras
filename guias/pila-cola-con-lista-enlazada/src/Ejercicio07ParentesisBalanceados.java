/*
Prompt inicial utilizado:
Implementá en Java 21 una clase independiente `Ejercicio07ParentesisBalanceados` para validar paréntesis `(` y `)` usando una pila enlazada propia de caracteres. Por cada apertura apila; por cada cierre, si la pila está vacía devuelve falso; de lo contrario hace pop. Al finalizar devuelve válido solo si la pila quedó vacía. Ignora caracteres distintos de paréntesis y no intentes validar la gramática completa. Explica que LIFO empareja cada cierre con la apertura más reciente pendiente. En main prueba `(2 + 3) * (5 - 1)` y `((a + b) * c)` como válidas; `(2 + 3` y `())(` como inválidas; además expresión vacía y una expresión anidada. Para n caracteres documenta O(n) tiempo y O(n) espacio. No uses arrays ni colecciones como la pila. Incluye Javadoc y comentario inicial con prompt completo y nota real de ajustes.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 7 — Verificador de paréntesis.
 * <p>Cada '(' se apila; ')' consume la apertura más reciente. Válidos: (2 + 3) * (5 - 1),
 * ((a + b) * c), vacío y (x+(y*z)); inválidos: (2 + 3 y ())(. Valida solo paréntesis.
 * Para n caracteres: O(n) tiempo y O(n) espacio en el peor caso.</p>
 */
public class Ejercicio07ParentesisBalanceados {
    private static final class Nodo { private final char dato; private final Nodo siguiente; private Nodo(char d, Nodo s) { dato = d; siguiente = s; } }
    private static final class PilaCaracteres {
        private Nodo top;
        private boolean isEmpty() { return top == null; }
        private void push(char c) { top = new Nodo(c, top); }
        private char pop() { if (isEmpty()) throw new IllegalStateException("Pila de aperturas vacía."); char c = top.dato; top = top.siguiente; return c; }
    }
    private Ejercicio07ParentesisBalanceados() { }
    /** Comprueba el balance de paréntesis, ignorando los demás caracteres.
     * @param expresion texto analizado
     * @return true si no hay cierres sobrantes y quedan cero aperturas
     * @throws IllegalArgumentException si la referencia es null
     */
    public static boolean estaBalanceada(String expresion) {
        if (expresion == null) throw new IllegalArgumentException("La expresión no puede ser null.");
        PilaCaracteres aperturas = new PilaCaracteres();
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (c == '(') aperturas.push(c);
            else if (c == ')') { if (aperturas.isEmpty()) return false; aperturas.pop(); }
        }
        return aperturas.isEmpty();
    }
    /** Ejecuta los casos de la consigna y límites.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio 7 — paréntesis balanceados");
        for (String e : new String[]{"(2 + 3) * (5 - 1)", "((a + b) * c)", "(2 + 3", "())(", "", "(x+(y*z))"})
            System.out.println("\"" + e + "\" → " + (estaBalanceada(e) ? "válida" : "inválida"));
    }
}
