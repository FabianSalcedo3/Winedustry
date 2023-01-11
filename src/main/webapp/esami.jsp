<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.generationitaly.examplewebapp.entity.Studente" %>
<%@ page import="it.generationitaly.examplewebapp.entity.Esame" %>
<%@ page import="it.generationitaly.examplewebapp.entity.Corso" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Esami</title>
		</head>
	<body>
		<% Studente studente = (Studente) request.getAttribute("studente"); %>
		<form action="#" method="post">
			<table>
				<thead>
					<tr>
						<th>DATA</th>
						<th>VOTO</th>
						<th>LODE</th>
						<th>CFU</th>
						<th>CODICE CORSO</th>
						<th>NOME CORSO</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<% for(Esame esame : studente.getEsami()){ %>
					<tr>
						<td><%=esame.getDataEsame() %></td>
						<td><%=esame.getVoto() %></td>
						<td><%=esame.isLode()%></td>
						<td><%=esame.getCorso().getCodice()%></td>
						<td><%=esame.getCorso().getNome() %></td>
					</tr>
					<% } %>
				</tbody>
			</table>
		</form>
		<a type="button" href="ListaStudentiServlet">INDIETRO</a>
		<br>
		<a type="button" href="AggiungiEsameServlet?id=<%=studente.getId() %>">+ AGGIUNGI ESAME</a>
	</body>
</html>