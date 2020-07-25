<%@page import="proyecto_web_gestion_tienda.model.Producto"%>
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
	
	<div class="container">
		<div class="row">
			<div class="col-md-offset-1 col-md-8">
				<div class="col-md-8">
					<img src="${productoId.rutaImagen}"
						class="img-responsive center-block" alt="Image">
				</div>
				<br> <br> <br>
				<div class="col-md-4">
					<div class="text-center">
						<h5>
							<span text=""></span><br>
							<spantext=""> </span>
						</h5>
					</div>
					<div>
						<h3>${productoId.descripcion}</h3>
					</div>
					<br>
					<div class="pull-right">
						<h4>
							<strong>Precio:  ${productoId.precioUnitarioSinIva} </strong>
						</h4>
					</div>
					<c:if test="${sessionScope.persona!=null}">
						<div>
							<form
								action="http://localhost:8080/proyecto_web_gestion_tienda/ControllerCarrito"
								method="get">
								<label>NºProductos</label><br> <input type="number"
									name="cantidad" value="1" width="30px"> <br> <br>
								<input type="hidden" name="idProductoCarrito"
									value="${productoId.id}">
								<button type="submit" class="btn btn-lg btn-success btn-product">Añadir
									a la cesta</button>
							</form>
						</div>
					</c:if>
					<c:if test="${sessionScope.persona==null}">
						<div>
							<form
								action="http://localhost:8080/proyecto_web_gestion_tienda/ControllerCarritoNologeado"
								method="get">
								<label>NºProductos</label><br> <input type="number"
									name="cantidad" value="1" width="30px"> <br> <br>
								<input type="hidden" name="idProductoCarrito"
									value="${productoId.id}">
								<button type="submit" class="btn btn-lg btn-success btn-product">Añadir
									a la cesta</button>
							</form>
						</div>
					</c:if>
					<br> <br>
					<c:if test="${sessionScope.persona!=null}">
						<form action="http://localhost:8080/proyecto_web_gestion_tienda/ControllerCliente" method="get">
							<button type="submit" class="btn btn-lg btn-primary btn-product">
								VOLVER</button>
						</form>
					</c:if>
					<c:if test="${sessionScope.persona==null}">
						<form
							action="http://localhost:8080/proyecto_web_gestion_tienda/ControllerIndex"
							method="get">
							<button type="submit" class="btn btn-lg btn-primary btn-product">
								VOLVER</button>
						</form>
					</c:if>
					<form action=""></form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>