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
import java.math.BigDecimal;

@WebServlet("/consultarSaldo")
public class ConsultarSaldoServlet extends HttpServlet{
    private CuentasDAO cuentasDAO ;
    
    public ConsultarSaldoServlet(){
        this.cuentasDAO = new CuentasDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Obtener el correo del usuario que ha iniciado sesión
        String correo = (String) request.getSession().getAttribute("user");
        
        // Obtener el saldo de la cuenta del usuario por correo electrónico
        BigDecimal saldo = cuentasDAO.obtenerSaldoPorCorreo(correo);
        
        // Establecer el saldo como un atributo en la sesión
        request.getSession().setAttribute("saldo", saldo);
        
        // Redireccionar al JSP para mostrar el saldo
        response.sendRedirect("principal.jsp");
    }
}
