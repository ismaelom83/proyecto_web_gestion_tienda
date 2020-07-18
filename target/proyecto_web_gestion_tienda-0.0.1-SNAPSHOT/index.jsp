<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
<title>Tienda Online</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">

</head>

<body>


<%@include file="nav/nav.jsp" %>

	<form method="POST" id="logoutForm"></form>

	<div class="container">
		<div class="row">
			<div class="col-md-offset-1 col-md-8">
				<div class="col-md-8">
					<img src="https://placehold.it/1200x600?text=SIN%20IMAGEN"
						class="img-responsive center-block" alt="Image">
				</div>
				<div class="col-md-4">
					<div class="text-center">
						<img
							name="aboutme" width="140" height="140" class="img-circle">
						<h5><span></span><br>
							<span></span></h5>
					</div>
					<div>
						<h3></h3>
					</div>
					<div class="pull-right">
						<h4>
							<strong></strong>
						</h4>
					</div>
					<a 
					type="button" class="btn btn-lg btn-success btn-product">
						<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;Comprar
					</a>
				</div>
			</div>

		</div>
	</div>
	<br>
	<br>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>