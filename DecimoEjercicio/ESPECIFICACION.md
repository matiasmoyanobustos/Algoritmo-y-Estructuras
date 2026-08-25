# Especificación: Algoritmo de ordenamiento Bubble Sort

## 1. Objetivo del proyecto

Crear un prompt en español para OpenCode que solicite la implementación en Java 21 del algoritmo de ordenamiento Bubble Sort (ordenamiento burbuja) para un vector de números enteros.

El prompt debe explicar por qué este algoritmo resulta adecuado únicamente para fines didácticos o conjuntos pequeños de datos, y solicitar que el programa contabilice la cantidad de comparaciones e intercambios realizados durante el ordenamiento.

Este ejercicio debe mantenerse separado de los ejercicios anteriores mediante una carpeta propia dentro del proyecto.

## 2. Requisitos funcionales

El prompt debe solicitar que OpenCode:

- Implemente el programa en Java 21.
- Genere automáticamente un vector de números enteros con valores aleatorios.
- Implemente el algoritmo Bubble Sort para ordenar el vector de menor a mayor.
- Contabilice la cantidad de comparaciones realizadas.
- Contabilice la cantidad de intercambios realizados.
- Muestre el vector original antes del ordenamiento.
- Muestre el vector ordenado después del ordenamiento.
- Informe las estadísticas de comparaciones e intercambios.
- Explique por qué Bubble Sort es adecuado solo para fines didácticos.
- Incluya un análisis completo de la complejidad temporal y espacial.
- Incluya documentación Javadoc que explique el algoritmo y su análisis.

## 3. Requisitos no funcionales

- El código debe ser comprensible para un estudiante de estructuras de datos y algoritmos.
- No debe utilizar librerías externas.
- No debe utilizar métodos de ordenamiento de bibliotecas.
- El algoritmo debe implementarse manualmente con ciclos anidados.
- La contabilización de comparaciones e intercambios debe ser explícita.
- El código debe incluir comentarios Javadoc en la clase y los métodos principales.
- La salida debe ser clara y no debe incluir información que no sea solicitada.

## 4. Restricciones y decisiones técnicas

- Lenguaje: Java.
- Versión: Java 21.
- Entrada: generación automática de datos aleatorios.
- El algoritmo debe ordenar de menor a mayor.
- Se debe implementar la versión optimizada con bandera de intercambio.
- La optimización permite finalizar anticipadamente si no hay intercambios en una pasada.
- Se debe contar cada comparación y cada intercambio realizado.

## 5. Generación de datos

El programa debe generar automáticamente el vector con las siguientes características:

### Vector

- Cantidad de elementos: por ejemplo, `10` elementos.
- Rango de valores: por ejemplo, entre `1` y `50`.
- El vector se muestra antes y después del ordenamiento.

Ejemplo de datos generados:

```
Vector original:  [34, 12, 45, 7, 28, 3, 41, 18, 50, 23]
Vector ordenado:  [3, 7, 12, 18, 23, 28, 34, 41, 45, 50]
Comparaciones: 45
Intercambios: 28
```

## 6. Algoritmo Bubble Sort

### Estrategia

El algoritmo Bubble Sort recorre el vector múltiples veces. En cada pasada, compara elementos adyacentes y los intercambia si están en el orden incorrecto (el mayor a la derecha del menor). Después de cada pasada, el mayor elemento sin ordenar se "burbujea" hacia su posición final.

### Algoritmo paso a paso

1. Recorrer el vector con un ciclo externo desde `limite = n - 1` hasta `1`.
2. Para cada pasada, recorrer con un ciclo interno desde `j = 0` hasta `limite - 1`.
3. Comparar `vector[j]` con `vector[j + 1]`.
4. Si `vector[j] > vector[j + 1]`, intercambiar ambos elementos.
5. Incrementar el contador de comparaciones.
6. Si se realizó un intercambio, incrementar el contador de intercambios.
7. Si no hubo intercambios en una pasada completa, el vector ya está ordenado y se puede finalizar.

### Optimización con bandera

Se puede incorporar una bandera `huboIntercambio` que indique si hubo intercambios durante una pasada. Si no hubo intercambios, el vector ya está ordenado y el algoritmo puede finalizar anticipadamente. Esta optimización mejora el mejor caso de `O(n^2)` a `O(n)`.

## 7. Complejidad esperada

### Complejidad temporal

- **Mejor caso**: `O(n)`, cuando el vector ya está ordenado y se utiliza la optimización con bandera. Solo se realiza una pasada sin intercambios.
- **Caso promedio**: `O(n^2)`, porque se realizan aproximadamente `n^2 / 2` comparaciones.
- **Peor caso**: `O(n^2)`, cuando el vector está ordenado en sentido inverso. Se realizan `n * (n-1) / 2` comparaciones y la misma cantidad de intercambios.

