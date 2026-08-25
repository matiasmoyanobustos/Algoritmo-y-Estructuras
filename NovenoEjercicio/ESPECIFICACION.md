# Especificación: Búsqueda del mayor elemento de una matriz

## 1. Objetivo del proyecto

Crear un prompt en español para OpenCode que solicite la implementación en Java 21 de un algoritmo que encuentre el mayor elemento de una matriz de números enteros.

El prompt debe justificar por qué resulta necesario recorrer todos los elementos de la matriz para encontrar el máximo, y solicitar el análisis de la complejidad temporal y espacial del algoritmo.

Este ejercicio debe mantenerse separado de los ejercicios anteriores mediante una carpeta propia dentro del proyecto.

## 2. Requisitos funcionales

El prompt debe solicitar que OpenCode:

- Implemente el programa en Java 21.
- Genere automáticamente una matriz de números enteros con valores aleatorios.
- Implemente un método que recorra la matriz completa usando dos ciclos anidados.
- Encuentre el mayor elemento de la matriz.
- Informe el valor del mayor elemento encontrado.
- Informe la posición (fila y columna) donde se encuentra el mayor elemento.
- Justifique por qué es necesario recorrer todos los elementos.
- Incluya un análisis completo de la complejidad temporal y espacial.
- Incluya documentación Javadoc que explique la estrategia y el análisis de complejidad.

## 3. Requisitos no funcionales

- El código debe ser comprensible para un estudiante de estructuras de datos y algoritmos.
- No debe utilizar librerías externas.
- No debe utilizar métodos de búsqueda de máximos de bibliotecas.
- El recorrido debe implementarse manualmente con dos ciclos anidados.
- La justificación del recorrido completo debe estar documentada.
- El código debe incluir comentarios Javadoc en la clase y los métodos principales.
- La salida debe ser clara y no debe incluir información que no sea solicitada.

## 4. Restricciones y decisiones técnicas

- Lenguaje: Java.
- Versión: Java 21.
- Entrada: generación automática de datos aleatorios.
- La matriz debe ser de dos dimensiones (filas y columnas).
- El recorrido debe ser fila por fila, de izquierda a derecha.
- Se debe inicializar el máximo con el primer elemento de la matriz.
- Se debe comparar cada elemento con el máximo actual.
- Se debe almacenar la posición del máximo encontrado.

## 5. Generación de datos

El programa debe generar automáticamente la matriz con las siguientes características:

### Matriz

- Cantidad de filas: por ejemplo, `4` filas.
- Cantidad de columnas: por ejemplo, `5` columnas.
- Rango de valores: por ejemplo, entre `1` y `100`.
- La matriz se muestra antes de ejecutar la búsqueda.

Ejemplo de matriz generada:

```
Matriz generada:
[ 45,  12,  78,  34,  56]
[ 23,  89,  15,  67,  41]
[ 92,  38,  54,  21,  73]
[ 11,  63,  27,  85,  49]
```

Mayor elemento: 92 en la posición (2, 0).

## 6. Algoritmo de búsqueda del máximo

### Estrategia

El algoritmo debe recorrer la matriz completa utilizando dos ciclos anidados. Se inicializa el máximo con el primer elemento de la matriz (posición [0][0]). Luego, se compara cada elemento con el máximo actual. Si el elemento actual es mayor que el máximo, se actualiza el máximo y se registra su posición.

### Algoritmo paso a paso

1. Inicializar `maximo` con `matriz[0][0]`.
2. Inicializar `filaMaxima` y `columnaMaxima` en `0`.
3. Recorrer la matriz con un ciclo externo desde `fila = 0` hasta `filas - 1`.
4. Para cada fila, recorrer con un ciclo interno desde `columna = 0` hasta `columnas - 1`.
5. En cada posición, comparar `matriz[fila][columna]` con `maximo`.
6. Si el elemento actual es mayor que `maximo`, actualizar `maximo`, `filaMaxima` y `columnaMaxima`.
7. Al finalizar ambos ciclos, retornar el máximo y su posición.

### Justificación del recorrido completo

El prompt debe solicitar que se explique por qué es necesario recorrer todos los elementos:

