<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath(); %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Historial de Usuarios</title>
  <jsp:include page="layout/head.jsp"/>

</head>
<body>

<jsp:include page="layout/main.jsp"/>

<section class="mt-5">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <table class="table">
          <thead class="text-center thead-dark">
          <tr>
            <th scope="col">#</th>
            <th scope="col">Nombre</th>
            <th scope="col">Descripción</th>
            <th scope="col">Estado</th>
            <th scope="col">Fecha Inicio</th>
            <th scope="col">Fecha Fin</th>
            <th scope="col">Bloques</th>
            <th scope="col">Modificar</th>
            <th scope="col">Eliminar</th>
          </tr>
          </thead>
          <tbody class="text-center">
          <c:forEach items="${listMaterias}" var="materias" varStatus="status">
            <tr>
              <td>${materias.id}</td>
              <td>${materias.nombre}</td>
              <td>${materias.descripcion}</td>
              <td>${materias.estado ? "Activo" : "Inactivo"}</td>
              <td>${materias.fecha_inicio}</td>
              <td>${materias.fecha_fin}</td>
              <td>${materias.bloques}</td>
              <td class="text-center">
                <form method="get" action="<%=context%>/ServletActualizarMateria">
                  <input type="hidden" name="id" value="${materias.id}">
                  <button type="submit" title="Modificar" class="btn btn-outline-warning"><i class="fas fa-edit"></i></button>
                </form>
              </td>
              <td class="text-center">
                <form method="post" action="<%=context%>/ServletEliminarMateria">
                  <input type="hidden" name="id" value="${materias.id}">
                  <button type="submit" title="Eliminar" class="btn btn-outline-danger"><i class="fas fa-trash"></i></button>
                </form>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
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
