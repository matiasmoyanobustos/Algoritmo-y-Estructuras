# Prompts para OpenCode — Listas enlazadas simples

Usá cada prompt de forma independiente. Cada clase debe ser Java 21, tener su implementación propia de nodos y lista cuando corresponda, y usar datos fijos y deterministas en `main`. No usar `ArrayList`, `LinkedList` ni dependencias de otra clase de ejercicio. Incluir Javadoc con consigna, razonamiento, entradas/salidas, casos, errores y complejidad. Copiar el prompt íntegro al comienzo del fuente y añadir la nota requerida de ajustes.

## Ejercicio 1 — Crear una lista enlazada desde cero

> Implementá en Java 21 la clase independiente `Ejercicio01CrearListaEnlazada` con una lista propia de enteros, sin colecciones. Define un Nodo con dato y referencia siguiente; head apunta al primer nodo o null, y size cuenta nodos. Implementá insertarAlInicio, insertarAlFinal, imprimir, estaVacia y getSize. Explicá cómo se actualizan head, enlaces y size; insertar al inicio es O(1), agregar al final recorre nodos y cuesta O(n). Usa datos fijos en main, muestra lista vacía, inserciones al inicio/final, contenido y tamaño. Agregá Javadoc y comentarios de las referencias. Colocá este prompt íntegro al comienzo del archivo bajo “Prompt inicial utilizado:” y al final “Ajustes realizados luego de la primera respuesta de OpenCode:” indicando que no hubo ajustes o describiendo los reales.

## Ejercicio 2 — Buscar elementos

> Implementá en Java 21 la clase independiente `Ejercicio02BuscarEnLista`, con Nodo y lista simple propios de enteros, sin colecciones. Implementá boolean buscar(int dato) recorriendo desde head, siguiendo siguiente hasta encontrar el valor o null. Explicá que no hay acceso directo por índice como en un arreglo y por qué la búsqueda es secuencial O(n), con espacio adicional O(1). En main carga datos definidos, prueba primer elemento, elemento posterior, ausente y lista vacía, e imprime cada resultado. Documentá Javadoc, recorrido y casos. Copiá este prompt completo al inicio bajo “Prompt inicial utilizado:” y al final agrega “Ajustes realizados luego de la primera respuesta de OpenCode:” con “No hubo ajustes” o el detalle verdadero.

## Ejercicio 3 — Obtener por posición

> Implementá en Java 21 la clase independiente `Ejercicio03ObtenerPorPosicion` y una lista propia de enteros enlazados. Implementá int obtener(int posicion): valida primero que 0 <= posicion < size; ante índice inválido lanza IndexOutOfBoundsException con mensaje claro y no cambia la lista. Una posición no da acceso directo: recorre desde head, nodo por nodo, hasta alcanzarla. En main muestra acceso a posiciones primera, intermedia y final, más pruebas de -1 y size capturando la excepción y mostrando que la lista conserva datos y tamaño. No uses colecciones. Documentá estrategia y complejidad O(n) tiempo/O(1) espacio adicional. Copiá el prompt íntegro al inicio con el rótulo pedido y al final indica si hubo ajustes.

## Ejercicio 4 — Insertar en una posición

> Implementá en Java 21 la clase independiente `Ejercicio04InsertarEnPosicion` con lista enlazada simple propia de enteros. Implementá void insertarEnPosicion(int dato, int posicion), permitiendo 0 <= posicion <= size; 0 es inicio, size final e intermedios se insertan entre nodos. Valida antes de cambiar estado y lanza IndexOutOfBoundsException si es inválida. En inserción intermedia preserva el enlace en orden: nuevo.siguiente = actual.siguiente; después actual.siguiente = nuevo. Explica que alterar primero el enlace anterior sin guardar el siguiente desconecta el resto de la lista. Incrementa size una sola vez. Main demuestra insertar en lista vacía, inicio, medio, final y casos inválidos sin cambios. Sin colecciones; documenta complejidad O(n). Copiá este prompt completo al inicio y al final informa los ajustes reales o que no hubo.

## Ejercicio 5 — Eliminar por valor

