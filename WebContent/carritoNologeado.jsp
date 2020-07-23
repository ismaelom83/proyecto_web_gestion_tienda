<%@page import="java.util.ArrayList"%>
<%@page import="proyecto_web_gestion_tienda.model.Producto"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<% 
ArrayList<Producto> listaP = (ArrayList<Producto>) request.getAttribute("productoCarritoLista");
pageContext.setAttribute("listaP", listaP);
%>

	<div class="container">
		<c:if test="${sessionScope.productoCarritoLista2==null}">
			<div class="row">
				<div class="col-md-offset-1 col-md-10">
					<div class="jumbotron">
						<div class="container">
							<h2 class="text-center">Aún no ha seleccionado ningún
								producto para comprar</h2>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${sessionScope.productoCarritoLista2!=null}">
			<div class="row">
				<div class="col-sm-12 col-md-10 col-md-offset-1">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Product</th>
								<th class="text-center">Total</th>
								<th>Cantidad</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sessionScope.productoCarritoLista2}" var="pro">
								<tr>
									<td class="col-md-10">
										<div class="media">
											<img class="thumbnail pull-left media-object"
												src="<c:url value="${pro.rutaImagen}"/>"
												style="width: 150px;">
											<div class="media-body">
												<h4 class="media-heading">
													&nbsp; <span><c:out value="${pro.descripcion}"></c:out></span>
												</h4>
											</div>
										</div>
									</td>
									<td class="col-md-1 text-center"><strong><c:out
												value="${pro.precioUnitarioSinIva}"></c:out></strong>
													<td class="text-left">
											<strong><c:out value="${pro.cantidad}"></c:out></strong></td></td>
									<td class="col-md-1"><a href="ControllerBorrarCarrito?idProductoBorrar=<c:out value="${pro.id}"></c:out>" class="btn btn-danger">
											<span class="glyphicon glyphicon-remove"></span> Eliminar
									</a></td>
								
								</tr>
							</c:forEach>
							<tr>
								<td> </td>
								<td><h3>Total</h3></td>
								<td class="text-right"><h3>
										<strong><c:out value="${sessionScope.sumaTotal}"></c:out></strong>
									</h3></td>
							</tr>
							<tr>
								<td> </td>
								<td><c:if test="${sessionScope.persona!=null}">
										<a href="http://localhost:8080/proyecto_web_gestion_tienda/ControllerCliente" class="btn btn-default"> <span
											class="glyphicon glyphicon-shopping-cart"></span> Continuar
											comprando
										</a>
									</c:if> <c:if test="${sessionScope.persona==null}">
										<a href="http://localhost:8080/proyecto_web_gestion_tienda/ControllerIndex" class="btn btn-default"> <span
											class="glyphicon glyphicon-shopping-cart"></span> Continuar
											comprando
										</a>
									</c:if></td>
								<td>
									<form
										action="http://localhost:8080/proyecto_web_gestion_tienda/ControllerCarrito"
										method="post">
										<button type="submit" class="btn btn-success">FinalizarCompra</button>
									</form>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
	</div>
	<br>
	<br>


	<%@include file="includes/footer.jsp"%>

</body>
</html>