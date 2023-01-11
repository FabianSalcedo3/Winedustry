<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
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
					<div class="card-title">Home</div>
					<div class="card" style="width: 18rem;">
					  <ul class="list-group list-group-flush">
					    <li class="list-group-item"><a class="btn" href="ListaStudentiServlet"><i class="fa-regular fa-user"></i> VISUALIZZA STUDENTI</a></li>
					    <li class="list-group-item"><a class="btn" href="ListaCorsiServlet"><i class="fa-light fa-layer-group"></i> VISUALIZZA CORSI</a></li>
					  </ul>
					</div>
				</div>
			</div>
		</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>	
	</body>
</html>