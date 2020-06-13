<%-- 
    Document   : listarCategorias
    Created on : 13-jun-2020, 9:30:36
    Author     : JCH
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Categoria"%>
<jsp:useBean id = "lista" scope = "session" class = "java.util.List" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Inventario</title>
        <%@include file = "../WEB-INF/css-js.jspf"%>
    </head>
    <body>
        <%@include file = "../WEB-INF/encabezado.jspf"%>
        <h1>Listado de categorias</h1><br>
        <a href="" class="btn btn-success">Agregar nueva</a><br><br>
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
            <%
                for (int i = 0; i < lista.size(); i++) {
                    Categoria cat = new Categoria();
                    cat = (Categoria)lista.get(1);
            %>
            <tr>
                <td><%= cat.getId_categoria() %></td>
                <td><%= cat.getNom_categoria() %></td>
                <td><%= cat.getEstado_categoria() %></td>
                <td>
                    <a href="" class="btn btn-warning">Editar</a>
                    <a href="" class="btn btn-danger">Eliminar</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%@include file = "../WEB-INF/pie.jspf"%>
    </body>
</html>
