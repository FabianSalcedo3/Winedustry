<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entities.Prodotto"%>
<%@ page import="java.util.List"%>
<jsp:include page="bootstrap.jsp"></jsp:include>
<% List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("prodotti"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Vini</title>
</head>
<body>
  <div class="container-fluid">
    <div class="row my-4 justify-content-around">
      <% for (Prodotto prodotto : prodotti) { %>
      <div class="card border-0" style="width: 12rem;">
        <% if (prodotto.getCategoria().equals("Rosso")) { 
          out.print("<img src='./images/"+"Rosso" +".png' class='card-img-top'>");
          } else if (prodotto.getCategoria().equals("Bianco")) { 
            out.print("<img src='./images/"+"Bianco" +".png' class='card-img-top'>");
            } else if (prodotto.getCategoria().equals("Rosato")) { 
              out.print("<img src='./images/"+"Rosato" +".png' class='card-img-top'>");
              } else if (prodotto.getCategoria().equals("Bollicine")) { 
                out.print("<img src='./images/"+"Bollicine" +".png' class='card-img-top'>"); 
                } else { out.print("<img src='./images/"+"Error" +".png class='card-img-top'>");
                  } %>
        <div class="card-body text-center">
          <h5 class="card-title"><%=prodotto.getVitigno()%></h5>
          <a href="#" class="btn btn-primary">Info</a>
        </div>
      </div>
      <% } %>
    </div>
  </div>
</body>
</html>
