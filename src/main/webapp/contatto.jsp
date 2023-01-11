<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="it.generationitaly.examplewebapp.entity.Studente"%>
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
					<%
					Studente studente = (Studente)request.getAttribute("studente");
					%>
					<div class="card-title">Studente matricola: <%=studente.getMatricola() %></div>
						<div class="card mb-2">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>NOME</th>
										<th>COGNOME</th>
										<th>MAIL</th>
										<th>TELEFONO</th>
										<th>DOMICILIO</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><%= studente.getNome() %></td>
										<td><%= studente.getCognome() %></td>
										<td><%= studente.getContatti().getEmail() %></td>
										<td><%= studente.getContatti().getTelefono() %></td>
										<td><%= studente.getContatti().getDomicilio() %></td>
									</tr>
								</tbody>
							</table>
						</div>
					<a type="button" class="btn btn-danger" href="ListaStudentiServlet">INDIETRO</a>
				</div>
			</div>
		</div>
	</body>
</html>