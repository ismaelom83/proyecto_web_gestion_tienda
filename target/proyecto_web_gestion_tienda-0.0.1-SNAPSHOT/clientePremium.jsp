<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Tienda Online</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>

	<%
		HttpSession mySession2 = request.getSession();

	int n =0;

	if (mySession2.getAttribute("listaLogeada") != null && n == 0) {
		n++;
		response.sendRedirect("http://localhost:8080/proyecto_web_gestion_tienda/ControllerCarrito");
	}
	%>

<%@include file="includes/nav.jsp" %>

<h1>Clientes Premium</h1>

<%@include file="includes/footer.jsp" %>
</body>
</html>