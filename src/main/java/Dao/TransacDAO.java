/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author Josem
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Model.Transaccion;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class TransacDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/thebank";
    private String USER_DB = "root";
    private String PASSWORD_DB = "1478";
    
    //crud
    private static final String INSERTAR_TRANSACCION = "INSERT INTO transferencias (cedula, monto, tipo, fecha, tarifa) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECCIONAR_DATOS = "SELECT monto, tipo, fecha, tarifa FROM transferencias WHERE cedula = ? ORDER BY fecha DESC LIMIT 20 ";
    
    
    // Conexion
    protected Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("conectando a la BD...");
            conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            System.out.println(conexion);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: driver no encontrado");
        } catch (SQLException e) {
            System.out.println("Error al conectar la BD " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }
    
    // Insertar una transacción
    public void insertarTransaccion(Transaccion transaccion) {
        try (Connection conexion = getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_TRANSACCION)) {

            preparedStatement.setInt(1, transaccion.getCedula());
            preparedStatement.setBigDecimal(2, transaccion.getMonto());
            preparedStatement.setString(3, transaccion.getTipo());
            preparedStatement.setTimestamp(4, transaccion.getFecha());
            preparedStatement.setBigDecimal(5, transaccion.getTarifa());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar una transacción: " + e.getMessage());
        }
    }
    
public List<Transaccion> seleccionarTransaccionesPorCedula(int cedula) {
    List<Transaccion> transacciones = new ArrayList<>();
    try (Connection conexion = getConnection();
         PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_DATOS)) {
        preparedStatement.setInt(1, cedula);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Transaccion transaccion = new Transaccion();
            transaccion.setMonto(resultSet.getBigDecimal("monto"));
            transaccion.setTipo(resultSet.getString("tipo"));
            transaccion.setFecha(resultSet.getTimestamp("fecha"));
            transaccion.setTarifa(resultSet.getBigDecimal("tarifa"));
            transacciones.add(transaccion);
        }
    } catch (SQLException e) {
        System.out.println("Error al seleccionar info acerca de transacciones: " + e.getMessage());
    }
        System.out.println("Transacciones obtenidas: " + transacciones.size());
    return transacciones;
}

    
    
}
