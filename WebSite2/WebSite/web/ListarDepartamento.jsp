<%-- 
    Document   : listarDepartamento
    Created on : 31 de mar. de 2023, 09:38:35
    Author     : eddie.mssantos
--%>

<%@page import="model.Departamento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<Departamento> listaDepartamento = (List<Departamento>) request.getAttribute("listaDepartamento");%>

        <table>
            <th>Codigo:</th>
            <th>Nome:</th>
            <th>Telefone:</th>
            <th>Excluir:</th>
            <th>Alterar:</th>
            <%
                for (Departamento dep : listaDepartamento) {
            %>

            <tr>
                <td><%= dep.getIdDepartamento()%></td>
                <td><%= dep.getNomeDepartamento()%></td>
                <td><%= dep.getFoneDepartamento()%></td>
                
                <td>
                    <a href="Controle?flag=excluirDepartamento&idDep=<%= dep.getIdDepartamento()%>">Excluir</a>
                </td>
                
                <td>
                    <a href="Controle?flag=AlterarDepartamento.jsp&id=<%=dep.getIdDepartamento()%>"&nome=<%=dep.getNomeDepartamento()%>&fone=<%=dep.getFoneDepartamento()%>>Alterar</a>
                </td>
            </tr>
            
            <%}%>
        </table>
    </body>
</html>
