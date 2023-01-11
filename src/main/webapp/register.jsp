<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
            <h1 class="mb-3">Register</h1>
            <form action="RegisterServlet" method="post" class="needs-validation" oninput='password2.setCustomValidity(password2.value != password.value ? "Passwords do not match." : "")'>
                <div class="form-floating mb-2 was-validated">
                    <label class="form-label" for="username">Username:</label>
                    <input type="text" class="form-control" id="username" placeholder="" name="username" required>
                </div>
                <div class="form-floating mb-2 was-validated">
                    <label class="form-label" for="password">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="" name="password" required>
                </div>
                <div class="form-floating mb-2 was-validated">
                    <label class="form-label" for="password2">Reapet Password:</label>
                    <input type="password" class="form-control" id="password2" placeholder="" name="password2" required>
                </div>
                <div class="form-group form-check">
                    <input class="form-check-input" type="checkbox" id="check">
                    <label class="form-check-label" for="check">I agree with the: <a href="" class="font-italic">terms of services</a></label>
                </div>

                <div>
                    <button type="submit" class="btn btn-primary">Sign up</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>