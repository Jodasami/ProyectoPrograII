<%-- 
    Document   : Administrator_Menu
    Created on : 7 feb. 2022, 11:00:00
    Author     : jodas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú Para Administradores</title>
    </head>
    <body  background="Images/BG.png">
    <center>
        <br><br>
        <font size='10' color='white'>Menú Para Administradores</font>
        <br><br><br><br>     
        <table cellpadding="3" cellspacing="5">
            <thead>
                <tr> 
                    <th>
                        <font size="5" color="white">
                        Parqueo
                        </font>
                    </th>

                    <th> 
                        <font size="5" color="white">
                        Roles de Usuario
                        </font>
                    </th>
                    <th>
                        <font size="5" color="white">
                        Vehículos
                        </font>
                    </th>

                    <th>
                        <font size="5" color="white">
                        Tarifa del Parqueo
                        </font>
                    </th>

                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> 
                        <font size="5" color="white">
                        <a href="./Create_Parking_Lot.jsp">Crear un Parqueo</a>
                        </font>
                    </td>
                    <td>
                        <font size="5" color="white">
                        <a href="AdminManagementServlet">Ver Usuarios y Roles</a>
                        </font>
                    </td>
                    <td>
                        <font size="5" color="white">
                        <a href="VehicleShowManagementServlet">Vehículos Registrados</a>
                        </font>
                    </td>
                      <td>
                        <font size="5" color="white">
                        <a href="Register_Fee.jsp">Agregar tarifa de Vehículo</a>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td> 
                        <font size="5" color="white">
                        <a href="Park_Vehicle_In_Parking_Lot.jsp">Asignar un Espacio a un Vehículo</a>
                        </font>
                    </td>
                    <td> 
                    </td>
                    <td> 
                        <font size="5" color="white">
                        <a href="Remove_Vehicle_In_Parking_Lot.jsp">Retirar un Vehículo y Cobrar</a>
                        </font>
                    </td>
                      <td>
                        <font size="5" color="white">
                        <a href="FeeManagementServlet">Tarifas Registradas</a>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td>
                        <font size="5" color="white">
                        <a href="./Register_User_Admin.jsp">Registrar Usuario</a>
                        </font>
                    </td>
                    <td> 
                    </td>
                    <td> 
                        <font size="5" color="white">
                        <a href="ParkedVehiclesServlet">Ver Vehículos Parqueados</a>
                        </font>
                    </td>
                </tr>
                <tr>
                    <td> 
                        <font size="5" color="white">
                        <a href="ParkingLotManagementServlet">Ver Parqueos y Espacios</a>
                        </font>
                    </td>
                </tr>
            </tbody>
        </table>
        <br><br>
        <input type="submit" value="Modificar Precios" />
        <input type="submit" value="Consultar Reservaciones" />
        <br><br><br><br>
        <table border="0" width="1" cellspacing="4">

            <tbody>
                <tr>
                    <th><input type="submit" value="Generar Reporte de Ganancias" /></th>
                    <th><input type="submit" value="Generar Reporte de Trabajadores" /></th>
                    <th><input type="submit" value="Generar Reporte de ALGO MÁS" /></th>
                </tr>
            </tbody>
        </table>


        <br><br>
        <input type="button" value="Cerrar Sesión" onclick="window.location = 'Login.jsp'">
    </center>
</body>
</html>
