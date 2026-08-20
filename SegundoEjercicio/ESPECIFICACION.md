# Especificación: Búsqueda en vector mediante ordenamiento burbuja

## 1. Objetivo del proyecto

Desarrollar un programa sencillo en Java 21 que genere aleatoriamente un vector de números enteros y un elemento buscado, ordene el vector mediante el algoritmo burbuja y luego busque linealmente el elemento dentro del vector ordenado.

El programa debe informar si el elemento existe, su posición dentro del vector ordenado y la cantidad de posiciones recorridas hasta encontrarlo. Si el elemento no existe, debe informar que no fue encontrado y cuántas posiciones se recorrieron para determinarlo.

Este ejercicio debe mantenerse separado del primer ejercicio mediante una carpeta propia dentro del proyecto.

## 2. Requisitos funcionales

El programa debe:

- Estar implementado en Java 21.
- Generar automáticamente los elementos del vector con valores aleatorios.
- Generar automáticamente el valor entero que se desea buscar.
- Ordenar el vector utilizando exclusivamente el algoritmo burbuja.
- Buscar el valor solicitado recorriendo el vector ordenado desde la primera posición.
- Informar si el elemento fue encontrado.
- Informar la posición del elemento cuando exista.
- Informar la cantidad de posiciones recorridas en todos los casos.
- Informar que el elemento no existe cuando la búsqueda finalice sin encontrarlo.
- Permitir valores repetidos en el vector.

## 3. Requisitos no funcionales

- El código debe ser claro, legible y adecuado para un contexto académico.
- Debe utilizar únicamente las clases estándar necesarias de Java 21.
- El algoritmo de ordenamiento debe ser reconocible y estar implementado manualmente; no se deben utilizar métodos de ordenamiento de bibliotecas.
- El código debe incluir comentarios Javadoc en la clase y los métodos principales.
- La salida debe ser clara y no debe incluir información que no sea solicitada.

## 4. Restricciones

- Lenguaje: Java 21.
- No se requiere entrada por teclado; los datos se generan automáticamente.
- El vector no debe considerarse ordenado inicialmente.
- La estrategia obligatoria de ordenamiento es burbuja.
- La búsqueda posterior debe ser lineal, recorriendo el vector ordenado desde el principio.
- Se permite que existan valores repetidos.
- No se requiere utilizar búsqueda binaria, aunque el vector quede ordenado.
- El ejercicio debe estar ubicado en una carpeta independiente del primer ejercicio, por ejemplo `SegundoEjercicio`.

## 5. Entrada y salida

### Datos generados

El programa debe utilizar una cantidad fija y sencilla de elementos, por ejemplo
`10`, y generar cada valor aleatoriamente dentro de un rango razonable, por
ejemplo entre `1` y `50`. El valor buscado también debe generarse aleatoriamente
dentro del mismo rango. Por este motivo, en algunas ejecuciones el elemento
puede existir y en otras no.

### Salida cuando el elemento existe

La salida debe indicar:

- Que el elemento fue encontrado.
- La posición que ocupa en el vector ordenado.
- La cantidad de posiciones recorridas hasta encontrarlo.

La posición debe utilizar un criterio definido y consistente. Se recomienda utilizar índices desde cero y documentarlo en los comentarios Javadoc o en el texto de salida.

### Salida cuando el elemento no existe

La salida debe indicar:

- Que el elemento no fue encontrado.
- Que se recorrieron las `n` posiciones del vector para comprobarlo.

## 6. Entidades, clases y responsabilidades

Se recomienda una clase ejecutable con un método `main` y dos métodos auxiliares:

- Método de ordenamiento burbuja: recibe el vector y lo ordena de menor a mayor mediante intercambios entre elementos adyacentes.
- Método de búsqueda lineal: recibe el vector ordenado y el valor buscado; devuelve o comunica la posición encontrada y la cantidad de posiciones recorridas.

No se requiere una jerarquía de clases ni una arquitectura compleja.

## 7. Estrategia de ordenamiento

El algoritmo burbuja debe comparar elementos adyacentes y realizar un intercambio cuando estén en el orden incorrecto. En cada pasada, el mayor elemento pendiente se desplaza hacia el final del segmento no ordenado.

Se puede incorporar una bandera que indique si hubo intercambios durante una pasada. Si no hubo intercambios, el vector ya está ordenado y el algoritmo puede finalizar anticipadamente.

El ordenamiento se realiza antes de la búsqueda, tal como se solicitó. Por ese motivo, las posiciones de los elementos pueden cambiar respecto del vector original.

## 8. Estrategia de búsqueda

Después de ordenar el vector, se debe realizar una búsqueda lineal:

