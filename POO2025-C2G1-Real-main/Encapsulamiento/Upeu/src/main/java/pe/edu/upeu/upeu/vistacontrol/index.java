/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.upeu.vistacontrol;

import jdk.jfr.Percentage;
import pe.edu.upeu.upeu.modelo.Persona;
import pe.edu.upeu.upeu.utils.Lectura;

/**
 *
 * @author Ultra
 */
public class index {
    public static void inicio(){
        Lectura leer = new Lectura();
        Persona persona = new Persona();
 //CLASE OBJETO CONSTRUCTOR

 // Ingresar valores al objeto
 System.out.print("> Nombre: ");
 persona.setNombre(leer.cadena());
 System.out.print("> Edad: ");
 persona.setEdad(leer.entero());
 System.out.print("> Talla: ");
 persona.setTalla(leer.decimal());

 // Mostrar valores del objeto
 System.out.println("DATOS INGRESADOS");
 System.out.println("* Nombre: " + persona.getNombre());
 System.out.println("* Edad: " + persona.getEdad());
 System.out.println("* Talla: " + persona.getTalla());
 }
 public static void main(String[] args) {
 inicio();
 }
}

