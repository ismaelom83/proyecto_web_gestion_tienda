<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="navbar h-5  mt-2">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		<c:if test="${sessionScope.persona==null}">
		<a href="ControllerIndex" class="navbar-brand"><img alt="Logo"  width="100px" height="40px" src="./img/logo-pccomponentes.jpg"></a>
	</c:if>
	<c:if test="${sessionScope.persona!=null}">
		<a href="ControllerCliente" class="navbar-brand"><img alt="Logo"  width="100px" height="40px" src="./img/logo-pccomponentes.jpg"></a>
	</c:if>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<c:if test="${sessionScope.persona!=null}">
					<li><a href="ControllerMisPedidos">MisPedidos</a></li>
				</c:if>
				<c:if test="${sessionScope.persona!=null}">
					<li><a>Bienvenido: ${sessionScope.persona}</a></li>
				</c:if>
			</ul>

	<ul class="navbar-nav mr-auto">
			<c:if test="${sessionScope.persona!=null}">
				Bienvenido: ${sessionScope.persona}
			</c:if>
		</ul>

			<ul class="nav navbar-nav navbar-right">
				<c:if test="${sessionScope.persona!=null}">
					<li class="active"><a href="carrito.jsp"><img
							alt="carrito" width="40px" height="40px"
							src="./img/baseline_shopping_cart_black_18dp.png"></a></li>
				</c:if>
				<c:if test="${sessionScope.persona==null}">
					<li><a class="nav-item active nav-link"
						href="http://localhost:8080/proyecto_web_gestion_tienda/ControllerCarritoNologeado"><img
							alt="carrito" width="40px" height="40px"
							src="./img/baseline_shopping_cart_black_18dp.png"></a></li>
				</c:if>
				<c:if test="${sessionScope.persona==null}">
					<li><a href="login.jsp"><span></span><img
							src="./img/baseline_login_black_18dp.png"></a></li>
				</c:if>
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
<!--  <div class="jumbotron">  -->
<!-- 	<div class="container text-center">  -->
<!-- 		<img  -->
<!--  			src="https://www.lynkoo.com/wp-content/uploads/2013/08/20130828_Como-crear-un-logotipo-adecuado-para-mi-tienda-online-3.jpg"  -->
<!--  			alt="">  -->
<!--  	</div>  -->

<!--  	</div> -->




