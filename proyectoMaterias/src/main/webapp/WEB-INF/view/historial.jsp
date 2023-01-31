<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath(); %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Historial</title>
    <jsp:include page="layout/head.jsp"/>
</head>
<body>
<jsp:include page="layout/main.jsp"/>


<div class="text-center">
    <h1> Historial de Usuarios</h1>
</div>

<section>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <table class="table table-striped table-dark">
                    <thead class="text-center">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Estatus</th>
                        <th scope="col">Modificar</th>
                        <th scope="col">Eliminar</th>
                    </tr>
                    </thead>
                    <tbody class="text-center">
                    <c:forEach items="${listUsuarios}" var="user" varStatus="status">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.nombre}</td>
                            <td>${user.estatus}</td>
                            <td class="text-center">
                                <form method="get" action="<%=context%>/ServletActualizar">
                                    <input type="hidden" name="id" value="${user.id}">
                                    <button type="submit" title="Modificar" class="btn btn-outline-warning"><i class="fas fa-user-edit"></i></button>
                                </form>
                            </td>
                            <td class="text-center">
                                <form method="post" action="<%=context%>/ServletEliminar">
                                    <input type="hidden" name="id" value="${user.id}">
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



</body>
</html>
