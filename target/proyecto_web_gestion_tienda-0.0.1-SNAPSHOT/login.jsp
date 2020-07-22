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
	
	<%@include file="includes/nav.jsp" %>

<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">Login de Trabjadores y Clientes</div>
				</div>
				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<form id="loginform" class="form-horizontal" method="POST"
						action="http://localhost:8080/proyecto_web_gestion_tienda/ControllerLogin" role="form">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								type="text" class="form-control" name="email"
								placeholder="email">
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" name="password"
								placeholder="password">
						</div>

						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls">
								<button id="btn-login" type="submit" class="btn btn-success">Login
								</button>
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-12 control">
								<div style="border-top: 1px solid #888; padding-top: 15px;">
									�Todav�a no tienes una cuenta de cliente? �Puedes crearla ahora mismo <a
										href="#"
										onClick="$('#loginbox').hide(); $('#signupbox').show()">
										pulsando aqu�! </a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="signupbox" style="display: none; margin-top: 50px"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">Crear una nueva cuenta</div>
				</div>
				<div class="panel-body">
					<form id="signupform" class="form-horizontal" role="form"
						method="POST" enctype="multipart/form-data" action="#">

						<div id="signupalert" style="display: none"
							class="alert alert-danger">
							<p>Error:</p>
							<span></span>
						</div>
						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="email"
									placeholder="Email">
							</div>
						</div>

						<div class="form-group">
							<label for="nombre" class="col-md-3 control-label">Nombre</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="nombre"
									placeholder="Nombre">
							</div>
						</div>
						<div class="form-group">
							<label for="apellidos" class="col-md-3 control-label">Apellidos</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="apellidos"
									placeholder="Apellidos">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Password</label>
							<div class="col-md-9">
								<input type="password" class="form-control" name="passwd"
									placeholder="Password">
							</div>
						</div>
						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-signup" type="submit" class="btn btn-info">
									Continuar</button>
								<span style="margin-left: 8px;">o&nbsp;</span> <a href=""
									onclick="$('#signupbox').hide(); $('#loginbox').show()"
									type="button" class="btn btn-default">Volver al formulario
									de login</a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<%@include file="includes/footer.jsp" %>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"
		src="@{/webjars/jquery/jquery.min.js}"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>	
</body>
</html>