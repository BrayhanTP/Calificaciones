<%@page import="com.emergentes.Personas"%>
<%@page import="java.util.ArrayList"%>
<% 
    if (session.getAttribute("listaper")==null){
    ArrayList<Personas> lisaux = new ArrayList<Personas>();
    session.setAttribute("listaper", lisaux);
    }
    ArrayList<Personas> lista = (ArrayList<Personas>) session.getAttribute("listaper");
    
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border ="1">
           
            <td>PRIMER PARCIAL TEM-742 <p></p>
                Nombre: Brayhan Rancel Traqui Poma <p></p>
            Carnet: 6029633 L.P.</td>
              </table>
        <h1>Registro de Calificaciones</h1>
        <a href="MainServlet?op=nuevo"><b>Nuevo</b></a>
        <p></p>
        <table border = "1">
            <tr>
                <th>id</th>
                <th>Nombre</th>
                <th>P1(30)</th>
                <th>P2(30)</th>
                <th>EF(40)</th>
                <th>Nota</th>
                <th></th>
                <th></th>
            </tr>
            <%
                if (lista!= null){
                for(Personas item : lista){
                 double notaFinal = (item.getPrimer_parcial()) + (item.getSegundo_parcial() ) + (item.getExamen_final());
                
                %>
             <tr>
                 <td><%= item.getId()%></td>
                 <td><%= item.getNombre()%></td>
                 <td><%= item.getPrimer_parcial()%></td>
                 <td><%= item.getSegundo_parcial()%></td>
                 <td><%= item.getExamen_final()%></td>
                 <td>  <%= notaFinal %></td>>
                
                 <td>
                     <a href="MainServlet?op=Editar&id=<%=item.getId()%>">Editar</a>
                 </td>
              
                 <td>
                     <a href="MainServlet?op=eliminar&id=<%=item.getId()%>"
                     onclick="return(confirm('Esta seguro de eliminar??'))"
                     >Eliminar</a>
                 </td>
            </tr>
            <%
                }
                }
            %>
        </table>
    </body>
</html>
