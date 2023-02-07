<%@ page import="com.example.sigema.model.Materia" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registro de usuarios</title>
    <jsp:include page="WEB-INF/view/layout/head.jsp"/>

</head>
<body>

<jsp:include page="/WEB-INF/view/layout/main.jsp"/>



<div class="text-center">
    <h1> Registrar Materias</h1>
</div>

<section style="margin-top: 5%">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <form method="post" action="<%=context%>/ServletRegistrarMateria">
                    <div class="form-group">
                        <label>Nombre</label>
                        <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Escribe el nombre" required>
                    </div>
                    <div class="form-group">
                        <label>Descripcion</label>
                        <input type="text" id="descripcion" name="descripcion" class="form-control" placeholder="Escribe la descripción" required>
                    </div>
                    <div class="form-group">
                        <label>Fecha Inicio</label>
                        <input type="date" id="fecha_inicio" name="fecha_inicio" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Fecha Fin</label>
                        <input type="date" id="fecha_fin" name="fecha_fin" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Bloques</label>
                        <input type="number" id="bloques" name="bloques" class="form-control" placeholder="Escribe el numero de bloques" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Registrar</button>
                </form>
            </div>
        </div>
    </div>
</section>

<script>
    if (window.history.replaceState) {
        window.history.replaceState(null, null, window.location.href);
    }
</script>


</body>
</html>