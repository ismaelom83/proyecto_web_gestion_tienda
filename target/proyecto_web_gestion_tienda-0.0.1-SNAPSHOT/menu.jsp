<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@page import="proyecto_web_gestion_tienda.model.Productos"%>
<%@page import="proyecto_web_gestion_tienda.model.Trabajadores"%>
<%@page import="proyecto_web_gestion_tienda.model.Clientes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">

<title>Tienda Online</title>
</head>
<body>
<%@include file="nav/nav.jsp" %>
<%Trabajadores t = (Trabajadores)request.getAttribute("trabajador"); Productos p = new Productos(); ArrayList<Productos> l = (ArrayList<Productos>)request.getAttribute("todosProductos");%>
<h1>bienvenido al menu de los trabajadores</h1>
<h1>Hola: <% out.println(t.getUser());  %> Tu saldo es de <% out.println(t.getSalario()); %></h1>
<%-- <h2>El descuento es: <% out.println(l); %></h2> --%>



<%  

for(Productos p1 : l){
	out.println("<table border='2'>");
	out.println("<tr>");
	out.println("<td>"+p1.getDescripcion()+"</td>");
	out.println("<td>"+p1.getDescuento()+"</td>");
	out.println("<td>"+p1.getPrecioUnitarioSinIva()+"</td>");
	out.println("<td>"+p1.getStock()+"</td>");
	out.println("<td>"+p1.getRutaImagen()+"</td>");
	out.println("</tr>");
	out.println("</table>");
}

%>

</body>
</html>