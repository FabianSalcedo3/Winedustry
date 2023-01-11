<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Aggiungi studente</title>
		<link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<link rel="stylesheet" href="style.css">
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
	</head>
	<body background="gradient.jpg">
    <div class="container">
        <div class="row g-3 justify-content-center h-50 my-auto">
            <div class="col-sm-12 col-md-8 col-lg-4 justify-content-center">
                <div class="card-title">Studente</div>
					<form action="AggiungiStudenteServlet" method="post">
						<div class="form-floating mb-3">
							<input class="form-control" type="text" id="matricolaInput" name="matricola" required placeholder="">
							<label for="matricolaInput">MATRICOLA*</label>
						</div>
						<div class="form-floating mb-3">
							<input class="form-control" type="text" id="codiceFiscaleInput" name="codiceFiscale" required placeholder="">
							<label for="codiceFiscaleInput">CODICE FISCALE*</label>
						</div>
						<div class="form-floating mb-3">
							<input class="form-control" type="text" id="nomeInput" name="nome" required placeholder="">
							<label for="nomeInput">NOME*</label>
						</div>
						<div class="form-floating mb-3">
							<input class="form-control" type="text" id="cognomeInput" name="cognome" required placeholder="">
							<label for="cognomeInput">COGNOME*</label>
						</div>
						<div class="form-floating mb-3">
							<input class="form-control" type="date" id="dataNascitaInput" name="dataNascita" required placeholder="">
							<label for="dataNascitaInput">DATA NASCITA*</label>
						</div>
							<input class="form-check-input" type="radio" id="sesso-Input" name="sesso" required value="M">
							<label class="form-check-label" for="sesso-Input">M</label>
							<input class="form-check-input" type="radio" id="sesso-Input" name="sesso" required value="F">
							<label class="form-check-label" for="sesso-Input">F</label>
						<div class="card-footer"><button class="btn btn-success" type="submit">aggiungi</button></div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>