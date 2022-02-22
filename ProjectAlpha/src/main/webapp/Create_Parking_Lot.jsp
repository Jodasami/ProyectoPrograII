<%-- 
    Document   : Create_Parking_Lot
    Created on : 8 feb. 2022, 23:37:21
    Author     : jodas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        h1 {
            font-size: 21px;
            color: white;
        }

        h2 {
            font-size: 38px;
            color: white;
        }

    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creación de Parqueos</title>
    </head>
    <body background="Images/BG.png">
        <br><br>
        <i>

            <marquee> <b>
                    <font size=8 color=white>Registro de Parqueos</font>
                </b>


            </marquee>
        </i>
    <center>
        <h1>
            *El número del id del parqueo debe estar en el rango del 1 al 10
        </h1>
        <br>

        <form action="ParkingLotManagementServlet" method="post">

            <font size="7" color="white">Datos del Parqueo</font>
            <br><br>
            <font size="5" color="white"><b>

                <table cellpadding="5">

                    <tr>

                        <td>
                            Número del Parqueo:
                        </td>

                        <td>

                            <input type="text" name="id">

                        </td>

                    </tr>
                    <tr>

                        <td>
                            Nombre del Parqueo:
                        </td>

                        <td>

                            <input type="text" name="name">

                        </td>

                    </tr>



                    <tr>

                        <td>

                            Número de Espacios que tiene el Parqueo:

                        </td>

                        <td>

                            <input type="text" name="numberOfSpaces">

                        </td>

                    </tr>

                    <tr>

                        <td>

                            Número de espacios designados para personas con discapacidad:

                        </td>

                        <td>

                            <input type="text" name="numberOfSpacesWithDisabiltyAdaptation">

                        </td>

                    </tr>

                </table>
            </b> 
            </font>
            <br>

            <input type="submit" value="Continuar" />
            <!-- TODO: Espacio entre botones -->
            <input type="reset" value="Cancelar" />

        </form>
        <br>
        <input type="submit" value="Volver" size="50" onclick= "history.back()"/>
    </center>


</body>
</html>
