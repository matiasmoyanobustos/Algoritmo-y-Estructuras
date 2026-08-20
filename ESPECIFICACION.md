# Especificación: Prompt para OpenCode

## 1. Objetivo del proyecto

Crear un prompt en español para OpenCode que solicite la implementación en Java 21 de un algoritmo capaz de encontrar el valor mínimo de un vector de números enteros.

El resultado solicitado a OpenCode debe ser únicamente la implementación del algoritmo, sin una clase de prueba adicional ni explicaciones separadas de la solución.

## 2. Requisitos funcionales

El prompt debe solicitar que OpenCode:

- Implemente un algoritmo que encuentre el menor valor de un vector de números enteros.
- Reciba los datos mediante la entrada estándar.
- Utilice Java 21.
- Suponga que el vector siempre contiene al menos un elemento.
- Incluya comentarios dentro del código para explicar las partes relevantes de la implementación.
- Entregue únicamente el código de la implementación solicitada.
- Explique, dentro de los comentarios del código o como parte de la documentación solicitada en el propio código, por qué no es necesario ordenar el vector para encontrar el valor mínimo.

## 3. Requisitos no funcionales

- La solución debe ser clara, directa y adecuada para un contexto académico de estructuras de datos y algoritmos.
- El código debe ser legible y estar correctamente organizado.
- No debe utilizar librerías externas.
- El prompt debe solicitar que se informe la complejidad temporal y espacial esperada.
- El prompt debe pedir una solución eficiente, evitando operaciones que no sean necesarias para resolver el problema.

## 4. Restricciones

- Lenguaje: Java.
- Versión: Java 21.
- Interacción: entrada estándar.
- El vector no estará vacío.
- Alcance: únicamente la implementación del algoritmo.
- No se debe ordenar el vector como paso previo ni como parte de la solución.
- No se deben agregar funcionalidades ajenas, como búsqueda de otros estadísticos, validaciones de datos no solicitadas o una interfaz gráfica.

## 5. Lenguaje y versión

La implementación debe realizarse en Java 21.

## 6. Estructura general del proyecto

No se requiere una estructura de proyecto completa. El entregable debe ser un prompt documentado en este archivo para solicitar a OpenCode una única implementación en Java.

La implementación que produzca OpenCode deberá contener el punto de entrada y la lectura de los valores desde la entrada estándar, de acuerdo con el formato de entrada que el propio prompt debe dejar explícito.

## 7. Entidades, clases o componentes

El prompt debe solicitar como mínimo:

- Una clase Java ejecutable.
- Un punto de entrada `main`.
- La lógica de recorrido del vector para determinar el mínimo.
- El mecanismo de lectura desde la entrada estándar.

No se requiere una jerarquía de clases ni componentes adicionales.

## 8. Atributos y responsabilidades

- La clase principal debe coordinar la lectura de la entrada, el procesamiento del vector y la impresión del resultado.
- La variable que represente el mínimo debe inicializarse utilizando el primer elemento del vector, evitando asumir que todos los valores son positivos.
- El recorrido debe comparar cada elemento restante con el mínimo actual y actualizarlo cuando corresponda.
- El resultado debe imprimirse por la salida estándar.

## 9. Relaciones entre componentes

El punto de entrada debe ejecutar secuencialmente estas responsabilidades:

1. Leer la cantidad de elementos y los valores del vector desde la entrada estándar.
2. Recorrer el vector una sola vez.
3. Determinar el valor mínimo.
4. Mostrar el mínimo por la salida estándar.

## 10. Estructuras de datos

Debe utilizarse un vector o arreglo de números enteros. No se requiere ninguna estructura auxiliar adicional para calcular el mínimo.

## 11. Flujo principal del sistema

El prompt debe especificar un formato de entrada concreto:

- Primera línea: un entero `n`, que representa la cantidad de elementos.
- Segunda línea: `n` números enteros separados por espacios.
- Restricción: `n` es mayor que cero.

La salida debe consistir en el valor mínimo del vector, impreso por la salida estándar.

La estrategia solicitada debe ser un recorrido lineal:

