<%-- 
    Document   : listarCategorias
    Created on : 13-jun-2020, 9:30:36
    Author     : JCH
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Model.Categoria"%>
<jsp:useBean id="lista" scope="session" class="java.util.List"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Inventario</title>
        <%@include file = "../WEB-INF/css-js.jspf"%>
    </head>
    <body>
        <%@include file = "../WEB-INF/encabezado.jspf"%>
        <h1>Listado de categorias</h1><br>
        <a href="<%= request.getContextPath() %>/Categorias?opcion=crear" class="btn btn-success">Agregar nueva</a><br><br>
        <table class="table table-hover">
            <tr class="" style="background: black; color: white;">
                <th>ID</th>
                <th>Nombre</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
            <%
                for (int i = 0; i < lista.size(); i++) {
                    Categoria cat = new Categoria();
                    cat = (Categoria)lista.get(i);
                    int act = cat.getEstado_categoria();
                    String ms = "";
                    if (act == 1) {
                        ms = "Activo";
                        }else{
                        ms = "Inactivo";
                    }
            %>
            <tr>
                <td><%= cat.getId_categoria() %></td>
                <td><%= cat.getNom_categoria() %></td>
                <td><%= ms %></td>
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
