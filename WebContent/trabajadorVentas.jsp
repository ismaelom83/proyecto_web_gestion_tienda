<%@page import="java.util.ArrayList"%>
<%@page import="proyecto_web_gestion_tienda.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>

<!-- FRAMEWORK BOOTSTRAP para el estilo de la pagina-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

<!-- Los iconos tipo Solid de Fontawesome-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
<script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>





<!-- DATA TABLE -->
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="css/styles.css">

<script type="text/javascript" src="js/datatable.js"></script>
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand navbar-light bg-light">
		<a href="#" class="navbar-brand"><img alt="Logo" width="100px"
			height="40px" src="./img/logo-pccomponentes.jpg"></a>
		<button type="button" class="navbar-toggler" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false">
			--> <span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li><a class="nav-item active nav-link"
					href="ControllerTrabajadorVentas">Volver</a></li>
						<li><a class="nav-item active nav-link"
					href="ControllerMostrarDevolucion">Devolucion Pedidos</a></li>
			</ul>


			<ul class="navbar-nav mr-auto">
				<li>Bienvenido: ${sessionScope.persona}</li>
			</ul>
			<form class="navbar-form navbar-right"
				style="margin-right: 30px; width: 400px">
				<input type="text" class="form-control"
					placeholder="Buscar En la Tienda Online De Ismael..." name="q">
			</form>

			<ul class="nav navbar-nav navbar-right">
				<li><a class="nav-item active nav-link" href="ControllerLogout">
						<img alt="" src="./img/Human-gnome-logout.svg.png" width="40px"
						height="40px">
				</a></li>
			</ul>
		</div>
	</nav>


<%@include file="includes/footer.jsp" %>
</body>
</html>