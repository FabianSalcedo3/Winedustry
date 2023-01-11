<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.generationitaly.examplewebapp.entity.Corso" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Corsi</title>
		</head>
	<body>
		<a type="button" href="#">+ AGGIUNGI</a>
		<% List<Corso> corsi = (List<Corso>) request.getAttribute("corsi"); %>
		<table>
			<thead>
				<tr>
					<th>CODICE</th>
					<th>NOME</th>
					<th>CFU</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<% for(Corso corso : corsi){ %>
				<tr>
					<td><%=corso.getCodice() %></td>
					<td><%=corso.getNome() %></td>
					<td><%=corso.getCfu()%></td>
					<td><a type="button" href="UpdateCorsoServlet?id=<%=corso.getId()%>">MODIFICA</a></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		<a type="button" href="index.jsp">INDIETRO</a>
	</body>
</html>