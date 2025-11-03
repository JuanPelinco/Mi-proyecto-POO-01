package pe.edu.upeu.sistemaalumnos.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:sqlite:data/alumnos.db";
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {

                Class.forName("org.sqlite.JDBC");

                conn = DriverManager.getConnection(URL);
                System.out.println("Conectado a SQLite correctamente");
            } catch (ClassNotFoundException e) {
                System.out.println("No se encontró el driver JDBC: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error al conectar: " + e.getMessage());
            }
        }
        return conn;
    }
}


