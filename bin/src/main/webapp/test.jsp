<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="RegioniServlet?regioneID=1">Veneto</a>
	<form action="RicercaProdottiServlet" method="post">
		<input type="hidden" name="ricercaProdotto" value="r">
		<button type="submit">click</button>
	</form>
</body>
</html>