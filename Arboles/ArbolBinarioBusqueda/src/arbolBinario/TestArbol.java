package arbolBinario;

public class TestArbol {

    public static void main(String[] args) {
        try {
            
            ArbolBinario arbol;
            Nodo a1, a2, a;
            
            a1 = ArbolBinario.nuevoArbol(null, "Maria", null);
            a2 = ArbolBinario.nuevoArbol(null, "Rodrigo", null);
            a = ArbolBinario.nuevoArbol(a1, "Esperanza", a2);
            
            a1 = ArbolBinario.nuevoArbol(null, "Anyora", null);
            a2 = ArbolBinario.nuevoArbol(null, "Abel", null);
            a = ArbolBinario.nuevoArbol(a1, "M Jesus", a2);
            
            a = ArbolBinario.nuevoArbol(a1, "Esperanza", a2);
            arbol = new ArbolBinario(a);
            
            ArbolBinario.preorden(arbol.raizArbol());
            System.out.println("------");
            ArbolBinario.inorden(arbol.raizArbol());
            System.out.println("------");
            ArbolBinario.postorden(arbol.raizArbol());
            
        } catch (Exception ex) {
            System.out.println("Ups! " + ex.getMessage());
        }
    }

}