1. Tomar el primer elemento como mínimo provisional.
2. Examinar cada elemento siguiente.
3. Compararlo con el mínimo provisional.
4. Actualizar el mínimo si el elemento actual es menor.
5. Imprimir el mínimo encontrado al finalizar el recorrido.

Esta estrategia es correcta porque el mínimo de un conjunto se puede determinar manteniendo el menor valor observado hasta cada posición. Al terminar de revisar todos los elementos, ese valor necesariamente es el menor de todo el vector.

La complejidad temporal esperada es `O(n)`, ya que cada elemento debe examinarse como máximo una vez. La complejidad espacial adicional esperada es `O(1)` si se considera únicamente el espacio usado por el algoritmo de búsqueda; la memoria necesaria para almacenar el vector es `O(n)`.

El prompt debe exigir una explicación de que ordenar el vector no es necesario: para conocer el mínimo alcanza con comparar cada elemento con el menor encontrado hasta el momento. Ordenar agrega un costo de `O(n log n)` en algoritmos de ordenamiento eficientes y realiza trabajo adicional que no aporta información necesaria para obtener únicamente el menor valor.

## 12. Manejo de errores y excepciones

El prompt debe indicar que se puede asumir que la entrada cumple el formato especificado y que `n` siempre es mayor que cero. No es necesario solicitar un tratamiento especial para vectores vacíos.

La implementación debe leer correctamente números enteros y producir el resultado esperado para valores positivos, negativos y cero.

## 13. Casos límite

El prompt debe contemplar, mediante comentarios o una breve aclaración en el código, los siguientes casos:

- Vector con un solo elemento.
- Todos los elementos iguales.
- Mínimo ubicado en la primera posición.
- Mínimo ubicado en la última posición.
- Todos los valores negativos.
- Combinación de valores negativos, cero y positivos.

## 14. Entrada y salida

Entrada:

```text
n
v1 v2 ... vn
```

Salida:

```text
minimo
```

El prompt debe pedir que OpenCode no agregue mensajes interactivos ni texto adicional a la salida, para mantener el formato indicado.

## 15. Orden recomendado de implementación

1. Declarar la clase principal y el punto de entrada.
2. Leer `n` desde la entrada estándar.
3. Leer los `n` valores enteros.
4. Inicializar el mínimo con el primer valor.
5. Recorrer los valores restantes y actualizar el mínimo cuando sea necesario.
6. Imprimir el mínimo.
7. Incorporar comentarios sobre la estrategia, sus complejidades y la innecesariedad de ordenar.
8. Verificar que la respuesta contenga únicamente la implementación solicitada.

## 16. Criterios de aceptación

El prompt se considera completo si incluye el siguiente texto o una formulación equivalente:

> Implementá en Java 21 un programa que lea desde la entrada estándar un vector de números enteros y encuentre su valor mínimo.
>
> El formato de entrada debe ser el siguiente: la primera línea contiene un entero `n`, mayor que cero, que indica la cantidad de elementos; la segunda línea contiene `n` números enteros separados por espacios. El programa debe imprimir únicamente el valor mínimo por la salida estándar.
>
> Antes de escribir la implementación, considerá como estrategia adecuada realizar un recorrido lineal del vector: inicializá el mínimo con el primer elemento y compará cada elemento siguiente con el mínimo actual, actualizándolo cuando encuentres un valor menor. Esta estrategia es correcta porque permite mantener, en cada paso, el menor valor observado hasta ese momento.
>
> Documentá en comentarios del código la estrategia utilizada, la complejidad temporal `O(n)` y la complejidad espacial adicional `O(1)`. Aclarà también en un comentario por qué no es necesario ordenar el vector: para obtener el mínimo basta con inspeccionar y comparar todos los elementos; ordenar implicaría un costo adicional, generalmente `O(n log n)`, sin ser necesario para este objetivo.
>
> Incluí comentarios claros y concisos en las partes relevantes. Considerá valores positivos, negativos y cero, y suponé que el vector siempre tiene al menos un elemento. Entregá únicamente la implementación en Java, sin clase de prueba ni explicaciones fuera del código.
