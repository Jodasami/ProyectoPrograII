<%-- 
    Document   : modify_user
    Created on : Jan 25, 2022, 4:54:16 AM
    Author     : Esteban
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificación de Vehículos</title>
    </head>
    <body background="Images/BG.png">
        <br><br>
        <i>

            <marquee> <b>
                    <font size=8 color=white>Modificación de Vehículos</font>
                </b>


            </marquee>
        </i>
        <br><br><br>
    <center>
        <form action="VehicleManagementServlet" method="post">

            <font size="7" color="white">Datos del Vehículo</font>
            <br>
            <font size="4" color="white">*Recuerde que la placa del vehículo no se puede modificar*</font>
            <br><br>
            <font size="5" color="white"><b>

                <table cellpadding="5">

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

                </table>
            </b> 
            </font>
            <br>

            <input type="submit" value="Modificar Vehículo" />
            <!-- TODO: Espacio entre botones -->
            <input type="reset" value="Cancelar" />


        </form>
    </center>


</body>
</html>
