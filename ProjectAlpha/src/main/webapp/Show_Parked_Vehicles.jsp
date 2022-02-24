<%-- 
    Document   : Show_Parked_Vehicles
    Created on : Feb 24, 2022, 12:55:46 AM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Vehículos Parqueados</title>
    </head>
    <body background="Images/BG.png">

        <i>
            <marquee  <b><font color="white" size="8">Lista de Vehículos Parqueados en el Sistema </font></b>
            </marquee>
        </i>

        <br><br><br>

    <center>
        <br><br>
        <table border="2">

            <td bgcolor="#000000" ><font size="5" color="white"><b>Placa</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Nombre del Parqueo</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Espacio en el que se Parqueó</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Tiempo Parqueado Estimado</b></font> </td>

            <c:forEach items="${vehicles}" var="currentVehicle" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? '#2666CF' : '#F5F2E7'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentVehicle.plate}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentVehicle.parkingName}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.spaceParked}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.parkingTime}"/></font></td>
    
                </tr>
            </c:forEach>



        </table>
        <br><br><br>
        <input type="button" value="Volver al menú principal" onclick= "history.back()" >
    </center>

</body>
</html>
