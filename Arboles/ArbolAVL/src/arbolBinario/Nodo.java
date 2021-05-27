package arbolBinario;

public class Nodo {

    protected Object dato;//Estudiante
    protected Nodo izdo;
    protected Nodo dcho;

    public Nodo(Object valor) {
        dato = valor;
        izdo = dcho = null;
    }

    public Nodo(Nodo ramaIzdo, Object valor, Nodo ramaDcho) {
        this(valor);
        izdo = ramaIzdo;
        dcho = ramaDcho;
    }
// operaciones de acceso

    public Object valorNodo() {
        return dato;
    }

    public Nodo subarbolIzdo() {
        return izdo;
    }

    public Nodo subarbolDcho() {
        return dcho;
    }

    public void nuevoValor(Object d) {
        dato = d;
    }

    public void ramaIzdo(Nodo n) {
        izdo = n;
    }

    public void ramaDcho(Nodo n) {
        dcho = n;
    }

    public void visitar() {
        //System.out.print(dato + " ");
        System.out.println(dato.toString());
        //return dato;
    }
}
