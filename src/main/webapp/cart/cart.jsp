<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<%@ page import="entities.Regione"%>
<%@ page import="entities.Prodotto"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<html>

<head>
    <title>Carrello Winedustry</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link href=" https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="cart/cart.css">
</head>

<body>
	<% List<Prodotto> listaProdotti = (List<Prodotto>)request.getAttribute("listaProdotti");
	String img = "https://www.signorvino.com/dw/image/v2/BCXQ_PRD/on/demandware.static/-/Sites-SGV_EC_COM/default/dwb374350e/images/VFR021102021-F.png?sw=500";
	int totale = 0;%>
    <main class="page">
        <section class="shopping-cart dark">
            <div class="container">
                <div class="block-heading">
                    <h2>Carrello</h2>
                    <p>Ecco un riepilogo degli articolo che hai inserito nel tuo carrello</p>
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col-md-12 col-lg-8">
                            <div class="items">
                            	<%for(Prodotto prodotto : listaProdotti){ 
                            		totale+=prodotto.getPrezzo(); %>
                            		<div class="product">
                                    <div class="row">
                                        <div class="col-md-3">
                                            <img class="img-fluid mx-auto d-block image"
                                                src="<%=prodotto.getImmagine()%>">
	                                        </div>
	                                        <div class="col-md-8">
	                                            <div class="info">
	                                                <div class="row">
	                                                    <div class="col-md-5 product-name">
	                                                        <div class="product-name">
	                                                            <a href="#"><%=prodotto.getNome()%></a>
<!-- 	                                                            <div class="product-info"> -->
<%-- 	                                                                <div>Uva: <span class="value"><%=prod.getUva()%></span></div> --%>
<%-- 	                                                                <div>Gradi: <span class="value"><%=prod.getGradi()%></span></div> --%>
<%-- 	                                                                <div>Sapore: <span class="value"><%=prod.getSapore()%></span></div> --%>
<!-- 	                                                            </div> -->
	                                                        </div>
	                                                    </div>
	                                                    <div class="col-md-4 quantity">
	                                                        <label for="quantity">Quantità:</label>
	                                                        <input id="quantity" type="number" value="1"
	                                                            class="form-control quantity-input">
	                                                    </div>
	                                                    <div class="col-md-3 price">
	                                                        <span>&euro; <%=prod.getPrezzo()%></span>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
                            	<%} %>                                                             
                            </div>
                        </div>
                        <div class="col-md-12 col-lg-4">
                            <div class="summary">
                            	<div>
	                                <h3>Riepilogo</h3>
	                                <div class="summary-item linea">
	                                    <span class="text">Prodotti</span>
	                                    <span class="price">&euro; <%=totale %></span>
	                                </div>
	                                <div class="summary-item linea">
	                                    <span class="text">Spedizione</span>
	                                    <span class="price">&euro; 5</span>
	                                </div>
	                                <div class="summary-item">
	                                    <span class="text">Totale</span>
	                                    <span class="price">&euro; <%=totale+5%></span>
	                                </div>
	                                <button type="button" class="btn btn-primary btn-lg btn-block">Checkout</button>
	                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>

</html>