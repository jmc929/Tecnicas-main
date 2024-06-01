<%-- 
    Document   : index
    Created on : 25/05/2024, 3:15:00 p. m.
    Author     : Josem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bancoin</title>
    <link rel="stylesheet" href="css/estilos.css">
    <link rel="website icon" href="imagenes/moneda.png">
</head>
<body>
    <div id="principal"> 
        <h1 class="titulo1">Cuenta Bancaria</h1>
        <div id="secundario">
            <h1 class="titulo2">Iniciar sesión</h1>
            <form action="login" method = "post">  
                <fieldset class="mi-fieldset"> <!--Aqui uso el fieldset solo en el codigo, swe que es para separar secciones, en el css le quito el estilo porque no me gusta-->
                    <legend> <!-- el legend pone un titulo al campo generado por el fieldeset, como no es de mi gusto, no puse ningun titulo-->
                        <ul>
                             <li>
                                <label id="usuario" for="usuario-boton">Usuario:</label><br>
                                <input id="usuario-boton" autocomplete="off" name="correo" type="text" required >
                            </li>
                            <li>
                                <label id="contraseña" for="contraseña-boton">Contraseña:</label><br>
                                <input id="contraseña-boton" autocomplete="off" name="contraseña" type="password" required>
                                
                            </li>
                            <li>
                                <button class="iniciar"><a class="no-linea">Iniciar</button></a>
                            </li>
                <% if (request.getAttribute("mensajeError") != null) { %>
                <p class="error"><%= request.getAttribute("mensajeError") %></p>
            <% } %>
                        </ul>
                    </legend>
                </fieldset>
            </form>
        </div>
    </div>
    <div id="izquierda">
        <h1 class="titulo">crear cuenta</h1>
        <form action = "registro" method = "post">
            <p>
            <ul>
                    <li ><input class="crear" type="text" placeholder="Nombre" name = "nombre" required autocomplete="off"></li>
                    <li ><input class="crear" type="text" placeholder="telefono" name ="telefono" required autocomplete="off"></li>
                    <li ><input class="crear" type="email" placeholder="Correo Electronico" name="correo" required autocomplete="off"></li>
                    <li ><input class="crear" type="password" placeholder="Contraseña" name="contraseña" required autocomplete="off"></li>
                    <li ><input class="crear" type="text" placeholder="C.C" name="cedula" required autocomplete="off"></li>
                    <li><button class="crear1">Crear cuenta</button></li>
                <% if (request.getAttribute("mensajeRegistro") != null) { %>
                <p class="error"><%= request.getAttribute("mensajeRegistro") %></p>
            <% } %>
                </ul>
            </p>
                

        </form>
    </div>  
    <div id="abajo">
        <h1 class="titulo">Reactivar Cuenta</h1>
        <form>
            <ul>
                <li><input class="reactivar" type="text" placeholder="C.C" required autocomplete="off"></li>
                <li><input class="reactivar" type="email" placeholder="Correo Electronico" required autocomplete="off"></li>
                <li><input class="reactivar" type="password" placeholder="contraseña" required autocomplete="off"></li>
                <li><button class="reactivar1">Reactivar Cuenta</button></li>
            </ul>
        </form>
    </div>
</body>

</html>
