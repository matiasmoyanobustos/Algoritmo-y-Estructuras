# Especificación: Comparación de igualdad entre dos vectores

## 1. Objetivo del proyecto

Crear un prompt en español para OpenCode que solicite la implementación en Java 21 de un algoritmo que determine si dos vectores de números enteros son iguales, es decir, si contienen los mismos elementos en las mismas posiciones.

El algoritmo debe finalizar apenas detecte una diferencia entre los elementos correspondientes de ambos vectores, sin necesidad de recorrerlos completamente. El prompt debe solicitar el análisis del mejor caso, peor caso y caso promedio, explicando por qué el algoritmo puede detenerse temprano.

Este ejercicio debe mantenerse separado de los ejercicios anteriores mediante una carpeta propia dentro del proyecto.

## 2. Requisitos funcionales

El prompt debe solicitar que OpenCode:

- Implemente el programa en Java 21.
- Genere automáticamente dos vectores de números enteros con valores aleatorios.
- Implemente un método que compare ambos vector posición por posición.
- Detenga la comparación en la primera posición donde los elementos difieran.
- Informe si los vectores son iguales o diferentes.
- Informe en qué posición se encontró la diferencia (si existe).
- Incluya un análisis completo de la complejidad temporal y espacial.
- Incluya documentación Javadoc que explique la estrategia y el análisis de complejidad.

## 3. Requisitos no funcionales

- El código debe ser comprensible para un estudiante de estructuras de datos y algoritmos.
- No debe utilizar librerías externas.
- No debe utilizar métodos de comparación de vectores de bibliotecas.
- La comparación debe implementarse manualmente con un ciclo.
- La finalización anticipada debe ser explícita en el código.
- El código debe incluir comentarios Javadoc en la clase y los métodos principales.
- La salida debe ser clara y no debe incluir información que no sea solicitada.

## 4. Restricciones y decisiones técnicas

- Lenguaje: Java.
- Versión: Java 21.
- Entrada: generación automática de datos aleatorios.
- Los dos vectores deben tener la misma longitud para poder compararlos.
- El algoritmo debe usar un ciclo simple que recorra ambos vectores simultáneamente.
- En cada posición, se compara `vector1[i]` con `vector2[i]`.
- Si los elementos difieren, el método debe retornar `false` inmediatamente.
- Si se completa el recorrido sin diferencias, el método debe retornar `true`.
- No se deben crear estructuras auxiliares para la comparación.

## 5. Generación de datos

El programa debe generar automáticamente los datos con las siguientes características:

### Vectores

- Cantidad de elementos: por ejemplo, `10` elementos cada uno.
- Rango de valores: por ejemplo, entre `1` y `20`.
- Los dos vectores deben generarse independientemente.
- Los vectores se muestran antes de ejecutar la comparación.

### Probabilidad de igualdad

Para que el programa pueda mostrar ambos casos (vectores iguales y diferentes), se puede generar el segundo vector como:

- **Opción A**: Copia del primero con una modificación aleatoria en una posición. Esto garantiza que sean diferentes.
- **Opción B**: Generación completamente independiente. Esto permite ambos casos.
- **Opción C**: El segundo vector es siempre una copia modificada del primero, cambiando un porcentaje de elementos.

La opción recomendada para un contexto académico es generar ambos vectores independientemente, para que en algunas ejecuciones sean iguales y en otras no. Sin embargo, dado que con vectores aleatorios independientes la probabilidad de igualdad es extremadamente baja, se recomienda generar el segundo vector como copia del primero con una o dos posiciones modificadas aleatoriamente para garantizar la existencia de al menos un caso con diferencia observable.

Ejemplo de datos generados:

```
Vector 1: [5, 3, 8, 3, 5, 12, 8, 1, 15, 3]
Vector 2: [5, 3, 7, 3, 5, 12, 8, 1, 15, 3]
Diferencia detectada en la posicion 2: vector1=8, vector2=7
Los vectores NO son iguales.
```

