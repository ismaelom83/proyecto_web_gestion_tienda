<%@page import="proyecto_web_gestion_tienda.model.Mensajeria"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
<title>Tienda Online</title>
</head>
<body>

	<%
		HttpSession mySession = request.getSession();
	if (mySession.getAttribute("persona") == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
	ArrayList<Mensajeria> devoluciones = (ArrayList<Mensajeria>) request.getAttribute("listaDevolucionPedidos");
	pageContext.setAttribute("misDevoluciones", devoluciones);
	%>

	<%-- 	<%@include file="includes/navTrabajadores.jsp"%> --%>


	<div class="row">
		<div class="col-md-offset-4 col-md-4">
			<table class="table table-striped">
				<thead>
					<tr>
						<td><strong>ID origen</strong></td>
						<td><strong>asunto</strong></td>
						<td><strong>cuerpo</strong></td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageScope.misDevoluciones}" var="devoluciones">
						<tr>
							<td><span><c:out value="${devoluciones.id}"></c:out></span>
							<td><span><c:out value="${devoluciones.asunto}"></c:out></span>
							<td><span><a href="${devoluciones.cuerpo}"><c:out
											value="${devoluciones.cuerpo}"></c:out></a></span>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>

</html>