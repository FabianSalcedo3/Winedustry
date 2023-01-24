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
</body>
</html>