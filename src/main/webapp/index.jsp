<%-- 
    Document   : index
    Created on : 12 jul. 2023, 19:16:49
    Author     : Usuario
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Gesetion de Profesores</title>
         <link rel="stylesheet" href="<%=request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/css/bootstrap.min.css"/>
        <script defer src="<%= request.getContextPath() %>/webjars/bootstrap/5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
       
         <h1></h1
         <jsp:include page="/templates/header.jsp"></jsp:include> 
        <div class="container text-center">
            <h1>Gestion de Tienda!</h1>
        
            <div class="row">
                <div class="col-sm-6 d-flex justify-content-center">
                <div class="card" style="width: 18rem;">
                 <img src="assets/img/Profesor.png" class="card-img-top" alt="...">
                 <div class="card-body">
                 <h5 class="card-title">Registro de Tienda</h5>
    <p class="card-text">Registrar Tienda</p>
    <a href="<%= request.getContextPath() %>/TiendaServlet?action=showRegister" class="btn btn-primary">Registrar</a>
  
            </div>
        </div>
    </body>
</html>
