<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand navbar-light bg-light">
		<a href="#" class="navbar-brand"><img alt="Logo"  width="100px" height="40px" src="./img/logo-pccomponentes.jpg"></a>
	<button type="button" class="navbar-toggler" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false">
		--> <span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
				<li><a class="nav-item active nav-link"
					href="ControllerTrabajadorCompras">Volver</a></li>
		</ul>
	
		
		<ul class="navbar-nav mr-auto">	
				<li>Bienvenido: ${sessionScope.persona}</li>
		</ul>
	<form class="navbar-form navbar-right" style="margin-right: 30px; width: 400px">
				<input type="text" class="form-control" placeholder="Buscar En la Tienda Online De Ismael..."
					name="q">
			</form>
	
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${sessionScope.persona!=null}">
				<li style="margin-right:20px;"><a class="nav-item active nav-link" href="carrito.jsp"><img alt="carrito" width="40px" height="40px" src="./img/baseline_shopping_cart_black_18dp.png"></a></li>
			</c:if>


			
				<li><a class="nav-item active nav-link" href="ControllerLogout"> <img alt=""
						src="./img/Human-gnome-logout.svg.png" width="40px" height="40px">
				</a></li>
		</ul>


	</div>
</nav>