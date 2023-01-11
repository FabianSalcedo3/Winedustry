<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.generationitaly.examplewebapp.entity.Studente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<% Studente studente = (Studente) request.getAttribute("studente"); %>
		<form action="UpdateStudenteServlet" method="post">
			<div>
				<input type="text" id="matricolaInput" name="matricola" required value="<%=studente.getMatricola() %>" readonly>
				<label for="matricolaInput">MATRICOLA</label>
			</div>
			<div>
				<input type="text" id="codiceFiscaleInput" name="codiceFiscale" required value="<%=studente.getCodiceFiscale() %>" readonly>
				<label for="codiceFiscaleInput">CODICE FISCALE</label>
			</div>
			<div>
				<input type="text" id="nomeInput" name="nome" required value="<%=studente.getNome()%>">
				<label for="nomeInput">NOME</label>
			</div>
			<div>
				<input type="text" id="cognomeInput" name="cognome" required value="<%=studente.getCognome()%>">
				<label for="cognomeInput">COGNOME</label>
			</div>
			<div>
				<input type="date" id="dataNascitaInput" name="dataNascita" required value="<%=studente.getDataNascita()%>">
				<label for="dataNascitaInput">DATA NASCITA</label>
			</div>
				<input type="radio" id="sesso-Input" name="sesso" required value="M" <%= studente.getSesso() == 'M' ? "checked" : "" %>>
				<label for="sesso-Input">M</label>
				<input type="radio" id="sesso-Input" name="sesso" required value="F" <%= studente.getSesso() == 'F' ? "checked" : "" %>>
				<label for="sesso-Input">F</label>
			<input type="hidden" value="<%=studente.getId()%>" name="id">
			<button type="submit">modifica</button>
		</form>
	</body>
</html>