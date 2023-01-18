<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<!-- Mio CSS -->
<link href="./style.css" rel="stylesheet" />
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<!-- LOGIN -->
	<%
	String validationUsername = (String) request.getAttribute("validationUsername");
	String validationPassword = (String) request.getAttribute("validationPassword");
	String errorUserLogin = (String) request.getAttribute("errorUserLogin");
	String errorPasswordLogin = (String) request.getAttribute("errorPasswordLogin");
	String username = (String) request.getAttribute("username");
	%>
	
	<div class="section" style="height: 600px; position: absolute;">
		<div class="form-structor">
			<div class="signup">
				<h2 class="form-title" id="signup">
					<span>or</span>Sign up
				</h2>
				<div class="form-holder">
					<input type="text" class="input" placeholder="Name"> 
					<input type="email" class="input" placeholder="Email"> 
					<input type="password" class="input" placeholder="Password">
				</div>
				<button class="submit-btn">Sign up</button>
			</div>

			<div class="login slide-up">
				<div class="center">
					<h2 class="form-title" id="login">
						<span>or</span>Log in
					</h2>
					<form action="LoginServlet" method="post">
						<div class="form-holder">
							<input type="text" class="form-control <%=validationUsername%> border-0"
								placeholder="Username" name="username">
							<div class="invalid-feedback my-2">
								<%
								if (errorUserLogin != null) {
									out.print(errorUserLogin);
								}
								%>
							</div>
							<input type="password" class="form-control <%=validationPassword%> border-0"
								placeholder="Password" name="password">
							<div class="invalid-feedback my-2">
								<%
								if (errorPasswordLogin != null) {
									out.print(errorPasswordLogin);
								}
								%>
							</div>
						</div>
						<button type="submit" class="submit-btn">Accedi</button>
					</form>
				</div>
			</div>
		</div>
	</div>




	<!-- Mio javascript -->
	<script type="text/javascript" src="animazioni.js"></script>
	<!-- Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>