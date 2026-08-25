# Especificación: Suma de todos los elementos de una matriz

## 1. Objetivo del proyecto

Crear un prompt en español para OpenCode que solicite la implementación en Java 21 de un algoritmo que calcule la suma de todos los elementos de una matriz de números enteros.

El prompt debe indicar explícitamente cómo se recorrerá la matriz (mediante dos ciclos anidados, recorriendo filas y columnas), solicitar el análisis de la complejidad temporal y espacial, y pedir que el programa contabilice la cantidad de operaciones aritméticas realizadas durante el cálculo de la suma.

Este ejercicio debe mantenerse separado de los ejercicios anteriores mediante una carpeta propia dentro del proyecto.

## 2. Requisitos funcionales

El prompt debe solicitar que OpenCode:

- Implemente el programa en Java 21.
- Genere automáticamente una matriz de números enteros con valores aleatorios.
- Implemente un método que recorra la matriz completa usando dos ciclos anidados.
- Calcule la suma de todos los elementos de la matriz.
- Contabilice la cantidad de operaciones de suma realizadas.
- Muestre la matriz generada.
- Informe el resultado de la suma total.
- Informe la cantidad de operaciones realizadas.
- Incluya un análisis completo de la complejidad temporal y espacial.
- Incluya documentación Javadoc que explique la estrategia y el análisis de complejidad.

## 3. Requisitos no funcionales

- El código debe ser comprensible para un estudiante de estructuras de datos y algoritmos.
- No debe utilizar librerías externas.
- No debe utilizar métodos de suma de matrices de bibliotecas.
- El recorrido debe implementarse manualmente con dos ciclos anidados.
- La contabilización de operaciones debe ser explícita en el código.
- El código debe incluir comentarios Javadoc en la clase y los métodos principales.
- La salida debe ser clara y no debe incluir información que no sea solicitada.

## 4. Restricciones y decisiones técnicas

- Lenguaje: Java.
- Versión: Java 21.
- Entrada: generación automática de datos aleatorios.
- La matriz debe ser de dos dimensiones (filas y columnas).
- El recorrido debe ser fila por fila, de izquierda a derecha.
- La suma se realiza elemento por elemento acumulando en una variable.
- Se debe contar cada operación de suma realizada.
- No se deben utilizar estructuras auxiliares para el cálculo.

## 5. Generación de datos

El programa debe generar automáticamente la matriz con las siguientes características:

### Matriz

- Cantidad de filas: por ejemplo, `4` filas.
- Cantidad de columnas: por ejemplo, `5` columnas.
- Rango de valores: por ejemplo, entre `1` y `50`.
- La matriz se muestra antes de ejecutar el cálculo.

Ejemplo de matriz generada:

```
Matriz generada:
[12,  5, 23,  8, 15]
[ 3, 18,  7, 21, 10]
[16,  2, 14,  9, 25]
[ 6, 11, 19,  4, 20]
```

## 6. Algoritmo de suma

### Estrategia

El algoritmo debe recorrer la matriz completa utilizando dos ciclos anidados. El ciclo externo recorre las filas de la matriz, y el ciclo interno recorre las columnas de cada fila. En cada posición, se suma el elemento actual a una variable acumuladora. Al finalizar el recorrido, se retorna la suma total.

### Algoritmo paso a paso

1. Inicializar una variable `sumaTotal` en `0`.
2. Inicializar un contador de operaciones en `0`.
3. Recorrer la matriz con un ciclo externo desde `fila = 0` hasta `filas - 1`.
4. Para cada fila, recorrer con un ciclo interno desde `columna = 0` hasta `columnas - 1`.
5. En cada posición, sumar `matriz[fila][columna]` a `sumaTotal`.
6. Incrementar el contador de operaciones en `1`.
7. Al finalizar ambos ciclos, retornar `sumaTotal` y el contador de operaciones.

### Justificación del recorrido completo

El prompt debe solicitar que se explique por qué es necesario recorrer toda la matriz:

