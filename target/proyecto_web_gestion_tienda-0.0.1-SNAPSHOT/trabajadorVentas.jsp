<%@page import="java.util.ArrayList"%>
<%@page import="proyecto_web_gestion_tienda.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
<title>Insert title here</title>
</head>
<body>
<%@include file="includes/nav.jsp" %>

<%
HttpSession mySession = request.getSession(true);
Persona p = (Persona)mySession.getAttribute("persona"); ArrayList<Persona> lista = (ArrayList<Persona>)request.getAttribute("todosProductos");%>
<h1>bienvenido al menu de los trabajadores de Ventas</h1>
<h1>Hola: <% out.println(p.getNombre());  %><% out.println(p.getApellido1()); %> tu email es: <% out.println(p.getMail()); %> eres un trabajador tipo<% out.println(p.getTipoPersona()); %></h1>
<%-- <h2>El descuento es: <% out.println(l); %></h2> --%>
<%@include file="includes/footer.jsp" %>
</body>
</html>