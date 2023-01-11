<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.generationitaly.examplewebapp.entity.Studente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Studenti</title>
		<link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<link rel="stylesheet" href="style.css">
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
	</head>
	<body background="gradient.jpg">
		<div class="container">
			<div class="row g-3 h-50 my-auto">
				<div class="col-12">
					<% List<Studente> studenti = (List<Studente>) request.getAttribute("studenti"); %>
						<div class="card-title">Lista Studenti</div>
						<div class="card mb-2">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>MATRICOLA</th>
										<th>CODICE FISCALE</th>
										<th>NOME</th>
										<th>COGNOME</th>
										<th>DATA NASCITA</th>
										<th>SESSO</th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<% for(Studente studente : studenti){ %>
									<tr>
										<td><%=studente.getMatricola() %></td>
										<td><%=studente.getCodiceFiscale() %></td>
										<td><%=studente.getNome()%></td>
										<td><%=studente.getCognome() %></td>
										<td><%=studente.getDataNascita() %></td>
										<td><%=studente.getSesso() %></td>
										<td><a type="button" class="btn btn-primary" href="UpdateStudenteServlet?id=<%=studente.getId()%>">MODIFICA</a></td>
										<%-- <td><input type="hidden" name="id" value="<%=studente.getId() %>"></td> --%>
										<td><a type="button" class="btn btn-primary" href="EsamiServlet?id=<%=studente.getId()%>">ESAMI</a></td>
										<td><a type="button" class="btn btn-primary" href="ContattiServlet?id=<%=studente.getId()%>">INFO</a></td>
									</tr>
									<% } %>
								</tbody>
							</table>
						</div>
					<a type="button" class="btn btn-success" href="aggiungi-studente.jsp">+ AGGIUNGI</a>
					<a type="button" class="btn btn-warning" href="index.jsp">INDIETRO</a>
				</div>
			</div>
		</div>
	</body>
</html>