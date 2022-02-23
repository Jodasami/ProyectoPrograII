<%-- 
    Document   : Park_Vehicle_Confirmation
    Created on : Feb 22, 2022, 9:01:34 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%

        String spaceNumber = (String) request.getAttribute("spaceNumber");


    %>


    <title>Confirmación Parqueo</title>
</head>
<body  background="Images/BG.png">
<center>
    <br><br>
    <b>
        <font size='7' color='white'>Su vehículo ha sido Parqueado en la posición <%=spaceNumber%> del Parqueo con Éxito</font>
    </b>
    
    <form action="RoleUserTypeServlet" method="post">
        
        <input type="submit" value="Aceptar">
        
    </form>
        
</center>
</html>
