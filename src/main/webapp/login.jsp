<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
	<head>
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	        crossorigin="anonymous"></script>
	    <link rel="stylesheet" href="style2.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
	</head>	
	<body>
	    <div class="bg-image">
	        <div class="login">
	            <h1 class="mb-3">Login</h1>
	            <form action="LoginServlet" method="post" class="needs-validation">
	                <div class="form-floating mb-2 was-validated">
	                    <label class="form-label" for="username">Username:</label>
	                    <input type="text" class="form-control" id="username" placeholder="" name="username" required>
	                    <div class="invalid-feedback">
	                        Please enter your email address
	                    </div>
	                    <% if (request.getAttribute("error-username") != null) { %> 
					    <span class="error"><%=request.getAttribute("error-username")%></span> 
						<% } %> 
	                </div>
	                <div class="form-floating mb-2 was-validated">
	                    <label class="form-label" for="password">Password:</label>
	                    <input type="password" class="form-control" id="password" placeholder="" name="password" required>
	                    <div class="invalid-feedback">
	                        Please enter your password
	                    </div>
	                    <% if (request.getAttribute("error-password") != null) { %>
						<span class="error"><%=request.getAttribute("error-password") %></span>
						<% } %>
	                </div>
	                <div class="form-group form-check">
	                    <input class="form-check-input" type="checkbox" id="check">
	                    <label class="form-check-label" for="check">Remember me</label>
	                </div>
	
	                <div>
	                    <button type="submit" class="btn btn-primary">Sign in</button>
	                    <a href="register.jsp">Register</a>
	                </div>
	            </form>
	        </div>
	    </div>
	</body>
</html>
