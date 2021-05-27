
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Walter
 */
public class TestFromFile {

    public static void main(String[] args) {
        TablaDispersaEnlazada TDE = new TablaDispersaEnlazada();

        try {
            Scanner sc = new Scanner(new File("C:\\Users\\Walter\\Documents\\NetBeansProjects\\TablaDispersaEncadenada\\src\\data.csv"));
            //sc.useDelimiter(",");
            while (sc.hasNext())
            {
                String [] a = sc.next().split(",");
                // 0 codigo
                // 1 nombre
                // 2 edad
                // 3 fecha
                Socio s = new Socio(a[1], Integer.parseInt(a[0]), Integer.parseInt(a[2]), a[3]);
                TDE.insertar(s);
                
            }
            sc.close();  //closes the scanner  

        } catch (FileNotFoundException fnf) {
            System.out.println("Error al abrir el archivo");
        }
        
        /*
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\Walter\\Documents\\NetBeansProjects\\TablaDispersaEncadenada\\src\\data.csv"));
            //sc.useDelimiter(",");
            while (sc.hasNext())
            {
                String [] a = sc.next().split(",");
                int d = TablaDispersaEnlazada.dispersion(Integer.parseInt(a[0]));
                System.out.println("Codigo "+ a[0] + " | pos "+ d);
            }
            sc.close();  //closes the scanner  

        } catch (FileNotFoundException fnf) {
            System.out.println("Error al abrir el archivo");
        }
        */
        
        System.out.print("Ingrese codigo: ");
        Scanner s = new Scanner(System.in);
        
        String entrada = s.next();
        
        Elemento e = TDE.buscar(Integer.parseInt(entrada));
        int pos = TablaDispersaEnlazada.dispersion(Integer.parseInt(entrada));
        
        if(e != null && e.getSocio() != null){
            System.out.println(pos);
            System.out.println(e.getSocio().toString());
        }
        
        
    }
}
