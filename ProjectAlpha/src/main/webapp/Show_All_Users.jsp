<%-- 
    Document   : show_all_customers
    Created on : Jan 19, 2022, 7:55:42 PM
    Author     : EstebanAntonioSanabr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de clientes</title>
    </head>
    <body background="Images/BG.png">

        <i>
            <marquee  <b><font color="lightgreen" size="8">Lista de Clientes en el Sistema </font></b>
            </marquee>
        </i>

        <br><br><br>

    <center>
        <table border="2">

            <td bgcolor="white" ><font size="5" color="#FFFFFF"><b>Nombre del cliente</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#FFFFFF"><b>ID</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#FFFFFF"><b>Teléfono</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#FFFFFF"><b>Usuario</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#FFFFFF"><b>Contraseña</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#FFFFFF"><b>¿Posee Discapacidad?</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#FFFFFF"><b>Rol de Usuario</b></font> </td>

            <c:forEach items="${users}" var="currentUser" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? 'black' : 'blue'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentUser.name}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentUser.id}"/></font></td>
                    <td><font size="5"><c:out value="${currentUser.phone}"/></font></td>
                    <td><font size="5"><c:out value="${currentUser.username}"/></font></td>
                    <td><font size="5"><c:out value="${currentUser.password}"/></font></td>
                    <td><font size="5"><c:out value="${currentUser.disabilityPresented}"/></font></td>
                    <td><font size="5"><c:out value="${currentUser.role}"/></font></td>

                    <td><font size="5"><a href="AdminRetrievalServlet?action=edit&userUsername=<c:out value="${currentUser.username}"/>">Modificar Usuario</a></font>
                        <font size="5"><a href="AdminRetrievalServlet?action=delete&userUsername=<c:out value="${currentUser.username}"/>">Eliminar Usuario</a></font></td>
                </tr>
            </c:forEach>



        </table>
        <br><br><br>
        <input type="button" value="Volver al menú principal" onclick="window.location = 'Administrator_Menu.jsp'" >
    </center>

</body>
</html>
