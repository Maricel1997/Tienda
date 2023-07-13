<%-- 
    Document   : create
    Created on : 12 jul. 2023, 19:21:52
    Author     : Usuario
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Registro de Profesores</title>
        <link rel="stylesheet" href="<%=request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/css/bootstrap.min.css"/>
        <script defer src="<%= request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        

        <h1 class="text-center text-primary">Registrar de Tienda</h1>
         <jsp:include page="../templates/header.jsp"></jsp:include>
        <div class="container">
            <form action="<%= request.getContextPath() %>/TiendaServlet?action=create" method="POST">
                <div class="mb-3">
                    <label for="nombre" class="form-label"> Nombre:</label> 
                    <input type="text" class="form-control"  name="nombre" id="nombre" required minlength="1" maxlength="100" placeholder="Nombre del Tienda">
                </div>
                <div class="mb-3">
                    <label for="documento" class="form-label">Documento:</label>
                    <input type="text" class="form-control" name="documento" id="documento" required minlength="1" maxlength="100" placeholder="Breve Descripcion"/>
                </div>
                <div class="mb-3">
                    <label for="direccion" class="form-label" >Direccion:</label>
                    <input type="text" class="form-control" name="direccion" id="direccion" required minlength="1" maxlength="100" placeholder="Breve descripción"/>
                </div>
                <div class="mb-3">
                    <label for="telefono" class="form-label">Telefono:</label>
                    <input type="text" class="form-control" name="telefono" id="telefono" required minlength="6" maxlength="50" placeholder="Breve Descripcion"/>
                </div>
                 <div class="mb-3">
                    <label for="fechadenac" class="form-label">Fechadenac:</label>
                    <input type="text" class="form-control" name="fechadenac" id="fechadenac" required minlength="6" maxlength="50" placeholder="Breve Descripcion"/>
                </div>
               
                <button type="submit" class="btn btn-primary">Guardar</button>
            </form>
        </div>
    </body>
</html>