- **No se puede conocer el máximo sin revisar todos los elementos**: El mayor elemento puede estar en cualquier posición de la matriz. No hay forma de saberlo sin examinar cada uno.
- **No hay orden en la matriz**: A diferencia de un vector ordenado donde el máximo estaría en un extremo, la matriz no tiene un orden predefinido.
- **Una sola pasada es suficiente**: No se necesita recorrer la matriz múltiples veces. Un solo recorrido completo permite encontrar el máximo.
- **El máximo puede estar en la última posición**: Si el mayor elemento está en la esquina inferior derecha, el algoritmo debe llegar hasta allí.

## 7. Complejidad esperada

### Complejidad temporal

- **Mejor caso**: `O(f * c)`, porque siempre se deben recorrer todos los elementos para confirmar que no hay uno mayor.
- **Caso promedio**: `O(f * c)`, porque se recorre la matriz completa en todos los casos.
- **Peor caso**: `O(f * c)`, cuando el máximo está en la última posición o todos los elementos son iguales.

### Complejidad espacial

- **Espacio adicional**: `O(1)`, porque solo se utilizan variables para el máximo, su posición y los índices de los ciclos. No se crea ninguna estructura de datos auxiliar.

## 8. Justificación del recorrido obligatorio

El prompt debe solicitar que se documente la justificación del recorrido completo:

### Por qué no se puede detener antes

- El máximo puede estar en cualquier posición. Si se detuviera antes, podría haber un elemento mayor no examinado.
- No hay forma de predecir dónde está el máximo sin revisar cada posición.
- A diferencia de una búsqueda en vector ordenado, aquí no hay estructura que permita descartar regiones.

### Comparación con otros algoritmos

- En un vector ordenado, el máximo está en el último posición y se accede en `O(1)`.
- En una matriz no ordenada, no hay acceso directo al máximo sin recorrer todos los elementos.
- Un algoritmo divide y vencerás no reduce la complejidad porque no se puede descartar ninguna región sin examinarla.

## 9. Estructura del programa

El programa debe contener al menos:

- Una clase ejecutable con método `main`.
- Un método para generar la matriz aleatoria.
- Un método para mostrar la matriz formateada.
- Un método que recorra la matriz y encuentre el mayor elemento con su posición.
- Un método o sección para mostrar la justificación y el análisis de complejidad.

No se requiere una jerarquía de clases ni una arquitectura compleja.

## 10. Entrada y salida

### Datos generados

El programa debe generar automáticamente la matriz sin solicitar datos por teclado.

### Salida esperada

El programa debe imprimir:

1. La matriz generada formateada.
2. El valor del mayor elemento encontrado.
3. La posición (fila y columna) del mayor elemento.
4. La justificación de por qué se necesita recorrer todos los elementos.
5. El análisis de complejidad temporal y espacial.

### Ejemplo de salida

```
Matriz generada:
[ 45,  12,  78,  34,  56]
[ 23,  89,  15,  67,  41]
[ 92,  38,  54,  21,  73]
[ 11,  63,  27,  85,  49]

Mayor elemento: 92
Posicion: fila 2, columna 0

--- Justificacion del recorrido completo ---
El mayor elemento puede estar en cualquier posicion de la matriz. No hay
forma de determinar cual es el maximo sin examinar cada elemento. A diferencia
de un vector ordenado, la matriz no tiene un orden predefinido que permita
descartar regiones. Por eso es necesario recorrer todos los elementos en
una sola pasada.

--- Complejidad ---
Temporal: O(f * c) - Se recorre la matriz completa fila por fila.
Espacial: O(1) - Solo se utilizan variables auxiliares (maximo, posicion e indices).
```

## 11. Análisis de complejidad detallado

### Mejor caso

Cuando la matriz tiene dimensiones mínimas (1x1). El algoritmo retorna el único elemento. Complejidad `O(1)` para matrices constantes, pero en general `O(f * c)` porque siempre se debe recorrer toda la matriz.

### Caso promedio

Cuando la matriz tiene dimensiones razonables (por ejemplo, 4x5). El algoritmo recorre todos los elementos comparando cada uno con el máximo actual. Complejidad `O(f * c)`.

### Peor caso

Cuando la matriz es grande y el máximo está en la última posición. El algoritmo recorre todos los elementos hasta llegar al final. Complejidad `O(f * c)`.

### Espacio adicional

Solo se utilizan:

