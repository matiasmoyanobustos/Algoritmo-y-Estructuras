# Especificación: Inversión de un vector con dos métodos

## 1. Objetivo del proyecto

Crear un prompt en español para OpenCode que solicite la implementación en Java 21 de dos versiones distintas para invertir el orden de los elementos de un vector de números enteros.

La primera versión debe utilizar un vector auxiliar para almacenar los elementos en orden inverso. La segunda versión debe invertir el mismo vector sin utilizar memoria adicional significativa, intercambiando elementos desde los extremos hacia el centro.

El prompt debe solicitar una comparación completa entre ambas soluciones, indicando ventajas, desventajas y la complejidad temporal y espacial de cada una.

Este ejercicio debe mantenerse separado de los ejercicios anteriores mediante una carpeta propia dentro del proyecto.

## 2. Requisitos funcionales

El prompt debe solicitar que OpenCode:

- Implemente el programa en Java 21.
- Genere automáticamente un vector de números enteros con valores aleatorios.
- Implemente una versión de inversión utilizando un vector auxiliar.
- Implemente una segunda versión de inversión sin memoria adicional significativa (in-place).
- Muestre el vector original antes de cada inversión.
- Muestre el vector invertido después de cada operación.
- Ejecute ambas soluciones sobre el mismo vector para garantizar la comparabilidad.
- Realice una comparación explícita de ventajas, desventajas y complejidad.
- Incluya documentación Javadoc que explique cada enfoque y su análisis.

## 3. Requisitos no funcionales

- El código debe ser comprensible para un estudiante de estructuras de datos y algoritmos.
- No debe utilizar librerías externas.
- No debe utilizar métodos de inversión de vectores de bibliotecas.
- La inversión debe implementarse manualmente con ciclos.
- Ambas soluciones deben ser claramente identificables en el código.
- El código debe incluir comentarios Javadoc en la clase y los métodos principales.
- La salida debe ser clara y no debe incluir información que no sea solicitada.

## 4. Restricciones y decisiones técnicas

- Lenguaje: Java.
- Versión: Java 21.
- Entrada: generación automática de datos aleatorios.
- La solución con vector auxiliar debe crear un nuevo arreglo del mismo tamaño.
- La solución in-place debe modificar el vector original directamente.
- No se deben utilizar estructuras auxiliares en la segunda solución (solo variables temporales para intercambio).
- Ambas soluciones deben producir el mismo resultado: el vector con sus elementos en orden inverso.

## 5. Generación de datos

El programa debe generar automáticamente los datos con las siguientes características:

### Vector

- Cantidad de elementos: por ejemplo, `10` elementos.
- Rango de valores: por ejemplo, entre `1` y `20`.
- El vector se muestra antes de ejecutar cada inversión.

Ejemplo de datos generados:

```
Vector original: [5, 3, 8, 3, 5, 12, 8, 1, 15, 3]
```

## 6. Solución 1: Inversión con vector auxiliar

### Estrategia

La solución debe crear un nuevo vector del mismo tamaño que el original. Luego, debe recorrer el vector original desde el último elemento hasta el primero, y copiar cada elemento a la posición correspondiente en el nuevo vector. De esta manera, el primer elemento del original queda en la última posición del auxiliar, y así sucesivamente.

### Algoritmo paso a paso

1. Crear un vector auxiliar del mismo tamaño que el original.
2. Recorrer el vector original con un ciclo desde `i = 0` hasta `n - 1`.
3. En cada posición, copiar `original[i]` a `auxiliar[n - 1 - i]`.
4. Retornar el vector auxiliar como resultado.

### Complejidad esperada

- **Temporal**: `O(n)`, porque se recorre el vector una sola vez realizando una copia.
- **Espacial**: `O(n)`, porque se crea un nuevo vector del mismo tamaño.

## 7. Solución 2: Inversión in-place (sin memoria adicional)

### Estrategia

La solución debe modificar el vector original directamente, intercambiando los elementos desde los extremos hacia el centro. Se intercambia el elemento de la posición `i` con el elemento de la posición `n - 1 - i`, avanzando desde ambos extremos hasta que los índices se crucen.

### Algoritmo paso a paso

