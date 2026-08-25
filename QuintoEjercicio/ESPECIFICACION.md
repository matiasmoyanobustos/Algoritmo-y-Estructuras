# Especificación: Conteo de apariciones de un valor en un vector

## 1. Objetivo del proyecto

Crear un prompt en español para OpenCode que solicite la implementación en Java 21 de un algoritmo que cuente cuántas veces aparece un determinado valor dentro de un vector de números enteros.

El prompt debe justificar por qué el algoritmo necesita recorrer completamente el vector para garantizar un conteo correcto, incluso en el mejor caso. Además, debe solicitar el análisis de la complejidad temporal y espacial del algoritmo, explicando por qué no es posible obtener un resultado exacto sin revisar cada posición del vector.

Este ejercicio debe mantenerse separado de los ejercicios anteriores mediante una carpeta propia dentro del proyecto.

## 2. Requisitos funcionales

El prompt debe solicitar que OpenCode:

- Implemente el programa en Java 21.
- Genere automáticamente un vector de números enteros con valores aleatorios.
- Genere automáticamente el valor que se desea contar dentro del vector.
- Implemente un método que recorra el vector completo y cuente las apariciones del valor buscado.
- Informe cuántas veces aparece el valor en el vector.
- Justifique por qué es necesario recorrer todo el vector.
- Incluya un análisis completo de la complejidad temporal y espacial.
- Incluya documentación Javadoc que explique la estrategia y el análisis de complejidad.

## 3. Requisitos no funcionales

- El código debe ser comprensible para un estudiante de estructuras de datos y algoritmos.
- No debe utilizar librerías externas.
- No debe utilizar métodos de conteo de bibliotecas.
- El recorrido del vector debe implementarse manualmente con un ciclo.
- La justificación de por qué se necesita recorrer todo el vector debe estar documentada.
- El código debe incluir comentarios Javadoc en la clase y los métodos principales.
- La salida debe ser clara y no debe incluir información que no sea solicitada.

## 4. Restricciones y decisiones técnicas

- Lenguaje: Java.
- Versión: Java 21.
- Entrada: generación automática de datos aleatorios.
- El algoritmo debe recorrer el vector completo desde la posición 0 hasta la última posición.
- No se debe utilizar ninguna estructura de datos adicional como HashMap o HashSet para el conteo.
- El conteo debe realizarse con una variable acumuladora simple.
- Se debe justificar por qué el vector no está ordenado y por qué no se puede detener antes.

## 5. Generación de datos

El programa debe generar automáticamente los datos con las siguientes características:

### Vector

- Cantidad de elementos: por ejemplo, `15` elementos.
- Rango de valores: por ejemplo, entre `1` y `20`.
- Los valores deben mostrarse antes de ejecutar el conteo.

### Valor buscado

- El valor buscado debe generarse dentro del mismo rango que el vector (`1` a `20`).
- Esto garantiza que en algunas ejecuciones el valor exista y en otras no.

Ejemplo de datos generados:

```
Vector:     [5, 3, 8, 3, 5, 12, 8, 1, 15, 3, 5, 20, 8, 1, 12]
Valor buscado: 5
Apariciones: 3
```

## 6. Algoritmo de conteo

### Estrategia

El algoritmo debe recorrer el vector completo desde la primera posición hasta la última, comparando cada elemento con el valor buscado. Cada vez que los valores coincidan, se incrementa un contador.

### Algoritmo paso a paso

1. Inicializar un contador en `0`.
2. Recorrer el vector con un ciclo desde la posición `0` hasta `n - 1`.
3. En cada posición, comparar el elemento actual con el valor buscado.
4. Si son iguales, incrementar el contador en `1`.
5. Al finalizar el recorrido, informar el valor del contador.

### Justificación del recorrido completo

El prompt debe solicitar que se explique por qué el algoritmo necesita recorrer completamente el vector:

- **El vector no está ordenado**: No se puede asumir que los valores repetidos están juntos. Los valores pueden estar distribuidos en cualquier posición.
- **El valor buscado puede aparecer en cualquier posición**: Desde la primera hasta la última posición, incluyendo el caso de que aparezca al final del vector.
- **El valor buscado puede no existir**: Para confirmar que un valor no existe, es necesario revisar todas las posiciones. Si se detuviera antes, podría haber una aparición no contada.
- **No hay forma de saber de antemano cuántas veces aparece**: Sin una estructura de datos previa como un mapa de frecuencias, no hay acceso directo al conteo.
- **El peor caso requiere revisar todo el vector**: Si el valor buscado aparece en la última posición o no aparece, el algoritmo debe llegar hasta el final.

