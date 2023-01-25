<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="login/registrazione.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="login/registrazione.js"></script>
</head>
<body>
<<<<<<< HEAD
<% Boolean errorUsername = (Boolean)request.getAttribute("errorUsername");
	if(errorUsername==null) errorUsername=false;
	Boolean errorEmail = (Boolean)request.getAttribute("errorEmail");
	if(errorEmail==null) errorEmail=false;
	boolean register = false;
	if(errorEmail || errorUsername){
		register = true;}%>
	<div class="container">
        <div class="frame <%=(register)?"frame-long":""%>">
            <div class="nav text-center">
                <ul class="links" style="width: 100vw; padding-inline-start: 0px">
                    <li class="signin-active <%=(register)?"signin-inactive":""%>"><a class="btn">Accedi</a></li>
                    <li class="signup-inactive <%=(register)?"signup-active":""%>"><a class="btn">Registrati</a></li>
                </ul>
            </div>
            <div ng-app ng-init="checked = false">
                <!-- ACCEDI -->
                <form class="form-signin  <%=(register)?"form-signin-left":""%>" action="LoginServlet" method="post" name="form">
                    <label for="username-sign">Username</label>
                    <input class="form-styling" type="text" id="username-sign" name="username" />
                    <label for="password-sign">Password</label>
                    <input class="form-styling" type="password" id="password-sign" name="password"/>
                    <button type="submit" class="btn-signup">ACCEDI</button>
                </form>
                <!-- REGISTRATI -->
                <form class="form-signup  <%=(register)?"form-signup-left":""%>" action="RegisterServlet" method="post" name="form" oninput="return checkPassword(this)">
                    <label for="username-reg">Username</label>
                    <input class="form-styling" type="text" id="username-reg" name="username"/>
               		<%if(errorUsername){ %><span class="text-danger">Questo username è già in uso</span><%} %>
                    <label for="email">Email</label>
                    <input class="form-styling" type="text" id="email" name="email"/>
                 	<%if(errorEmail){ %><span class="text-danger">Questa mail è già in uso</span><%} %> 
                    <label for="passwordReg1">Password</label>
                    <input class="form-styling" type="password" id="passwordReg1" name="password"/>
                    <label for="passwordReg2">Conferma Password</label>
                    <input class="form-styling" type="password" id="passwordReg2"/>
                    <span id="message" style="font-weight: bolder"></span>
                    <button type="submit" class="btn-signup">REGISTRATI</button>
                </form>
            </div>
        </div>
     </div>
=======
  <div class="container position-absolute top-50 start-50 translate-middle">
    <div class="frame">
      <div class="nav text-center">
        <ul class="links" style="width: 100vw; padding-inline-start: 0px">
          <li class="signin-active">
            <a class="btn">Accedi</a>
          </li>
          <li class="signup-inactive">
            <a class="btn">Registrati</a>
          </li>
        </ul>
      </div>
      <div ng-app ng-init="checked = false">
        <!-- ACCEDI -->
        <form class="form-signin" action="LoginServlet" method="post" name="form">
          <label for="username-sign">Username</label>
          <input class="form-styling" type="text" id="username-sign" name="username" />
          <label for="password-sign">Password</label>
          <input class="form-styling" type="password" id="password-sign" name="password" />
          <button type="submit" class="btn-signup">ACCEDI</button>
        </form>
        <!-- REGISTRATI -->
        <form class="form-signup" action="RegisterServlet" method="post" name="form"
          oninput="return checkPassword(this)"
        >
          <label for="username-reg">Username</label>
          <input class="form-styling" type="text" id="username-reg" name="username" />
          <label for="email">Email</label>
          <input class="form-styling" type="text" id="email" name="email" />
          <label for="passwordReg1">Password</label>
          <input class="form-styling" type="password" id="passwordReg1" name="password" />
          <label for="passwordReg2">Conferma Password</label>
          <input class="form-styling" type="password" id="passwordReg2" />
          <span id="message"></span>
          <button type="submit" class="btn-signup">REGISTRATI</button>
        </form>
      </div>
    </div>
  </div>
>>>>>>> branch 'backup' of https://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@github.com/FabianSalcedo3/Winedustry
</body>
</html>