<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entities.Utente"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<title>Winedustry - Home Page</title>
<link href="<%=request.getContextPath()%>/home/stylehome.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
</head>

<body class="sfondohome">
	<%@ include file="../HeadFoot/navbar.jsp"%>
		<div class="row" style="margin-right: 0px;">
			<!-- primo col di 3 -->
			<div class="col-md-3">
			</div>

			<!-- secondo col di 6 -->
			<div class="col-md-6 "
				style="position: relative; display: flex; justify-content: center; text-align: center;">
				<div class="glassmorfismocartina">
					ì <img src="Cartina_Italia.png"
						style="height: 85vh; width: 35vw; margin-top: 20px;">
				</div>


				<!-- TOOLTIP veneto -->
				<div
					style="position: absolute; margin-top: 17vh; margin-right: 6vw;">
					<link
						href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&display=swap"
						rel="stylesheet">
					<div class="item-hints">
						<div class="hint" data-position="4">
							<span class="hint-radius"></span> 							
							<a href="<%=request.getContextPath()%>/RegioniServlet?regioneID=8">
								<span class="hint-dot"></span>
							</a>
							<div class="hint-content do--split-children glassmorfismo"
								style="width: 600px; height: 70px;">
								<p style="margin-left: 15px; margin-right: 15px;">Scopri
									alcuni tra i vini più raffinati del Bel Paese. Assapora
									passione, tradizione e innovazione e lasciati trasportare da
									aromi fruttati o floreali.</p>
							</div>
						</div>
					</div>
				</div>


				<!-- TOOLTIP emilia-romagna -->
				<div
					style="position: absolute; margin-top: 24vh; margin-right: 10.5vw;">
					<link
						href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&display=swap"
						rel="stylesheet">
					<div class="item-hints">
						<div class="hint" data-position="4">
							<span class="hint-radius"></span> 
							<a href="<%=request.getContextPath()%>/RegioniServlet?regioneID=6">
								<span class="hint-dot"></span>
							</a>
							<div class="hint-content do--split-children glassmorfismo"
								style="width: 550px;">
								<p style="margin-left: 15px; margin-right: 15px;">L'Emilia-Romagna
									ti sorprenderà con i suoi vini rosso rubino o con bianchi
									rinfrescanti. Ogni bottiglia racconta una storia, fatti
									trasportare in una terra rinomata per la sua tradizione
									culinaria e tecnologica.</p>
							</div>
						</div>
					</div>
				</div>


				<!-- TOOLTIP toscana -->
				<div
					style="position: absolute; margin-top: 32vh; margin-right: 8vw;">
					<link
						href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&display=swap"
						rel="stylesheet">
					<div class="item-hints">
						<div class="hint" data-position="4">
							<span class="hint-radius"></span>
							<a href="<%=request.getContextPath()%>/RegioniServlet?regioneID=5">
								<span class="hint-dot"></span>
							</a>
							<div class="hint-content do--split-children glassmorfismo"
								style="width: 330px;">
								<p style="margin-left: 15px; margin-right: 15px;">Nati
									dall'incontro tra i colli del Chianti e il Tirreno, ad ogni
									sorso i vini toscani regalano un'esperienza unica che
									restituisce l'unicità del terroir di una regione ricca di arte
									e passione vinicola.</p>
							</div>
						</div>
					</div>
				</div>


				<!-- TOOLTIP puglia -->
				<div
					style="position: absolute; margin-top: 48vh; margin-left: 26vw;">
					<link
						href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&display=swap"
						rel="stylesheet">
					<div class="item-hints">
						<div class="hint" data-position="4">
							<span class="hint-radius"></span> 
							<a href="<%=request.getContextPath()%>/RegioniServlet?regioneID=7">
								<span class="hint-dot"></span>
							</a>
							<div class="hint-content do--split-children glassmorfismo"
								style="width: 290px;">
								<p style="margin-left: 15px; margin-right: 15px;">Se vuoi
									scoprire gli antichi sapori di una terra ancora più antica
									lasciati catturare dai corposi e freschi vini pugliesi.
									Assaggia alcuni dei vini più raffinati al mondo.</p>
							</div>
						</div>
					</div>
				</div>


				<!-- TOOLTIP sicilia -->
				<div
					style="position: absolute; margin-top: 74vh; margin-left: 10vw;">
					<link
						href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&display=swap"
						rel="stylesheet">
					<div class="item-hints">
						<div class="hint" data-position="4">
							<span class="hint-radius"></span> 
							<a href="<%=request.getContextPath()%>/RegioniServlet?regioneID=1">
								<span class="hint-dot"></span>
							</a>
							<div class="hint-content do--split-children glassmorfismo"
								style="width: 320px;">
								<p style="margin-left: 15px; margin-right: 15px;">Invecchiati
									in botti di quercia, i vini siciliani raccontano la storia di
									una terra ricca e rinomata per la sua tradizione vinicola.
									Scopri qui i suoi sapori.</p>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<!-- questo ultimo div ha chiuso il row -->

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script src="<%=request.getContextPath()%>/home/scriptmenu.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
	<%@include file="../HeadFoot/footer.jsp" %>
</body>

</html>