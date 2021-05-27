
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Walter
 */
public class Socio extends Persona {
    
    private int codigo;
    private int edad;
    private LocalDate fecha;

    public Socio(String nombre, int codigo, int edad, int dia, int mes, int año) {
        super(nombre);
        this.codigo = codigo;
        
        this.edad = edad;
        this.fecha = LocalDate.of(año, mes, dia);
    }

    public Socio(String nombre, int codigo, int edad, String date) {
        super(nombre);
        this.codigo = codigo;
        
        this.edad = edad;
        this.fecha = LocalDate.of(
                Integer.parseInt(date.split("/")[2]), 
                Integer.parseInt(date.split("/")[1]), 
                Integer.parseInt(date.split("/")[0])
        );
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Socio{" + "codigo=" + codigo + ", edad=" + edad + ", fecha=" + fecha + '}';
    }

}