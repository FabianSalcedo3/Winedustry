<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.generationitaly.examplewebapp.entity.Studente"%>
<%@ page import="it.generationitaly.examplewebapp.entity.Corso"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body
	style="background-image: url(https://img.wallpapic.it/i7469-547-131/thumb/cavallo-stallone-mustang-spiaggia-sfondo.jpg); background-repeat: no-repeat; background-size: cover;">
	<%
	List<Corso> corsi = (List<Corso>) request.getAttribute("corsi");
	%>
	<%
	Studente studente = (Studente) request.getAttribute("studente");
	%>

	<div class="container text-center">
		<div class="row">

			<form action="AggiungiEsameServlet" method="post">

				<div class="form-floating mb-3">
					<h3>
						Studente:
						<%=studente.getMatricola()%>,
						<%=studente.getNome()%>
						<%=studente.getCognome()%>
					</h3>
					<input type="hidden" name="idStudente"
						value="<%=studente.getId()%>">
				</div>

				<div class="mb-3">
					<label for="corsoSelect">Corso: </label> <select id="corsoSelect" name="idCorso">
						<% for (Corso corso : corsi) { %>
						<option value="<%=corso.getId()%>"><%=corso.getNome()%></option>
						<% } %>
					</select>
				</div>

				<div class="form-floating mb-3">
					<input id="input-dataEsame" class="form-control" name="dataEsame"
						type="date" required> <label for="input-dataEsame">Data
						Esame</label>
				</div>

				<div class="form-floating mb-3">
					<input id="input-voto" class="form-control" name="voto"
						type="number" required> <label for="input-voto">Voto</label>
				</div>

				<div class="mb-3">
					<input class="form-check-input" type="checkbox" name="lode"
						id="flexCheckboxDefault1" value="lode"> <label
						class="form-check-label" for="flexRadioDefault1">LODE</label>
				</div>

				<button type="submit" class="btn btn-primary">AGGIUNGI</button>
			</form>

		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous">
	</script>
</body>
</html>