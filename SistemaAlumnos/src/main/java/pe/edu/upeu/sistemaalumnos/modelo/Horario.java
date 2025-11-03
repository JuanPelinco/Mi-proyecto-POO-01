package pe.edu.upeu.sistemaalumnos.modelo;

import lombok.Data;

@Data
public class Horario {
    private int id;
    private String horaSalida;
    private String horaLlegada;

    @Override
    public String toString() {
        return horaSalida + " - " + horaLlegada;
    }
}
