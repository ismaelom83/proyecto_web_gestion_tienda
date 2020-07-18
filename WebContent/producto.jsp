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
						class="img-responsive center-block" alt="Image" >
				</div>
				<br> <br> <br>
				<div class="col-md-4">
					<div class="text-center">
						<h5>
							<span text=""></span><br>
							<spantext="">
							</span>
						</h5>
					</div>
					<div>
						<h3>
						 ${productoId.descripcion}
						</h3>
					</div>
					<br>
					<div class="pull-right">
						<h4>
							<strong>
						${productoId.precioUnitarioSinIva} 
							</strong>
						</h4>
					</div>
					<a href="ControllerCarrito?idProductoCarrito=${productoId.id}" type="button" class="btn btn-lg btn-success btn-product">A�adir al Carrito</a>
					<br>
					<br>
					<form
						action="http://localhost:8080/proyecto_web_gestion_tienda/ControllerIndex"
						method="get">
						<button type="submit" class="btn btn-lg btn-primary btn-product">  VOLVER  </button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>