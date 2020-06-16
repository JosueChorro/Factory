<%-- 
    Document   : crearCategoria
    Created on : 15-jun-2020, 11:34:58
    Author     : JCH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "categoria" scope = "session" class = "Model.Categoria" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file = "../WEB-INF/css-js.jspf"%>
        <script type="text/javscript">
            function regresar(url){
                location.href= null;
            }
        </script>
    </head>
    <body>
        <%@include file = "../WEB-INF/encabezado.jspf"%>
        <h1>Mantenimiento Categorias</h1>
        <form name="frmCategoria" id ="frmCategoria" action="<%= request.getContextPath() %>/Categorias" method="POST">
            <input type="hidden" name="id_categoria" value="<%= categoria.getId_categoria() %>" />
            <div>
                <label for="txtNomCategoria">Nombre: </label>
                <input type="text" name="txtNomCategoria" value="<%= categoria.getNom_categoria() %>">
            </div>
            <div>
                <label for="txtEstadoCategoria">Estado: </label>
                <input type="text" name="txtEstadoCategoria" value="<%= categoria.getEstado_categoria() %>">
            </div>
            <div>
                <input type="submit" name="btnGuardar" value="Guardar">
                <input type="button" onclick="regresar('<%= request.getContextPath() %>/Categorias')" name="btnRegresar" value="Regresar">
            </div>
        </form>
        
        <%@include file = "../WEB-INF/pie.jspf"%>
    </body>
</html>
