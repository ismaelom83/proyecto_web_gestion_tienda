
<%@page import="proyecto_web_gestion_tienda.model.Producto"%>
<%@page import="proyecto_web_gestion_tienda.model.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%Persona persona = (Persona)request.getAttribute("persona");  ArrayList<Persona> lista = (ArrayList<Persona>)request.getAttribute("todosProductos");
Producto producto = (Producto)request.getAttribute("objetoProducto");%>
<h1>bienvenido al menu de los trabajadores</h1>
<%-- <h1>Hola: <% out.println(persona.getNombre());  %> apellido:  <% out.println(persona.getApellido1()); %></h1> --%>
<%-- <h2>El descuento es: <% out.println(l); %></h2> --%>

<%
for(Persona p : lista){
	out.println("<table border='1'>");
	out.println("<tr>");
	out.println("<td>"+p.getNombre()+"</td>");
	out.println("<td>"+p.getApellido1()+"</td>");
	out.println("<td>"+p.getApellido2()+"</td>");
	out.println("<td>"+p.getDni()+"</td>");
	out.println("<td>"+p.getEmail()+"</td>");
	out.println("<td>"+p.getEdad()+"</td>");
	out.println("</tr>");
	out.println("</table>");
}

%>



</body>
</html>