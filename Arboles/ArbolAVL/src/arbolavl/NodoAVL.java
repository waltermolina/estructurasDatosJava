package arbolAVL;

import arbolBinario.*;

public class NodoAVL extends Nodo {

    int fe; // puede ser -1, 0, +1

    public NodoAVL(Object valor) {
        super(valor);
        fe = 0;
    }

    public NodoAVL(Object valor, NodoAVL ramaIzdo, NodoAVL ramaDcho) {
        super(ramaIzdo, valor, ramaDcho);
        fe = 0;
    }
}
