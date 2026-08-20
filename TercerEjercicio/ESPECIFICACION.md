# Especificación: Búsqueda binaria en un vector ordenado

## 1. Objetivo del proyecto

Crear un prompt en español para OpenCode que solicite la implementación en Java 21 de un programa que busque un valor dentro de un vector ordenado utilizando búsqueda binaria.

El programa debe recibir los datos desde la entrada estándar, mostrar paso a paso la evolución de las variables de búsqueda y permitir ejecutarse desde la terminal. Si el valor aparece varias veces, debe informar cuántas apariciones existen. Si no aparece, debe imprimir un mensaje indicando que el dato no existe.

## 2. Requisitos funcionales

El prompt debe solicitar que OpenCode:

- Implemente el programa en Java 21.
- Lea el vector y el valor buscado desde la entrada estándar.
- Trabaje con un vector ordenado de menor a mayor.
- Utilice búsqueda binaria como estrategia principal.
- Muestre en cada iteración los valores actuales de `inicio`, `medio` y `fin`.
- Muestre el valor ubicado en la posición `medio` y la decisión tomada.
- Informe la posición de una aparición del valor cuando sea encontrado.
- Cuente e informe todas las apariciones del valor si existen elementos repetidos.
- Imprima un mensaje claro cuando el valor buscado no exista.
- Entregue una implementación sencilla, clara y comentada con Javadoc.

## 3. Requisitos no funcionales

- El código debe ser comprensible para un estudiante de estructuras de datos y algoritmos.
- No debe utilizar librerías externas.
- No debe utilizar métodos de búsqueda ya implementados por bibliotecas.
- La búsqueda binaria debe implementarse manualmente.
- La salida debe permitir observar el funcionamiento interno del algoritmo.
- El programa debe poder compilarse y ejecutarse desde la terminal.

## 4. Restricciones y decisiones técnicas

- Lenguaje: Java.
- Versión: Java 21.
- Entrada: entrada estándar.
- El vector se considera ordenado antes de comenzar la búsqueda.
- No es necesario ordenar el vector dentro del programa.
- La búsqueda debe utilizar índices enteros `inicio`, `medio` y `fin`.
- La posición debe informarse utilizando índices desde cero.
- Si existen valores repetidos, se debe contar el total de apariciones.
- La búsqueda binaria debe encontrar primero una aparición del valor. Luego, para contar repeticiones, se puede recorrer el vector o expandir hacia la izquierda y derecha desde la posición encontrada.

## 5. Formato de entrada y ejecución desde la terminal

El programa debe leer los datos desde la entrada estándar con el siguiente formato:

```text
n
v1 v2 ... vn
x
```

Donde:

- `n` es la cantidad de elementos del vector.
- `v1` hasta `vn` son enteros ordenados de menor a mayor.
- `x` es el dato que se desea buscar.
- Se debe suponer que `n` es mayor que cero.

Ejemplo de ejecución desde la terminal:

```bash
java TercerEjercicio.Main << EOF
8
2 4 4 4 7 10 12 15
4
EOF
```

El programa debe imprimir el seguimiento de las iteraciones y luego informar que el valor `4` fue encontrado, su posición de una aparición y que aparece `3` veces.

## 6. Estrategia de búsqueda binaria

La búsqueda binaria es más eficiente que la búsqueda lineal cuando el vector está ordenado porque descarta la mitad de los elementos restantes en cada iteración. La búsqueda lineal puede tener que revisar uno por uno todos los elementos, mientras que la búsqueda binaria reduce rápidamente el intervalo de búsqueda.

En cada iteración se debe:

1. Calcular `medio` a partir de `inicio` y `fin`, evitando desbordamientos innecesarios.
2. Mostrar los valores de `inicio`, `medio` y `fin`.
3. Mostrar el elemento ubicado en `medio`.
4. Comparar el elemento central con `x`.
5. Si el elemento central es igual a `x`, informar que se encontró una aparición y conservar la posición.
6. Si el elemento central es menor que `x`, actualizar `inicio` para continuar en la mitad derecha.
7. Si el elemento central es mayor que `x`, actualizar `fin` para continuar en la mitad izquierda.
8. Repetir mientras `inicio` sea menor o igual que `fin`.

El seguimiento debe explicar las decisiones con mensajes similares a:

- `El valor central es menor: buscar en la mitad derecha.`
- `El valor central es mayor: buscar en la mitad izquierda.`
- `Valor encontrado.`

## 7. Conteo de valores repetidos

Si la búsqueda encuentra el valor `x`, el programa debe contar todas sus apariciones.

Como el vector está ordenado, los valores repetidos quedan juntos. El prompt debe solicitar una solución sencilla. Se puede contar recorriendo el vector completo y comparando cada elemento con `x`, o recorriendo desde la posición encontrada hacia la izquierda y hacia la derecha mientras el valor coincida.

La segunda alternativa aprovecha el orden del vector y evita revisar posiciones alejadas del bloque de repetidos. En ambos casos, el programa debe informar:

- La posición de una aparición encontrada.
- La cantidad total de apariciones.

No es necesario informar todas las posiciones, salvo que OpenCode lo considere útil sin complicar la solución.

## 8. Caso en que el valor no existe

Si el ciclo termina porque `inicio` es mayor que `fin`, el programa debe imprimir un mensaje claro, por ejemplo:

