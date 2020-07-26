
	<nav class="navbar navbar-expand navbar-light bg-light">
		<a href="#" class="navbar-brand"><img alt="Logo" width="100px"
			height="40px" src="./img/logo-pccomponentes.jpg"></a>
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
			<form class="navbar-form navbar-right"
				style="margin-right: 30px; width: 400px">
				<input type="text" class="form-control"
					placeholder="Buscar En la Tienda Online De Ismael..." name="q">
			</form>

			<ul class="nav navbar-nav navbar-right">
				<li><a class="nav-item active nav-link" href="ControllerLogout">
						<img alt="" src="./img/Human-gnome-logout.svg.png" width="40px"
						height="40px">
				</a></li>
			</ul>
		</div>
	</nav>