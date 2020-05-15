/**
 * EJERCICIO 12.1 - Pag 348 y 349
 * Función hash: Método de la multiplicación
 * 
 * Code review and comments by Walter Molina (github.com/waltermolina).
 * Original code from ESTRUCTURAS DE DATOS EN JAVA by Luis Joyanes Aguilar & Ignacio Zahonero Martínez
 * ISBN 978-84-481-5631-2

 */

// Importamos el paquete de entrada/salida estandar para poder hacer uso de BufferedReader
import java.io.*;

class DispersionHash {
  // Cantidad de posiciones de la tabla
  static final int M = 1024; 
  
  // Constante para la dispersión: Inversa de la razón áurea (https://es.wikipedia.org/wiki/Número_Áureo)
  static final double R = 0.618034;

  /**
   * Convierte la clase en un número entero
   * @param   clave   la clave a transformar
   * @return          valor entero de la clave 
   */
  static long transformaClave(String clave) {
    
    // d almacenará el valor entero calculado.
    long d;
	
	// 0 es la mínima posición de la tabla
    d = 0;
    
	/**
	 * Recorremos el string clave desde la posición la primera letra (posición 0) 
	 * hasta la última letra o hasta la décima letra.
	 * Usando el método length() se obtiene la cantidad de letras
	 * de la palabra (https://guru99.es/string-length-method-java/)
	 * Math.min nos permite elegir el menor entre dos valores, en nuestro caso entre
	 * la última letra y la décima letra.
	 */
    for (int j = 0; j < Math.min(clave.length(),10); j++) {
	  // En d guardamos la suma de:
      // (1) Lo que tiene d * 27. El número 27 responde a la cantidad de caracteres del alfabeto
	  // (2) El valor entero del caractero en la posicion j de la clave.
	  //     Para recuperar el caracter deseado se usa el método charAt().
	  //     Luego, ese valor se convierte a entero usando el casting (int). El valor 
	  //     obtenido coincide con el código ASCII del caracter.
      d = d * 27 + (int)clave.charAt(j);
      
	  // Ayuda: Para ver cómo va cambiando el valor de d, puedes descomentar la siguiente línea.
	  //System.out.println("d: "+ d);
    }
    
    /* NOTA: en algunas implementaciones, el algoritmo puede generar un número 
     * mayor que el máximo entero que puede gestionar la computadora. En ese caso,
	 * debido al overflow, el número obtenido será negativo.
	 * Es preciso corregir esa desviación para que el número esté en el rango de los
	 * enteros positivos.
     */
    
    if (d < 0) d = -d;
    
	// Finalmente, retornamos el valor entero de la clave.
    return d;
  }
  
  /**
   * Método de la multiplicación
   * @param   x   valor entero de la clave
   * @return      dirección dispersa, un número entero en el rango 0 ... M-1 
   */
  static int dispersion(long x) {
    
	// t es donde almacenaremos nuestros calculos con parte decimal
	double t;
	
	// v almacenará el valor truncado entero de interés para el retorno
    int v;
    
	// En t almacenamos sólo la parte decimal de nuestro producto, 
	// haciendo uso de la diferencia entre:
	// (1) R*x con su parte entera y decimal (todo el número)
	// (2) Sólo la parte entera de R*x, la cual se obtiene con la función Piso
	//     que Java incluye en la libreria Math.
	//     Ejemplo: 1.234 - 1.000 = 0.234
    t = R * x - Math.floor(R * x); // parte decimal
	
	// A continuación, obtenemos el producto de M por la parte decimal obtenida
	// y lo convertimos a entero para poder retornarlo.
    v = (int) (M * t);
    
    return v;
  }



  /**  
   * Método principal. Inicia la ejecución del algoritmo.
   * Nos permite ingresas 10 palabras obteniendo la Dispersión de la clave para
   * cada una de ellas.
   * 
   * @throws IOException En caso de haber errores en el uso de entrada por teclado.
   */
  public static void main(String[]a) throws IOException {
    //Clave que introducirá el usuario
	String clave;
	//Valor de la clave obtneido por el algoritmo.
    long valor;
	
    // La clase BufferedReader nos permite ingresar datos. En este caso, desde la entrada estándar.
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    /*El algoritmo nos permite ingresar 10 palabras*/
    for (int k = 1; k <= 10; k++) {
      //Primero nos pide la clave a dispersar haciendo uso de la entrada construida con BufferedReader.
      //El método readLine() registra el ingreso desde el teclado hasta que se oprime la tecla ENTER.
      System.out.print("\nClave a dispersar: ");
      clave = entrada.readLine();

      //Luego, utiliza el método transformaClave para convertir la clave en un número entero
      valor = transformaClave(clave);

      // Con el núemro entero obtenido, se aplica el método de la multiplicación.
      valor = dispersion(valor);
	  
      System.out.println("Dispersion de la clave " + clave + " \t " + valor);
    }
  }
}
