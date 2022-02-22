<%-- 
    Document   : Modify_Parking_Lot
    Created on : Feb 22, 2022, 8:39:30 AM
    Author     : jodas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificación de Parqueos</title>
    </head>
    <body background="Images/BG.png">
        <b>
            <font size=8 color=white>Modificación de Parqueos</font>
        </b>

        <br><br><br><br>
    <center>
        <form action="ParkingLotRetrievalServlet" method="post">

            <font size="7" color="white">Datos del Parqueo</font>
            <br>
            <font size="4" color="white">*Recuerde que el Número del Parqueo no se puede Modificar*</font>
             <br>
            <font size="4" color="white">*Los Vehículos ya Parqueados se Eliminaran de este Parqueo*</font>
            <br><br>

            <font size="5" color="white"><b>

                <table cellpadding="5">
                    
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
