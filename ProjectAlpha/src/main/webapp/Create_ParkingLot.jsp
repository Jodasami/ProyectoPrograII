<%-- 
    Document   : Create_ParkingLot
    Created on : 8 feb. 2022, 23:37:21
    Author     : jodas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <br><br><br><br>
    <center>
        <form action="ParkingLotManagementServlet" method="get">

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
            
            <input type="submit" value="Guardar Parqueo" />
            <!-- TODO: Espacio entre botones -->
            <input type="reset" value="Cancelar" />
            
        </form>
        <br>
            <input type="submit" value="Volver" size="50" onclick= "history.back()"/>
    </center>


</body>
</html>
