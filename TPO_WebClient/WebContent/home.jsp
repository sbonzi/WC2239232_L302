<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de gestión de envios | HOME</title>
	<link rel="stylesheet" type="text/css" href="css/pages.css">
	<link rel="stylesheet" type="text/css" href="css/menu.css">
</head>
<body>
	<ul>
	  <li><a class="active" href="home.jsp">Home</a></li>
	  <li><a href="abmEnvios.jsp">ABM Envio</a></li>
	  <li><a href="abmCliente.html">ABM Cliente</a></li>
	  <li><a href="abmVehiculo.html">ABM Vehìculo</a></li>
	  <li><a href="abmSucursal.html">ABM Sucursal</a></li>
	  <li style="float:right"><a class="active" href="login?action=out" method=GET>Exit</a></li>
	</ul>
	<%if (request.getSession() != null && request.getSession().getAttribute("usuario") != null) {%>
		<a class="message" style="float:right" href="home?action=login" target="_self"><%=request.getSession().getAttribute("usuario")%></a>
	<%}else{%>
		<a class="message" style="float:right" href="home?action=login" target="_self">Login</a>
	<%}%>
</body>
</html>