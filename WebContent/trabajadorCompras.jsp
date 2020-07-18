<%@page import="proyecto_web_gestion_tienda.model.Persona"%>
<%@page import="proyecto_web_gestion_tienda.model.Trabajadore"%>
<%@page import="proyecto_web_gestion_tienda.model.Producto"%>
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
<%@include file="includes/nav.jsp" %>
<%Persona p = (Persona)request.getAttribute("persona"); 
ArrayList<Persona> lista = (ArrayList<Persona>)request.getAttribute("todasPersonas");
pageContext.setAttribute("lista", lista); %>
<h1>bienvenido al menu de los trabajadores de Compras</h1>
<h1>Hola: <% out.println(p.getNombre());  %><% out.println(p.getApellido1()); %> tu email es: <% out.println(p.getMail()); %>eres un trabajador tipo<% out.println(p.getTipoPersona()); %></h1>
<%-- <h2>El descuento es: <% out.println(l); %></h2> --%>


<table border="2">
				<tr>
				    <th>Nombre</th>
				    <th>Apellido</th>
				    <th>DNI</th>
				    <th>Email</th>
				    <th>Tipo Persona</th>
			    </tr>
			    <c:forEach items="${pageScope.lista}" var="persona">
			        <tr>
			            <td><c:out value="${persona.nombre}"></c:out></td>
			            <td><c:out value="${persona.apellido1}"></c:out></td>	
			            <td><c:out value="${persona.dni}"></c:out></td> 
			             <td><c:out value="${persona.mail}"></c:out></td>     
			              <td><c:out value="${persona.tipoPersona}"></c:out></td>        
			        </tr>
			    </c:forEach>
			</table>


<%@include file="includes/footer.jsp" %>
</body>
</html>