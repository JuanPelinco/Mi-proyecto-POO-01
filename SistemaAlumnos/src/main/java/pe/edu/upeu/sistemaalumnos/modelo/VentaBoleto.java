package pe.edu.upeu.sistemaalumnos.modelo;

public class VentaBoleto {
    private int id;
    private Alumno alumno;
    private Destino destino;
    private Horario horario;
    private double precio;

    public VentaBoleto(int id, Alumno alumno, Destino destino, Horario horario, double precio) {
        this.id = id;
        this.alumno = alumno;
        this.destino = destino;
        this.horario = horario;
        this.precio = precio;
    }

    // Getters y setters
    public int getId() { return id; }
    public Alumno getAlumno() { return alumno; }
    public Destino getDestino() { return destino; }
    public Horario getHorario() { return horario; }
    public double getPrecio() { return precio; }

    public void setId(int id) { this.id = id; }
    public void setAlumno(Alumno alumno) { this.alumno = alumno; }
    public void setDestino(Destino destino) { this.destino = destino; }
    public void setHorario(Horario horario) { this.horario = horario; }
    public void setPrecio(double precio) { this.precio = precio; }
}
