# Especificación: Detección de elementos duplicados en un vector

## 1. Objetivo del proyecto

Crear un prompt en español para OpenCode que solicite la implementación en Java 21 de dos soluciones diferentes para detectar elementos duplicados dentro de un vector de números enteros.

La primera solución debe utilizar dos ciclos anidados para comparar cada par de elementos. La segunda solución debe utilizar una estructura `HashSet` para identificar duplicados de manera más eficiente. Además, el prompt debe solicitar una comparación explícita entre ambas implementaciones desde el punto de vista de la complejidad temporal y espacial.

Este ejercicio debe mantenerse separado de los ejercicios anteriores mediante una carpeta propia dentro del proyecto.

## 2. Requisitos funcionales

El prompt debe solicitar que OpenCode:

- Implemente el programa en Java 21.
- Genere automáticamente un vector de números enteros con valores aleatorios que contenga al menos algunos duplicados para garantizar que ambas soluciones tengan resultados que comparar.
- Implemente una solución usando dos ciclos anidados (fuerza bruta) que recorra todos los pares posibles.
- Implemente una segunda solución usando `HashSet` que inserte elementos y detecte duplicados al intentar agregar un elemento ya existente.
- Ejecute ambas soluciones sobre el mismo vector para garantizar la comparabilidad de resultados.
- Muestre los duplicados encontrados por cada solución.
- Realice una comparación explícita de la complejidad temporal y espacial de ambas soluciones.
- Incluya documentación Javadoc que explique cada enfoque y su análisis de complejidad.

## 3. Requisitos no funcionales

- El código debe ser comprensible para un estudiante de estructuras de datos y algoritmos.
- No debe utilizar librerías externas.
- La solución de fuerza bruta debe implementarse manualmente con ciclos anidados.
- La solución con `HashSet` debe utilizar la implementación estándar de Java.
- La comparación de complejidades debe ser clara y estar documentada.
- El código debe incluir comentarios Javadoc en la clase y los métodos principales.
- La salida debe ser clara y no debe incluir información que no sea solicitada.

## 4. Restricciones y decisiones técnicas

- Lenguaje: Java.
- Versión: Java 21.
- Entrada: generación automática de datos aleatorios.
- El vector debe contener valores repetidos para que ambas soluciones encuentren duplicados.
- La solución de fuerza bruta debe usar exactamente dos ciclos anidados.
- La solución con `HashSet` debe detectar duplicados al intentar insertar un elemento que ya existe.
- Las posiciones de los duplicados deben informarse utilizando índices desde cero.
- Se debe generar el vector de tal forma que garantice la existencia de al menos un duplicado.

## 5. Generación de datos

El programa debe generar automáticamente un vector de enteros con las siguientes características:

- Cantidad de elementos: por ejemplo, `15` elementos.
- Rango de valores: por ejemplo, entre `1` y `20`, lo que garantiza matemáticamente la existencia de duplicados (principio del palomar).
- Los valores deben mostrarse antes de ejecutar cada solución.

Ejemplo de vector generado:

```
[5, 3, 8, 3, 5, 12, 8, 1, 15, 3, 5, 20, 8, 1, 12]
```

Duplicados esperados: `5`, `3`, `8`, `1`, `12`.

## 6. Solución 1: Fuerza bruta con ciclos anidados

### Estrategia

La solución debe comparar cada elemento del vector con todos los elementos que lo siguen. Para cada posición `i`, se recorren las posiciones `j` desde `i + 1` hasta el final del vector. Si `vector[i] == vector[j]`, se identifica un duplicado.

### Algoritmo paso a paso

1. Recorrer el vector con un ciclo externo desde `i = 0` hasta `n - 1`.
2. Para cada `i`, recorrer con un ciclo interno desde `j = i + 1` hasta `n - 1`.
3. Comparar `vector[i]` con `vector[j]`.
4. Si son iguales, registrar el valor como duplicado (evitando registros repetidos si el mismo valor aparece más de dos veces).
5. Al finalizar, mostrar la lista de duplicados encontrados.

### Complejidad esperada

- **Temporal**: `O(n^2)`, porque se realizan `n * (n-1) / 2` comparaciones en el peor caso.
- **Espacial**: `O(1)` adicional, porque solo se utilizan variables auxiliares para controlar los ciclos y almacenar resultados temporales. Sin embargo, si se almacenan los duplicados encontrados en una lista, el espacio puede ser `O(d)` donde `d` es la cantidad de duplicados.

