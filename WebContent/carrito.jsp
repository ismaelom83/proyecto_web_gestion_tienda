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


<%@include file="includes/nav.jsp" %>

<div class="container">

		<div class="row">
			<div class="col-sm-12 col-md-10 col-md-offset-1">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Product</th>
							<th class="text-center">Total</th>
							<th> </th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="col-md-10">
								<div class="media">
									<img
										class="thumbnail pull-left media-object"
										src=""
										style="width: 150px;">									
									<div class="media-body">
										<h4 class="media-heading">&nbsp;
											<span text="">Nombre del producto</span>
										</h4>
										<h5 class="media-heading">&nbsp;
											by <span text="">pepe@pepe.com</span>
										</h5>
										
									</div>
								</div>
							</td>

							<td class="col-md-1 text-center"><strong text=""></strong></td>
							<td class="col-md-1">
								<a href="" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Eliminar
								</a>
							</td>
						</tr>
						
						
						<tr>
							<td> </td>
							<td><h3>Total</h3></td>
							<td class="text-right"><h3>
									<strong text="">$31.53</strong>
								</h3></td>
						</tr>
						<tr>
							<td> </td>
							<td>
								<a href="index.jsp" class="btn btn-default">
									<span class="glyphicon glyphicon-shopping-cart"></span>
									Continuar comprando
								</a>
							</td>
							<td>
								<a href="" class="btn btn-success">
									Finalizar compra <span class="glyphicon glyphicon-play"></span>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<br>
	<br>
	
	
	<%@include file="includes/footer.jsp" %>
	
</body>
</html>