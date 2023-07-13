<%-- 
    Document   : tiendaget
    Created on : 12 jul. 2023, 19:16:27
    Author     : Usuario
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina de registro de Contacto</h1>
        <form action="<%= request.getContextPath()%>/TiendaServlet" method="GET">
            <label>Nombre:</label>
            <input type="text" name="nombre">
            <br>
            <label>Documento:</label>
            <input type="text" name="documento">
            <br>
            <label>Direccion:</label>
            <input type="text" name="direccion">
            <br>
            <label>Telefono:</label>
            <input type="txt" name="telefono">
            <br>
            <label>FechadeNac:</label>
            <input type="txt" name="fechadenac">
            <br>
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
