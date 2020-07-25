<%@page import="javax.persistence.metamodel.SetAttribute"%>
<%@page import="proyecto_web_gestion_tienda.model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
<title>Tienda Online</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/styles.css">

</head>

<body>

	<%@include file="includes/navPrincipal.jsp"%>
	<%
		ArrayList<Producto> listaP = (ArrayList<Producto>) request.getAttribute("todosProductos");
	pageContext.setAttribute("listaP", listaP);
	ArrayList<Producto> listaCategoria = (ArrayList<Producto>) request.getAttribute("productosCategoria");
	pageContext.setAttribute("listaCategoria", listaCategoria);
	%>


	<%
		HttpSession mySession = request.getSession();
	if (mySession.getAttribute("todosProductos") == null) {
	response.sendRedirect(request.getContextPath() + "/ControllerIndex");
}
	if (mySession.getAttribute("persona") != null) {
		mySession.invalidate();
	}
	%>

	<div class="container">
		<div class="section" id="carousel">
			<div class="container">
				<div class="row">
					<div class="col-md-8 mr-auto ml-auto">

						<!-- Carousel Card -->
						<div class="card card-raised card-carousel">
							<div id="carouselExampleIndicators" class="carousel slide"
								data-ride="carousel" data-interval="5000">
								<ol class="carousel-indicators">
									<li data-target="#carouselExampleIndicators" data-slide-to="0"
										class="active"></li>
									<li data-target="#carouselExampleIndicators" data-slide-to="1"
										class=""></li>
									<li data-target="#carouselExampleIndicators" data-slide-to="2"
										class=""></li>
								</ol>
								<div class="carousel-inner">
									<div class="carousel-item active">
										<img class="d-block w-100 h-100" src="img/s2.jpg"
											alt="First slide">
										<div class="carousel-caption d-none d-md-block">
											<h4>
												<i class="material-icons"></i>

											</h4>
										</div>
									</div>
									<div class="carousel-item">
										<img class="d-block w-100" src="img/s3.jpg" alt="Second slide">
										<div class="carousel-caption d-none d-md-block">
											<h4>
												<i class="material-icons"></i>

											</h4>
										</div>
									</div>
									<div class="carousel-item">
										<img class="d-block w-100" src="img/s1.jpg" alt="Third slide">
										<div class="carousel-caption d-none d-md-block">
											<h4>
												<i class="material-icons"></i>

											</h4>
										</div>
									</div>
								</div>
								<a class="carousel-control-prev"
									href="#carouselExampleIndicators" role="button"
									data-slide="prev"> <i class="material-icons"></i> <span
									class="sr-only"></span>
								</a> <a class="carousel-control-next"
									href="#carouselExampleIndicators" role="button"
									data-slide="next"> <i class="material-icons"></i> <span
									class="sr-only"></span>
								</a>
							</div>
						</div>
						<!-- End Carousel Card -->

					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<a href="ControllerMostarCategoria?categoria=portatiles"
			class="btn botonesIr btn-1">Ver portatiles</a> <a
			href="ControllerMostarCategoria?categoria=monitores"
			class="btn botonesIr btn-2">Ver Monitores</a> <a
			href="ControllerMostarCategoria?categoria=televisiones"
			class="btn botonesIr btn-3">Ver Televisiones</a>
			<a href="ControllerIndex"
			class="btn botonesIr btn-4">Ver Todos</a>
	</div>



	<div class="container page-wrapper">
		<div class="page-inner">
			<div class="row">
				<c:forEach items="${sessionScope.todosProductos}" var="producto">
					<div class="el-wrapper">
						<div class="box-up">
							<img class="img" src="<c:url value="${producto.rutaImagen}"/>"
								width="250px;" alt="">
							<div class="img-info">
								<div class="info-inner">
									<span class="p-name"><c:out
											value="${producto.descripcion}"></c:out></span> <span
										class="p-company"></span>
								</div>
								<div class="a-size">
									Stock: <span class="size"></span>
									<c:out value="${producto.stock}"></c:out>
								</div>
							</div>
						</div>

						<div class="box-down">
							<div class="h-bg">
								<div class="h-bg-inner"></div>
							</div>

							<a class="cart"
								href="ControllerProductoId?idProducto=<c:out value="${producto.id}"></c:out>">
								<span class="price"><c:out
										value="${producto.precioUnitarioSinIva}"></c:out></span> <span
								class="add-to-cart"> <span class="txt">Add in cart</span>
							</span>
							</a>
						</div>

					</div>
				</c:forEach>
			</div>

		</div>

	</div>

	<br>
	<br>

	<%@include file="includes/footer.jsp"%>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js"
		integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U"
		crossorigin="anonymous"></script>
	<script
		src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js"
		integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9"
		crossorigin="anonymous"></script>
</body>

</html>