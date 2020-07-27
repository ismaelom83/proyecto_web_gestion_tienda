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


	<div id="signupbox" style="margin-top: 50px"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<div class="panel-title">Enviar correo Trabajador</div>
			</div>
			<div class="panel-body">
				<form id="signupform" class="form-horizontal" role="form"
					method="get" enctype="multipart/form-data" action="ControllerEnviarMensaje">
					<div id="signupalert" style="display: none"
						class="alert alert-danger">
						<p>Error:</p>
						<span></span>
					</div>
					<div class="form-group">
						<label for="email" class="col-md-3 control-label">Id
							Destinatario</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="IdDestinatario"
								placeholder="Id Destinatario">
						</div>
					</div>
					<div class="md-form">
						<textarea id="form7" class="md-textarea form-control" name="asunto" rows="3"></textarea>
						<label for="form7">Asunto</label>
					</div>
					<!--Textarea with icon prefix-->
					<div class="md-form">
						<i class="fas fa-pencil-alt prefix"></i>
						<textarea id="form10" class="md-textarea form-control"  name="cuerpo" rows="3"></textarea>
						<label for="form10">Cabecera Mensaje</label>
					</div>
					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<button id="btn-signup" type="submit" class="btn btn-info">
								EnviarCorreo</button>
			
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>




	<%@include file="includes/footer.jsp"%>
</body>
</html>