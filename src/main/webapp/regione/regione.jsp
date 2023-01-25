<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Regione"%>
<%@ page import="entities.prodotto.alcolico.Vino"%>
<%@ page import="java.util.List"%>
<%
Regione regione = (Regione) request.getAttribute("regione");
List<Vino> prodottiRegione = regione.getVini();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title><%=regione.getNome() %></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="regione/styleregione.css">
<link rel="stylesheet" href="HeadFoot/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css'>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />

</head>
<body class="corpo">
	<section class="first">
<%-- 		<%@ include file="../HeadFoot/navbar.jsp" %> --%>
		<div class="outer">
			<div class="inner">
				<div class="bg one">
					<div class="container text-center">
						<a type="button" class="btn btn-outline-light top-0 mb-5" href="<%=request.getContextPath()%>/home/home.jsp">
							<i class="bi bi-arrow-return-left"></i>
						</a>                        
						<h2 class="section-heading titolino"><%=regione.getNome()%></h2>
						<p style="color: #cccccc; font-size: larger;"><%=regione.getDescrizione()%></p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="second">
		<div class="outer">
			<div class="inner">
				<div class="bg">
					<div class="container section-heading"
						style="display: flex; justify-content: center;">
						<div class="row">							
							<% for(int i = 0; i < prodottiRegione.size(); i++){ %>
								<% if(!prodottiRegione.get(i).equals(null) && i<4) { %>							
								<div class="col">
									<div class="finestracard h-100" >
										<!-- Product image-->
										<img class="card-img-top" style="width:50%;" src="<%=prodottiRegione.get(i).getImmagine()%>"/>
										<!-- Product details-->
										<div class="card-body p-4">
											<div class="text-center">
												<!-- Product name-->
												<h5 class="fw-bolder"><%=prodottiRegione.get(i).getNome() %></h5>
												<!-- Product price-->
												&euro;<%=prodottiRegione.get(i).getPrezzo() %>
											</div>
										</div>
										<!-- Product actions-->
										<div class="card-footer border-top-0 bg-transparent">
											<div class="text-center">
												<a class="btn btn-outline-dark mt-auto" href="ProdottiServlet?prodottoID=<%=prodottiRegione.get(i).getId()%>">Vino!</a>
											</div>
										</div>
									</div>
								</div>
								<% } 
							 } %>
							 <form action="ProdottiServlet" method="post">
							 <button type="submit" class="btn btn btn-outline-light bottom-0 mt-5">Scoprine altri</button>
							 </form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<section class="third">
		<div class="outer">
			<div class="inner">
				<div class="bg"></div>
			</div>
		</div>
	</section>

	<script src='https://assets.codepen.io/16327/gsap-latest-beta.min.js'></script>
	<script src='https://assets.codepen.io/16327/Observer.min.js'></script>
	<script
		src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/SplitText3.min.js'></script>
	<script src="regione/scriptregione.js"></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<!-- 	<script src="regione/scriptmenu.js"></script> -->
</body>
</html>
