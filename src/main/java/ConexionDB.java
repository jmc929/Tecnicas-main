/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Josem
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
        
        
public class ConexionDB {
    public static void main(String[] args) {
        String URL_DB = "jdbc:mariadb://localhost:3306/thebank";
        String USER_DB = "root";
        String PASSWORD_DB = "1478";
        
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            System.out.println("conexion exitosa " + conexion);
            conexion.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Error, MariaDB driver no encontrado");
        }
        catch(SQLException e){
            System.out.println("Error al conectar la base de datos: "+ e.getMessage());
        }
    }
}