O cuando son iguales:

```
Vector 1: [5, 3, 8, 3, 5, 12, 8, 1, 15, 3]
Vector 2: [5, 3, 8, 3, 5, 12, 8, 1, 15, 3]
No se detectaron diferencias.
Los vectores son iguales.
```

## 6. Algoritmo de comparación

### Estrategia

El algoritmo debe recorrer ambos vectores simultáneamente, posición por posición, comparando los elementos correspondientes. Si en alguna posición los elementos difieren, el algoritmo finaliza inmediatamente indicando que los vectores no son iguales. Si se completa el recorrido sin encontrar diferencias, los vectores son iguales.

### Algoritmo paso a paso

1. Verificar que ambos vectores tengan la misma longitud. Si no la tienen, retornar `false` inmediatamente.
2. Recorrer ambos vectores con un ciclo desde la posición `0` hasta `n - 1`.
3. En cada posición `i`, comparar `vector1[i]` con `vector2[i]`.
4. Si los elementos son diferentes, retornar `false` inmediatamente (finalización anticipada).
5. Si el ciclo completa el recorrido sin encontrar diferencias, retornar `true`.

### Justificación de la finalización anticipada

El prompt debe solicitar que se explique por qué el algoritmo puede detenerse en la primera diferencia:

- **No es necesario revisar todo el vector**: Si se encontró una diferencia, los vectores ya no son iguales independientemente del resto de los elementos.
- **La igualdad es una condición conjunta**: Todos los elementos deben ser iguales en todas las posiciones. Una sola diferencia es suficiente para determinar desigualdad.
- **Eficiencia en el mejor caso**: Si la diferencia está en la primera posición, el algoritmo solo realiza una comparación.
- **No se puede predecir dónde está la diferencia**: Por eso se necesita recorrer hasta encontrarla o hasta terminar el vector.

## 7. Complejidad esperada

### Complejidad temporal

- **Mejor caso**: `O(1)`, cuando la diferencia está en la primera posición o cuando los vectores tienen longitudes diferentes. El algoritmo realiza una sola comparación y finaliza.
- **Caso promedio**: `O(n)`, porque la diferencia puede estar en cualquier posición del vector. En promedio, se recorre la mitad del vector antes de encontrar una diferencia.
- **Peor caso**: `O(n)`, cuando los vectores son completamente iguales. El algoritmo debe recorrer todas las posiciones para confirmar que no hay diferencias.

### Complejidad espacial

- **Espacio adicional**: `O(1)`, porque solo se utilizan variables para el índice del ciclo y las longitudes de los vectores. No se crea ninguna estructura de datos auxiliar.

## 8. Justificación de la detección temprana

El prompt debe solicitar que se documente la justificación de la finalización anticipada. Esta justificación debe incluir:

### Por qué se puede detener en la primera diferencia

- La igualdad de vectores requiere que **todos** los elementos coincidan en **todas** las posiciones.
- Si un solo par de elementos difiere, la condición de igualdad ya no se cumple.
- No hay forma de que una diferencia posterior "compense" una diferencia anterior.
- Revisar posiciones adicionales después de encontrar una diferencia no cambia el resultado.

### Comparación con otros algoritmos

- A diferencia del conteo de apariciones (ejercicio anterior), donde se debe recorrer todo el vector, aquí la igualdad es una propiedad que se puede descartar con una sola diferencia.
- Un algoritmo de conteo no puede detenerse porque podría haber más apariciones. Un algoritmo de igualdad sí puede detenerse porque una diferencia es suficiente.

## 9. Estructura del programa

El programa debe contener al menos:

- Una clase ejecutable con método `main`.
- Un método para generar un vector aleatorio.
- Un método para generar una copia modificada del vector (para garantizar diferencia observable).
- Un método que compare dos vectores y retorne `true` o `false`.
- Un método o sección para mostrar el análisis de complejidad.

No se requiere una jerarquía de clases ni una arquitectura compleja.

## 10. Entrada y salida

