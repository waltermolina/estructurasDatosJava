/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Walter
 */
public class Elemento {

    Persona p;
    Elemento sgte;

    public Elemento(Persona p) {
        p = p;
        sgte = null;
    }

    public Persona getSocio() {
        return p;
    }
}
