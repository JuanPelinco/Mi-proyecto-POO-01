/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.arraylistobjetoherencia_y_submenu.modelo;

/**
 *
 * @author Ultra
 */
public class Estudiante extends Persona{
 private String codigo;
 private String carrera;
 public Estudiante() {
 }
 public Estudiante(int idpersona, String nombre, String dni) {
 super(idpersona, nombre, dni);
 }
 public Estudiante(String codigo, String carrera, int idpersona, String nombre, String dni) {
 super(idpersona, nombre, dni);
 this.codigo = codigo;
 this.carrera = carrera;
 }
 public String getCarrera() {
 return carrera;
 }
 public void setCarrera(String carrera) {
 this.carrera = carrera;
 }
 public String getCodigo() {
 return codigo;
 }
 public void setCodigo(String codigo) {
 this.codigo = codigo;
}}
