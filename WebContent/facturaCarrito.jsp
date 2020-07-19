<!DOCTYPE html>
<html lang="es">
<head>
<title>Mercado-Segunda-Mano</title>
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
		<div class="col-xs-offset-3 col-xs-6">
			<div class="invoice-title">
				<h2>Factura</h2>
				<h3 class="pull-right">
					Compra #<span>1234</span>
				</h3>
			</div>
			<hr>
			<div class="row">
				<div class="col-xs-6">
					<address>
						<strong>Comprado por:</strong><br> <span></span><br> <span></span><br>
					</address>
				</div>
				<div class="col-xs-6 text-right">
					<address>
						<strong>Fecha de compra:</strong><br> <span></span><br>
						<br>
					</address>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-offset-3 col-md-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<strong>Listado de productos</strong>
					</h3>
				</div>
				<div class="panel-body invoice-body">
					<div class="table-responsive">
						<table class="table table-condensed">
							<thead>
								<tr>
									<td><strong>Producto</strong></td>
									<td class="text-right"><strong>Precio</strong></td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><span>Producto</span></td>
									<td class="text-right"><span>123€</span></td>
								</tr>
								<tr>
									<td class="thick-line text-right"><strong>Total</strong></td>
									<td class="thick-line text-right"><span></span></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br>
<br>

	<%@include file="includes/footer.jsp"%>

</body>
</html>