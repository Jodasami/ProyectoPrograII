<%-- 
    Document   : show_info_users
    Created on : Jan 19, 2022, 7:50:41 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente insertado</title>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        %>
    </head>
    <body>
        Datos del cliente insertado:
        Nombre: <%=name%>
        Correo: <%=email%>
        Teléfono: <%=phone%>
        Dirección: <%=address%>
        Usuario: <%=username%>
        Password: <%=password%>
    </body>
</html>

