/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinarioordenado;

import arbolBinario.*;

public class TestArbolBinario {

    public static void main(String[] args) {
        System.out.println("=== Arbol Binario de Busqueda ===");

        ArbolBinarioBusqueda arbolBinarioBusqueda = new ArbolBinarioBusqueda();

        try {
            arbolBinarioBusqueda.insertar(new Estudiante(10, "Walter"));
            arbolBinarioBusqueda.insertar(new Estudiante(15, "Tatiana"));
            arbolBinarioBusqueda.insertar(new Estudiante(7, "Olivia"));
            arbolBinarioBusqueda.insertar(new Estudiante(3, "Chuck"));
            arbolBinarioBusqueda.insertar(new Estudiante(9, "Julio"));
            arbolBinarioBusqueda.insertar(new Estudiante(1, "Timoteo"));
        } catch (Exception e) {
            System.out.println("Error al Insertar! " + e.getMessage());
        }
        try {
            //Búsqueda
            Estudiante estudianteBuscado;
            Nodo n = arbolBinarioBusqueda.buscar(new Estudiante(10));
            if (n != null && n.valorNodo() instanceof Estudiante) {
                estudianteBuscado = (Estudiante) n.valorNodo();
                System.out.println("Buscado: " + estudianteBuscado.toString());
            } else {
                System.out.println("Buscado: NO ENCONTRADO");
            }
        } catch (Exception e) {
            System.out.println("Error al Buscar! " + e.getMessage());
        }

        try{
            arbolBinarioBusqueda.eliminar(new Estudiante(15));
        }catch(Exception e){
            System.out.println("Error al Eliminar! " + e.getMessage());
        }
        
        try {
            //Recorrido
            System.out.println("\nPreorden");
            ArbolBinario.preorden(arbolBinarioBusqueda.raizArbol());

        } catch (Exception e) {
            System.out.println("Error al recorrer! " + e.getMessage());
        }
        
        try {
            //Recorrido
            System.out.println("\nInorden");
            ArbolBinario.inorden(arbolBinarioBusqueda.raizArbol());
            

        } catch (Exception e) {
            System.out.println("Error al recorrer! " + e.getMessage());
        }
        
        try {
            System.out.println("\nPostorden");
            ArbolBinario.postorden(arbolBinarioBusqueda.raizArbol());

        } catch (Exception e) {
            System.out.println("Error al recorrer! " + e.getMessage());
        }
    }

}
