package pe.edu.upeu.encapsulamiento;

import pe.edu.upeu.encapsulamiento.modelo.Estudiante;

public class ClaseGeneral {

    public static void probarJugador(){
        Jugador jugador = new Jugador();
        jugador.setNombre("Juanito");
        jugador.setApellido("Mamani");
        jugador.setEdad(25);
        jugador.setPosicion("DELANTERO");
        jugador.setNumeroCam(15);
        System.out.println(jugador);
    }



    public static void probar(){
        Estudiante estudiante = new Estudiante();
        estudiante.setCarrera("Ing Sistemas");
        estudiante.setCodigo("202510855");
        estudiante.trabajo();

    }




    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setEdad(17);
        persona.setGenero('M');
        persona.saludo();
        System.out.println("Genero " + persona.getGenero());

        probar();
        probarJugador();
    }
}