### Complejidad espacial

- **Espacio adicional**: `O(1)`, porque el ordenamiento se realiza in-place. Solo se utilizan variables auxiliares para los ciclos, el intercambio temporal y la bandera.

## 8. Justificación de su uso limitado

El prompt debe solicitar que se explique por qué Bubble Sort es adecuado solo para fines didácticos:

### Limitaciones del algoritmo

- **Ineficiencia para grandes volúmenes de datos**: Con `O(n^2)` en el caso promedio y peor, es demasiado lento para vectores grandes.
- **Muchas comparaciones innecesarias**: Se comparan elementos que ya están en su posición correcta.
- **Intercambios excesivos**: Cada intercambio requiere tres operaciones de asignación.
- **No escala bien**: Mientras Quick Sort o Merge Sort manejan millones de elementos eficientemente, Bubble Sort se vuelve inviable rápidamente.

### Cuándo podría usarse

- **Fines didácticos**: Es fácil de entender e implementar, ideal para aprender conceptos de ordenamiento.
- **Vectores muy pequeños**: Para vectores de menos de 10-20 elementos, la diferencia de rendimiento es despreciable.
- **Vectores casi ordenados**: Con la optimización, puede ser eficiente si el vector necesita pocas correcciones.
- **Cuando la simplicidad es prioritaria**: Cuando no se requiere rendimiento y se busca la implementación más simple.

### Comparación con otros algoritmos

| Algoritmo      | Mejor caso | Promedio  | Peor caso | Espacio  |
|----------------|------------|-----------|-----------|----------|
| Bubble Sort    | O(n)       | O(n^2)   | O(n^2)   | O(1)     |
| Selection Sort | O(n^2)     | O(n^2)   | O(n^2)   | O(1)     |
| Insertion Sort | O(n)       | O(n^2)   | O(n^2)   | O(1)     |
| Quick Sort     | O(n log n) | O(n log n)| O(n^2)  | O(log n) |
| Merge Sort     | O(n log n) | O(n log n)| O(n log n)| O(n)  |

## 9. Estructura del programa

El programa debe contener al menos:

- Una clase ejecutable con método `main`.
- Un método para generar el vector aleatorio.
- Un método que implemente el algoritmo Bubble Sort con contadores de comparaciones e intercambios.
- Un método o sección para mostrar la justificación y el análisis de complejidad.

No se requiere una jerarquía de clases ni una arquitectura compleja.

## 10. Entrada y salida

### Datos generados

El programa debe generar automáticamente el vector sin solicitar datos por teclado.

### Salida esperada

El programa debe imprimir:

1. El vector original.
2. El vector ordenado.
3. La cantidad de comparaciones realizadas.
4. La cantidad de intercambios realizados.
5. La justificación de por qué Bubble Sort es adecuado solo para fines didácticos.
6. El análisis de complejidad temporal y espacial.

### Ejemplo de salida

```
Vector original:  [34, 12, 45, 7, 28, 3, 41, 18, 50, 23]
Vector ordenado:  [3, 7, 12, 18, 23, 28, 34, 41, 45, 50]

Estadisticas:
Comparaciones: 45
Intercambios: 28

--- Justificacion ---
Bubble Sort es adecuado para fines didacticos porque es facil de entender
e implementar. Sin embargo, su complejidad O(n^2) lo hace ineficiente para
grandes volumenes de datos. Para vectores de más de 1000 elementos, se
recomienda usar algoritmos como Quick Sort o Merge Sort con complejidad
O(n log n).

--- Complejidad ---
Mejor caso:    O(n)   - Vector ya ordenado (con optimizacion).
Caso promedio: O(n^2) - Muchas comparaciones e intercambios.
Peor caso:     O(n^2) - Vector ordenado en sentido inverso.
Espacial:      O(1)   - Ordenamiento in-place sin estructuras auxiliares.
```

## 11. Análisis de complejidad detallado

### Mejor caso

Cuando el vector ya está ordenado de menor a mayor. Con la optimización, solo se realiza una pasada completa sin intercambios. El algoritmo detecta que no hubo intercambios y finaliza. Complejidad `O(n)`.

### Caso promedio

Cuando el vector está desordenado aleatoriamente. Se realizan aproximadamente `n^2 / 2` comparaciones y una cantidad proporcional de intercambios. Complejidad `O(n^2)`.

### Peor caso

Cuando el vector está ordenado en sentido inverso (de mayor a menor). Se realizan `n * (n-1) / 2` comparaciones y la misma cantidad de intercambios. Complejidad `O(n^2)`.

