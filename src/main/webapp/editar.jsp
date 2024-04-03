<%@page import="com.emergentes.Personas"%>
<%
   Personas reg = (Personas) request.getAttribute("miobjper");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Persona</title>
    </head>
    <body>
        <table border ="1">
           
            <td>PRIMER PARCIAL TEM-742 <p></p>
                Nombre: Brayhan Rancel Traqui Poma <p></p>
            Carnet: 6029633 L.P.</td>
              </table>
        <h1>Registro de Calificaciones</h1>
        <form action="MainServlet" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="<%= reg.getId() %>" size="2" readonly></td>
                </tr>
                 <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="<%= reg.getNombre() %>"></td>
                </tr>
                 <tr>
                    <td>Primer_Parcial</td>
                    <td><input type="text" name="primer_parcial" value="<%= reg.getPrimer_parcial()%>"></td>
                </tr>
                 <tr>
                    <td>Segundo_Parcial</td>
                    <td><input type="text" name="segundo_parcial" value="<%= reg.getSegundo_parcial() %>"></td>
                </tr>
                 <tr>
                    <td>Examen_final</td>
                    <td><input type="text" name="examen_final" value="<%= reg.getExamen_final() %>"></td>
                </tr>
                 <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
