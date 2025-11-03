package pe.edu.upeu.sistemaalumnos.modelo;

import lombok.Data;
import java.sql.Date;

@Data
public class Venta {
    private int id;
    private String cliente;
    private Destino destino;
    private Horario horario;
    private double precio;
    private Date fecha;
}
