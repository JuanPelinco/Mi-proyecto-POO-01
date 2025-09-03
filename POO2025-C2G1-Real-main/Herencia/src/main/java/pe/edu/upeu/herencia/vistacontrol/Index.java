/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.herencia.vistacontrol;

import pe.edu.upeu.herencia.modelo.Trabajador;

/**
 *
 * @author Ultra
 */
public class Index {
    public static void inicio(){
 Trabajador trabajador = new Trabajador(4500, "EsSalud", "Ventas", "Vendedor", 1,
"Juan", "Perez", "12345678", "10/10/2001");

 System.out.println("Datos del Trabajador");
 System.out.println("* ID: " + trabajador.getIdpersona());
 System.out.println("* Nombre: " + trabajador.getNombre());
 System.out.println("* Apellidos: " + trabajador.getApellido());
 System.out.println("* DNI: " + trabajador.getDni());
 System.out.println("* Fecha de Nacimiento: " + trabajador.getFecha_nacimiento());
 System.out.println("* Salario: " + trabajador.getSalario());
 System.out.println("* Seguro: " + trabajador.getSeguro());
 System.out.println("* Area de trabajo: " + trabajador.getArea_trabajo());
 System.out.println("* Cargo: " + trabajador.getCargo());
 System.out.println("-------------------------------------");
 }
 public static void main(String[] args) {
 inicio();
 }
}
