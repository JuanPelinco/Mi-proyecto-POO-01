/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.arraylistobjetoherencia_y_submenu.vistacontrol;

import pe.edu.upeu.arraylistobjetoherencia_y_submenu.utils.Lectura;
import pe.edu.upeu.arraylistobjetoherencia_y_submenu.utils.Utilitarios;

/**
 *
 * @author Ultra
 */
    public class Indexprincipal {
 private static Lectura leer = new Lectura();
 public static void menu(){
 System.out.print("""
 *** MENU PRINCIPAL ***
1. Trabajador
2. Estudiante
3. Salir
""");
 System.out.print("Seleccione opcion [1-3]: ");
 }
 public static void inicio(){
 int opcion;
 Indextrabajador.datosdeinstalacion();
 Indexestudiante.datosdeinstalacion();
 do {
 menu();
 opcion = leer.entero();
 switch (opcion) {
 case 1 -> Indextrabajador.inicio();
 case 2 -> Indexestudiante.inicio();
 case 3 -> Utilitarios.salir();
 default -> Utilitarios.error(1);
 }
 } while (opcion!=3);
 }
}


