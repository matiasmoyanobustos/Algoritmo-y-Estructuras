# Guía — Listas enlazadas simples

Trabajo práctico sobre listas enlazadas simples en Java 21 con OpenCode. Cada ejercicio tiene una clase independiente, una demostración con datos predefinidos, Javadoc y su prompt inicial en un comentario fuente. La especificación completa está en [ESPECIFICACION.md](ESPECIFICACION.md), los prompts en [PROMPTS.md](PROMPTS.md) y las entradas/salidas verificadas en [PRUEBAS.md](PRUEBAS.md).

## Ejercicios

1. Crear lista enlazada de enteros.
2. Buscar elementos.
3. Obtener por posición.
4. Insertar en posición.
5. Eliminar por valor.
6. Eliminar por posición.
7. Modificar elemento.
8. Contar ocurrencias.
9. Invertir lista.
10. Lista enlazada genérica para Integer, String y Alumno.

## Requisitos y compilación

Se requiere JDK 21. No hay dependencias externas. Desde esta carpeta, compilar todos los ejercicios:

```sh
mkdir -p out
javac --release 21 -d out src/*.java
```

Ejecutar una clase de forma independiente:

```sh
java -cp out Ejercicio01CrearListaEnlazada
```

Cada clase incluye sus propias pruebas en `main`; para ejecutar otro ejercicio, sustituí el nombre por el de la tabla:

| Ejercicio | Clase |
|---|---|
| 1 | `Ejercicio01CrearListaEnlazada` |
| 2 | `Ejercicio02BuscarEnLista` |
| 3 | `Ejercicio03ObtenerPorPosicion` |
| 4 | `Ejercicio04InsertarEnPosicion` |
| 5 | `Ejercicio05EliminarPorValor` |
| 6 | `Ejercicio06EliminarPorPosicion` |
| 7 | `Ejercicio07ModificarElemento` |
| 8 | `Ejercicio08ContarOcurrencias` |
| 9 | `Ejercicio09InvertirLista` |
| 10 | `Ejercicio10ListaEnlazadaGenerica` |

## Javadoc y pruebas

Generar Javadoc de la API:

```sh
javadoc --release 21 -d docs src/*.java
```

Compilar y ejecutar pruebas con entradas y resultados esperados/observados: consultar [PRUEBAS.md](PRUEBAS.md).

`out/` y `docs/` son artefactos generados y no deben versionarse.
