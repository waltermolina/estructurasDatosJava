package arbolBinario;

public class ArbolBinario {

    protected Nodo raiz;

    //Constructor Arbol vacío
    public ArbolBinario() {
        raiz = null;
    }

    //Constructor con nodos
    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }

    // Comprueba el estatus del árbol (si está vacío)
    boolean esVacio() {
        return raiz == null;
    }

    //Recupera la raíz
    public Nodo raizArbol() {
        return raiz;
    }

    //
    public static Nodo nuevoArbol(Nodo ramaIzqda, Object dato, Nodo ramaDrcha) {
        return new Nodo(ramaIzqda, dato, ramaDrcha);
    }

    // Recorrido de un árbol binario en preorden
    public static void preorden(Nodo r) {
        if (r != null) {
            r.visitar();
            preorden(r.subarbolIzdo());
            preorden(r.subarbolDcho());
        }
    }
    
    public static void inorden(Nodo r){
    if (r != null){
      inorden (r.subarbolIzdo());
      r.visitar();
      inorden (r.subarbolDcho());
    }
  }
  
  // Recorrido de un árbol binario en postorden
  public static void postorden(Nodo r){
    if (r != null){
      postorden (r.subarbolIzdo());
      postorden (r.subarbolDcho());
      r.visitar();
    }
  }

}
