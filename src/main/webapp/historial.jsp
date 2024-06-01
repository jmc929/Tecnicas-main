<%-- 
    Document   : principal
    Created on : 25/05/2024, 3:43:45 p. m.
    Author     : Josem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bancoin</title>
    <link rel="stylesheet" href="css/estilos3.css">
    <link rel="website icon" href="imagenes/moneda.png">
</head>     
<body>
    <div id="principal">
        <h1 class="titulo1">Historial transaccional</h1>
        <div id="secundario">
    <table border="1">
      <tr>
        <th>Monto</th>
        <th>Tipo</th>
        <th>Fecha</th>
        <th>tarifa</th>
      </tr>
      <tbody>
        <c:forEach items="${transacciones}" var="transaccion">
          <tr>
            <td><c:out value="${transaccion.monto}" /></td>
            <td><c:out value="${transaccion.tipo}" /></td>
            <td><c:out value="${transaccion.fecha}" /></td>
            <td><c:out value="${transaccion.tarifa}" /></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
                    
          <form action="mostrar" method="get">
              <button type="submit" value="mostrar" id="mostrar">Mostrar historial</button>
          </form>
          
          <li><button id="volver"><a class="no-linea" href="principal.jsp">volver</button></a></li>
              
          
        </div>
    </div>
    </body>
    </html>                 