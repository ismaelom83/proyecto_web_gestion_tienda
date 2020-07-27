<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand navbar-light bg-light">
	<c:if test="${sessionScope.persona==null}">
		<a href="ControllerIndex" class="navbar-brand"> <img alt="Logo" width="100px" height="40px" src="./img/logo-pccomponentes.jpg"> </a>
	</c:if>
	<c:if test="${sessionScope.persona!=null}">
		<a href="#" class="navbar-brand"><img alt="Logo"  width="100px" height="40px" src="./img/logo-pccomponentes.jpg"></a>
	</c:if>
	<button type="button" class="navbar-toggler" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false">
		--> <span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<c:if test="${sessionScope.persona!=null}">
				<li><a class="nav-item active nav-link"
					href="ControllerMisPedidos">MisPedidos</a></li>
			</c:if>
			<c:if test="${sessionScope.persona!=null}">
				<li><a class="nav-item active nav-link"
					href="ControllerCliente">Volver Zona Compra</a></li>
			</c:if>
					<c:if test="${sessionScope.persona!=null}">
				<li><a class="nav-item active nav-link"
					href="enviarMensaje.jsp">Enviar Mensaje</a></li>
			</c:if>
		</ul>
	
		
		<ul class="navbar-nav mr-auto">
			<c:if test="${sessionScope.persona!=null}">
				<li>Bienvenido: ${sessionScope.persona}</li>
			</c:if>
		</ul>
	<form class="navbar-form navbar-right" style="margin-right: 30px; width: 400px">
				<input type="text" class="form-control" placeholder="Buscar En la Tienda Online De Ismael..."
					name="q">
			</form>
	
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${sessionScope.persona!=null}">
				<li style="margin-right:20px;"><a class="nav-item active nav-link" href="carrito.jsp"><img alt="carrito" width="40px" height="40px" src="./img/baseline_shopping_cart_black_18dp.png"></a></li>
			</c:if>

			<c:if test="${sessionScope.persona==null}">
				<li><a class="nav-item active nav-link"
					href="http://localhost:8080/proyecto_web_gestion_tienda/ControllerCarritoNologeado"> <img alt="carrito" width="40px" height="40px" src="./img/baseline_shopping_cart_black_18dp.png"> </a></li>
			</c:if>

			<c:if test="${sessionScope.persona==null}">
				<li style="margin-left: 20px; margin-right: 30px;"><a
					class="nav-item active nav-link" href="login.jsp"> <img alt=""
						src="./img/baseline_login_black_18dp.png"></a></li>
			</c:if>
			<c:if test="${sessionScope.persona!=null}">
				<li><a class="nav-item active nav-link" href="ControllerLogout"> <img alt=""
						src="./img/Human-gnome-logout.svg.png" width="40px" height="40px">
				</a></li>
			</c:if>
		</ul>


	</div>
</nav>

