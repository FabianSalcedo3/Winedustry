<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.generationitaly.examplewebapp.entity.Corso" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Aggiungi corso</title>
	</head>
	<body>
		<form action="AggiungiCorsoServlet" method="post">
			<div>
				<input type="text" id="codiceInput" name="codice" required>
				<label for="codiceInput">CODICE</label>
			</div>
			<div>
				<input type="text" id="nomeInput" name="nome" required>
				<label for="nomeInput">NOME</label>
			</div>
			<div>
				<input type="text" id="cfuInput" name="cfu" required>
				<label for="cfuInput">CFU</label>
			</div>
			<input type="hidden" name="id">
			<button type="submit">modifica</button>
		</form>
	</body>
</html>