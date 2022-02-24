<%-- 
    Document   : Pay_ParkingLot
    Created on : Feb 23, 2022, 11:28:36 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%

        String fee = (String) request.getAttribute("fee");
        String idParking = (String) request.getAttribute("idParking");
        String plate = (String) request.getAttribute("plate");

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancelación Monto</title>
    </head>
    <body  background="Images/BG.png">
    <center>
        <br><br>
        <font size='9' color='white'>Cancelación de Monto</font>

        <br><br><br><br><br>

        <form action="RemoveVehicleServlet" method="post">

            <font size='5' color='white'>El total del monto a pagar es: <%=fee%></font>

            <font size='5' color='white'>Gracias por utilizar nuestro Servicio</font>

            <br><br>

            <input type="submit" value="Aceptar" />

            <input type="hidden" name="idParking" value=<%=idParking%>>

            <input type="hidden" name="plate" value=<%=plate%>>
            
        </form>
    </center>
</html>
