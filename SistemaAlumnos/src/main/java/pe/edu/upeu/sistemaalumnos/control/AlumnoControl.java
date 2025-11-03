package pe.edu.upeu.sistemaalumnos.control;

import pe.edu.upeu.sistemaalumnos.modelo.Alumno;
import pe.edu.upeu.sistemaalumnos.servicio.AlumnoServicio;

import java.util.List;
import java.util.Scanner;

public class AlumnoControl {

    static AlumnoServicio alumnoServicio = new AlumnoServicio();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n📚=== SISTEMA DE GESTIÓN DE ALUMNOS ===");
            System.out.println("1️  Agregar alumno");
            System.out.println("2️  Listar alumnos");
            System.out.println("3️  Actualizar alumno");
            System.out.println("4️  Eliminar alumno");
            System.out.println("0️  Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> listar();
                case 3 -> actualizar();
                case 4 -> eliminar();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void agregar() {
        System.out.println("\nRegistrar nuevo alumno");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.print("Correo: ");
        String correo = sc.nextLine();

        Alumno a = new Alumno(0, nombre, apellido, edad, correo);
        alumnoServicio.agregarAlumno(a);
    }

    private static void listar() {
        System.out.println("\nLista de alumnos:");
        List<Alumno> lista = alumnoServicio.listarAlumnos();
        for (Alumno a : lista) {
            System.out.printf("%d | %s %s | %d años | %s\n",
                    a.getId(), a.getNombre(), a.getApellido(), a.getEdad(), a.getCorreo());
        }
    }

    private static void actualizar() {
        System.out.println("\nActualizar alumno");
        System.out.print("ID del alumno: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Nueva edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.print("Nuevo correo: ");
        String correo = sc.nextLine();

        Alumno a = new Alumno(id, nombre, apellido, edad, correo);
        alumnoServicio.actualizarAlumno(a);
    }

    private static void eliminar() {
        System.out.println("\nEliminar alumno");
        System.out.print("ID del alumno: ");
        int id = Integer.parseInt(sc.nextLine());
        alumnoServicio.eliminarAlumno(id);
    }
}