1. Inicializar dos índices: `inicio = 0` y `fin = n - 1`.
2. Mientras `inicio < fin`:
   a. Almacenar `vector[inicio]` en una variable temporal.
   b. Asignar `vector[fin]` a `vector[inicio]`.
   c. Asignar la variable temporal a `vector[fin]`.
   d. Incrementar `inicio` en 1.
   e. Decrementar `fin` en 1.
3. El vector queda invertido en su lugar.

### Complejidad esperada

- **Temporal**: `O(n)`, porque se recorre la mitad del vector realizando intercambios.
- **Espacial**: `O(1)`, porque solo se utiliza una variable temporal para el intercambio.

## 8. Comparación de soluciones

El prompt debe solicitar que OpenCode incluya una comparación explícita entre ambas implementaciones:

### Tabla comparativa esperada

| Aspecto                | Vector auxiliar        | In-place               |
|------------------------|------------------------|------------------------|
| Complejidad temporal    | O(n)                   | O(n)                   |
| Complejidad espacial    | O(n)                   | O(1)                   |
| Memoria utilizada       | Doble del vector       | Solo variables locales |
| Modifica el original    | No (crea una copia)    | Sí (modifica directo)  |
| Seguridad de datos      | Conserva el original   | Pierde el original     |
| Legibilidad             | Alta                   | Alta                   |
| Escalabilidad           | Limitada por memoria   | Excelente              |
| Caso de uso ideal       | Cuando se necesita     | Cuando la memoria es   |
|                        | conservar el original  | limitada               |

### Análisis esperado

El prompt debe pedir que se explique:

- Por qué ambas soluciones tienen la misma complejidad temporal.
- Por qué la solución in-place es más eficiente en memoria.
- En qué casos sería preferible conservar el vector original.
- En qué casos la limitación de memoria hace preferible la solución in-place.
- La importancia de conocer ambas estrategias para elegir la adecuada según el contexto.

## 9. Estructura del programa

El programa debe contener al menos:

- Una clase ejecutable con método `main`.
- Un método para generar el vector aleatorio.
- Un método para la inversión con vector auxiliar (retorna nuevo vector).
- Un método para la inversión in-place (modifica el vector recibido).
- Un método o sección para mostrar la comparación de soluciones.

No se requiere una jerarquía de clases ni una arquitectura compleja.

## 10. Entrada y salida

### Datos generados

El programa debe generar automáticamente el vector sin solicitar datos por teclado.

### Salida esperada

El programa debe imprimir:

1. El vector original.
2. El vector invertido con la solución de vector auxiliar.
3. El vector invertido con la solución in-place.
4. La comparación de ambas soluciones (ventajas, desventajas, complejidad).

### Ejemplo de salida

```
Vector original: [5, 3, 8, 3, 5, 12, 8, 1, 15, 3]

--- Solucion 1: Vector auxiliar ---
Vector invertido: [3, 15, 1, 8, 12, 5, 3, 8, 3, 5]

--- Solucion 2: In-place (intercambio desde extremos) ---
Vector invertido: [3, 15, 1, 8, 12, 5, 3, 8, 3, 5]

--- Comparacion de soluciones ---
Vector auxiliar:
  Temporal: O(n) | Espacial: O(n)
  Ventaja: Conserva el vector original intacto.
  Desventaja: Utiliza el doble de memoria.

In-place:
  Temporal: O(n) | Espacial: O(1)
  Ventaja: No utiliza memoria adicional significativa.
  Desventaja: Modifica el vector original (se pierde el orden original).
```

## 11. Análisis de complejidad detallado

### Solución con vector auxiliar

- **Temporal**: `O(n)`, porque se recorre el vector original una sola vez copiando cada elemento.
- **Espacial**: `O(n)`, porque se crea un nuevo vector del mismo tamaño que el original.

### Solución in-place

- **Temporal**: `O(n/2)` que es `O(n)`, porque se realizan n/2 intercambios.
- **Espacial**: `O(1)`, porque solo se utiliza una variable temporal para el intercambio.

### Comparación

Ambas soluciones tienen la misma complejidad temporal `O(n)`. La diferencia principal es el espacio: la primera utiliza `O(n)` adicionales mientras que la segunda utiliza `O(1)`.

## 12. Justificación de las soluciones

El prompt debe solicitar que se documente la justificación de cada enfoque:

