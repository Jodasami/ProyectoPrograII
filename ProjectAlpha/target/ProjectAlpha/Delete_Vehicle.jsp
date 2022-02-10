<%-- 
    Document   : delete_User
    Created on : 24/01/2022, 07:22:41 PM
    Author     : jodas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Retirar Vehículo</title>
    </head>
    <body>
        <form action="UserInfoServlet" method="get">
            <br>
            <br>
            <br>
            <br>
            <center>
                <table> 
                    <tr>
                    <h2>  Formulario para Retirar Vehículos </h2>

                    </tr>



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

                            <input type="submit" value="Retirar vehiculo" />

                        </td>

                        <td>

                            <input type="reset" value="Cancelar" />

                        </td>

                    </tr>

                </table>
            </center>


        </form>
    </body>
</html>
