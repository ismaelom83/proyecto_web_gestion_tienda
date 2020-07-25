<%@page import="java.util.ArrayList"%>
<%@page import="proyecto_web_gestion_tienda.model.Producto"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Tienda Online</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/stylesNav.css">
</head>
<body>
	<%@include file="includes/navPrincipal.jsp"%>
<h1>bienvenido administrador</h1>
  <div class="container">     
        <div class="section" id="carousel">
        <div class="container">
            <div class="row">
                <div class="col-md-8 mr-auto ml-auto">

                    <!-- Carousel Card -->
                    <div class="card card-raised card-carousel">
                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" data-interval="3000">
                          <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1" class=""></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2" class=""></li>
                          </ol>
                          <div class="carousel-inner">
                            <div class="carousel-item active">
                              <img class="d-block w-100 h-100" src="https://thumb.pccomponentes.com/s-1127-3000/promotions/6163/landing.jpg"
                              alt="First slide">
                              <div class="carousel-caption d-none d-md-block">
                                <h4>
                                    <i class="material-icons"></i>
                                    
                                </h4>
                              </div>
                            </div>
                            <div class="carousel-item">
                              <img class="d-block w-100" src="https://thumb.pccomponentes.com/s-1127-3000/promotions/6194/subbg.jpg"  alt="Second slide">
                              <div class="carousel-caption d-none d-md-block">
                                <h4>
                                    <i class="material-icons"></i>
                                    
                                </h4>
                              </div>
                            </div>
                            <div class="carousel-item">
                              <img class="d-block w-100" src="https://thumb.pccomponentes.com/s-1127-3000/promotions/6198/grn.jpg" alt="Third slide">
                              <div class="carousel-caption d-none d-md-block">
                                <h4>
                                    <i class="material-icons"></i>
                            
                                </h4>
                              </div>
                            </div>
                          </div>
                          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <i class="material-icons"></i>
                            <span class="sr-only"></span>
                          </a>
                          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <i class="material-icons"></i>
                            <span class="sr-only"></span>
                          </a>
                        </div>
                    </div>
                    <!-- End Carousel Card -->

                </div>
            </div>
        </div>
    </div>
    </div>
    
    
   
    
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>

	<%@include file="includes/footer.jsp" %>


</body>
</html>