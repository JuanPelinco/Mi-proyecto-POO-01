/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.arraylistobjetoherencia_y_submenu.modelo;

/**
 *
 * @author Ultra
 */
public class Persona {
    private int idpersona;
 private String nombre;
 private String dni;
 public Persona() {
 }
 public Persona(int idpersona, String nombre, String dni) {
 this.idpersona = idpersona;
 this.nombre = nombre;
 this.dni = dni;
 }
 public String getDni() {
 return dni;
 }
 public void setDni(String dni) {
 this.dni = dni;
 }
 public int getIdpersona() {
 return idpersona;
 }
 public void setIdpersona(int idpersona) {
 this.idpersona = idpersona;
 }
 public String getNombre() {
 return nombre;
 }
 public void setNombre(String nombre) {
 this.nombre = nombre;
 }
}
