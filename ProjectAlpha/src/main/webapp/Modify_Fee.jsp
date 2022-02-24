<%-- 
    Document   : Modify_Fee
    Created on : Feb 23, 2022, 7:19:12 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edición de Tarifas</title>
    </head>
       <%
        String vehicleType = (String) request.getAttribute("vehicleType");

    %>
    
    <center>
    <body background="Images/BG.png">
        <b>
            <font size=8 color=white>Edición de Tarifas</font>
        </b>

        <br><br><br><br>
    
        <form action="FeeLotRetrievalServlet" method="post">

            <font size="5" color="white"><b>

                <table cellpadding="5">

                    <tr>

                        <td>
                            Nuevo Precio de la Tarifa por Día (colones):
                        </td>

                        <td>

                            <input type="text" name="fee">

                        </td>

                    </tr>

                </table>
            </b> 
            </font>
            <br>

            <input type="hidden" name="vehicleType" value=<%=vehicleType%>>

            <input type="submit" value="Continuar" />
            <!-- TODO: Espacio entre botones -->
            <input type="reset" value="Cancelar" />

        </form>
        <br>
        <input type="submit" value="Volver" size="50" onclick= "history.back()"/>
    </center>

</body>
</html>
