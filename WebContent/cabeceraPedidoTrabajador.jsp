<%@page import="proyecto_web_gestion_tienda.model.CabeceraPedido"%>
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
</head>
<body>
	
	
	<%
	HttpSession mySession = request.getSession();
if (mySession.getAttribute("persona")==null) {
	response.sendRedirect(request.getContextPath() + "/login.jsp");
}
		ArrayList<CabeceraPedido> cabeceraPedidos = (ArrayList<CabeceraPedido>) request.getAttribute("cabeceraPedidos2");
	pageContext.setAttribute("misPedidos2", cabeceraPedidos);
	%>
	
	
	

<!-- 	<div class="container"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-md-offset-1 col-md-10"> -->
<!-- 				<div class="jumbotron"> -->
<!-- 					<div class="container"> -->
<!-- 						<h2 class="text-center">A�n no ha seleccionado ning�n -->
<!-- 							producto para comprar</h2> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<table class="table table-striped">
					<thead>
						<tr>
							<td><strong>ID</strong></td>
							<td><strong>Fecha</strong></td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${pageScope.misPedidos2}" var="pedidos">
						<tr>
							<td><span><c:out value="${pedidos.id}"></c:out></span>
							<td><span></span></td>
							<td><div>
							<form
								action="ControllerTrabajadorCompras"
								method="post">
								<input type="hidden" name="idCabeceraPedido2"
									value="${pedidos.id}">
								<button type="submit" class="btn btn-lg btn-success btn-product">Ver Pedido</button>
							</form>
						</div></td>
						<td></td>
						</tr>
							</c:forEach>
					</tbody>
				</table>

			</div>
					</div>
			<a href="ControllerTrabajadorCompras" class="btn btn-success">vover a
				ver pedidos</a>
		</div>
		</div>
	<br>
	<br>
	
		<%@include file="includes/footer.jsp"%>
</body>
</html>