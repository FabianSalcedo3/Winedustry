<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<%@ page import="entities.Regione"%>
<%@ page import="entities.prodotto.Prodotto"%>
<%@ page import="entities.ordine.Carrello"%>
<%@ page import="entities.ordine.CarrelloItem"%>
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
	<% Carrello carrello = (Carrello)request.getAttribute("carrello");
	List<CarrelloItem> listaProdotti = carrello.getCarrelloItems();
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
                            	<%for(CarrelloItem item : listaProdotti){ 
                            		totale+=(item.getProdotto().getPrezzo()*item.getQuantita()); %>
                            		<div class="product">
                                    <div class="row">
                                        <div class="col-md-3">
                                            <img class="img-fluid mx-auto d-block image"
                                                src="<%=item.getProdotto().getImmagine()%>">
	                                        </div>
	                                        <div class="col-md-8">
	                                            <div class="info">
	                                                <div class="row">
	                                                    <div class="col-md-5 product-name">
	                                                        <div class="product-name">
	                                                            <a href="#"><%=item.getProdotto().getNome()%></a>
	                                                        </div>
	                                                    </div>
	                                                    <div class="col-md-4 quantity">
	                                                        <label for="quantity">Quantità:</label>
	                                                        <input id="quantity" type="number" value="<%=item.getQuantita()%>"
	                                                            class="form-control quantity-input">
	                                                    </div>
	                                                    <div class="col-md-3 price">
	                                                        <span>&euro; <%=item.getProdotto().getPrezzo()*item.getQuantita()%></span>
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
	                                <form action="pagamento/pagamento.html">
	                                <button type="submit" class="btn btn-primary btn-lg btn-block">Checkout</button>
	                                </form>
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