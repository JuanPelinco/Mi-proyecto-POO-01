package pe.edu.upeu.encapsulamiento;

import lombok.*;

/*@Getter

@Setter*/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private String posicion;
    private int numeroCam;

    @Override
    public String toString() {
        return "El jugador tiene estas caracteristicas:\n" +
                "nombre:"+nombre+"\n"
                + "apellido:"+apellido+"\n"
                + "edad:"+edad+"\n"
                + "posicion:"+posicion+"\n"
                +  "Camiseta N:"+numeroCam+"\n";

    }
}
