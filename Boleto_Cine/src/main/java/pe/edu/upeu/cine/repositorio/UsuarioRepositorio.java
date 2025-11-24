package pe.edu.upeu.cine.repositorio;

import pe.edu.upeu.cine.util.ConexionSQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepositorio {

    public boolean validarUsuario(String user, String pass) {
        String sql = "SELECT * FROM usuario WHERE username=? AND password=?";

        try (Connection con = ConexionSQLite.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean registrarUsuario(String user, String pass) {
        String sql = "INSERT INTO usuario (username, password, rol) VALUES (?, ?, ?)";

        try (Connection con = ConexionSQLite.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, "usuario");

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }


    public boolean eliminarUsuario(String user) {
        String sql = "DELETE FROM usuario WHERE username = ?";

        try (Connection con = ConexionSQLite.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }
}
