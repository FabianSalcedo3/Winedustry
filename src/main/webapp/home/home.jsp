<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link href="style.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>

<body>
	<% String usernameTemp = (String) session.getAttribute("user");
	if (usernameTemp == null) { 
	response.sendRedirect("../login.jsp"); 
	}  %>
	<div class="finestraintera">
		<!-- HEADER -->
		<div class="row">
			<!-- primo col di 3 -->
			<div class="col-md-3">
				<!-- <img src="icona.png" style="width: 110px; padding-top: 20px; padding-left: 30px;"> -->
			</div>
			<!-- secondo col di 6 -->
			<div class="col-md-6 "
				style="display: flex; justify-content: center; text-align: center;">
				<div class="glassmorfismocartina">
					<div class="logo">
						<h1 style="font-size: 70px; font-weight: 700;">Winedustry</h1>

						<img src="Cartina_Italia.png"
							style="height: 80vh; margin-top: 10px;">
					</div>
				</div>
			</div>

			<!-- spazio per i tooltip di 1 -->
			<div class="col-md-1">

				<!-- TOOLTIP veneto -->
				<div style="margin-left: -439px; margin-top: 170px;">
					<div class="item-hints">
						<div class="hint" data-position="4">
							<!-- is-hint -->
							<a href="../RegioniServlet?regioneID=1"><span class="hint-radius"></span>
							<span class="hint-dot"></span></a>
							<div class="hint-content do--split-children glassmorfismo"
								style="width: 380px;">
								<p style="margin-left: 15px; margin-right: 15px;">Scopri
									alcuni tra i vini più raffinati del Bel Paese. Assapora
									passione, tradizione e innovazione e lasciati trasportare da
									aromi fruttati o floreali.</p>
							</div>
						</div>
					</div>
				</div>

				<!-- TOOLTIP emilia-romagna -->
				<div style="margin-left: -460px; margin-top: 16px;">
					<link
						href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&display=swap"
						rel="stylesheet">
					<div class="item-hints">
						<div class="hint" data-position="4">
							<!-- is-hint -->
							<span class="hint-radius"></span> <span class="hint-dot"></span>
							<div class="hint-content do--split-children glassmorfismo"
								style="width: 350px;">
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
				<div style="margin-left: -450px; margin-top: 20px;">
					<link
						href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&display=swap"
						rel="stylesheet">
					<div class="item-hints">
						<div class="hint" data-position="4">
							<!-- is-hint -->
							<span class="hint-radius"></span> <span class="hint-dot"></span>
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
				<div style="margin-left: -250px; margin-top: 65px;">
					<link
						href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&display=swap"
						rel="stylesheet">
					<div class="item-hints">
						<div class="hint" data-position="4">
							<!-- is-hint -->
							<span class="hint-radius"></span> <span class="hint-dot"></span>
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
				<div style="margin-left: -330px; margin-top: 142px;">
					<link
						href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&display=swap"
						rel="stylesheet">
					<div class="item-hints">
						<div class="hint" data-position="4">
							<!-- is-hint -->
							<span class="hint-radius"></span> <span class="hint-dot"></span>
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
			<!-- MENU (dentro il row) -->

			<div class="col-md-1">
				<div class="burger">
					<span></span>
				</div>

				<nav>
					<ul class="main">
						<li><a href="#0">Home</a></li>
						<li><a href="#0">Shop</a></li>
						<li><a href="#0">Contact</a></li>
						<li><a href="#0">Cart <span>(5)</span></a></li>
					</ul>

					<div class="about">
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
							Aenean commodo ligula eget dolor. Aenean massa.</p>
					</div>

					<div class="social">
						<a href="#0" target="_blank"><svg
								xmlns="http://www.w3.org/2000/svg"
								xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
								width="64px" height="64px" viewBox="0 0 64 64">
                                <g transform="translate(0, 0)">
                                    <path
									d="M64,12.2c-2.4,1-4.9,1.8-7.5,2.1c2.7-1.6,4.8-4.2,5.8-7.3c-2.5,1.5-5.3,2.6-8.3,3.2C51.5,7.6,48.1,6,44.3,6 c-7.3,0-13.1,5.9-13.1,13.1c0,1,0.1,2,0.3,3C20.6,21.6,10.9,16.3,4.5,8.4c-1.1,1.9-1.8,4.2-1.8,6.6c0,4.6,2.3,8.6,5.8,10.9 c-2.2-0.1-4.2-0.7-5.9-1.6c0,0.1,0,0.1,0,0.2c0,6.4,4.5,11.7,10.5,12.9c-1.1,0.3-2.3,0.5-3.5,0.5c-0.8,0-1.7-0.1-2.5-0.2 c1.7,5.2,6.5,9,12.3,9.1c-4.5,3.5-10.2,5.6-16.3,5.6c-1.1,0-2.1-0.1-3.1-0.2C5.8,55.8,12.7,58,20.1,58c24.2,0,37.4-20,37.4-37.4 c0-0.6,0-1.1,0-1.7C60,17.1,62.2,14.8,64,12.2z">
                                    </path>
                                </g>
                            </svg></a> 
                            <a href="#0" target="_blank">
                            	<svg
								xmlns="http://www.w3.org/2000/svg"
								xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
								width="64px" height="64px" viewBox="0 0 64 64">
                               	 	<g transform="translate(0, 0)">
                                   	 	<path
										d="M32,5.766c8.544,0,9.556,0.033,12.931,0.187c3.642,0.166,7.021,0.895,9.621,3.496 c2.6,2.6,3.329,5.979,3.496,9.621c0.154,3.374,0.187,4.386,0.187,12.931s-0.033,9.556-0.187,12.931 c-0.166,3.642-0.895,7.021-3.496,9.621c-2.6,2.6-5.98,3.329-9.621,3.496c-3.374,0.154-4.386,0.187-12.931,0.187 s-9.557-0.033-12.931-0.187c-3.642-0.166-7.021-0.895-9.621-3.496c-2.6-2.6-3.329-5.979-3.496-9.621 C5.798,41.556,5.766,40.544,5.766,32s0.033-9.556,0.187-12.931c0.166-3.642,0.895-7.021,3.496-9.621 c2.6-2.6,5.979-3.329,9.621-3.496C22.444,5.798,23.456,5.766,32,5.766 M32,0c-8.691,0-9.78,0.037-13.194,0.193 c-5.2,0.237-9.768,1.511-13.436,5.178C1.705,9.037,0.43,13.604,0.193,18.806C0.037,22.22,0,23.309,0,32 c0,8.691,0.037,9.78,0.193,13.194c0.237,5.2,1.511,9.768,5.178,13.436c3.666,3.666,8.234,4.941,13.436,5.178 C22.22,63.963,23.309,64,32,64s9.78-0.037,13.194-0.193c5.199-0.237,9.768-1.511,13.436-5.178c3.666-3.666,4.941-8.234,5.178-13.436 C63.963,41.78,64,40.691,64,32s-0.037-9.78-0.193-13.194c-0.237-5.2-1.511-9.768-5.178-13.436 c-3.666-3.666-8.234-4.941-13.436-5.178C41.78,0.037,40.691,0,32,0L32,0z">
                                    	</path>
                                   		<path data-color="color-2"
										d="M32,15.568c-9.075,0-16.432,7.357-16.432,16.432c0,9.075,7.357,16.432,16.432,16.432 S48.432,41.075,48.432,32C48.432,22.925,41.075,15.568,32,15.568z M32,42.667c-5.891,0-10.667-4.776-10.667-10.667 c0-5.891,4.776-10.667,10.667-10.667c5.891,0,10.667,4.776,10.667,10.667C42.667,37.891,37.891,42.667,32,42.667z">
                                    	</path>
                                    	<circle data-color="color-2" cx="49.082" cy="14.918" r="3.84"></circle>
                                	</g>
                            	</svg>
                            </a>
					</div>
					<ul class="sub">
						<li><a href="#0">FAQ &amp; Shipping</a></li>
						<li><a href="#0">Terms &amp; Conditions</li>
					</ul>
				</nav>
				<div class="overlay"></div>
			</div>
		</div>
		<!-- questo ultimo div ha chiuso il row -->


		<!-- FOOTER -->
		<footer id="sticky-footer"
			class="flex-shrink-0 py-3 bg-dark text-white-50 fixed-bottom">
			<div class="container text-center">
				<small>Copyright &copy;2023 All rights reserved. | Made By
					Fabian, Enrico B, Jasmeen, Graziano, Enrico N, Andrea, Vincenzo.</small>
			</div>
		</footer>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<script src="./scriptcartina.js"></script>

	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
	<script src="./script.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>

</html>