<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
        <link href="styles.css" rel="stylesheet" />
    </head>
    <body>
    	<% Prodotto prodotto = (Prodotto) request.getAttribute("prodotto"); %>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">Winedustry</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="https://s.tannico.it/media/catalog/product/cache/1/thumbnail/0dc2d03fe217f8c83829496872af24a0/a/u/aulenterosso.jpg" ></div>
                    <div class="col-md-6">
                        <h1 class="display-5 fw-bolder">Rubicone Rosso IGT "Aulente rosso" 2020 - San Patrignano</h1>
                        <div class="fs-5 mb-5">
                            <span class="text-decoration-line-through">&euro;11,90</span>
                            <span>&euro;8,90</span>
                        </div>
                        <p class="lead">
                        	<ul style="list-style-type: none; padding-left: 0rem; margin-bottom: 2rem;">
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
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Aggiungi al carrello
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Related items section-->
        <%  List<Prodotto> prodottiPerRegione = prodotto.getRegione().getVini(); %>
        <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
                <h2 class="fw-bolder mb-4">Altri vini simili</h2>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <div class="col mb-5">
                    	<!-- Primo prodotto-->
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://s.tannico.it/media/catalog/product/cache/1/thumbnail/0dc2d03fe217f8c83829496872af24a0/a/u/aulenterosso.jpg " alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><%=prodottiPerRegione.get(1).getVitigno() %></h5>
                                    <!-- Product price-->
                                    $40.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="ProdottiServlet?prodottoID=<%=prodottiPerRegione.get(1).getId() %>">Vino!</a></div>
                            </div>
                        </div>
                     </div>
                     <div class="col mb-5"> 
                        <!-- Secondo prodotto-->
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://s.tannico.it/media/catalog/product/cache/1/thumbnail/0dc2d03fe217f8c83829496872af24a0/a/u/aulenterosso.jpg " alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><%=prodottiPerRegione.get(2).getVitigno() %></h5>
                                    <!-- Product price-->
                                    $40.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="ProdottiServlet?prodottoID=<%=prodottiPerRegione.get(2).getId() %>">Vino!</a></div>
                            </div>
                        </div>
                     </div>
                     <div class="col mb-5">  
                        <!-- Terzo prodotto-->
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://s.tannico.it/media/catalog/product/cache/1/thumbnail/0dc2d03fe217f8c83829496872af24a0/a/u/aulenterosso.jpg " alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><%=prodottiPerRegione.get(3).getVitigno() %></h5>
                                    <!-- Product price-->
                                    $40.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="ProdottiServlet?prodottoID=<%=prodottiPerRegione.get(3).getId() %>">Vino!</a></div>
                            </div>
                        </div>
                     </div>
                     <div class="col mb-5">   
                        <!-- Quarto prodotto-->
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://s.tannico.it/media/catalog/product/cache/1/thumbnail/0dc2d03fe217f8c83829496872af24a0/a/u/aulenterosso.jpg " alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><%=prodottiPerRegione.get(4).getVitigno() %></h5>
                                    <!-- Product price-->
                                    $40.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="ProdottiServlet?prodottoID=<%=prodottiPerRegione.get(4).getId() %>">Vino!</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="script.js"></script>
    </body>
</html>