### Datos generados

El programa debe generar automáticamente los dos vectores sin solicitar datos por teclado.

### Salida esperada

El programa debe imprimir:

1. El primer vector generado.
2. El segundo vector generado.
3. El resultado de la comparación (iguales o diferentes).
4. La posición de la diferencia si los vectores son diferentes.
5. El análisis de complejidad (mejor caso, peor caso, caso promedio y espacio).

### Ejemplo de salida cuando son diferentes

```
Vector 1: [5, 3, 8, 3, 5, 12, 8, 1, 15, 3]
Vector 2: [5, 3, 7, 3, 5, 12, 8, 1, 15, 3]

Los vectores NO son iguales.
Diferencia encontrada en la posicion 2: vector1=8, vector2=7

--- Complejidad ---
Mejor caso:    O(1) - La diferencia esta en la primera posicion.
Caso promedio: O(n) - La diferencia puede estar en cualquier posicion.
Peor caso:     O(n) - Los vectores son completamente iguales.
Espacial:      O(1) - Solo se utilizan variables auxiliares (indice y longitudes).
```

### Ejemplo de salida cuando son iguales

```
Vector 1: [5, 3, 8, 3, 5, 12, 8, 1, 15, 3]
Vector 2: [5, 3, 8, 3, 5, 12, 8, 1, 15, 3]

Los vectores son iguales.
No se encontraron diferencias en ninguna posicion.

--- Complejidad ---
Mejor caso:    O(1) - La diferencia esta en la primera posicion.
Caso promedio: O(n) - La diferencia puede estar en cualquier posicion.
Peor caso:     O(n) - Los vectores son completamente iguales.
Espacial:      O(1) - Solo se utilizan variables auxiliares (indice y longitudes).
```

## 11. Análisis de complejidad detallado

### Mejor caso

Cuando la diferencia se encuentra en la primera posición (posición 0). El algoritmo realiza una sola comparación y finaliza. Complejidad `O(1)`.

También es mejor caso cuando los vectores tienen longitudes diferentes. En este caso, el algoritmo puede verificar las longitudes y retornar `false` sin recorrer ningún elemento.

### Caso promedio

Cuando la diferencia se encuentra en una posición intermedia del vector. El algoritmo recorre una fracción del vector antes de encontrar la diferencia. En promedio, se recorre la mitad del vector. Complejidad `O(n)`.

### Peor caso

Cuando los vectores son completamente iguales (todos los elementos coinciden en todas las posiciones). El algoritmo debe recorrer todo el vector para confirmar que no hay diferencias. Complejidad `O(n)`.

### Espacio adicional

Solo se utilizan:

- Una variable entera para el índice del ciclo.
- Dos variables enteras para las longitudes de los vectores.
- No se crean arreglos, listas, conjuntos u otras estructuras auxiliares.

Espacio adicional: `O(1)`.

## 12. Generación de datos para pruebas

Para que el programa pueda mostrar ambos casos (vectores iguales y diferentes), se recomienda:

### Estrategia de generación

1. Generar el primer vector aleatoriamente.
2. Para el segundo vector, generar una copia del primero y modificar aleatoriamente una o dos posiciones.
3. Esto garantiza que siempre exista una diferencia observable.

### Alternativa

Generar ambos vectores completamente aleatoriamente. En este caso, los vectores serán diferentes en casi todas las ejecuciones (la probabilidad de que sean iguales es extremadamente baja). Esto es aceptable porque el ejercicio se centra en el algoritmo de comparación, no en la generación de igualdad.

## 13. Casos límite

La implementación debe contemplar:

- Vectores con un solo elemento, iguales.
- Vectores con un solo elemento, diferentes.
- Vectores con todos los elementos iguales.
- Vectores con todos los elementos diferentes.
- Vectores con valores negativos, cero y positivos.
- Vectores donde la diferencia está en la primera posición.
- Vectores donde la diferencia está en la última posición.
- Vectores con la misma longitud pero diferentes valores.
- Vectores con diferentes longitudes.
- Vectores vacíos (longitud 0).
- Valores extremos del rango generado.
- Vectores ordenados de la misma manera.
- Vectores ordenados de manera diferente.

