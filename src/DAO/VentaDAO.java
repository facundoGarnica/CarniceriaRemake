/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CarpetaClases.Fecha;
import CarpetaClases.Venta;
import ConexionDB.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DAO.FechaDAO;

/**
 *
 * @author garca
 */
public class VentaDAO {

    private ConexionDB conexionDB;

    public VentaDAO() {
        this.conexionDB = new ConexionDB();
    }

    // Método para agregar una nueva venta
    public boolean agregarVenta(Venta venta) {
        String sql = "INSERT INTO venta (Fecha_id, medio_pago, total) VALUES (?, ?, ?)";
        try (Connection conn = conexionDB.conectar()) {
            conn.setAutoCommit(false); // Desactivar auto-commit para manejar manualmente las transacciones
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, venta.getFecha().getId());  // ID de la hoja asociada
                stmt.setString(2, venta.getMedioDePago());  // Medio de pago
                stmt.setInt(3, venta.getTotal());  // Total de la venta

                int affectedRows = stmt.executeUpdate();

                if (affectedRows > 0) {
                    ResultSet generatedKeys = stmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        venta.setId(generatedKeys.getInt(1));  // Asignar el ID generado a la venta
                    }
                    conn.commit();  // Confirmar la transacción
                    System.out.println("Venta agregada con éxito.");
                    return true;
                }
            } catch (SQLException e) {
                conn.rollback();  // Revertir cambios si ocurre algún error
                System.out.println("Error al agregar venta: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return false;
    }

    // Método para obtener una venta por su ID
    public Venta obtenerVentaPorId(int id) {
        String sql = "SELECT * FROM venta WHERE id = ?";
        Venta venta = null;

        try (Connection conn = conexionDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                venta = new Venta();
                FechaDAO fechaDAO = new FechaDAO();  // Si aún necesitas usar FechaDAO para el manejo de la fecha
                int fechaIdInt = rs.getInt("fecha");

                Fecha fecha = fechaDAO.obtenerFechaPorId(fechaIdInt);
                // Rellenar los atributos de la venta
                venta.setId(rs.getInt("id"));
                venta.setFecha(fecha);  // Asignar la fecha
                venta.setMedioDePago(rs.getString("medio_pago"));
                venta.setTotal(rs.getInt("total"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener venta: " + e.getMessage());
        }

        return venta;
    }

    // Método para obtener todas las ventas
    public ArrayList<Venta> obtenerTodasLasVentas() {
        String sql = "SELECT * FROM venta";
        ArrayList<Venta> ventas = new ArrayList<>();

        try (Connection conn = conexionDB.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId(rs.getInt("id"));
                // Venta ahora tiene fecha (no hoja_id), asumiendo que se maneja correctamente en la base de datos
                FechaDAO fechaDAO = new FechaDAO();
                int fechaIdInt = rs.getInt("fecha");  // Obtienes el ID de la fecha
                Fecha fecha = fechaDAO.obtenerFechaPorId(fechaIdInt);  // Obtener la fecha
                venta.setFecha(fecha);  // Asignar la fecha a la venta
                venta.setMedioDePago(rs.getString("medio_pago"));
                venta.setTotal(rs.getInt("total"));
                ventas.add(venta);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener todas las ventas: " + e.getMessage());
        }

        return ventas;
    }

    // Método para actualizar una venta
    public boolean actualizarVenta(Venta venta) {
        String sql = "UPDATE venta SET fecha = ?, medio_pago = ?, total = ? WHERE id = ?";
        try (Connection conn = conexionDB.conectar()) {
            conn.setAutoCommit(false);  // Desactivar auto-commit
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, venta.getFecha().getId());  // Asignar el ID de la fecha
                stmt.setString(2, venta.getMedioDePago());
                stmt.setInt(3, venta.getTotal());
                stmt.setInt(4, venta.getId());

                int affectedRows = stmt.executeUpdate();
                if (affectedRows > 0) {
                    conn.commit();  // Confirmar la transacción
                    return true;
                }
            } catch (SQLException e) {
                conn.rollback();  // Revertir cambios si ocurre un error
                System.out.println("Error al actualizar venta: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return false;
    }

    // Método para eliminar una venta
    public boolean eliminarVenta(int id) {
        String sql = "DELETE FROM venta WHERE id = ?";
        try (Connection conn = conexionDB.conectar()) {
            conn.setAutoCommit(false);  // Desactivar auto-commit
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                int affectedRows = stmt.executeUpdate();
                if (affectedRows > 0) {
                    conn.commit();  // Confirmar la transacción
                    return true;
                }
            } catch (SQLException e) {
                conn.rollback();  // Revertir cambios si ocurre un error
                System.out.println("Error al eliminar venta: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return false;
    }

    public ArrayList<Venta> obtenerVentasPorFecha(int anio, int mes, int dia) {
        ArrayList<Venta> ventas = new ArrayList<>();
        // Formatear la fecha en formato YYYY-MM-DD
        String fecha = String.format("%04d-%02d-%02d", anio, mes, dia);
        System.out.println("Fecha formateada: " + fecha);  // Depurar: Verifica la fecha antes de usarla

        // Consulta directa por fecha usando DATE() para ignorar la parte de la hora
        String sql = "SELECT v.id, v.fecha, v.medio_pago, v.total "
                + "FROM venta v "
                + "JOIN Fecha f ON v.fecha = f.id "
                + "WHERE DATE(f.fecha) = ?";  // Usar DATE() para comparar solo la fecha (sin hora)

        try (Connection conn = conexionDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Establecer el parámetro con la fecha formateada
            stmt.setString(1, fecha);

            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados de la consulta
            while (rs.next()) {
                // Crear el objeto Venta y asignar los valores
                Venta venta = new Venta();
                venta.setId(rs.getInt("id"));

                // Obtener la fecha desde la base de datos
                int fechaId = rs.getInt("fecha");  // Asumiendo que la columna en la tabla venta es "fecha"
                FechaDAO fechaDAO = new FechaDAO();
                Fecha fechaObj = fechaDAO.obtenerFechaPorId(fechaId);  // Obtener la fecha por ID

                venta.setFecha(fechaObj);  // Asignar la fecha completa a la venta
                venta.setMedioDePago(rs.getString("medio_pago"));
                venta.setTotal(rs.getInt("total"));

                // Agregar la venta a la lista
                ventas.add(venta);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las ventas por fecha: " + e.getMessage());
        }

        return ventas;
    }

}
