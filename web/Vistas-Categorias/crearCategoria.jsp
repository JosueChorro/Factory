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
        <script type="text/javascript">
            function regresar(url){
                location.href= url;
            }
        </script>       
    </head>
    <body>
        <%@include file = "../WEB-INF/encabezado.jspf"%><br><br>
        <h1 class="text-center">Mantenimiento Categorias</h1>
        <br><br>
        <form name="frmCategoria" id ="frmCategoria" action="<%= request.getContextPath() %>/Categorias" method="POST" class="form-horizontal">
            <input type="hidden" name="id_categoria" value=0 />
            <div class="form-group">
                <label for="txtNomCategoria" class="control-label">Nombre: </label>
                <input type="text" name="txtNomCategoria" class="form-control" value="<%= categoria.getNom_categoria() %>">
            </div>
            <div class="form-group">
                <label for="txtEstadoCategoria" class="control-label">Estado: </label>
                <input type="text" name="txtEstadoCategoria" value=1  class="form-control">
            </div><br>
            <div class="form-group">
                <input type="submit" name="btnGuardar" value="Guardar" class="btn btn-outline-primary">
                <input type="button" onclick="regresar('<%= request.getContextPath() %>/Categorias?opcion=listar')" name="btnRegresar" value="Regresar" class="btn btn-danger">
            </div>
        </form>
        
        <%@include file = "../WEB-INF/pie.jspf"%>
    </body>
</html>
