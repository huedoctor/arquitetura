<%-- 
    Document   : AlterarDepartamento
    Created on : 20 de abr. de 2023, 10:32:05
    Author     : eddie.mssantos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Controle">
            <input type="hidden" name="flag" value="AlterarDeparmanto">

            <p>
                <label for="id">ID:</label>
                <input id="id" size="3" maxlength="3" type="text" name="id" value="<%=  request.getParameter("id")%>">
            </p>

            <p>
                <label for="nome">NOME:</label>
                <input id="nome" size="50" maxlength="50" type="text" name="nome" value="<%=  request.getParameter("nome")%>">
            </p>

            <p>
                <label for="fone">FONE:</label>
                <input id="fone" size="15" maxlength="15" type="tel" name="fone" value="<%=  request.getParameter("fone")%>">
            </p>

            <p>
                <input type="submit" value="Salvar">
            </p>
        </form> 
    </body>
</html>
