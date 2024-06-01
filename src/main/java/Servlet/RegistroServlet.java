/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet;

/**
 *
 * @author Josem
 */

import Dao.CuentasDAO;
import Model.Cuenta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private CuentasDAO cuentasDAO ;
    
    public RegistroServlet(){
        this.cuentasDAO = new CuentasDAO();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contraseña");
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        
        Cuenta nuevaCuenta = new Cuenta(nombre, telefono, cedula, correo, contraseña);
        cuentasDAO.insertarUsuario(nuevaCuenta);
        
         try {
            cuentasDAO.insertarUsuario(nuevaCuenta);
            String mensajeRegistro = "Registrado correctamente";
            request.setAttribute("mensajeError", mensajeRegistro);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error al registrar la cuenta: " + e.getMessage());
        }
    }
    
}
