<%-- 
    Document   : ShowParkingLot
    Created on : Feb 22, 2022, 8:40:09 AM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Parqueos</title>
    </head>
    <center>
    <body background="Images/BG.png">

        <i>
            <marquee  <b><font color="white" size="8">Lista de Parqueos en el Sistema </font></b>
            </marquee>
        </i>

        <br><br><br>

    
        <br><br>
        <table border="2">

            <td bgcolor="#000000" ><font size="5" color="white"><b>ID</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Nombre</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Número de Espacios del Parqueo</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Número de Espacios para Personas con Discapacidad</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Opciones</b></font> </td>
            
            <c:forEach items="${parkingLots}" var="currentParkingLot" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? '#2666CF' : '#F5F2E7'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentParkingLot.id}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentParkingLot.name}"/></font></td>
                    <td><font size="5"><c:out value="${currentParkingLot.numberOfSpaces}"/></font></td>
                    <td><font size="5"><c:out value="${currentParkingLot.numberOfSpacesWithDisabiltyAdaptation}"/></font></td>

                    <td><font size="5"><a href="ParkingLotRetrievalServlet?action=edit&parkingLotId=<c:out value="${currentParkingLot.id}"/>">Modificar Parqueo</a></font>
                        <font size="5"><a href="ParkingLotRetrievalServlet?action=delete&parkingLotId=<c:out value="${currentParkingLot.id}"/>">Eliminar Parqueo</a></font></td>
                </tr>
            </c:forEach>



        </table>
        <br><br><br>
        <input type="button" value="Volver al menú principal" onclick="window.location = 'Administrator_Menu.jsp'" >
    </center>

</body>
</html>
