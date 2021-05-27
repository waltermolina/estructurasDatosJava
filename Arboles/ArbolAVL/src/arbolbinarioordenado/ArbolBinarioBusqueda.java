package arbolbinarioordenado;

import arbolBinario.*;

public class ArbolBinarioBusqueda extends ArbolBinario {
    
    public ArbolBinarioBusqueda() {
        super();
    }

    public ArbolBinarioBusqueda(Nodo raiz) {
        super(raiz);
    }
    
    public Nodo buscar(Object buscado) {
        Comparador dato;
        dato = (Comparador) buscado;
        if (raiz == null) {
            return null;
        } else {
            return localizar(raizArbol(), dato);
        }
    }

    protected Nodo localizar(Nodo raizSub, Comparador buscado) {
        if (raizSub == null) {
            return null;
        } else if (buscado.igualQue(raizSub.valorNodo())) {
            return raiz;
        } else if (buscado.menorQue(raizSub.valorNodo())) {
            return localizar(raizSub.subarbolIzdo(), buscado);
        } else {
            return localizar(raizSub.subarbolDcho(), buscado);
        }
    }

    public void insertar(Object valor) throws Exception {
        Comparador dato;
        dato = (Comparador) valor;
        raiz = insertar(raiz, dato);
    }

    //método interno para realizar la operación
    protected Nodo insertar(Nodo raizSub, Comparador dato) throws Exception {
//        try{
//            System.out.print("RAIZ: "+(raizSub.valorNodo().toString()));
//        } catch(Exception e){
//            System.out.print("RAIZ: "+raizSub);
//        }
//        System.out.println("DATO: "+dato.toString());
//        
//        
        
        if (raizSub == null) {
            raizSub = new Nodo(dato);
        } else if (dato.menorQue(raizSub.valorNodo())) {
            Nodo iz;
            iz = insertar(raizSub.subarbolIzdo(), dato);
            raizSub.ramaIzdo(iz);
        } else if (dato.mayorQue(raizSub.valorNodo())) {
            Nodo dr;
            dr = insertar(raizSub.subarbolDcho(), dato);
            raizSub.ramaDcho(dr);
        } else {
            throw new Exception("Nodo duplicado");
        }
        return raizSub;
    }

    public void eliminar(Object valor) throws Exception {
        Comparador dato;
        dato = (Comparador) valor;
        raiz = eliminar(raiz, dato);
    }

    //método interno para realizar la operación
    protected Nodo eliminar(Nodo raizSub, Comparador dato) throws Exception {
        try {
            System.out.print("RAIZ: "+(raizSub.valorNodo().toString()));
        } catch(Exception e){
            System.out.print("RAIZ: "+raizSub);
        }
        
        
        if (raizSub == null) {
            throw new Exception("No encontrado el nodo con la clave");
        } else if (dato.menorQue(raizSub.valorNodo())) {
            Nodo iz;
            iz = eliminar(raizSub.subarbolIzdo(), dato);
            raizSub.ramaIzdo(iz);
        } else if (dato.mayorQue(raizSub.valorNodo())) {
            Nodo dr;
            dr = eliminar(raizSub.subarbolDcho(), dato);
            raizSub.ramaDcho(dr);
        } else {
            // Nodo encontrado
            Nodo q;
            q = raizSub; // nodo a quitar del árbol
            if (q.subarbolIzdo() == null) {
                raizSub = q.subarbolDcho();
            } else if (q.subarbolDcho() == null) {
                raizSub = q.subarbolIzdo();
            } else { // tiene rama izquierda y derecha
                q = reemplazar(q);
            }
            q = null;
        }
        return raizSub;
    }

    // método interno para susutituir por el mayor de los menores
    private Nodo reemplazar(Nodo act) {
        Nodo a, p;
        p = act;
        a = act.subarbolIzdo(); // rama de nodos menores
        while (a.subarbolDcho() != null) {
            p = a;
            a = a.subarbolDcho();
        }
        act.nuevoValor(a.valorNodo());
        if (p == act) {
            p.ramaIzdo(a.subarbolIzdo());
        } else {
            p.ramaDcho(a.subarbolIzdo());
        }
        return a;
    }

}