## 7. Complejidad esperada

### Complejidad temporal

- **Mejor caso**: `O(n)`, cuando el valor buscado aparece en la primera posición. Aunque se encuentre temprano, no se puede detener porque podría haber más apariciones.
- **Caso promedio**: `O(n)`, porque se recorre una fracción significativa del vector.
- **Peor caso**: `O(n)`, cuando el valor está en la última posición o no existe.

**Nota importante**: Aunque el valor se encuentre en la primera posición, el algoritmo debe continuar recorriendo porque puede haber más apariciones en posiciones posteriores. Por eso todos los casos son `O(n)`.

### Complejidad espacial

- **Espacio adicional**: `O(1)`, porque solo se utiliza una variable para el contador y una variable para el índice del ciclo. No se crea ninguna estructura de datos auxiliar.

## 8. Justificación del recorrido obligatorio

El prompt debe solicitar que se documente la justificación del recorrido completo. Esta justificación debe incluir:

### Por qué no se puede detener antes

- El vector no está ordenado, por lo que los valores iguales pueden estar dispersos.
- No se puede predecir cuántas veces aparece el valor sin revisar todas las posiciones.
- Si el valor buscado aparece en la posición `0` y también en la posición `n-1`, un recorrido parcial encontraría solo una aparición.

### Comparación con búsqueda binaria

- La búsqueda binaria solo funciona en vectores ordenados y encuentra una aparición, no todas.
- Este algoritmo busca el conteo total, no solo una posición.

### Comparación con estructuras de datos

- Un `HashMap` podría almacenar frecuencias y dar respuestas `O(1)` posteriores, pero requiere `O(n)` de espacio adicional y una fase de construcción previa.
- El enfoque solicitado es directo, sin estructuras auxiliares, ideal para un primer contacto con algoritmos de búsqueda lineal.

## 9. Estructura del programa

El programa debe contener al menos:

- Una clase ejecutable con método `main`.
- Un método para generar el vector aleatorio.
- Un método para generar el valor buscado.
- Un método que cuente las apariciones del valor en el vector.
- Un método o sección para mostrar la justificación y el análisis de complejidad.

No se requiere una jerarquía de clases ni una arquitectura compleja.

## 10. Entrada y salida

### Datos generados

El programa debe generar automáticamente el vector y el valor buscado sin solicitar datos por teclado.

### Salida esperada

El programa debe imprimir:

1. El vector generado.
2. El valor que se desea contar.
3. La cantidad de veces que aparece el valor en el vector.
4. La justificación de por qué se necesita recorrer todo el vector.
5. El análisis de complejidad temporal y espacial.

### Ejemplo de salida

```
Vector generado: [5, 3, 8, 3, 5, 12, 8, 1, 15, 3, 5, 20, 8, 1, 12]
Valor buscado: 5
Apariciones del valor 5: 3

--- Justificacion del recorrido completo ---
El vector no esta ordenado, por lo que los valores iguales pueden estar
distribuidos en cualquier posicion. Para garantizar un conteo exacto, es
necesario revisar cada posicion del vector desde la primera hasta la ultima.
No se puede detener ante la primera coincidencia porque podrian existir
mas apariciones en posiciones posteriores.

--- Complejidad ---
Temporal: O(n) - Se recorre el vector una sola vez en todos los casos.
Espacial: O(1) - Solo se utilizan variables auxiliares (contador e indice).
```

## 11. Análisis de complejidad detallado

### Mejor caso

Cuando el valor buscado se encuentra en la primera posición del vector. Sin embargo, el algoritmo debe continuar recorriendo porque puede haber más apariciones. Por lo tanto, el mejor caso es `O(n)`.

### Caso promedio

Cuando el valor buscado está distribuido en varias posiciones del vector. El recorrido se realiza completo. Complejidad `O(n)`.

### Peor caso

Cuando el valor buscado está en la última posición o no existe en el vector. El recorrido se realiza completo hasta el final. Complejidad `O(n)`.

### Espacio adicional

Solo se utilizan:

- Una variable entera para el contador de apariciones.
- Una variable entera para el índice del ciclo.
- No se crean arreglos, listas, conjuntos u otras estructuras auxiliares.

Espacio adicional: `O(1)`.