> Implementá en Java 21 la clase independiente `Ejercicio05EliminarPorValor` con lista enlazada propia de enteros. Implementá boolean eliminar(int dato) que retire solo la primera aparición y retorne true, o false si falta. Contempla lista vacía, head, medio, último, duplicados y valor inexistente. Para head, avanza head; para otro nodo, el anterior debe apuntar al siguiente del eliminado. Decrementa size solo cuando elimina. Explica que Java no libera manualmente el objeto: al quedar inaccesible, el Garbage Collector podrá recuperarlo si no quedan referencias. Main demuestra cada caso con datos fijos y capturas de contenido/tamaño. No usar colecciones. Documenta recorrido O(n), espacio adicional O(1). Copia prompt íntegro al principio bajo el rótulo solicitado y consigna los ajustes reales al final.

## Ejercicio 6 — Eliminar por posición

> Implementá en Java 21 la clase independiente `Ejercicio06EliminarPorPosicion` con lista enlazada simple propia de enteros y método void eliminarEnPosicion(int posicion). Valida primero 0 <= posicion < size; lanza IndexOutOfBoundsException clara sin modificar si es inválida. Posición cero actualiza head; en los demás casos recorre hasta el nodo anterior y enlaza anterior.siguiente con eliminado.siguiente. Actualiza size exactamente una vez. Explica cómo se localiza el anterior y se salta el nodo. Main prueba eliminación de inicio, medio y final, e índices -1 y size inválidos, mostrando que no hay cambios tras error. Sin colecciones; O(n) tiempo, O(1) espacio adicional. Incluye Javadoc, prompt completo como comentario inicial y nota honesta de ajustes al final.

## Ejercicio 7 — Modificar un elemento

> Implementá en Java 21 la clase independiente `Ejercicio07ModificarElemento` con una lista propia enlazada de enteros y método modificar(int posicion, int nuevoDato). Valida posición 0 <= posicion < size antes del recorrido y lanza IndexOutOfBoundsException sin alterar la lista si no es válida. Recorre desde head hasta el nodo, cambia solo su dato y conserva head, siguiente y size. Explica la diferencia entre modificar el dato y modificar la referencia al siguiente. Main demuestra un cambio válido y posiciones -1 y size, con estado antes/después. Sin colecciones; O(n) tiempo y O(1) espacio adicional. Documenta con Javadoc; copia este prompt exacto al comienzo y registra ajustes reales al final.

## Ejercicio 8 — Contar ocurrencias

> Implementá en Java 21 la clase independiente `Ejercicio08ContarOcurrencias` con lista enlazada simple propia de enteros y método int contarOcurrencias(int dato). Recorre desde head hasta null y suma cada coincidencia; no cortes al encontrar la primera, pues se necesita el total. Usa en main la secuencia 10 -> 20 -> 10 -> 30 -> 10 y comprueba que contar 10 devuelve 3; también prueba valor ausente y lista vacía. No uses colecciones. Explica recorrido completo, casos y complejidad O(n) tiempo/O(1) espacio adicional en Javadoc. Copia el prompt íntegro al comienzo y añade al final la nota real de ajustes.

## Ejercicio 9 — Invertir lista

> Implementá en Java 21 la clase independiente `Ejercicio09InvertirLista` con lista enlazada propia de enteros y método invertir() in-place. Usa referencias anterior, actual y siguiente: guarda siguiente antes de cambiar actual.siguiente, invierte el enlace y avanza; al finalizar actualiza head a la nueva cabeza. Explica que si se sobrescribe el enlace antes de guardar siguiente se pierde el resto de la lista. No crees otra lista; size no cambia. Main demuestra lista vacía, un nodo y 10 -> 20 -> 30 -> 40 -> null transformándose en 40 -> 30 -> 20 -> 10 -> null. Sin colecciones; O(n) tiempo/O(1) espacio adicional. Documenta Javadoc y casos. Copia el prompt entero al inicio y declara ajustes verdaderos al final.

## Ejercicio 10 — Lista genérica

> Implementá en Java 21 la clase independiente `Ejercicio10ListaEnlazadaGenerica` con Nodo<T> y ListaEnlazada<T>, sin usar colecciones. Incluye todas las operaciones de la guía: insertar al inicio/final, imprimir, vacía/tamaño, buscar, obtener por posición, insertar en posición, eliminar primera coincidencia, eliminar por posición, modificar, contar ocurrencias e invertir. Mantén head, enlaces y size; valida posiciones y lanza IndexOutOfBoundsException antes de modificar. Compara datos con Objects.equals. Explica que el tipo de dato/nodo se generaliza a T, pero recorrido e invariantes no dependen del tipo. En main demuestra instancias separadas de Integer, String y Alumno (record) y resultados definidos, sin mezclar tipos. Incluye Javadoc con errores, casos y complejidades. Copia el prompt completo al inicio y registra los ajustes reales al final.
