/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet;

/**
 *
 * @author Josem
 */
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.TransacDAO;
import Model.Transaccion;
import jakarta.servlet.http.HttpSession;


@WebServlet("/mostrar")
public class ObtenerServlet extends HttpServlet {
    
      protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        HttpSession session = request.getSession();
        int cedula = (int) session.getAttribute("cedula");
        
      TransacDAO transacDAO = new TransacDAO();
      List<Transaccion> transacciones = transacDAO.seleccionarTransaccionesPorCedula(cedula);

      
       request.setAttribute("transacciones", transacciones);
       request.getRequestDispatcher("historial.jsp").forward(request, response);
    }
}
