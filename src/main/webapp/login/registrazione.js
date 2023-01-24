$(function () {
  $(".btn").click(function () {
    $(".form-signin").toggleClass("form-signin-left");
    $(".form-signup").toggleClass("form-signup-left");
    $(".frame").toggleClass("frame-long");
    $(".signup-inactive").toggleClass("signup-active");
    $(".signin-active").toggleClass("signin-inactive");
    $(".forgot").toggleClass("forgot-left");
    $(this).removeClass("idle").addClass("active");
  });
});

function checkPassword(form) {
  password1 = document.getElementById("passwordReg1").value;
  password2 = document.getElementById("passwordReg2").value;
  // no password 1
  if (password1 == ""){
    document.getElementById("message").style.color = "red";
    document.getElementById("message").innerHTML = "Please enter password";
  }
  // no password 2
  else if (password2 == ""){
    document.getElementById("message").style.color = "red";
    document.getElementById("message").innerHTML = "Please confirm password";
  }
  // diverse
  else if (password1 != password2) {
    document.getElementById("message").style.color = "red";
    document.getElementById("message").innerHTML = "Passwords did not match";
  }
  // uguali
  else {
    document.getElementById("message").style.color = "green";
    document.getElementById("message").innerHTML = "Passwords match";
  }
}