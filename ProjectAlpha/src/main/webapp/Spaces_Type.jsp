<%-- 
    Document   : Spaces_Type
    Created on : Feb 21, 2022, 5:44:44 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <style>
        h1 {
            font-size: 23px;
            color: white;
        }

        h2 {
            font-size: 38px;
            color: white;
        }

    </style>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar Espacio</title>
    </head>
    <body  background="Images/BG.png">
    <center>
        <br><br>
        <font size='9' color='white'>Tipos de Espacios en el Parqueo</font>
        <br><br><br><br>

        <h1>
            Ingrese el Tipo de Vehículo que tendrán los Espacios para Personas con Discapacidad:

            <select name="vehicleTypeDisability">
                <option value="motorcycle">Motocicleta</option>
                <option value="ligthVehicles">Liviano</option>
                <option value="heavyVehicles">Pesado</option>
                <option value="bike">Bicicleta</option>
                <option value="other">Otro</option>
            </select>
        </h1>
        
        <br>

        <h2>
            Digite la cantidad de Espacios con el Tipo de Vehículo que Desee
        </h2>

        <br>
        <form action="SpacesTypeServlet" method="get">

            <font size="5" color="white"><b>

                <table cellpadding="5">

                    <tr>

                        <td>
                            Motocicleta:
                        </td>

                        <td>

                            <input type="text" name="motorcycle">

                        </td>

                    </tr>
                    <tr>

                        <td>
                            Vehículo Liviano:
                        </td>

                        <td>

                            <input type="text" name="ligthVehicles">

                        </td>

                    </tr>



                    <tr>

                        <td>

                            Vehículo Pesado:

                        </td>

                        <td>

                            <input type="text" name="heavyVehicles">

                        </td>

                    </tr>

                    <tr>

                        <td>

                            Bicicleta:

                        </td>

                        <td>

                            <input type="text" name="bike">

                        </td>

                    </tr>

                    <tr>

                        <td>


                            Otro (especifique):

                        </td>

                        <td>

                            <input type="text" name="other">

                        </td>

                    </tr>
                    <input type="hidden" name="id" value=${id}>
                </table>
            </b> 
            </font>
            <br>

            <input type="submit" value="Aceptar" />
            <!-- TODO: Espacio entre botones -->
            <input type="reset" value="Cancelar" />

        </form>
    </center>
</body>
</html>