- Una variable entera para el máximo encontrado.
- Dos variables enteras para la posición del máximo (fila y columna).
- Dos variables enteras para los índices de los ciclos.
- No se crean arreglos, listas, conjuntos u otras estructuras auxiliares.

Espacio adicional: `O(1)`.

## 12. Casos límite

La implementación debe contemplar:

- Matriz de 1x1 (un solo elemento).
- Matriz de 1 fila y múltiples columnas.
- Matriz de múltiples filas y 1 columna.
- Matriz cuadrada (mismas filas que columnas).
- Matriz con todos los elementos iguales.
- Matriz con valores negativos, cero y positivos.
- Matriz con el máximo en la primera posición [0][0].
- Matriz con el máximo en la última posición.
- Matriz con el máximo en una posición intermedia.
- Matriz con valores extremos del rango generado.
- Múltiples elementos con el mismo valor máximo.

## 13. Documentación Javadoc requerida

El código debe incluir Javadoc para:

- La clase principal.
- El método `main`.
- El método que genera la matriz.
- El método que muestra la matriz formateada.
- El método que encuentra el mayor elemento.

La documentación debe explicar:

- El objetivo del algoritmo.
- La estrategia de recorrido con dos ciclos anidados.
- La inicialización del máximo con el primer elemento.
- La actualización del máximo y su posición.
- La justificación de por qué se necesita recorrer todos los elementos.
- Las complejidades temporal O(f * c) y espacial O(1).

## 14. Prompt final para OpenCode

> Implementá en Java 21 un programa sencillo que encuentre el mayor elemento de una matriz de números enteros.
>
> **Generación de datos:** El programa debe generar automáticamente una matriz de 4 filas y 5 columnas con valores enteros aleatorios entre 1 y 100. Mostrá la matriz generada formateada antes de ejecutar la búsqueda.
>
> **Algoritmo de búsqueda:** Implementá un método que recorra la matriz completa utilizando dos ciclos anidados. El ciclo externo debe recorrer las filas desde 0 hasta filas-1. El ciclo interno debe recorrer las columnas desde 0 hasta columnas-1. Inicializá el máximo con el primer elemento `matriz[0][0]` y su posición en `[0][0]`. En cada posición, compará `matriz[fila][columna]` con el máximo actual. Si el elemento actual es mayor, actualizá el máximo y registrá su nueva posición.
>
> **Justificación del recorrido:** Documentá con Javadoc por qué es necesario recorrer todos los elementos. Explicá que el mayor elemento puede estar en cualquier posición, que la matriz no tiene un orden predefinido que permita descartar regiones, y que una sola pasada completa es suficiente para encontrar el máximo.
>
> **Complejidad:** Analizá la complejidad temporal y espacial. Indicá que la complejidad temporal es O(f * c) donde f es la cantidad de filas y c la cantidad de columnas, porque siempre se deben recorrer todos los elementos. Explicá que la complejidad espacial es O(1) porque solo se utilizan variables auxiliares para el máximo, su posición y los índices.
>
> **Documentación:** Documentá con Javadoc la clase, el `main`, el método de generación, el método de muestra formateada y el método de búsqueda. Explicá que este es un ejemplo de búsqueda lineal en una matriz, y que a diferencia de vectores ordenados donde el máximo se accede en O(1), aquí es necesario examinar cada posición.
>
> **Salida:** El programa debe imprimir la matriz formateada, el mayor elemento, su posición, la justificación del recorrido completo y el análisis de complejidad. No debe solicitar datos por teclado.

## 15. Criterios de aceptación

La implementación será aceptada si:

- Compila correctamente con Java 21.
- Genera automáticamente la matriz sin solicitar datos por teclado.
- Implementa un método que recorra la matriz con dos ciclos anidados.
- Inicializa el máximo con el primer elemento de la matriz.
- Compara cada elemento con el máximo actual y lo actualiza si es mayor.
- Almacena y muestra la posición del mayor elemento.
- Incluye una justificación clara de por qué se necesita recorrer todos los elementos.
- Incluye un análisis de complejidad temporal O(f * c) y espacial O(1).
- Utiliza Javadoc para documentar la clase, métodos y análisis de complejidad.
- Está ubicada en una carpeta independiente de los ejercicios anteriores.
- El código es claro, legible y adecuado para un contexto académico.
- No utiliza librerías externas ni métodos predefinidos de búsqueda de máximos.
