<%-- 
    Document   : Show_Vehicles
    Created on : Feb 15, 2022, 1:25:49 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Vehículos</title>
    </head>
    <body background="Images/BG.png">

        <i>
            <marquee  <b><font color="white" size="8">Lista de Vehículos en el Sistema </font></b>
            </marquee>
        </i>

        <br><br><br>

    <center>
        <br><br>
        <table border="2">

            <td bgcolor="#000000" ><font size="5" color="white"><b>Placa</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Color</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Marca</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Modelo</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Propietario</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Tipo de Vehículo</b></font> </td>

            <c:forEach items="${vehicles}" var="currentVehicle" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? '#2666CF' : '#F5F2E7'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentVehicle.plate}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentVehicle.color}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.brand}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.model}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.owner}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.vehicleType}"/></font></td>

                    <td><font size="5"><a href="VehicleRetrievalServlet?action=edit&vehiclePlate=<c:out value="${currentVehicle.plate}"/>">Modificar Vehículo</a></font>
                        <font size="5"><a href="VehicleRetrievalServlet?action=delete&vehiclePlate=<c:out value="${currentVehicle.plate}"/>">Eliminar Vehículo</a></font></td>
                </tr>
            </c:forEach>



        </table>
        <br><br><br>
        <input type="button" value="Volver al menú principal" onclick= "history.back()" >
    </center>

</body>
</html>
