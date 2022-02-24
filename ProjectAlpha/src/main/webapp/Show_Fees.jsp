<%-- 
    Document   : Show_Fees
    Created on : Feb 23, 2022, 7:03:10 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tarifas Registradas</title>
    </head>
    <body background="Images/BG.png">

        <i>
            <marquee  <b><font color="white" size="8">Tarifas Registradas en el Sistema </font></b>
            </marquee>
        </i>

        <br><br><br>

    <center>
        <br><br>
        <table border="2">

            <td bgcolor="#000000" ><font size="5" color="white"><b>Precio de la Tarifa</b></font> </td>
            <td bgcolor="#000000" ><font size="5" color="white"><b>Tipo de Vehículo</b></font> </td>

            <c:forEach items="${fees}" var="currentFee" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? '#2666CF' : '#F5F2E7'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentFee.fee}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentFee.vehicleType}"/></font></td>


                    <td><font size="5"><a href="FeeRetrievalServlet?action=edit&vehicleType=<c:out value="${currentFee.vehicleType}"/>">Modificar Tarifa</a></font>
                        <font size="5"><a href="FeeRetrievalServlet?action=delete&vehicleType=<c:out value="${currentFee.vehicleType}"/>">Eliminar Tarifa</a></font></td>
                </tr>
            </c:forEach>



        </table>
        <br><br><br>
        <input type="button" value="Volver al menú principal" onclick= "history.back()" >
    </center>
</html>