1. Comenzar en el índice cero.
2. Comparar el elemento actual con el valor buscado.
3. Incrementar el contador de posiciones recorridas por cada posición examinada.
4. Si coinciden, finalizar e informar el índice actual.
5. Si se llega al final sin coincidencia, informar que el elemento no existe.

Si existen valores repetidos, se debe informar la primera aparición que se encuentre durante el recorrido del vector ordenado. En consecuencia, la posición informada es la primera posición del valor dentro del vector ordenado.

La cantidad de posiciones recorridas se interpreta de la siguiente manera:

- Si se encuentra en el índice `i`, se recorrieron `i + 1` posiciones.
- Si no se encuentra, se recorrieron `n` posiciones.

## 9. Análisis de complejidad

### Ordenamiento burbuja

- Mejor caso: `O(n)` si se utiliza la detección de una pasada sin intercambios y el vector ya está ordenado.
- Caso promedio: `O(n^2)`.
- Peor caso: `O(n^2)`, por ejemplo, cuando el vector está ordenado en sentido inverso.
- Espacio adicional: `O(1)`, porque se ordena el vector en el mismo arreglo y solo se utilizan variables auxiliares.

### Búsqueda lineal

- Mejor caso: `O(1)`, si el valor buscado se encuentra en la primera posición del vector ordenado.
- Caso promedio: `O(n)`, porque normalmente se examina una parte significativa del vector.
- Peor caso: `O(n)`, si el valor está en la última posición o no existe.
- Espacio adicional: `O(1)`.

### Complejidad total del programa

Como el ordenamiento se realiza antes de la búsqueda, el costo total queda dominado por el algoritmo burbuja:

- Mejor caso total: `O(n)`, considerando un vector ya ordenado y un elemento encontrado al inicio.
- Caso promedio total: `O(n^2)`.
- Peor caso total: `O(n^2)`.
- Espacio adicional total: `O(1)`.

## 10. Manejo de valores repetidos

El vector puede contener valores repetidos. La búsqueda debe detenerse en la primera coincidencia encontrada durante el recorrido ascendente del vector ordenado.

Debe aclararse que, al ordenar el vector, no se conserva necesariamente la posición original de cada aparición. La posición informada corresponde al vector ordenado y utiliza índices desde cero.

## 11. Casos límite

La implementación debe contemplar:

- Vector con un solo elemento.
- Elemento buscado ubicado originalmente en la primera posición.
- Elemento buscado ubicado originalmente en la última posición.
- Elemento buscado que queda en la primera posición después de ordenar.
- Elemento buscado que queda en la última posición después de ordenar.
- Elemento buscado inexistente.
- Todos los elementos iguales.
- Valores negativos, cero y positivos.
- Vector inicialmente ordenado, para evaluar el mejor caso de burbuja.
- Vector ordenado en sentido inverso, para evaluar el peor caso de burbuja.
- Valores repetidos.

## 12. Documentación requerida

El desarrollador debe incorporar Javadoc que explique:

- El objetivo de la clase.
- El formato de entrada y salida.
- La responsabilidad del método de ordenamiento burbuja.
- La responsabilidad del método de búsqueda lineal.
- El significado del contador de posiciones recorridas.
- El criterio utilizado para informar la posición cuando hay repetidos.
- Las complejidades del ordenamiento, de la búsqueda y del programa completo.

## 13. Orden recomendado de implementación

1. Crear la carpeta independiente `SegundoEjercicio`.
2. Crear la clase Java ejecutable dentro de esa carpeta.
3. Generar el vector y el valor buscado con `Random`.
4. Implementar el ordenamiento burbuja ascendente.
5. Implementar la optimización de finalización temprana cuando no haya intercambios.
6. Implementar la búsqueda lineal y el contador de posiciones recorridas.
7. Informar el vector original, el vector ordenado, el valor buscado y el resultado.
8. Agregar la documentación Javadoc.
9. Compilar con Java 21.
10. Ejecutar varias veces para observar los casos encontrado y no encontrado.

## 14. Criterios de aceptación

La implementación será aceptada si:

- Compila correctamente con Java 21.
- Genera automáticamente el vector y el valor buscado sin solicitar datos por teclado.
- Ordena el vector utilizando el algoritmo burbuja implementado manualmente.
- Busca el valor luego del ordenamiento mediante un recorrido lineal.
- Informa la posición con índices desde cero cuando encuentra el elemento.
- Informa correctamente cuántas posiciones recorrió.
- Informa que el elemento no existe después de recorrer todo el vector cuando corresponde.
- Funciona con valores repetidos, informando la primera aparición en el vector ordenado.
- Incluye Javadoc suficiente para explicar la solución y su análisis de mejor caso, peor caso y caso promedio.
- Está ubicada en una carpeta separada del primer ejercicio.
