<%-- 
    Document   : principal
    Created on : 25/05/2024, 3:43:45 p. m.
    Author     : Josem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bancoin</title>
    <link rel="stylesheet" href="css/estilos2.css">
    <link rel="website icon" href="imagenes/moneda.png">
</head>     
<body>
    <div id="principal">
        <h1 class="titulo1">Bancoin</h1>
        <div id="secundario">
                    <img id="foto" src="imagenes/perfil.webp" alt="">
                    <h1 class="titulo2">Nombre. . .</h1>
                    <form action="consultarSaldo" method="get">  
                        
                            <li>
                                <input id="consultar" type="number" value="${saldo}" readonly> <br>
                                <button type="submit" id="consultar-boton" value="Consultar saldo">Consultar saldo</button>
                            </li>
                    </form>
                                
                    <form action="deposito" method="post">
                        <li>
                            <input id="valor-transferir" type="number" name="monto" placeholder="Ingrese el valor a depositar" autocomplete="off"><br>
                            <button type="submit" id="transferir" value="COP" name="moneda" type="submit" >Depositar en COP</button>
                            <button type="submit" id="transferir" value="USD" name="moneda" type="submit" >Depositar en USD</button>
                            <button type="submit" id="transferir" value="EUR" name="moneda" type="submit" >Depositar en EUR</button>

                        </li>
                        
                    </form>
                    <form action="retiro" method="post">            
                        <li>
                            <input id="valor-retirar" type="number" name="monto" placeholder="Ingrese el valor a retirar" autocomplete="off"><br>
                            <button type="submit" id="retirar" value="COP" name="moneda">Retirar en COP</button>
                            <button type="submit" id="retirar" value="USD" name="moneda">Retirar en USD</button>
                            <button type="submit" id="retirar" value="EUR" name="moneda">Retirar en EUR</button>
                          
                        </li>
                                                     
                                <% if (request.getAttribute("mensajeRetiro") != null) { %>
                <p class="error"><%= request.getAttribute("mensajeRetiro") %></p>
            <% } %>  
            
                                <% if (request.getAttribute("mensajeDeposito") != null) { %>
                <p class="error"><%= request.getAttribute("mensajeDeposito") %></p>
            <% } %>                    
                    </form>       
                                <% if (request.getAttribute("mensajeRetiroF") != null) { %>
                <p class="error"><%= request.getAttribute("mensajeRetiroF") %></p>
            <% } %>   
                                <% if (request.getAttribute("mensajeDepositoF") != null) { %>
                <p class="error"><%= request.getAttribute("mensajeDepositoF") %></p>
            <% } %>             
                    </form>
        </div>
    </div>
        <div id="izquierda">
            <h1 class="titulo">Otras opciones</h1>
            <form>
                <ul>
                        <li><input type="button" class="opciones" id="mayor" value="Informacion personal"></input></li>
                        <li><button class="opciones"><a class="no-linea" href="historial.jsp"> Historial</button></a></li>
                        <li><button class="opciones">Pagar facturas</button></li>
                        <li><button class="opciones">Donaciones</button></li>
                        <li><button class="opciones"><a class="no-linea" href="index.jsp">Desactivar cuenta</button></a></li>
                    </ul>
            </form>
        </div>
        <div id="abajo">
            <h1 class="titulo">Politicas</h1>
            <ul>
                <ul>
                    <li><button class="opciones"><a href="Politicas.jsp">Politicas y privacidad</button></a></li>
                    <li><button class="opciones">Sobre Nosotros</button></li>
                    <li><button class="opciones">Redes sociales</button></li>
                    <li class="historial"><input type="text" readonly class="contador-final" id="historial-mayor"></li>
                </ul>
            </ul>
        </div>
    </body>
    </html>                 