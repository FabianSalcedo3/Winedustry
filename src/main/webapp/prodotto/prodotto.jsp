<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Regione"%>
<%@ page import="entities.Prodotto"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Item - Winedustry</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
<!--         <link href="prodotto/styleheader.css" rel="stylesheet"/> -->
        <link href="HeadFoot/style.css" rel="stylesheet" />
    </head>
    <body style="background-image: linear-gradient(180deg, rgba(0, 0, 0, 0.6) 100%, rgba(0, 0, 0, 0.6) 100%), url(prodotto/sfondo2.png);
    font-family: Cormorant Garamond, serif;">
    	<% Prodotto prodotto = (Prodotto) request.getAttribute("prodotto"); %>
        <!-- Navigation-->
        <%@ include file="../HeadFoot/navbar.jsp" %>
        
        <!-- Product section-->
        <div class="container">
            <div class="row gx-4 gx-lg-5 align-items-center" style="margin-top: 5%;">
                <div class="col-md-6">
                <img class="card-img-top mb-5 mb-md-0" style="border-radius: 15px;"
                src="https://s.tannico.it/media/catalog/product/cache/1/thumbnail/0dc2d03fe217f8c83829496872af24a0/a/u/aulenterosso.jpg" >
                </div>
                <div class="col-md-6" style="color: white; text-shadow: 2px 2px 3px rgba(51,51,51,0.7);">
                    <h1 class="display-5 fw-bolder"><%=prodotto.getNome() %></h1>
                    <div class="fs-5 mb-5">
                        <span class="text-decoration-line-through">&euro; <%=prodotto.getPrezzo() + 2.99 %></span>
                        <span>&euro; <%=prodotto.getPrezzo()+0.99 %></span>
                    </div>
                    <p class="lead">
                    	<ul style="list-style-type: none; padding-left: 0rem; margin-bottom: 2rem; font-size: 150%; border: 1px solid #cccccc; padding: 5%; border-radius: 15px;">
                            <li><b><i class="bi bi-geo-alt"></i> Regione: </b><%=prodotto.getRegione().getNome() %></li>
                            <li><b><i class="bi bi-calendar"></i> Annata: </b><%=prodotto.getAnnata() %></li>
                            <li><b><i class="bi bi-tag"></i> Categoria: </b><%=prodotto.getCategoria() %></li>
                            <li><b><i class="bi bi-trophy"></i> Vitigno: </b><%=prodotto.getVitigno() %></li>
                            <li><b><i class="bi bi-aspect-ratio"></i> Formato: </b><%=prodotto.getFormato() %></li>
                            <li><b><i class="bi bi-percent"></i> Gradazione: </b><%=prodotto.getGradazione() %></li>
                        </ul>
                    </p>
                    <div class="d-flex">
                        <input class="form-control text-center me-3" id="inputQuantity" type="number" value="1" style="width: 5rem" />
                        <button class="btn btn-outline-light flex-shrink-0" type="button">
                            <i class="bi-cart-fill me-1"></i>
                            Aggiungi al carrello
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Related items section-->
        <%  List<Prodotto> prodottiPerRegione = prodotto.getRegione().getVini(); %>
        <div class="container px-4 px-lg-5 mt-5">
            <h2 class="fw-bolder mb-4" style="color: white; text-shadow: 2px 2px 3px rgba(51,51,51,0.7);">Altri vini simili</h2>
            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            	<% for(int i = 0; i < prodottiPerRegione.size(); i++ ){
            		if(!prodottiPerRegione.get(i).equals(null) && i < 4){ %>      	
                <div class="col mb-5">
                	<!-- Primo prodotto-->
                    <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top" src="https://s.tannico.it/media/catalog/product/cache/1/thumbnail/0dc2d03fe217f8c83829496872af24a0/a/u/aulenterosso.jpg " alt="..." />
                        <!-- Product details-->
                        <div class="card-body">
                            <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder"><%=prodottiPerRegione.get(i).getNome() %></h5>
                                <!-- Product price-->
                                &euro;<%=prodottiPerRegione.get(i).getPrezzo() + 0.99 %>
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="ProdottiServlet?prodottoID=<%=prodottiPerRegione.get(i).getId() %>">Vino!</a></div>
                        </div>
                    </div>
                 </div>
                 <%}
           		}%>
            </div>
        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="script.js"></script>
        <%@include file="../HeadFoot/footer.jsp" %>
    </body>
</html>
