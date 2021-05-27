/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Walter
 */
public class Test {
    public static void main(String[] args) {
        TablaDispersaEnlazada TDE = new TablaDispersaEnlazada();
        TablaDispersaEnlazada tabla1 = new TablaDispersaEnlazada();
        
        Socio s1 = new Socio("Walter", 200, 32, 26, 4, 2021);
        Socio s2 = new Socio("Tatiana", 999, 32, 23, 5, 2020);
        Socio s3 = new Socio("Olivia", 182, 7, 7, 11, 2015);
        Socio s4 = new Socio("Gabriel", 400, 32, 26, 4, 2021);
        Socio s5 = new Socio("Clara", 998, 32, 23, 5, 2020);
        Socio s6 = new Socio("Sandra", 183, 7, 7, 11, 2015);
        
        TDE.insertar(s1);
        TDE.insertar(s2);
        TDE.insertar(s3);
        TDE.insertar(s4);
        TDE.insertar(s5);
        TDE.insertar(s6);
        
        tabla1.insertar(s1);
        tabla1.insertar(s2);
        
        
        tabla1.dispersion(0);
        TDE.dispersion(0);
        
        System.out.print(TablaDispersaEnlazada.dispersion(200) + " | ");
        System.out.println(TDE.buscar(200).getSocio().toString());
        
        System.out.print(TablaDispersaEnlazada.dispersion(999) + " | ");
        System.out.println(TDE.buscar(999).p.toString());
        
        System.out.print(TablaDispersaEnlazada.dispersion(182) + " | ");
        System.out.println(TDE.buscar(182).socio.toString());
        
        System.out.print(TablaDispersaEnlazada.dispersion(400) + " | ");
        System.out.println(TDE.buscar(400).socio.toString());
        
        System.out.print(TablaDispersaEnlazada.dispersion(998) + " | ");
        System.out.println(TDE.buscar(998).socio.toString());
        
        System.out.print(TablaDispersaEnlazada.dispersion(183) + " | ");
        System.out.println(TDE.buscar(183).socio.toString());
        
        // prueba de posiciones
        for(int i = 101; i<= 1999; i++){
            System.out.println(i+" pos "+TablaDispersaEnlazada.dispersion(i));
        }
        
        Socio s10 = new Socio("Walter", 101, 35, "12//10/1987");
        System.out.println(s10.getNombre());
    }
}