```text
El valor no existe en el vector.
```

También debe conservarse el seguimiento de las iteraciones realizadas para mostrar cómo se determinó que el valor no estaba presente.

## 9. Complejidad esperada

### Búsqueda binaria

- Mejor caso: `O(1)`, cuando `x` coincide con el elemento ubicado inicialmente en `medio`.
- Caso promedio: `O(log n)`.
- Peor caso: `O(log n)`, cuando el valor está cerca de un extremo o no existe.
- Espacio adicional: `O(1)` si se utiliza una implementación iterativa.

### Conteo de repetidos

- Si se expanden los extremos del bloque repetido, el costo adicional es `O(k)`, donde `k` es la cantidad de apariciones contiguas.
- Si no se encuentra el valor, no se realiza conteo adicional.
- En el peor caso, si todos los elementos son iguales, el conteo puede costar `O(n)`.

### Complejidad total

- Mejor caso total: `O(1)` si se encuentra el valor en el primer punto medio y el conteo termina de acuerdo con la estrategia utilizada.
- Caso promedio: `O(log n + k)` cuando se cuentan las `k` apariciones contiguas.
- Peor caso: `O(n)` cuando el vector contiene muchas repeticiones o cuando el conteo debe revisar todo el bloque de valores iguales.
- Espacio adicional: `O(1)`.

El prompt debe pedir que OpenCode explique que la búsqueda binaria, por sí sola, mantiene una complejidad de `O(log n)`, pero contar todas las apariciones puede agregar un costo proporcional a la cantidad de repetidos.

## 10. Documentación Javadoc requerida

El código debe incluir Javadoc para:

- La clase principal.
- El método `main`.
- El método que realiza la búsqueda binaria.
- El método que cuenta las apariciones, si se implementa como método separado.

La documentación debe explicar:

- Que el vector debe estar ordenado.
- Por qué la búsqueda binaria es más eficiente que la lineal en datos ordenados.
- El significado de `inicio`, `medio` y `fin`.
- La forma en que se muestran los pasos.
- El manejo de valores repetidos.
- Las complejidades temporal y espacial.

## 11. Casos de prueba requeridos

El prompt debe solicitar la verificación de estos casos:

- Valor ubicado en la primera posición.
- Valor ubicado en la última posición.
- Valor ubicado inicialmente en el punto medio.
- Valor que no existe y es menor que todos los elementos.
- Valor que no existe y es mayor que todos los elementos.
- Valor inexistente entre dos elementos.
- Vector con un único elemento.
- Todos los elementos iguales.
- Valor repetido dos o más veces.
- Vector con valores negativos, cero y positivos.

## 12. Criterios de aceptación

El prompt será correcto si solicita una implementación que:

- Compile con Java 21.
- Lea el vector ordenado y el dato `x` desde la terminal mediante entrada estándar.
- Implemente búsqueda binaria iterativa.
- Muestre `inicio`, `medio`, `fin`, el valor central y la decisión en cada paso.
- Informe una posición válida cuando encuentre el valor.
- Cuente correctamente todas las apariciones de un valor repetido.
- Muestre un mensaje claro cuando el valor no exista.
- Incluya Javadoc y comentarios claros.
- Explique la ventaja de `O(log n)` frente a `O(n)` para un vector ordenado.
- Informe correctamente el mejor caso, caso promedio, peor caso y espacio adicional.
- Entregue únicamente la implementación solicitada, sin utilizar métodos de búsqueda de bibliotecas.

## 13. Prompt final para OpenCode

> Implementá en Java 21 un programa sencillo que realice una búsqueda binaria sobre un vector de números enteros ordenado de menor a mayor.
>
> El programa debe leer desde la entrada estándar, en este formato: primero un entero `n`, luego `n` enteros ordenados y finalmente el valor `x` que se desea buscar. Debe poder ejecutarse desde la terminal y no debe ordenar el vector, porque se supone que ya está ordenado.
>
> Implementá la búsqueda binaria de forma iterativa utilizando las variables `inicio`, `medio` y `fin`. En cada iteración, imprimí paso a paso los valores de esas variables, el valor ubicado en `medio` y la decisión tomada: continuar por la mitad izquierda, continuar por la mitad derecha o informar que el valor fue encontrado.
>
> Explicá mediante Javadoc que la búsqueda binaria es más eficiente que una búsqueda lineal cuando los datos están ordenados, porque descarta la mitad de los elementos restantes en cada iteración. Indicá que la búsqueda binaria tiene complejidad `O(1)` en el mejor caso y `O(log n)` en el caso promedio y peor, mientras que la búsqueda lineal puede requerir `O(n)` comparaciones.
>
> Si `x` aparece varias veces, contá todas sus apariciones e informá la cantidad total y la posición de una aparición válida. Si no existe, imprimí un mensaje claro indicando que el valor no se encuentra en el vector.
>
> Documentá con Javadoc la clase, `main`, la búsqueda binaria y el método de conteo si existe. Explicá también que el conteo de repetidos puede agregar un costo de `O(k)`, donde `k` es la cantidad de apariciones, y que el espacio adicional esperado es `O(1)`. Mostrá únicamente la implementación Java solicitada, sin librerías externas ni métodos de búsqueda predefinidos.