- **No se puede omitir ningún elemento**: La suma total requiere sumar todos los elementos de la matriz.
- **No hay acceso directo a la suma**: Sin una estructura de datos previa que almacene la suma, es necesario visitar cada posición.
- **El orden de recorrido no afecta el resultado**: Sumar fila por fila o columna por columna produce el mismo resultado, pero el enfoque fila por fila es más natural y consistente con la memoria.

## 7. Complejidad esperada

### Complejidad temporal

- **Mejor caso**: `O(f * c)`, donde `f` es la cantidad de filas y `c` es la cantidad de columnas. Siempre se deben recorrer todos los elementos.
- **Caso promedio**: `O(f * c)`, porque se recorre la matriz completa en todos los casos.
- **Peor caso**: `O(f * c)`, cuando la matriz es grande y todos los elementos deben visitarse.

### Complejidad espacial

- **Espacio adicional**: `O(1)`, porque solo se utilizan variables para la suma acumulada, el contador de operaciones y los índices de los ciclos. No se crea ninguna estructura de datos auxiliar.

## 8. Contabilización de operaciones

El prompt debe solicitar que el programa cuente la cantidad de operaciones de suma realizadas. Cada vez que se ejecuta la línea `sumaTotal += matriz[fila][columna]`, se incrementa un contador.

La cantidad esperada de operaciones es `filas * columnas`, porque se realiza exactamente una suma por cada elemento de la matriz.

### Ejemplo

Para una matriz de 4 filas y 5 columnas:
- Total de elementos: 20
- Operaciones de suma: 20

## 9. Estructura del programa

El programa debe contener al menos:

- Una clase ejecutable con método `main`.
- Un método para generar la matriz aleatoria.
- Un método que recorra la matriz y calcule la suma, retornando también el conteo de operaciones.
- Un método o sección para mostrar la matriz formateada.
- Un método o sección para mostrar el análisis de complejidad.

No se requiere una jerarquía de clases ni una arquitectura compleja.

## 10. Entrada y salida

### Datos generados

El programa debe generar automáticamente la matriz sin solicitar datos por teclado.

### Salida esperada

El programa debe imprimir:

1. La matriz generada formateada.
2. La suma total de todos los elementos.
3. La cantidad de operaciones de suma realizadas.
4. El análisis de complejidad temporal y espacial.

### Ejemplo de salida

```
Matriz generada:
[12,  5, 23,  8, 15]
[ 3, 18,  7, 21, 10]
[16,  2, 14,  9, 25]
[ 6, 11, 19,  4, 20]

Suma total de todos los elementos: 228
Operaciones de suma realizadas: 20

--- Complejidad ---
Temporal: O(f * c) - Se recorre la matriz completa fila por fila.
Espacial: O(1) - Solo se utilizan variables auxiliares (suma, contador e indices).
```

## 11. Análisis de complejidad detallado

### Mejor caso

Cuando la matriz tiene dimensiones mínimas (1x1). El algoritmo realiza una sola operación de suma. Complejidad `O(1)` para matrices constantes, pero en general `O(f * c)`.

### Caso promedio

Cuando la matriz tiene dimensiones razonables (por ejemplo, 4x5). El algoritmo recorre todos los elementos realizando una suma por cada uno. Complejidad `O(f * c)`.

### Peor caso

Cuando la matriz es grande (por ejemplo, 100x100). El algoritmo recorre todos los elementos realizando muchas operaciones. Complejidad `O(f * c)`.

### Espacio adicional

Solo se utilizan:

- Una variable entera para la suma acumulada.
- Una variable entera para el contador de operaciones.
- Dos variables enteras para los índices de fila y columna.
- No se crean arreglos, listas, conjuntos u otras estructuras auxiliares.

Espacio adicional: `O(1)`.

## 12. Casos límite

La implementación debe contemplar:

- Matriz de 1x1 (un solo elemento).
- Matriz de 1 fila y múltiples columnas.
- Matriz de múltiples filas y 1 columna.
- Matriz cuadrada (mismas filas que columnas).
- Matriz rectangular (diferente cantidad de filas y columnas).
- Matriz con todos los elementos iguales.
- Matriz con valores negativos, cero y positivos.
- Matriz con valores extremos del rango generado.
- Matriz con todos los elementos en cero (suma = 0).

