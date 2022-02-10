<%-- 
    Document   : show_all_users
    Created on : 19/01/2022, 02:33:47 PM
    Author     : jodas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Vehículos</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
    <center>
        <table border="2">
            <td>Placa</td>
            <td>Color</td>
            <td>Marca</td>
            <td>Modelo</td>
            <td>Dueño</td>
            <td>Tipo de Vehículo</td>

            <c:forEach items="${vehicles}" var="currentVehicle">
                <tr>
                    <td><c:out value="${currentVehicle.plate}"/> </td>
                    <td><c:out value="${currentVehicle.color}"/> </td>
                    <td><c:out value="${currentVehicle.brand}"/> </td>
                    <td><c:out value="${currentVehicle.model}"/> </td>
                    <td><c:out value="${currentVehicle.owner}"/> </td>
                    <td><c:out value="${currentVehicle.vehicleType}"/> </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>