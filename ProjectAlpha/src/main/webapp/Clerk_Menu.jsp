<%-- 
    Document   : Clerk_Menu
    Created on : 7 feb. 2022, 11:00:13
    Author     : jodas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú Para Dependientes</title>
    </head>
    <body  background="Images/BG.png">
    <center>
        <br><br>
        <font size='9' color='white'>Menú Para Dependientes</font>
        <br><br><br><br>     
        <table cellpadding="3" cellspacing="5">
            <thead>
                <tr> 
                    <th>
                        <font size="5" color="white">
                        Vehículos
                        </font>
                    </th>

                    <th> 
                        <font size="5" color="white">
                        Usuarios
                        </font>
                    </th>

                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> 
                        <font size="4" color="white">
                        <a href="./Park_Vehicle_In_ParkingLot.jsp">Asignar Espacio a un Vehículo</a>
                        </font>
                    </td>
                    <td>
                        <font size="4" color="white">
                        <a href="./Register_Client.jsp">Registar Usuario</a>
                        </font>
                    </td>


                </tr>
                <tr>
                    <td>
                        <font size="4" color="white">
                        <a href="./RemoveAndCollect_Vehicle.jsp">Retirar Vehículo y Cobrar</a>
                        </font>
                    </td>

                    <td>
                        <font size="4" color="white">
                        <a href="AdminManagementServlet">Ver Usuarios Inscritos</a>
                        </font>
                    </td>

                </tr>
                <tr>
                    <td> 
                        <font size="4" color="white">
                        <a href="./Modify_Vehicle.jsp">Modificar Datos Del Vehículo</a>
                        </font>
                    </td>

                </tr>
                <tr>
                    <td> 
                        <font size="4" color="white">
                        <a href="./ShowAll_Vehicles.jsp">Ver Vehículos Parqueados</a>
                        </font>
                    </td>
                </tr>

                <tr>
                    <td> 
                        <font size="4" color="white">
                        <a href="VehicleShowManagementServlet">Ver Vehículos Registrados</a>
                        </font>
                    </td>
                </tr>
            </tbody>
        </table>
        <br><br>
        <input type="button" value="Cerrar Sesión" onclick="window.location = 'Login.jsp'" >
    </center>
</body>
</html>
