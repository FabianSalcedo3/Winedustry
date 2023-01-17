<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.Prodotto"%>
<%@ page import="java.util.List"%>
<jsp:include page="bootstrap.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vini</title>
</head>
<body>
  <div class="container-fluid">
    <div class="row justify-content-around">
      <%
      List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("prodotti");
      for (Prodotto prodotto : prodotti) {
      %>
      <div class="card border-0" style="width: 18rem;">
        <img
          src="./images/<%=(prodotto.getCategoria().equals("Rosso")) ? "Rosso"
		: (prodotto.getCategoria().equals("Bianco")) ? "Bianco"
				: (prodotto.getCategoria().equals("Rosato")) ? "Rosato" : (prodotto.getCategoria().equals("Bollicine")) ? "Bollicine" : "Error"%>.png"
          class="card-img-top"
        >
        <div class="card-body text-center">
          <h5 class="card-title"><%=prodotto.getVitigno()%></h5>
          <a href="#" class="btn btn-primary">Info</a>
        </div>
      </div>
      <%
      }
      %>
    </div>
  </div>
</body>
</html>