## 13. Documentación Javadoc requerida

El código debe incluir Javadoc para:

- La clase principal.
- El método `main`.
- El método que genera la matriz.
- El método que muestra la matriz formateada.
- El método que calcula la suma y cuenta operaciones.

La documentación debe explicar:

- El objetivo del algoritmo.
- La estrategia de recorrido con dos ciclos anidados.
- Por qué se recorre fila por fila.
- La contabilización de operaciones.
- Las complejidades temporal O(f * c) y espacial O(1).
- El significado de f y c en la complejidad.

## 14. Prompt final para OpenCode

> Implementá en Java 21 un programa sencillo que calcule la suma de todos los elementos de una matriz de números enteros, contabilizando la cantidad de operaciones realizadas.
>
> **Generación de datos:** El programa debe generar automáticamente una matriz de 4 filas y 5 columnas con valores enteros aleatorios entre 1 y 50. Mostrá la matriz generada formateada antes de ejecutar el cálculo.
>
> **Algoritmo de suma:** Implementá un método que recorra la matriz completa utilizando dos ciclos anidados. El ciclo externo debe recorrer las filas desde 0 hasta filas-1. El ciclo interno debe recorrer las columnas desde 0 hasta columnas-1. En cada posición, sumá el elemento `matriz[fila][columna]` a una variable acumuladora llamada `sumaTotal`. Simultáneamente, incrementá un contador de operaciones cada vez que realices una suma.
>
> **Contabilización de operaciones:** Cada ejecución de la línea `sumaTotal += matriz[fila][columna]` cuenta como una operación. El contador debe iniciarse en 0 y finalizar con un valor igual a filas * columnas, porque se realiza exactamente una suma por cada elemento de la matriz.
>
> **Justificación del recorrido:** Documentá con Javadoc por qué es necesario recorrer toda la matriz. Explicá que la suma total requiere visitar cada posición, que no hay acceso directo al resultado sin recorrer los datos, y que el orden de recorrido (fila por fila) es natural y consistente con la forma en que se almacenan las matrices en memoria.
>
> **Complejidad:** Analizá la complejidad temporal y espacial. Indicá que la complejidad temporal es O(f * c) donde f es la cantidad de filas y c la cantidad de columnas, porque se realiza exactamente una operación por cada elemento. Explicá que la complejidad espacial es O(1) porque solo se utilizan variables auxiliares para la suma, el contador y los índices.
>
> **Documentación:** Documentá con Javadoc la clase, el `main`, el método de generación, el método de muestra formateada y el método de cálculo. Explicá que este es un ejemplo de recorrido de matriz con ciclos anidados, y que la cantidad de operaciones siempre es filas * columnas independientemente de los valores almacenados.
>
> **Salida:** El programa debe imprimir la matriz formateada, la suma total, la cantidad de operaciones realizadas y el análisis de complejidad. No debe solicitar datos por teclado.

## 15. Criterios de aceptación

La implementación será aceptada si:

- Compila correctamente con Java 21.
- Genera automáticamente la matriz sin solicitar datos por teclado.
- Implementa un método que recorra la matriz con dos ciclos anidados.
- El ciclo externo recorre las filas y el interno las columnas.
- Calcula correctamente la suma de todos los elementos.
- Contabiliza explícitamente la cantidad de operaciones de suma.
- La cantidad de operaciones es igual a filas * columnas.
- Muestra la matriz formateada antes del cálculo.
- Informa la suma total y el conteo de operaciones.
- Incluye un análisis de complejidad temporal O(f * c) y espacial O(1).
- Utiliza Javadoc para documentar la clase, métodos y análisis de complejidad.
- Está ubicada en una carpeta independiente de los ejercicios anteriores.
- El código es claro, legible y adecuado para un contexto académico.
- No utiliza librerías externas ni métodos predefinidos de suma de matrices.
