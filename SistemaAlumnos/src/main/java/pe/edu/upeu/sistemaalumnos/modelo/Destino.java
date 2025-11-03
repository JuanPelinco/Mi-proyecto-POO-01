package pe.edu.upeu.sistemaalumnos.modelo;

import lombok.Data;

@Data
public class Destino {
    private int id;
    private String nombre;
    private double precioBase;

    @Override
    public String toString() {
        return nombre + " (S/ " + precioBase + ")";
    }
}
