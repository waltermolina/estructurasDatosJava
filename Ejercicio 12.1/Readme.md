
# Ejercicio 12.1 

A continuación se expone el código comentado del Ejercicio 12.1 de las páginas 348 y 349 del Libro Estructuras de Datos en Java.

## ❗ Acerca del ejercicio
El ejercicio  expone un ejemplo de uso del **método de la multiplicación** bajo el tema **Tablas de dispersión, funciones hash**.

### TL;DR
En este enlace podés probar el algoritmo desde tu navegador: [https://edjava-121.waltermolina.repl.run/](https://edjava-121.waltermolina.repl.run/)(puede tardar en cargar, si no funciona puedes abrir directamente el enlace del código).
Para ver el código comentado podes acceder a este [Repl.it](https://repl.it/@waltermolina/edJava-121) o ir directamente al archivo [DispersionHash.java](https://github.com/waltermolina/estructurasDatosJava/blob/master/Ejercicio%2012.1/DispersionHash.java) de este repositorio en Github.

## 🪧 Enunciado

> *Los **registros** que representan los **objetos de una perfumería** se van a **guardar en una tabla dispersa** de m = 1.024 posiciones.
> El campo **clave** es una **cadena de caracteres**, de la que se toman únicamente los 10 primeros.
> Se decide aplicar el método de la multiplicación como función de dispersión.
> Con este supuesto, **codificar la función de dispersión** y mostrar **10 direcciones dispersas**.*

## 📝 Resolución
#### **Paso 1**
Para generar la dispersión haciendo uso del método de la multiplicación, necesitamos transformar nuestra clave (recordemos que es una cadena de hasta 10 caracteres) en un número entero. Entonces, hacemos uso del método [`transformaClave()`](https://github.com/waltermolina/estructurasDatosJava/blob/master/Ejercicio%2012.1/DispersionHash.java).

Este método *recorre* el String **clave** *caracter a caracter* desde la primera letra (*posición 0*) *hasta la última letra* (o hasta la décima letra, la que encuentre primero). Veamos el código:

```java
long d = 0; //en d almacenaremos nuestra clave transformada
for (int j = 0; j < Math.min(clave.length(),10); j++) {
  d = d * 27 + (int)clave.charAt(j);
}
```
Si analizamos este `for` podemos encontrar que la condición de parada hace uso de dos métodos que pueden parecernos desconocidos: `length()` de la clase `String` y `min()` de la clase `Math`. Analicémoslos con detenimiento para poder entender nuestro algoritmo.
**Usando el método [`length()`](%28https://guru99.es/string-length-method-java/%29) se obtiene la cantidad de letras de la palabra.**

```java
clave.length() // para la palabra Walter retorna 6
```

**[`Math.min()`](https://www.discoduroderoer.es/metodos-de-la-clase-math-de-java/) nos permite elegir el menor entre un conjunto de valores**, en nuestro caso decide entre la última letra (la que recuperamos gracias al método `length()` ) y la décima letra (valor `10`). 

```java
Math.min(clave.length(),10)
```
Salvados los detalles, podemos pasar a analizar el cuerpo del bucle y conocer cómo realiza el proceso de transformación.

La sentencia `d = d * 27 + (int)clave.charAt(j)` hace una suma entre dos valores:

 1. Por un lado, se calcula el producto de `d` por `27`. El valor 27 responde a la cantidad de letras del alfabeto español.
2. El valor entero del caracter en la posicion `j` de la clave. Para recuperar el caracter deseado se usa el método [`charAt()`](https://guru99.es/string-charat-method-java/) de la clase `String`. Luego, ese valor se convierte a entero usando el [casting a `(int)`](https://javadesdecero.es/basico/conversion-tipo-ejemplos-casting/). Podemos chequear que el valor obtenido coincide con el [código ASCII](https://elcodigoascii.com.ar/) del caracter.
```java
d = d * 27 + (int)clave.charAt(j);
```

#### **Paso 2**
Una vez hecha la transformación, se aplica el **método de la multiplicación** haciendo uso del método  [`dispersion()`](https://github.com/waltermolina/estructurasDatosJava/blob/master/Ejercicio%2012.1/DispersionHash.java).

Este método es bastante simple. Recibe, en el parámetro formal `x`, el valor numérico de la clave ingresada por el usuario (la que calculamos en el Paso 1).

```java
static int dispersion(long x) {
	double t;
    int v;
    
    t = R * x - Math.floor(R * x);
    v = (int) (M * t); // M es la cantidad de posiciones de nuestra tabla
    
    return v;
  }
```
Analicemos las asignaciones en `t` y `v` que son las responsables de la magia.

En `t` *almacenamos sólo la parte decimal de nuestro producto*, haciendo uso de la diferencia entre:
1. `R * x` con su *parte entera y decimal* (todo el número). R es la constante para la dispersión. En nuestro algoritmo usamos la [inversa de la razón áurea](https://es.wikipedia.org/wiki/N%C3%BAmero_%C3%81ureo).
2. Sólo la *parte entera* de `R * x`, la cual se obtiene con la función [`floor()`](https://www.geeksforgeeks.org/java-floor-method-examples/) (Piso) que Java incluye en la libreria [Math](https://www.w3schools.com/java/java_math.asp).

Un ejemplo para entender el cálculo ():  `1.23 - 1.00 = 0.23`.

A continuación, en `v` almacenamos el producto de `M` (que representa la cantidad de posiciones de nuestra tabla) por la parte decimal obtenida y almacenada en `t`. 
```java
v = (int) (M * t);
```

Es importante notar que el resultado de la multiplicación será de tipo `double`, porque es el tipo de la variable `t`. Para poder guardarlo en `v`, debemos hacer el casting manual usando `(int)`.

## 💻 Prueba del algoritmo
En nuestro algoritmo, disponemos de un método `main` para poder probar el resultado del ejercicio. El método `main` simplemente cumple con la condición de  "*mostrar 10 direcciones dispersas*".

```java
public static void main(String[]a) throws IOException {
	String clave;
    long valor;
    
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    /*El algoritmo nos permite ingresar 10 palabras*/
    for (int k = 1; k <= 10; k++) {
      System.out.print("\nClave a dispersar: ");
      clave = entrada.readLine();
      
      valor = transformaClave(clave);
      valor = dispersion(valor);
	  
      System.out.println("Dispersion de la clave " + clave + " \t " + valor);
    }
  }
```
Analicemos el método:

 - Las variables `clave` y `valor`, son las responsables de almacenar la *clave introducida por el usuario* y el *valor calculado de la dispersión*.
 - `BufferedReader` es una clase muy útil para permitirnos ingresar datos a nuestro programa desde el teclado. El *Curso de Java* de *ProgramarYa* tiene un excelente tutorial sobre este concepto: [https://www.programarya.com/Cursos/Java/Entrada-de-datos](https://www.programarya.com/Cursos/Java/Entrada-de-datos). Podemos también pensar en compararlo con la clase Scanner que hemos usado en ejemplos previos, [¿cuál conviene usar?](http://ayudaitver.blogspot.com/2014/07/bufferedreader-vs-scanner-en-el.html)
 - Teniendo la clave, podemos empezar el proceso de transformación llamando a los métodos que estudiamos anteriormente.
 - Finalmente imprimimos el valor de la clave.

Es preciso notar que este proceso se repite 10 veces gracias al ciclo `for`.
