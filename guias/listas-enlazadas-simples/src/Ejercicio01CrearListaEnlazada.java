/*
Prompt inicial utilizado:
Implementá en Java 21 la clase independiente `Ejercicio01CrearListaEnlazada` con una lista propia de enteros, sin colecciones. Define un Nodo con dato y referencia siguiente; head apunta al primer nodo o null, y size cuenta nodos. Implementá insertarAlInicio, insertarAlFinal, imprimir, estaVacia y getSize. Explicá cómo se actualizan head, enlaces y size; insertar al inicio es O(1), agregar al final recorre nodos y cuesta O(n). Usa datos fijos en main, muestra lista vacía, inserciones al inicio/final, contenido y tamaño. Agregá Javadoc y comentarios de las referencias. Colocá este prompt íntegro al comienzo del archivo bajo “Prompt inicial utilizado:” y al final “Ajustes realizados luego de la primera respuesta de OpenCode:” indicando que no hubo ajustes o describiendo los reales.
Ajustes realizados luego de la primera respuesta de OpenCode:
No hubo ajustes.
*/
/**
 * Ejercicio 1. Lista enlazada simple de enteros creada desde cero.
 * <p>Ejemplo: lista vacía; insertar inicio 20, final 30, inicio 10 produce
 * {@code 10 -> 20 -> 30 -> null}, tamaño 3. Cada nodo guarda un entero y su enlace;
 * head señala el primero. Inserción inicial O(1), final O(n), consultas O(1), memoria O(n).</p>
 */
public class Ejercicio01CrearListaEnlazada {
    private static final class Nodo { int dato; Nodo siguiente; Nodo(int dato) { this.dato = dato; } }
    private Nodo head;
    private int size;

    /** Construye una lista inicialmente vacía.
     */
    public Ejercicio01CrearListaEnlazada() { }

    /** Inserta al inicio.
     * @param dato valor a agregar
     */
    public void insertarAlInicio(int dato) { Nodo nuevo = new Nodo(dato); nuevo.siguiente = head; head = nuevo; size++; }
    /** Inserta al final.
     * @param dato valor a agregar
     */
    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) head = nuevo;
        else { Nodo actual = head; while (actual.siguiente != null) actual = actual.siguiente; actual.siguiente = nuevo; }
        size++;
    }
    /** Imprime todos los nodos desde head.
     */
    public void imprimir() {
        System.out.println(representacion());
    }
    private String representacion() {
        StringBuilder texto = new StringBuilder(); Nodo actual = head;
        while (actual != null) { texto.append(actual.dato).append(" -> "); actual = actual.siguiente; }
        return texto.append("null").toString();
    }
    /** Indica si la lista no tiene nodos.
     * @return true si head es null
     */
    public boolean estaVacia() { return head == null; }
    /** Devuelve el número de nodos almacenados.
     * @return cantidad actual
     */
    public int getSize() { return size; }

    /** Demuestra inserción, impresión y tamaño con datos deterministas.
     * @param args no utilizados
     */
    public static void main(String[] args) {
        Ejercicio01CrearListaEnlazada lista = new Ejercicio01CrearListaEnlazada();
        System.out.println("Ejercicio 1 — Lista desde cero");
        System.out.print("Inicial: "); lista.imprimir(); System.out.println("vacía=" + lista.estaVacia() + ", size=" + lista.getSize());
        lista.insertarAlInicio(20); lista.insertarAlFinal(30); lista.insertarAlInicio(10);
        System.out.print("Tras insertar: "); lista.imprimir(); System.out.println("vacía=" + lista.estaVacia() + ", size=" + lista.getSize());
    }
}
