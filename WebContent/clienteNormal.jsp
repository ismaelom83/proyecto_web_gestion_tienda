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


	<%
		ArrayList<Producto> listaPro = (ArrayList<Producto>) request.getAttribute("todosProductos2");
	pageContext.setAttribute("listaPro", listaPro);
	%>


	<%@include file="includes/nav.jsp"%>


	<h1>${sessionScope.persona}</h1>

	<div class="container">
		<div class="row">
			<c:forEach items="${pageScope.listaPro}" var="producto">
				<div class="col-lg-4">
					<div class="panel panel-default panel-producto">
						<a
							href="ControllerProductoId?idProducto=<c:out value="${producto.id}"></c:out>"
							style="text-decoration: none; color: black;">
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
									<div class="col-md-6 precio">
										<span>Stock: <c:out
												value="${producto.stock}"></c:out></span>
									</div>
								</div>
							</div>
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>



	<%@include file="includes/footer.jsp"%>
</body>
</html>