### Espacio adicional

Solo se utilizan:

- Una variable para el límite del ciclo externo.
- Una variable para el índice del ciclo interno.
- Una variable temporal para el intercambio.
- Una variable booleana para la bandera de intercambio.
- Dos contadores para comparaciones e intercambios.

No se crean arreglos, listas, conjuntos u otras estructuras auxiliares. Espacio adicional: `O(1)`.

## 12. Casos límite

La implementación debe contemplar:

- Vector con un solo elemento (ya está ordenado).
- Vector con dos elementos (se comparan una vez).
- Vector ya ordenado (mejor caso, sin intercambios).
- Vector ordenado en sentido inverso (peor caso, muchos intercambios).
- Vector con todos los elementos iguales (sin intercambios).
- Vector con valores negativos, cero y positivos.
- Vector con valores repetidos.
- Valores extremos del rango generado.

## 13. Documentación Javadoc requerida

El código debe incluir Javadoc para:

- La clase principal.
- El método `main`.
- El método que genera el vector.
- El método que implementa Bubble Sort.

La documentación debe explicar:

- El funcionamiento del algoritmo (comparación de adyacentes e intercambio).
- La optimización con bandera de intercambio.
- La justificación de por qué es adecuado solo para fines didácticos.
- Las comparaciones con otros algoritmos.
- Las complejidades temporal y espacial.
- El mejor caso O(n), caso promedio O(n^2) y peor caso O(n^2).

## 14. Prompt final para OpenCode

> Implementá en Java 21 un programa sencillo que ordene un vector de números enteros utilizando el algoritmo Bubble Sort.
>
> **Generación de datos:** El programa debe generar automáticamente un vector de 10 enteros con valores aleatorios entre 1 y 50. Mostrá el vector original antes del ordenamiento.
>
> **Algoritmo Bubble Sort:** Implementá un método que ordene el vector de menor a mayor utilizando comparaciones de elementos adyacentes. El ciclo externo recorre desde `limite = n-1` hasta 1. El ciclo interno recorre desde 0 hasta `limite - 1`. En cada posición, compará `vector[j]` con `vector[j + 1]`. Si `vector[j] > vector[j + 1]`, intercambiá ambos elementos.
>
> **Optimización:** Incorporá una bandera `huboIntercambio` que se active cuando se realiza un intercambio. Si una pasada completa no genera intercambios, el vector ya está ordenado y el algoritmo puede finalizar anticipadamente.
>
> **Contabilización:** Contá cada comparación realizada y cada intercambio realizado. Al finalizar, informá ambas cantidades.
>
> **Justificación:** Documentá con Javadoc por qué Bubble Sort es adecuado solo para fines didácticos o conjuntos pequeños. Explicá que su complejidad O(n^2) lo hace ineficiente para grandes volúmenes de datos, que existen algoritmos como Quick Sort o Merge Sort con O(n log n), y que solo es válido para vectores muy pequeños o casi ordenados.
>
> **Complejidad:** Analizá la complejidad temporal y espacial. Indicá que el mejor caso es O(n) con la optimización, el caso promedio y peor son O(n^2), y el espacio adicional es O(1) porque el ordenamiento es in-place.
>
> **Documentación:** Documentá con Javadoc la clase, el `main`, el método de generación y el método de ordenamiento. Incluí una comparación con otros algoritmos para que el estudiante entienda cuándo usar cada uno.
>
> **Salida:** El programa debe imprimir el vector original, el vector ordenado, las estadísticas de comparaciones e intercambios, la justificación y el análisis de complejidad. No debe solicitar datos por teclado.

## 15. Criterios de aceptación

La implementación será aceptada si:

- Compila correctamente con Java 21.
- Genera automáticamente el vector sin solicitar datos por teclado.
- Implementa el algoritmo Bubble Sort con ciclos anidados.
- Utiliza la optimización con bandera de intercambio.
- Ordena el vector correctamente de menor a mayor.
- Contabiliza explícitamente las comparaciones e intercambios.
- Muestra el vector original y el vector ordenado.
- Incluye una justificación de por qué Bubble Sort es adecuado solo para fines didácticos.
- Incluye un análisis de complejidad con mejor caso O(n), promedio O(n^2) y peor O(n^2).
- Incluye el análisis de complejidad espacial O(1).
- Utiliza Javadoc para documentar la clase, métodos y análisis de complejidad.
- Está ubicada en una carpeta independiente de los ejercicios anteriores.
- El código es claro, legible y adecuado para un contexto académico.
- No utiliza librerías externas ni métodos predefinidos de ordenamiento.
