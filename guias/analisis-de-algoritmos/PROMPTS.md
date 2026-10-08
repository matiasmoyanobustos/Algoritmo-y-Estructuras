# Prompts para OpenCode

Los prompts siguientes se pueden usar individualmente. Cada uno solicita una solución Java 21 independiente para el ejercicio correspondiente. Deben guardarse en el archivo/clase indicado dentro de `src/`, sin dependencias externas ni entrada interactiva.

## Ejercicio 1 — Encontrar el mínimo de un vector

> Implementá en Java 21 una clase independiente llamada `Ejercicio01Minimo` con un método que encuentre y devuelva el menor entero de un arreglo `int[]`. Usá un único recorrido: inicializá el mínimo con el primer elemento y actualizalo al encontrar un valor menor. Justificá esta estrategia: permite examinar todos los valores sin reordenarlos, y ordenar sería trabajo adicional innecesario. Indicá complejidad temporal O(n) y espacial adicional O(1). Rechazá explícitamente un arreglo nulo o vacío mediante un error claro. Incluí un `main` con ejemplos, incluido el arreglo vacío. Documentá con Javadoc la clase, la consigna, la estrategia, las complejidades y los métodos públicos; agregá comentarios que expliquen decisiones importantes.

## Ejercicio 2 — Buscar un elemento en un vector desordenado

> Implementá en Java 21 una clase independiente llamada `Ejercicio02BusquedaLineal` que busque un entero en un arreglo desordenado mediante búsqueda lineal. Explicá que, al no estar ordenados los datos, no se puede descartar una parte del arreglo antes de inspeccionarla. El resultado debe informar el índice de la primera coincidencia (o -1) y la cantidad de posiciones examinadas: detenete al encontrarlo y, si no existe, recorre todo el arreglo. Analizá mejor caso O(1), peor caso O(n) y promedio O(n), suponiendo posición de éxito uniformemente distribuida; espacio adicional O(1). Admití arreglos vacíos. Incluí ejemplos de acierto al inicio y al final, ausencia y arreglo vacío. Usá Javadoc para la consigna, estrategia, complejidades, parámetros, resultado y errores; comentá las decisiones relevantes.

## Ejercicio 3 — Buscar un elemento en un vector ordenado

> Implementá en Java 21 una clase independiente llamada `Ejercicio03BusquedaBinaria` que busque un valor usando búsqueda binaria iterativa sobre un `int[]` ordenado ascendentemente. Explicá que cada comparación permite descartar la mitad del intervalo, por eso es más eficiente que buscar linealmente: O(log n) frente a O(n); el espacio adicional debe ser O(1). Tratá el orden ascendente como precondición, sin ordenar el arreglo dentro del algoritmo. En cada paso imprimí los índices izquierdo, derecho y medio, el valor central y la decisión que actualiza los límites. Devolvé el índice encontrado o -1. Demostrá casos de extremos, ausente, arreglo vacío y unitario. Documentá con Javadoc la consigna, estrategia, complejidades, precondiciones, métodos públicos y errores; agregá comentarios explicativos.

## Ejercicio 4 — Detectar elementos duplicados

> Implementá en Java 21 una clase independiente llamada `Ejercicio04Duplicados` con dos métodos para indicar si un arreglo `int[]` contiene valores repetidos. La primera solución debe comparar pares usando dos ciclos anidados, sin comparar un índice consigo mismo: peor caso O(n²), espacio adicional O(1). La segunda debe recorrer el arreglo usando `HashSet<Integer>` y detectar si un valor ya estaba presente: O(n) esperado y O(n) de espacio adicional. Las dos soluciones deben devolver el mismo resultado, detenerse al hallar el primer duplicado y admitir arreglo vacío. Compará sus complejidades en la salida de ejemplo y probá arreglos con y sin repetidos. Documentá con Javadoc la consigna, cada estrategia, complejidades, métodos públicos y errores; agregá comentarios en las decisiones relevantes.

## Ejercicio 5 — Contar ocurrencias

> Implementá en Java 21 una clase independiente llamada `Ejercicio05ContarOcurrencias` que cuente cuántas veces aparece un entero objetivo en un arreglo `int[]`. Recorré completamente el arreglo: encontrar una coincidencia no permite saber si hay más, por lo que son necesarias n inspecciones. Informá el conteo; un arreglo vacío debe producir cero. Indicá complejidad temporal O(n) y espacial adicional O(1). Incluí ejemplos con varias apariciones, valor ausente y arreglo vacío. Documentá con Javadoc la consigna, estrategia, justificación, complejidades, métodos públicos y errores; agregá comentarios explicativos donde aporten claridad.

