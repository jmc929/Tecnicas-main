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
import Dao.TransacDAO;
import Model.Transaccion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

        
@WebServlet("/retiro")        
public class RetiroServlet extends HttpServlet {
        private TransacDAO transacDAO;
        private CuentasDAO cuentasDAO;

    public RetiroServlet() {
        this.transacDAO = new TransacDAO();
        this.cuentasDAO = new CuentasDAO();
    }
    
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        int cedula = (int) session.getAttribute("cedula"); // Obtiene la cédula del usuario de la sesión

        // Obtiene el monto del formulario
        BigDecimal monto = new BigDecimal(request.getParameter("monto"));
        
        String moneda = request.getParameter("moneda");

        BigDecimal montoconvertido = convertirMoneda(monto, moneda);
        
        BigDecimal saldoActual = cuentasDAO.obtenerSaldoPorCedula(cedula);
        
        BigDecimal tarifa;
        if (montoconvertido.compareTo(new BigDecimal("50000")) < 0) {
            tarifa = new BigDecimal("100");
        } else {
            tarifa = montoconvertido.multiply(new BigDecimal("0.01"));
        }
        
         BigDecimal montoTotalDeducir = montoconvertido.add(tarifa);
        
        if (saldoActual.compareTo(montoTotalDeducir) >= 0){
        
        BigDecimal nuevoSaldo = saldoActual.subtract(montoTotalDeducir);

        // Crea una nueva transacción para el depósito
        Transaccion transaccion = new Transaccion(cedula, montoconvertido, "Retiro", new Timestamp(System.currentTimeMillis()),tarifa);
        
        cuentasDAO.actualizarSaldo(cedula, nuevoSaldo);

        // Inserta la transacción en la base de datos
        transacDAO.insertarTransaccion(transaccion);
        


        
            String mensajeRetiro = "se realizo el retiro de manera correcta.";
            request.setAttribute("mensajeRetiro", mensajeRetiro);
            request.getRequestDispatcher("principal.jsp").forward(request, response); 
    }
        else {
            String mensajeRetiroF = "Saldo insuficiente, no se realizó el retiro.";
            request.setAttribute("mensajeRetiroF", mensajeRetiroF);
            request.getRequestDispatcher("principal.jsp").forward(request, response); 
        }
  }
    
    private BigDecimal convertirMoneda(BigDecimal monto, String moneda){
        BigDecimal tasaCambio;
        switch (moneda) {
            case "USD":
                // Tasa de cambio USD a COP (ejemplo, debes actualizar con la tasa actual)
                tasaCambio = new BigDecimal("4000");
                break;
            case "EUR":
                // Tasa de cambio EUR a COP (ejemplo, debes actualizar con la tasa actual)
                tasaCambio = new BigDecimal("4500");
                break;
            case "COP":
            default:
                tasaCambio = BigDecimal.ONE;
                break;
        }
        return monto.multiply(tasaCambio);
    }
}