/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl;

/**
 *
 * @author Walter
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import arbolBinario.*;

import arbolBinario.ArbolBinario;
import arbolBinario.Nodo;
import arbolAVL.ArbolAVL;
import arbolbinarioordenado.Estudiante;

public class TestArbolAVL {

    public static void main(String[] args) {
        System.out.println("=== Arbol AVL ===");

        ArbolAVL arbol = new ArbolAVL();

        try {
            arbol.insertar(new Estudiante(10, "Walter"));
            arbol.insertar(new Estudiante(15, "Tatiana"));
            arbol.insertar(new Estudiante(7, "Olivia"));
            arbol.insertar(new Estudiante(3, "Chuck"));
            arbol.insertar(new Estudiante(9, "Julio"));
            arbol.insertar(new Estudiante(1, "Timoteo"));
            arbol.insertar(new Estudiante(4, "Pablo"));
        } catch (Exception e) {
            System.out.println("Error al Insertar! " + e.getMessage());
        }
        
        try{
            arbol.eliminar(new Estudiante(3));
        } catch(Exception e){
            System.out.println("Error al Eliminar! " + e.getMessage());
        } 
        
        
        try {
            //Recorrido
            System.out.println("\nPreorden");
            ArbolBinario.preorden(arbol.raizArbol());

        } catch (Exception e) {
            System.out.println("Error al recorrer! " + e.getMessage());
        }
        
        try {
            //Recorrido
            System.out.println("\nInorden");
            ArbolBinario.inorden(arbol.raizArbol());
            

        } catch (Exception e) {
            System.out.println("Error al recorrer! " + e.getMessage());
        }
        
        try {
            System.out.println("\nPostorden");
            ArbolBinario.postorden(arbol.raizArbol());

        } catch (Exception e) {
            System.out.println("Error al recorrer! " + e.getMessage());
        }
    }

}

