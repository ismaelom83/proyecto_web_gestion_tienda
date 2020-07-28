<%@page import="proyecto_web_gestion_tienda.model.Mensajeria"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
<title>tienda online</title>
</head>
<body>
	<%
		HttpSession mySession = request.getSession();
	if (mySession.getAttribute("persona") == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
	ArrayList<Mensajeria> devoluciones = (ArrayList<Mensajeria>) request.getAttribute("listaDevolucionPedidos2");
	pageContext.setAttribute("misDevoluciones2", devoluciones);
	%>
	
	<nav class="navbar h-5  mt-2">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		<a href="#" class="navbar-brand"><img alt="Logo"  width="100px" height="40px" src="./img/logo-pccomponentes.jpg"></a>

		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
			<li><a class="nav-item active nav-link"
					href="ControllerTrabajadorCompras">Volver</a></li>
				
				<c:if test="${sessionScope.persona!=null}">
					<li><a>Bienvenido: ${sessionScope.persona}</a></li>
				</c:if>
			
				
			</ul>

			<ul class="nav navbar-nav navbar-right">
				
				<c:if test="${sessionScope.persona!=null}">
					<li><a href="ControllerLogout"> <img alt=""
							src="./img/Human-gnome-logout.svg.png" width="40px" height="40px">
					</a></li>
				</c:if>
			</ul>
			<div>
				<form class="navbar-right" style="margin-right: 30px; width: 400px; margin-top: 15px;">
				<input type="text" class="form-control" placeholder="Buscar En la Tienda Online De Ismael..."
					name="q">
			</form>
			</div>
		
		</div>
			
	</div>
</nav>
	
<div class="row" style="margin-top: 100px;">
		<div class="col-md-offset-4 col-md-4">
			<table class="table table-striped">
				<thead>
					<tr>
						<td><strong>ID origen</strong></td>
						<td><strong>asunto</strong></td>
						<td><strong>cuerpo</strong></td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageScope.misDevoluciones2}" var="devoluciones">
						<tr>
							<td><span><c:out value="${devoluciones.id}"></c:out></span>
							<td><span><c:out value="${devoluciones.asunto}"></c:out></span>
						    <td><span><c:out value="${devoluciones.cuerpo}"></c:out></span>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>

	<%@include file="includes/footer.jsp"%>

</body>
</html>