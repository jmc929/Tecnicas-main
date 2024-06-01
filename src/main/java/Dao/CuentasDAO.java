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


import Model.Cuenta;
import java.math.BigDecimal;

public class CuentasDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/thebank";
    private String USER_DB = "root";
    private String PASSWORD_DB = "1478";
    
    
    //CRUD
    private static final String INSERTAR_CUENTA = "INSERT INTO cuentas (nombre, telefono, correo, contraseña, cedula) VALUES (?,?,?,?,?)";
    private static final String AUTENTICAR = "SELECT * FROM cuentas where correo= ? AND contraseña = ?";
    private static final String ELIMINAR_CUENTA = "DELETE FROM cuentas WHERE cedula = ?";
    private static final String OBTENER_SALDO_POR_CORREO = "SELECT Saldo FROM cuentas WHERE correo = ?";
    private static final String OBTENER_CEDULA = "SELECT cedula FROM cuentas WHERE correo = ?";
    private static final String ACTUALIZAR_SALDO = "UPDATE cuentas SET Saldo= ? WHERE cedula = ?";
    private static final String OBTENER_SALDO_POR_CEDULA = "SELECT Saldo FROM cuentas WHERE cedula = ?";



    
    
    //Conexion
    protected Connection getConnection(){
        Connection conexion = null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("conectando a la BD...");
            conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            System.out.println(conexion);
        } 
        catch(ClassNotFoundException e){
            System.out.println("Error: driver no encontrado");  
        }
        catch(SQLException e){
            System.out.println("Error al conectar la BD " + e.getMessage() );
            e.printStackTrace();
        }
        return conexion;
    }
    // Crear un usuario
    public void insertarUsuario(Cuenta nuevaCuenta){
        try(
                Connection conexion = getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_CUENTA)){
                
                preparedStatement.setString(1, nuevaCuenta.getNombre());
                preparedStatement.setString(2, nuevaCuenta.getTelefono());
                preparedStatement.setString(3, nuevaCuenta.getCorreo());
                preparedStatement.setString(4, nuevaCuenta.getContraseña());
                preparedStatement.setInt(5, nuevaCuenta.getCedula());
                preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Error al insertar una cuenta: " + e.getMessage());
        }          
    }
        
    // login
    public boolean iniciarSesion(String correo, String contraseña){
        boolean esAutenticado = false;
        try(
                Connection conexion = getConnection();
                PreparedStatement preparedStatement = conexion.prepareStatement(AUTENTICAR)){
                
            preparedStatement.setString(1, correo);
            preparedStatement.setString (2, contraseña);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            esAutenticado = resultSet.next();

        }
            catch(SQLException e){
            System.out.println("Error al intentar a hacer login: " + e.getMessage());
        }
        return esAutenticado;
    }
    
    
    public BigDecimal obtenerSaldoPorCorreo(String correo) {
        BigDecimal saldo = BigDecimal.ZERO; // Valor predeterminado en caso de que no se encuentre ninguna cuenta

        try (Connection conexion = getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(OBTENER_SALDO_POR_CORREO)) {

            preparedStatement.setString(1, correo);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                saldo = resultSet.getBigDecimal("Saldo");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el saldo por correo: " + e.getMessage());
        }

        return saldo;
    }
    
    public int obtenerCedulaPorCorreo(String correo) {
        int cedula = -1;
        try (
            Connection conexion = getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(OBTENER_CEDULA)) {

            preparedStatement.setString(1, correo);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cedula = resultSet.getInt("cedula");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la cédula: " + e.getMessage());
        }
        return cedula;
    }
    
    public BigDecimal obtenerSaldoPorCedula(int cedula) {
    BigDecimal saldo = BigDecimal.ZERO; // Valor predeterminado en caso de que no se encuentre ninguna cuenta

    try (Connection conexion = getConnection();
         PreparedStatement preparedStatement = conexion.prepareStatement(OBTENER_SALDO_POR_CEDULA)) {

        preparedStatement.setInt(1, cedula);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            saldo = resultSet.getBigDecimal("Saldo");
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el saldo por cédula: " + e.getMessage());
    }

    return saldo;
}
    
    
    public void actualizarSaldo(int cedula, BigDecimal nuevoSaldo) {
    try (Connection conexion = getConnection();
         PreparedStatement preparedStatement = conexion.prepareStatement(ACTUALIZAR_SALDO)) {

        preparedStatement.setBigDecimal(1, nuevoSaldo);
        preparedStatement.setInt(2, cedula);

        preparedStatement.executeUpdate();
    } 
    catch (SQLException e) {
        System.out.println("Error al actualizar el saldo: " + e.getMessage());
        }
    }
}
  
