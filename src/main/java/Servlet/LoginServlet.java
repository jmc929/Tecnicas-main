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

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private CuentasDAO cuentasDAO;
    
    public LoginServlet(){
        this.cuentasDAO = new CuentasDAO();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("contraseña");

        if (cuentasDAO.iniciarSesion(correo, contraseña)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", correo);
            
            
            int cedula = cuentasDAO.obtenerCedulaPorCorreo(correo);
            session.setAttribute("cedula", cedula);
            
           
            

            response.sendRedirect("principal.jsp"); // Redirigir a principal.jsp
        } else {
            String mensajeError = "No hay cuenta registrada con ese correo o contraseña.";
            request.setAttribute("mensajeError", mensajeError);
            request.getRequestDispatcher("index.jsp").forward(request, response); // Redirigir a index.jsp con mensaje de error
        }
    }
}