### Cuándo usar vector auxiliar

- Cuando se necesita conservar el vector original intacto.
- Cuando se requiere tener tanto el original como el invertido simultáneamente.
- Cuando la memoria disponible es suficiente para contener ambas copias.
- Cuando la claridad del código es prioritaria y no hay restricciones de memoria.

### Cuándo usar in-place

- Cuando la memoria es limitada y no se puede duplicar el vector.
- cuando se trabaja con vectores muy grandes donde la memoria es un recurso escaso.
- Cuando no es necesario conservar el vector original.
- Cuando se busca la máxima eficiencia en el uso de recursos.

## 13. Casos límite

La implementación debe contemplar:

- Vector con un solo elemento (no cambia al invertir).
- Vector con dos elementos (se intercambian).
- Vector con todos los elementos iguales (no cambia visualmente).
- Vector con valores negativos, cero y positivos.
- Vector con valores repetidos.
- Vector ya invertido (queda en el orden original).
- Vector ordenado creciente y decreciente.
- Valores extremos del rango generado.
- Vector de longitud par e impar.

## 14. Documentación Javadoc requerida

El código debe incluir Javadoc para:

- La clase principal.
- El método `main`.
- El método que genera el vector.
- El método de inversión con vector auxiliar.
- El método de inversión in-place.

La documentación debe explicar:

- El objetivo de cada solución.
- La estrategia utilizada en cada caso.
- La complejidad temporal y espacial de cada implementación.
- Cuándo es preferible cada enfoque.
- La diferencia entre crear una copia y modificar in-place.

## 15. Prompt final para OpenCode

> Implementá en Java 21 un programa sencillo que invierta el orden de los elementos de un vector de números enteros utilizando dos soluciones diferentes, y que compare ambas implementaciones.
>
> **Generación de datos:** El programa debe generar automáticamente un vector de 10 enteros con valores aleatorios entre 1 y 20. Mostrá el vector original antes de ejecutar cada solución.
>
> **Solución 1 - Vector auxiliar:** Implementá un método que cree un nuevo vector del mismo tamaño y copie los elementos en orden inverso. Recorré el vector original desde el último elemento hasta el primero, y colocá cada elemento en la posición correspondiente del nuevo vector. Retorná el vector auxiliar como resultado.
>
> **Solución 2 - In-place:** Implementá un método que modifique el vector original directamente. Utilizá dos índices, uno desde el inicio y otro desde el final, e intercambiá los elementos de ambas posiciones. Avanzá hacia el centro hasta que los índices se crucen. No crees ningún vector auxiliar, solo utilizá una variable temporal para el intercambio.
>
> **Comparación:** Imprimí una tabla o texto que compare ambas soluciones. Explicá que ambas tienen complejidad temporal O(n), pero la primera utiliza O(n) de espacio adicional mientras que la segunda utiliza O(1). Indicá en qué casos sería preferible cada una: cuando se necesita conservar el original vs cuando la memoria es limitada.
>
> **Documentación:** Documentá con Javadoc la clase, el `main`, y cada método de inversión. Explicá que la primera solución es más segura pero consume más memoria, y que la segunda es más eficiente en espacio pero modifica el vector original.
>
> **Salida:** El programa debe imprimir el vector original, el vector invertido por cada solución, y la comparación detallada con ventajas, desventajas y complejidad. No debe solicitar datos por teclado.

## 16. Criterios de aceptación

La implementación será aceptada si:

- Compila correctamente con Java 21.
- Genera automáticamente el vector sin solicitar datos por teclado.
- Contiene exactamente dos soluciones para invertir el vector.
- La primera solución utiliza un vector auxiliar y retorna un nuevo vector.
- La segunda solución modifica el vector in-place sin memoria adicional significativa.
- Ambas soluciones producen el mismo resultado: el vector con elementos en orden inverso.
- Muestra el vector original antes de cada inversión.
- Muestra el vector invertido después de cada operación.
- Incluye una comparación explícita de ventajas, desventajas y complejidad.
- Utiliza Javadoc para documentar la clase, métodos y análisis de complejidad.
- Está ubicada en una carpeta independiente de los ejercicios anteriores.
- El código es claro, legible y adecuado para un contexto académico.
- No utiliza librerías externas ni métodos predefinidos de inversión.
