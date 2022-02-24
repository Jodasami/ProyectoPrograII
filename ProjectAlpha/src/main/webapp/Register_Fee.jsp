<%-- 
    Document   : Register_Fee
    Created on : Feb 23, 2022, 6:08:45 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Tarifas</title>
    </head>
    <body background="Images/BG.png">
        <br><br>
        <i>
            <font size=7 color='white'>
            <marquee>
                Registro de Tarifas
            </marquee>
            </font>
        </i>

        <form action="FeeManagementServlet" method="post">
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

                                Precio de la Tarifa por Hora (colones):

                            </td>

                            <td>

                                <input type="text" name="fee">

                            </td>

                        </tr>

                        <tr>

                            <td>

                                Tipo de Vehículo al que le Desea Agregar la Tarifa: 

                            </td>

                            <td>

                                <select name="vehicleType">
                                    <option value="motorcycle">Motocicleta</option>
                                    <option value="ligthVehicles">Liviano</option>
                                    <option value="heavyVehicles">Pesado</option>
                                    <option value="bike">Bicicleta</option>
                                    <option value="other">Otro</option>
                                </select>

                            </td>

                        </tr>

                    </table>
                </b> 
                </font>
                <br>
                <input type="submit" value="Aceptar" />

                <input type="reset" value="Cancelar" />
                <br><br>

                <input type="submit" value="Regresar al Menú Principal" name="login" size="50" onclick= "history.back()"/>
            </center>


        </form>


    </body>
</html>
