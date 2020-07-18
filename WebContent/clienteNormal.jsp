<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="proyecto_web_gestion_tienda.model.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Tienda Online</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<%@include file="includes/nav.jsp"%>
	<h1>Cliente normal</h1>

	<%
		ArrayList<Producto> listaP = (ArrayList<Producto>) request.getAttribute("todosProductos");
	pageContext.setAttribute("listaP", listaP);
	%>

	<div class="container">
		<div class="row">
			<c:forEach items="${pageScope.listaP}" var="producto">
				<div class="col-lg-4">
					<div class="panel panel-default panel-producto">
						<div class="panel-heading">
							<span><c:out value="${producto.descripcion}"></c:out></span>
						</div>
						<div class="panel-body">
							<img src="<c:url value="${producto.rutaImagen}"/>"
								class="img-responsive center-block" alt="Image"
								style="height: 200px;">
						</div>
						<div class="panel-footer">
							<div class="row">
								<div class="col-md-6 precio">
									<span>Precio del producto: <c:out
											value="${producto.precioUnitarioSinIva}"></c:out></span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


	<%@include file="includes/footer.jsp"%>
</body>
</html>