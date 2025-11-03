package pe.edu.upeu.sistemaalumnos.repositorio;

import pe.edu.upeu.sistemaalumnos.modelo.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoRepositorio {

    private final Connection conn;

    public AlumnoRepositorio() {
        this.conn = ConexionBD.getConnection();
    }

    public void insertar(Alumno a) {
        String sql = "INSERT INTO alumno(nombre, apellido, edad, correo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setInt(3, a.getEdad());
            ps.setString(4, a.getCorreo());
            ps.executeUpdate();
            System.out.println("voleto insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }


    public List<Alumno> listar() {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumno";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Alumno a = new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getString("correo")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }


    public void actualizar(Alumno a) {
        String sql = "UPDATE alumno SET nombre=?, apellido=?, edad=?, correo=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setInt(3, a.getEdad());
            ps.setString(4, a.getCorreo());
            ps.setInt(5, a.getId());
            ps.executeUpdate();
            System.out.println("voleto actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }


    public void eliminar(int id) {
        String sql = "DELETE FROM alumno WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("voleto eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