## Ejercicio 6 — Comparar dos vectores

> Implementá en Java 21 una clase independiente llamada `Ejercicio06CompararVectores` que determine si dos arreglos `int[]` son iguales: deben tener misma longitud y mismos valores en los mismos índices. Compará primero las longitudes y, si coinciden, detenete inmediatamente al hallar la primera diferencia. Analizá mejor caso O(1), peor caso O(n) y caso promedio O(n) cuando típicamente se comparan una fracción significativa de los elementos antes de una diferencia o de concluir igualdad; espacio adicional O(1). Incluí ejemplos de arreglos iguales, distinta longitud, diferencia inicial, diferencia final y dos arreglos vacíos. Documentá con Javadoc la consigna, estrategia, complejidades, métodos públicos y errores, con comentarios sobre la finalización anticipada.

## Ejercicio 7 — Invertir un vector

> Implementá en Java 21 una clase independiente llamada `Ejercicio07InvertirVector` con dos versiones para invertir un arreglo de enteros. La versión auxiliar debe crear y devolver un arreglo nuevo en orden inverso, preservando el original: tiempo O(n), espacio adicional O(n). La versión in-place debe intercambiar los extremos hacia el centro, modificar el arreglo recibido, y usar tiempo O(n) y espacio adicional O(1). Compará ventajas y desventajas de las dos implementaciones en la salida de ejemplo. Contemplá arreglos vacíos, unitarios, pares e impares. Documentá con Javadoc la consigna, estrategia, complejidades y efectos laterales de cada método público; agregá comentarios explicativos.

## Ejercicio 8 — Sumar todos los elementos de una matriz

> Implementá en Java 21 una clase independiente llamada `Ejercicio08SumaMatriz` que sume los elementos de un arreglo bidimensional `int[][]`, recorriendo fila por fila y columna por columna. Devolvé o informá la suma y un contador de operaciones. Definí una operación como sumar un elemento de la matriz al acumulador, así el contador coincide con la cantidad de elementos procesados. Para f filas y c columnas rectangulares, indicá tiempo O(f·c) y espacio adicional O(1). Una matriz sin elementos debe dar suma cero y cero operaciones. Incluí ejemplos de matriz común, vacía y con filas vacías. Documentá con Javadoc la consigna, estrategia, complejidades y métodos públicos; comentá el criterio usado para contar operaciones.

## Ejercicio 9 — Encontrar el mayor elemento de una matriz

> Implementá en Java 21 una clase independiente llamada `Ejercicio09MayorMatriz` que encuentre el valor máximo de un `int[][]` mediante un recorrido completo. Inicializá el máximo con el primer elemento encontrado, no con cero, para manejar correctamente matrices de valores negativos. Justificá que es necesario inspeccionar todos los elementos: cualquiera podría contener el máximo. Indicá tiempo O(f·c) y espacio adicional O(1). Rechazá claramente la matriz nula o sin elementos. Incluí ejemplos de valores negativos y de matriz vacía. Documentá con Javadoc la consigna, estrategia, justificación, complejidades, métodos públicos y errores; agregá comentarios relevantes.

## Ejercicio 10 — Ordenamiento burbuja

> Implementá en Java 21 una clase independiente llamada `Ejercicio10BubbleSort` que ordene un arreglo `int[]` en orden ascendente con Bubble Sort y finalización anticipada si una pasada no realiza intercambios. Modificá el arreglo in-place y contabilizá comparaciones entre adyacentes e intercambios, mostrando ambos contadores. Explicá que Bubble Sort sirve principalmente para fines didácticos o conjuntos pequeños: su tiempo promedio y peor caso es O(n²), por lo que es ineficiente con conjuntos grandes comparado con métodos O(n log n). Con la optimización, el mejor caso es O(n); el espacio adicional es O(1). Probá arreglos vacío, unitario, ordenado, inverso y con repetidos. Documentá con Javadoc la consigna, estrategia, complejidades, efectos laterales y métodos públicos; explicá mediante comentarios la salida anticipada.
