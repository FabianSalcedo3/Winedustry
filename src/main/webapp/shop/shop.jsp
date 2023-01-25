<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Regione"%>
<%@ page import="entities.prodotto.Prodotto"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Commerce Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<!--     <link rel="stylesheet" href="shopStyle.css"> -->
</head>
<!-- background-image: linear-gradient(180deg, rgba(70, 69, 69, 0.5) 0%, rgba(51, 50, 50, 0.5) 100%), url('https://upload.wikimedia.org/wikipedia/commons/6/65/Wine_cellar.jpg'); background-size: cover; background-position: left; background-attachment: fixed; background-repeat: no-repeat; -->
<body style="background-color: #2a2a2a;">
	<% List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("prodotti"); %>
    <%@ include file="../HeadFoot/navbar.jsp" %>
    <!-- posizionamento pulsante Ordina per -->
    <div class="container d-flex mt-5 mb-5 justify-content-end mw-100">
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                aria-expanded="false">
                Ordina per
            </button>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Prezzo crescente</a></li>
                <li><a class="dropdown-item" href="#">Prezzo decrescente</a></li>
            </ul>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <!-- filtri -->
            <div class="col-md-3">
                <div class="card" style="margin-left: 20px; box-shadow: rgba(204, 204, 204, 0.35) 0px 5px 15px;">
                    <div class="card-body">
                        <h5 class="card-title text-center">Filtra</h5>
                        <form>
                            <div class="form-group mb-3">
                                <b>Categoria</b>
                                <div class="my-1">
                                    <input type="checkbox" id="rossi">
                                    <label for="rossi" class="tick">Rossi
                                    </label>
                                </div>
                                <div class="my-1">
                                    <input type="checkbox" id="bianchi">
                                    <label for="bianchi" class="tick">Bianchi
                                    </label>
                                </div>
                                <div class="my-1">
                                    <input type="checkbox" id="rosati">
                                    <label for="rosati" class="tick">Rosati
                                    </label>
                                </div>
                            </div>
                            <div class="form-group mb-3">
                                <b>Regione</b>
                                <div class="my-1">
                                    <input type="checkbox" id="sicilia">
                                    <label for="sicilia" class="tick">Sicilia
                                    </label>
                                </div>
                                <div class="my-1">
                                    <input type="checkbox" id="puglia">
                                    <label for="puglia" class="tick">Puglia
                                    </label>
                                </div>
                                <div class="my-1">
                                    <input type="checkbox" id="toscana">
                                    <label for="toscana" class="tick">Toscana
                                    </label>
                                </div>
                                <div class="my-1">
                                    <input type="checkbox" id="emilia-romagna">
                                    <label for="emilia-romagna" class="tick">Emilia-romagna
                                    </label>
                                </div>
                                <div class="my-1">
                                    <input type="checkbox" id="veneto">
                                    <label for="veneto" class="tick">Veneto
                                    </label>
                                </div>
                            </div>
                            <div class="form-group mb-3">
                                <b>Prezzo</b>
                                <div class="mt-1">
                                    <label for="prezzo-min">Min</label>
                                    <input type="number" class="form-floating form-control" id="prezzo-min" name="prezzo-min">
                                    <label for="prezzo-max">Max</label>
                                    <input type="number" id="prezzo-max" class="form-floating form-control" name="prezzo-max">
                                    
                                </div>
                            </div>
                            <div class="form-group mb-3">
                                <label for="category"><b>Formati</b></label>
                                <select class="form-control" id="category">
                                    <option>0.5L</option>
                                    <option>0.75L</option>
                                    <option>1L</option>
                                    <option>1.5L</option>
                                </select>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-outline-dark">Applica</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Prodotti -->
            <div class="col-md-9">
                <div class="row text-center">
                <% for(Prodotto prodotto : prodotti){ %>
                    <div class="col-md-4 mb-3">
                        <div class="card h-100 glass" style="display: flex; align-items: center; box-shadow: rgba(204, 204, 204, 0.35) 0px 5px 15px;">
                            <img src="<%=prodotto.getImmagine() %>"
                                style="width:50%;" class="card-img-top" alt="Product 1">
                            <div class="card-body border-top mt-2" style="width: 100%;">
                                <h5 class="card-title"><%=prodotto.getNome() %></h5>
                                <p class="card-text"><%=prodotto.getPrezzo() %></p>
                            </div>
                            <div class="card-footer border-top-0 bg-transparent">
                                <a href="ProdottiServlet?prodottoID=<%=prodotto.getId() %>" class="btn btn-outline-dark mb-2">Visualizza dettagli</a>
                            </div>
                        </div>
                    </div>
                    <% } %>
                    <!-- Additional Product cards can be added here -->
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>

</html>