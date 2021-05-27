/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinarioordenado;

/**
 *
 * @author Walter
 */
public class Estudiante implements Comparador {

    private int numMat;
    private String nombre;

    public Estudiante(int numMat, String nombre) {
        this.numMat = numMat;
        this.nombre = nombre;
    }

    public Estudiante(int numMat) {
        this.numMat = numMat;
    }
    
    
    public int getNumMat() {
        return numMat;
    }

    public void setNumMat(int numMat) {
        this.numMat = numMat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean igualQue(Object op2) {
        Estudiante p2 = (Estudiante) op2;
        return this.numMat == p2.numMat;
    }

    @Override
    public boolean menorQue(Object op2) {
        Estudiante p2 = (Estudiante) op2;
        return numMat < p2.numMat;
    }

    @Override
    public boolean menorIgualQue(Object op2) {
        Estudiante p2 = (Estudiante) op2;
        return numMat <= p2.numMat;
    }

    @Override
    public boolean mayorQue(Object op2) {
        Estudiante p2 = (Estudiante) op2;
        return numMat > p2.numMat;
    }

    @Override
    public boolean mayorIgualQue(Object op2) {
        Estudiante p2 = (Estudiante) op2;
        return numMat >= p2.numMat;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "numMat=" + numMat + ", nombre=" + nombre + '}';
    }    
    
}
