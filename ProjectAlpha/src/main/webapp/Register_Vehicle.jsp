<%-- 
    Document   : insert_User
    Created on : 18/01/2022, 10:15:10 AM
    Author     : jodas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Vehículo</title>
    </head>
    <body background="Images/BG.png">
        <br><br>
        <i>
            <font size=7 color='white'>
            <marquee>
                SISTEMA DE INGRESO DE VEHÍCULOS
            </marquee>
            </font>
        </i>

        <form action="VehicleInfoServlet" method="get">
            <br>
            <br>
            <br>
            <br>
            <center>
                <font size="7" color="white"> Formulario de Ingreso de Vehículos </font>
                <br><br>
                <font size="5" color="white"><b>
                    <table cellpadding="5">

                        <tr>

                            <td>

                                Placa: 

                            </td>

                            <td>

                                <input type="text" name="plate">

                            </td>

                        </tr>

                        <tr>

                            <td>

                                Color:

                            </td>

                            <td>

                                <input type="text" name="color">

                            </td>

                        </tr>

                        <tr>

                            <td>

                                <label> Marca del Vehículo: </label>

                            </td>

                            <td>

                                <input type="text" name="brand">

                            </td>

                        </tr>

                        <tr>

                            <td>

                                Modelo del Vehículo: 

                            </td>

                            <td>

                                <input type="text" name="model">

                            </td>

                        </tr>
                        <tr>

                            <td>

                                Tipo de Vehículo: 

                            </td>

                            <td>

                                <select name="vehicleType">
                                    <option value="1">Motocicleta</option>
                                    <option value="2">Liviano</option>
                                    <option value="3">Pesado</option>
                                    <option value="4">Bicicleta</option>
                                    <option value="5">Otro</option>
                                </select>

                            </td>

                        </tr>

                        <tr>

                            <td>

                                <input type="submit" value="Registrar Vehículo" />

                            </td>

                            <td>

                                <input type="reset" value="Cancelar" />

                            </td>

                        </tr>

                    </table>
                </b> 
                </font>
            </center>


        </form>


    </body>
</html>
