<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath(); %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Actualizar</title>
    <jsp:include page="layout/head.jsp"/>
</head>
<body>

<jsp:include page="layout/main.jsp"/>

<div class="text-center">
    <h1> Actualizar Usuarios</h1>
</div>

<section class="mt-5">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <form method="post" action="<%=context%>/ServletActualizarMateria">
                    <div class="form-group">
                        <label>Nombre</label>
                        <input type="text" value="${materia.nombre}" name="nombre" class="form-control" placeholder="Escribe el nombre" required>
                    </div>
                    <div class="form-group">
                        <label>Descripcion</label>
                        <input type="text" value="${materia.descripcion}" name="descripcion" class="form-control" placeholder="Escribe la descripción" required>
                    </div>
                    <div class="form-group">
                        <label>Estado</label>
                        <select name="estado" class="form-control">
                            <option value="${materia.estado}">${materia.estado ? "Activo" : "Inactivo"}</option>
                            <option value=${true}>Activo</option>
                            <option value=${false}>Inactivo</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Fecha Inicio</label>
                        <input type="date" value="${materia.fecha_inicio}"  name="fecha_inicio" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Fecha Fin</label>
                        <input type="date" value="${materia.fecha_fin}" name="fecha_fin" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Bloques</label>
                        <input type="number" value="${materia.bloques}" name="bloques" class="form-control" placeholder="Escribe el numero de bloques" required>
                        <input type="hidden" value="${materia.id}" name="id" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-primary">Actualizar</button>
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
