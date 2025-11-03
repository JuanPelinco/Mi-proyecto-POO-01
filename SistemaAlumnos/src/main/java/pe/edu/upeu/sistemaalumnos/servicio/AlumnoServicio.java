package pe.edu.upeu.sistemaalumnos.servicio;

import pe.edu.upeu.sistemaalumnos.modelo.Alumno;
import pe.edu.upeu.sistemaalumnos.repositorio.AlumnoRepositorio;

import java.util.List;

public class AlumnoServicio {

    private final AlumnoRepositorio repo = new AlumnoRepositorio();

    public void agregarAlumno(Alumno a) {
        repo.insertar(a);
    }

    public List<Alumno> listarAlumnos() {
        return repo.listar();
    }

    public void actualizarAlumno(Alumno a) {
        repo.actualizar(a);
    }

    public void eliminarAlumno(int id) {
        repo.eliminar(id);
    }
}

