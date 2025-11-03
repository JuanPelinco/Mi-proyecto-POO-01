package pe.edu.upeu.sistemaalumnos.servicio;

import pe.edu.upeu.sistemaalumnos.modelo.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class VentaServicio {

    private Connection conn;

    public VentaServicio() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:alumnos.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Destino> listarDestinos() {
        List<Destino> lista = new ArrayList<>();
        String sql = "SELECT * FROM destino";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Destino d = new Destino();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setPrecioBase(rs.getDouble("precio_base"));
                lista.add(d);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public List<Horario> listarHorarios() {
        List<Horario> lista = new ArrayList<>();
        String sql = "SELECT * FROM horario";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Horario h = new Horario();
                h.setId(rs.getInt("id"));
                h.setHoraSalida(rs.getString("hora_salida"));
                h.setHoraLlegada(rs.getString("hora_llegada"));
                lista.add(h);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public void guardarVenta(Venta v) {
        String sql = "INSERT INTO venta_boleto (cliente, destino_id, horario_id, precio, fecha) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, v.getCliente());
            ps.setInt(2, v.getDestino().getId());
            ps.setInt(3, v.getHorario().getId());
            ps.setDouble(4, v.getPrecio());
            ps.setString(5, v.getFecha().toString());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void actualizarVenta(Venta v) {
        String sql = "UPDATE venta_boleto SET cliente = ?, destino_id = ?, horario_id = ?, precio = ?, fecha = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, v.getCliente());
            ps.setInt(2, v.getDestino().getId());
            ps.setInt(3, v.getHorario().getId());
            ps.setDouble(4, v.getPrecio());
            ps.setString(5, v.getFecha().toString());
            ps.setInt(6, v.getId());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void eliminarVenta(int id) {
        String sql = "DELETE FROM venta_boleto WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Venta> listarVentas() {
        List<Venta> lista = new ArrayList<>();
        String sql = """
            SELECT v.id, v.cliente, v.precio, v.fecha,
                   d.id AS did, d.nombre AS dnombre, d.precio_base,
                   h.id AS hid, h.hora_salida, h.hora_llegada
            FROM venta_boleto v
            JOIN destino d ON v.destino_id = d.id
            JOIN horario h ON v.horario_id = h.id
        """;
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Venta v = new Venta();
                v.setId(rs.getInt("id"));
                v.setCliente(rs.getString("cliente"));
                v.setPrecio(rs.getDouble("precio"));
                v.setFecha(Date.valueOf(rs.getString("fecha")));

                Destino d = new Destino();
                d.setId(rs.getInt("did"));
                d.setNombre(rs.getString("dnombre"));
                d.setPrecioBase(rs.getDouble("precio_base"));

                Horario h = new Horario();
                h.setId(rs.getInt("hid"));
                h.setHoraSalida(rs.getString("hora_salida"));
                h.setHoraLlegada(rs.getString("hora_llegada"));

                v.setDestino(d);
                v.setHorario(h);
                lista.add(v);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }
}