## 7. Solución 2: Utilizando HashSet

### Estrategia

La solución debe utilizar un `HashSet` para almacenar los elementos ya vistos. Para cada elemento del vector, se intenta insertarlo en el conjunto. Si el método `add` retorna `false`, significa que el elemento ya existía y, por lo tanto, es un duplicado.

### Algoritmo paso a paso

1. Crear un `HashSet` vacío.
2. Recorrer el vector con un ciclo simple desde `i = 0` hasta `n - 1`.
3. Para cada elemento, intentar agregarlo al `HashSet`.
4. Si el método `add` retorna `false`, el elemento es un duplicado.
5. Registrar el duplicado encontrado.
6. Al finalizar, mostrar la lista de duplicados encontrados.

### Complejidad esperada

- **Temporal**: `O(n)`, porque cada inserción y búsqueda en `HashSet` tiene costo amortizado `O(1)`.
- **Espacial**: `O(n)` en el peor caso, porque el `HashSet` puede almacenar hasta `n` elementos si no hay duplicados. En el caso promedio con duplicados, el espacio es proporcional a la cantidad de elementos únicos.

## 8. Comparación de soluciones

El prompt debe solicitar que OpenCode incluya una comparación explícita entre ambas implementaciones:

### Tabla comparativa esperada

| Aspecto                | Fuerza bruta (ciclos anidados) | HashSet               |
|------------------------|-------------------------------|-----------------------|
| Complejidad temporal    | O(n²)                         | O(n)                  |
| Complejidad espacial    | O(1) u O(d)                   | O(n)                  |
| Legibilidad             | Alta                          | Alta                  |
| Uso de memoria          | Bajo                          | Moderado a alto       |
| Escalabilidad           | Baja para vectores grandes    | Alta para vectores grandes |
| Implementación          | Más verbosa                   | Más concisa           |

### Análisis esperado

El prompt debe pedir que se explique:

- Por qué la solución con `HashSet` es más rápida en vectores grandes.
- Por qué la solución de fuerza bruta usa menos memoria.
- En qué casos podría ser preferible cada solución.
- La importancia de la estructura de datos elegida en la eficiencia de un algoritmo.

## 9. Estructura del programa

El programa debe contener al menos:

- Una clase ejecutable con método `main`.
- Un método para generar el vector aleatorio con duplicados garantizados.
- Un método para la solución de fuerza bruta (ciclos anidados).
- Un método para la solución con `HashSet`.
- Un método o sección para mostrar la comparación de complejidades.

No se requiere una jerarquía de clases ni una arquitectura compleja.

## 10. Entrada y salida

### Datos generados

El programa debe generar automáticamente el vector sin solicitar datos por teclado.

### Salida esperada

El programa debe imprimir:

1. El vector generado.
2. Los duplicados encontrados por la solución de fuerza bruta.
3. Los duplicados encontrados por la solución con `HashSet`.
4. La comparación de complejidad temporal y espacial de ambas soluciones.

### Ejemplo de salida

```
Vector generado: [5, 3, 8, 3, 5, 12, 8, 1, 15, 3, 5, 20, 8, 1, 12]

--- Solucion 1: Fuerza bruta (ciclos anidados) ---
Duplicados encontrados: [5, 3, 8, 1, 12]

--- Solucion 2: HashSet ---
Duplicados encontrados: [5, 3, 8, 1, 12]

--- Comparacion de complejidad ---
Fuerza bruta:  Temporal O(n^2) | Espacial O(1)
HashSet:       Temporal O(n)   | Espacial O(n)
```

## 11. Análisis de complejidad detallado

### Solución de fuerza bruta

- **Mejor caso**: `O(n^2)` siempre, porque se deben recorrer todos los pares independientemente de los datos.
- **Peor caso**: `O(n^2)` cuando no hay duplicados o cuando todos los elementos son iguales.
- **Espacio adicional**: `O(1)` si solo se imprime cada duplicado al encontrarlo, o `O(d)` si se almacenan en una estructura.

### Solución con HashSet

- **Mejor caso**: `O(n)`, porque se recorre el vector una sola vez.
- **Peor caso**: `O(n)`, porque cada operación en el HashSet es amortizada `O(1)`.
- **Espacio adicional**: `O(n)` en el peor caso (todos los elementos son únicos), `O(u)` donde `u` es la cantidad de elementos únicos.

