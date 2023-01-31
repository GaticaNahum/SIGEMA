<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
    <title>Actualizar</title>
    <jsp:include page="/WEB-INF/view/layout/head.jsp"/>

</head>
<body>

<jsp:include page="/WEB-INF/view/layout/main.jsp"/>



<div class="text-center">
    <h1> Actualizar Usuarios</h1>
</div>

<section style="margin-top: 5%">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <form method="post" action="<%=context%>/ServletActualizar">
                    <div class="form-group">
                        <label>Nombre</label>
                        <input type="text" name="nombre" value="${usuario.nombre}" class="form-control" placeholder="Escribe el nombre">
                    </div>
                    <div class="form-group">
                        <label>Estatus</label>
                        <input type="text" name="status" value="${usuario.estatus}" class="form-control" placeholder="Escribe el estatus">
                        <input type="hidden" name="id" value="${usuario.id}" class="form-control">

                    </div>
                    <button type="submit" class="btn btn-primary">Registrar</button>
                </form>
            </div>
        </div>
    </div>
</section>




</body>
</html>
