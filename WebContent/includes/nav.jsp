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
            <a class="navbar-brand">Tienda Online</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><div style="margin-top:10px;">
                <form action="http://localhost:8080/proyecto_web_gestion_tienda/ControllerIndex" method="get">
                <button type="submit">INICIO</button>
                </form>
                </div></li>
                <li>
                    <a></a>
                </li>
                <li>
                    <a></a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
            <c:if test="${sessionScope.persona!=null}">
                <li><a href="carrito.jsp" ><span
                        class="glyphicon glyphicon-shopping-cart"></span> Carrito</a></li>
                        </c:if>
                         <c:if test="${sessionScope.persona==null}">
                <li><a href="http://localhost:8080/proyecto_web_gestion_tienda/ControllerCarritoNologeado" ><span
                        class="glyphicon glyphicon-shopping-cart"></span>Carrito</a></li>
                        </c:if>
                <li><a href="login.jsp"><span
                        class="glyphicon glyphicon-user"></span> Login</a></li>
                <li class="dropdown"><a
                    href="#" class="dropdown-toggle" data-toggle="dropdown"
                    role="button" aria-haspopup="true" aria-expanded="false"> <span>Menú</span> <span class="caret"></span>
                </a>
                    <ul class="dropdown-menu">
                        <li><form action="http://localhost:8080/proyecto_web_gestion_tienda/ControllerLogout" method="post">
                        <button type="submit">LoGout</button>
                        </form>
                        </li>
                    </ul></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Buscar..."
                    name="q">
            </form>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container text-center">
        <img src="https://www.lynkoo.com/wp-content/uploads/2013/08/20130828_Como-crear-un-logotipo-adecuado-para-mi-tienda-online-3.jpg"  alt="">
    </div>
</div>