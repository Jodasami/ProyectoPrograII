<%-- 
    Document   : Park_Vehicle_In_Parking_Lot
    Created on : 10 feb. 2022, 00:46:05
    Author     : jodas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parquear Vehículos</title>
    </head>
    <body  background="Images/BG.png">
    <center>
        <br><br>
        <font size='9' color='white'>Parquear Vehículos</font>

        <form action="ParkingVehiclesServlet" method="get">

            <br><br>

            <font size='5' color='white'>Número del Parqueo:</font>

            <input type="text" name="idParking">      

            <br>

            <font size='5' color='white'>Cédula del Cliente:</font>

            <input type="text" name="idUser"> 

            <br>

            <font size='5' color='white'>Placa del Vehículo:</font>

            <input type="text" name="plate"> 

            <input type="submit" value="Continuar" />
        </form>
    </center>

</html>
