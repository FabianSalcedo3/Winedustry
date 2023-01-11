<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.generationitaly.examplewebapp.entity.Corso" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Modifica corso</title>
	</head>
	<body>
		<% Corso corso = (Corso) request.getAttribute("corso");%>
		<form action="UpdateCorsoServlet" method="post">
			<div>
				<input type="text" id="codiceInput" name="codice" required value="<%=corso.getCodice() %>" readonly>
				<label for="codiceInput">CODICE</label>
			</div>
			<div>
				<input type="text" id="nomeInput" name="nome" required value="<%=corso.getNome() %>">
				<label for="nomeInput">NOME</label>
			</div>
			<div>
				<input type="text" id="cfuInput" name="cfu" required value="<%=corso.getCfu()%>">
				<label for="cfuInput">CFU</label>
			</div>
			<input type="hidden" value="<%=corso.getId()%>" name="id">
			<button type="submit">modifica</button>
		</form>
	</body>
</html>