## 12. Manejo de valores repetidos

El vector generado debe contener valores repetidos para que el algoritmo tenga resultados interesantes que mostrar. La generación debe garantizar que algunos valores aparezcan múltiples veces.

El valor buscado debe generarse dentro del mismo rango del vector para que en algunas ejecuciones exista y en otras no. Esto permite observar ambos casos en la salida.

## 13. Casos límite

La implementación debe contemplar:

- Vector con un solo elemento.
- Vector con todos los elementos iguales.
- Vector donde todos los elementos son únicos (el valor buscado no aparece).
- Vector con valores negativos, cero y positivos.
- Vector donde el valor buscado aparece solo una vez.
- Vector donde el valor buscado aparece en todas las posiciones.
- Vector donde el valor buscado aparece en la primera posición.
- Vector donde el valor buscado aparece en la última posición.
- Vector donde el valor buscado no existe (apariciones = 0).
- Vector ordenado creciente, ordenado decreciente y desordenado.
- Valores extremos del rango generado.

## 14. Documentación Javadoc requerida

El código debe incluir Javadoc para:

- La clase principal.
- El método `main`.
- El método que genera el vector.
- El método que cuenta las apariciones.

La documentación debe explicar:

- El objetivo del algoritmo.
- Por qué el vector no está ordenado y por qué no se puede usar búsqueda binaria.
- La estrategia de recorrido completo.
- La justificación de por qué se necesita revisar cada posición.
- Las complejidades temporal `O(n)` y espacial `O(1)`.
- El mejor caso, caso promedio y peor caso.

## 15. Prompt final para OpenCode

> Implementá en Java 21 un programa sencillo que cuente cuántas veces aparece un determinado valor dentro de un vector de números enteros.
>
> **Generación de datos:** El programa debe generar automáticamente un vector de 15 enteros con valores aleatorios entre 1 y 20. También debe generar el valor que se desea contar, dentro del mismo rango. Mostrá el vector generado y el valor buscado antes de ejecutar el conteo.
>
> **Algoritmo de conteo:** Implementá un método que recorra el vector completo desde la posición 0 hasta la última posición. Para cada elemento, comparalo con el valor buscado. Si son iguales, incrementá un contador. Al finalizar el recorrido, informá cuántas veces aparece el valor.
>
> **Justificación:** Documentá con Javadoc por qué el algoritmo necesita recorrer completamente el vector. Explicá que el vector no está ordenado, que los valores iguales pueden estar distribuidos en cualquier posición, que el valor buscado puede aparecer al final del vector, y que no se puede detener antes porque podría haber apariciones no contadas. Aclará que aunque el valor se encuentre en la primera posición, el algoritmo debe continuar porque puede haber más apariciones.
>
> **Complejidad:** Analizá la complejidad temporal y espacial. Indicá que el mejor caso, caso promedio y peor caso son `O(n)` porque siempre se recorre el vector completo. Explicá que el espacio adicional es `O(1)` porque solo se utilizan variables para el contador y el índice.
>
> **Documentación:** Documentá con Javadoc la clase, el `main`, el método de generación y el método de conteo. Explicá que este es un ejemplo de búsqueda lineal en un vector no ordenado, y que para conteos frecuentes se podrían usar estructuras como `HashMap` pero con un costo de espacio adicional.
>
> **Salida:** El programa debe imprimir el vector generado, el valor buscado, la cantidad de apariciones, la justificación del recorrido completo y el análisis de complejidad. No debe solicitar datos por teclado.

## 16. Criterios de aceptación

La implementación será aceptada si:

- Compila correctamente con Java 21.
- Genera automáticamente el vector y el valor buscado sin solicitar datos por teclado.
- Implementa un método que recorra el vector completo contando apariciones.
- Utiliza un ciclo simple desde 0 hasta n-1.
- No utiliza estructuras auxiliares como HashMap o HashSet.
- Utiliza una variable acumuladora simple para el conteo.
- Informa correctamente la cantidad de apariciones del valor.
- Incluye una justificación clara de por qué se necesita recorrer todo el vector.
- Incluye el análisis de complejidad temporal O(n) y espacial O(1).
- Utiliza Javadoc para documentar la clase, métodos y análisis de complejidad.
- Está ubicada en una carpeta independiente de los ejercicios anteriores.
- El código es claro, legible y adecuado para un contexto académico.
- No utiliza librerías externas ni métodos predefinidos de conteo.
