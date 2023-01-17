<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.generationitaly.winedustryofficial.entity.Regione" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	<% Regione regione = (Regione) request.getAttribute("regione"); 
	   out.println(regione.getDescrizione());
	   regione.getVini().forEach(vino -> out.println(vino.getVitigno()));
	%>
	
	</body>
</html>