## 12. Manejo de valores repetidos

El vector generado debe contener valores repetidos para que ambas soluciones tengan resultados que comparar. La generación debe garantizar al menos un duplicado utilizando el principio del palomar: si se generan más elementos que el rango posible, al menos un valor se repetirá.

Ambas soluciones deben informar la lista de valores que aparecen más de una vez, sin duplicar dichos valores en la lista de resultados.

## 13. Casos límite

La implementación debe contemplar:

- Vector con un solo elemento (sin duplicados posibles).
- Vector con todos los elementos iguales.
- Vector donde todos los elementos son únicos (excepto uno repetido una vez).
- Vector con valores negativos, cero y positivos.
- Vector con un solo valor repetido múltiples veces.
- Vector con múltiples valores repetidos.
- Vector ordenado creciente, ordenado decreciente y desordenado.
- Valores extremos del rango generado.

## 14. Documentación Javadoc requerida

El código debe incluir Javadoc para:

- La clase principal.
- El método `main`.
- El método que genera el vector con duplicados garantizados.
- El método de fuerza bruta con ciclos anidados.
- El método con `HashSet`.

La documentación debe explicar:

- El objetivo de cada solución.
- La estrategia utilizada en cada caso.
- La complejidad temporal y espacial de cada implementación.
- Por qué el `HashSet` permite una detección más eficiente.
- El uso del principio del palomar para garantizar duplicados.

## 15. Prompt final para OpenCode

> Implementá en Java 21 un programa sencillo que detecte elementos duplicados dentro de un vector de números enteros utilizando dos soluciones diferentes, y que compare ambas implementaciones.
>
> **Generación de datos:** El programa debe generar automáticamente un vector de 15 enteros con valores aleatorios entre 1 y 20. Este rango garantiza que existan duplicados por el principio del palomar. Mostrá el vector generado antes de ejecutar cada solución.
>
> **Solución 1 - Fuerza bruta:** Implementá un método que utilize dos ciclos anidados para comparar cada par de elementos. Para cada posición `i`, recorré las posiciones `j` desde `i + 1` hasta el final del vector. Si `vector[i] == vector[j]`, registralo como duplicado. Evitá duplicar valores en la lista de resultados.
>
> **Solución 2 - HashSet:** Implementá un método que recorra el vector una sola vez. Para cada elemento, intentá agregarlo a un `HashSet`. Si el método `add` retorna `false`, el elemento ya existía y es un duplicado. Registrá el duplicado encontrado.
>
> **Comparación:** Imprimí una tabla o texto que compare ambas soluciones en complejidad temporal y espacial. Explicá por qué el `HashSet` es más eficiente en tiempo pero usa más memoria, y en qué situaciones podría preferirse cada enfoque.
>
> **Documentación:** Documentá con Javadoc la clase, el `main`, y cada método. Explicá que la fuerza bruta tiene complejidad `O(n^2)` temporal y `O(1)` espacial, mientras que el `HashSet` tiene `O(n)` temporal y `O(n)` espacial. Indicá que ambas soluciones encuentran los mismos duplicados.
>
> **Salida:** El programa debe imprimir el vector generado, los duplicados encontrados por cada solución, y la comparación de complejidades. No debe solicitar datos por teclado.

## 16. Criterios de aceptación

La implementación será aceptada si:

- Compila correctamente con Java 21.
- Genera automáticamente el vector sin solicitar datos por teclado.
- Contiene exactamente dos soluciones para detectar duplicados.
- La primera solución utiliza dos ciclos anidados (fuerza bruta).
- La segunda solución utiliza `HashSet`.
- Ambas soluciones encuentran los mismos duplicados en el mismo vector.
- Informa la lista de duplicados encontrados por cada solución.
- Incluye una comparación explícita de complejidad temporal y espacial.
- Utiliza Javadoc para documentar la clase, métodos y análisis de complejidad.
- Está ubicada en una carpeta independiente de los ejercicios anteriores.
- El código es claro, legible y adecuado para un contexto académico.
- No utiliza librerías externas ni métodos predefinidos de búsqueda/ordenamiento de bibliotecas.
- El vector generado garantiza al menos un duplicado.
