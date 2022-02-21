<%-- 
    Document   : Register_User_Admin
    Created on : Feb 15, 2022, 4:06:40 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Usuarios</title>
    </head>
    <body background="Images/BG.png">
        <br><br>
        <i>

            <marquee> <b>
                    <font size=8 color=white>Registro de Usuarios</font>
                </b>


            </marquee>
        </i>
        <br><br><br><br><br>
    <center>
        <form action="UserInfoServlet" method="get">

            <font size="7" color="white">Datos Personales</font>
            <br><br>
            <font size="5" color="white"><b>

                <table cellpadding="5">

                    <tr>

                        <td>
                            Nombre Completo:
                        </td>

                        <td>

                            <input type="text" name="name" size="30">

                        </td>

                    </tr>
                    <tr>

                        <td>
                            Cédula:
                        </td>

                        <td>

                            <input type="text" name="id" size="9">

                        </td>

                    </tr>

                    

                    <tr>

                        <td>

                            Teléfono:

                        </td>

                        <td>

                            <input type="text" name="phone" size="8">

                        </td>

                    </tr>
                   
                    <tr>

                        <td>

                            Usuario:

                        </td>

                        <td>

                            <input type="text" name="username" size="10">

                        </td>

                    </tr>

                    <tr>

                        <td>


                            Contraseña:

                        </td>

                        <td>

                            <input type="text" name="password" size="15">

                        </td>

                    </tr>
                    <tr>

                        <td>

                            ¿Posee alguna discapacidad?

                        </td>

                        <td>

                            <input type="checkbox" name="disabilityPresented">

                        </td>

                    </tr>
                    
                     <tr>

                        <td>

                            Rol del Usuario

                        </td>

                        <td>

                           <select name="role">
                                    <option value="customer">Cliente</option>
                                    <option value="clerk">Dependiente</option>
                                    <option value="admin">Administrador</option>
                                </select>

                        </td>

                    </tr>

                </table>
            </b> 
            </font>
            <br>
            
            <input type="submit" value="Guardar cliente" />
            <!-- TODO: Espacio entre botones -->
            <input type="reset" value="Cancelar" />
            
        </form>
        <br>
            <input type="submit" value="Regresar al Menú Principal" name="login" size="50" onclick= "history.back()"/>
    </center>


</body>
</html>
