<%@page import="proyecto_web_gestion_tienda.model.DetallePedido"%>
<%@page import="proyecto_web_gestion_tienda.model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>

	<%@include file="includes/nav.jsp"%>



	<%
	HttpSession mySession = request.getSession();
	ArrayList<DetallePedido> lineasPedido2 = (ArrayList<DetallePedido>) request.getAttribute("lineasPedido");
	pageContext.setAttribute("listaPedido3", lineasPedido2);
	int totalCompra = (int) request.getAttribute("sTotal");
	 pageContext.setAttribute("total", totalCompra);
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
							<strong>Comprado por:</strong><br> <span>${sessionScope.persona}</span><br>
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
										<td class="text-right"><strong>cantidad</strong></td>

									</tr>
								</thead>

								<c:forEach items="${pageScope.listaPedido3}" var="lineas">
									<tr>
										<td><span><c:out
													value="${lineas.producto.descripcion}"></c:out></span></td>
										<td class="text-right"><span><c:out
													value="${lineas.producto.precioUnitarioSinIva}"></c:out></span></td>
										<td class="text-right"><span></span>
										<c:out value="${lineas.cantidad}"></c:out></td>

									</tr>
								</c:forEach>
								<tr>
									<td class="thick-line text-right"><strong>Total</strong></td>
									<td class="thick-line text-right"><span>${total}</span></td>
								</tr>

							</table>
						</div>
					</div>
				</div>
			</div>
			<a href="ControllerMisPedidos" class="btn btn-success">vover a
				ver pedidos</a>
		</div>
	</div>


	<br>
	<br>


	<%@include file="includes/footer.jsp"%>
</body>
</html>