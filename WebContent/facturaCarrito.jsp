<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="proyecto_web_gestion_tienda.model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

	<%
		Date dNow = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
	String currentDate = ft.format(dNow);
	%>



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
							<strong>Comprado por:</strong><br>
							<span>${sessionScope.persona}</span><br>
						</address>
					</div>
					<div class="col-xs-6 text-right">
						<address>
							<strong>Fecha de compra:</strong><br> <span><%=currentDate%></span><br>
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
										<td class="text-right"><strong>cantidad</strong></td>

									</tr>
								</thead>

								<c:forEach items="${sessionScope.productoCarritoLista}"
									var="factura">
									<tr>
										<td><span><c:out value="${factura.descripcion}"></c:out></span></td>
										<td class="text-right"><span><c:out
													value="${factura.precioUnitarioSinIva}"></c:out></span></td>
										<td class="text-right"><span>${sessionScope.cantidad}</span></td>

									</tr>
								</c:forEach>
								<tr>
									<td class="thick-line text-right"><strong>Total</strong></td>
									<td class="thick-line text-right"><span>${sessionScope.sumaTotal}</span></td>
								</tr>

							</table>
						</div>
					</div>
				</div>
			</div>
				<a href="clienteNormal.jsp" class="btn btn-success"  >vover a comprar</a>
		</div>
	</div>


	<%
		HttpSession mySession = request.getSession();
    
		mySession.removeAttribute("productoCarritoLista");
		mySession.removeAttribute("listaLogeada");

	%>

	<br>
	<br>

	<%@include file="includes/footer.jsp"%>

</body>
</html>