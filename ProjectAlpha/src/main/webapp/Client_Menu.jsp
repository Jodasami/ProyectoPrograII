<%-- 
    Document   : User_Menu
    Created on : Jan 30, 2022, 8:43:07 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú Para Clientes</title>
    </head>
    <body  background="Images/BG.png">
    <center>
        <br><br>
        <font size='9' color='white'>Menú Para Clientes</font>
        <br><br><br><br>     
        <table cellpadding="3" cellspacing="5">
            <thead>
                <tr> 
                    <th>
                        <font size="5" color="white">
                        Usuario
                        </font>
                    </th>

                    <th> 
                        <font size="5" color="white">
                        Vehículo
                        </font>
                    </th>
                    
                    <th> 
                        <font size="5" color="white">
                        Parqueos
                        </font>
                    </th>

                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> 
                        <font size="4" color="white">
                        <a href="./Modify_User.jsp">Modificar sus Datos Personales</a>
                        </font>
                    </td>
                    <td>
                        <font size="4" color="white">
                        <a href="./Register_Vehicle.jsp">Registrar su Vehículo</a>
                        </font>
                    </td>
                    <td>
                        <font size="4" color="white">
                        <a href="./ShowAll_ParkingLot.jsp">Ver Parqueos Disponibles</a>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>
                        <font size="4" color="white">
                        <a href="ClientManagementServlet">Eliminar su Cuenta</a>
                        </font>
                    </td>
                    <td>
                        <form action="UserManagementServlet" method="get">
                            <font size="4" color="white">
                            <a href="">Retirar su Vehículo</a>
                            </font>
                        </form>

                    </td>
                </tr>
            </tbody>
        </table>
         <br><br>
         <input type="button" value="Cerrar Sesión" onclick="window.location='Login.jsp'" >
    </center>
</body>
</html>