## 14. Documentación Javadoc requerida

El código debe incluir Javadoc para:

- La clase principal.
- El método `main`.
- El método que genera un vector aleatorio.
- El método que genera una copia modificada del vector.
- El método que compara dos vectores.

La documentación debe explicar:

- El objetivo del algoritmo.
- La estrategia de comparación posición por posición.
- La finalización anticipada en la primera diferencia.
- Por qué no es necesario recorrer todo el vector cuando hay una diferencia.
- Las complejidades temporal y espacial.
- El mejor caso O(1), caso promedio O(n) y peor caso O(n).

## 15. Prompt final para OpenCode

> Implementá en Java 21 un programa sencillo que determine si dos vectores de números enteros son iguales, es decir, si contienen los mismos elementos en las mismas posiciones.
>
> **Generación de datos:** El programa debe generar automáticamente dos vectores de 10 enteros con valores aleatorios entre 1 y 20. Para garantizar que exista al menos un caso observable de diferencia, generá el segundo vector como una copia del primero con una posición modificada aleatoriamente. Mostrá ambos vectores antes de ejecutar la comparación.
>
> **Algoritmo de comparación:** Implementá un método que recorra ambos vectores simultáneamente con un ciclo desde la posición 0 hasta n-1. En cada posición, compará `vector1[i]` con `vector2[i]`. Si los elementos difieren, retorná `false` inmediatamente sin继续 recorriendo (finalización anticipada). Si el ciclo completa el recorrido sin encontrar diferencias, retorná `true`.
>
> **Justificación de la detección temprana:** Documentá con Javadoc por qué el algoritmo puede detenerse en la primera diferencia. Explicá que la igualdad de vectores requiere que todos los elementos coincidan en todas las posiciones, que una sola diferencia es suficiente para descartar la igualdad, y que no hay forma de que una diferencia posterior "compense" una anterior.
>
> **Complejidad:** Analizá la complejidad temporal y espacial. Indicá que el mejor caso es `O(1)` cuando la diferencia está en la primera posición, el caso promedio es `O(n)` porque la diferencia puede estar en cualquier posición, y el peor caso es `O(n)` cuando los vectores son completamente iguales. Explicá que el espacio adicional es `O(1)` porque solo se utilizan variables para el índice y las longitudes.
>
> **Documentación:** Documentá con Javadoc la clase, el `main`, los métodos de generación y el método de comparación. Explicá que este es un ejemplo de algoritmo con finalización anticipada, y que a diferencia del conteo de apariciones donde se debe recorrer todo el vector, aquí una sola diferencia es suficiente para determinar el resultado.
>
> **Salida:** El programa debe imprimir ambos vectores, el resultado de la comparación, la posición de la diferencia si existe, y el análisis de complejidad. No debe solicitar datos por teclado.

## 16. Criterios de aceptación

La implementación será aceptada si:

- Compila correctamente con Java 21.
- Genera automáticamente los dos vectores sin solicitar datos por teclado.
- Implementa un método que compare dos vectores posición por posición.
- Utiliza un ciclo simple desde 0 hasta n-1.
- Implementa finalización anticipada en la primera diferencia (retorna `false` inmediatamente).
- Retorna `true` solo cuando todos los elementos coinciden.
- Informa la posición de la diferencia cuando los vectores son diferentes.
- Incluye un análisis completo de mejor caso O(1), caso promedio O(n) y peor caso O(n).
- Incluye el análisis de complejidad espacial O(1).
- Utiliza Javadoc para documentar la clase, métodos y análisis de complejidad.
- Está ubicada en una carpeta independiente de los ejercicios anteriores.
- El código es claro, legible y adecuado para un contexto académico.
- No utiliza librerías externas ni métodos predefinidos de comparación.
