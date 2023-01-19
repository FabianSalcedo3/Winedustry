<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Regione"%>
<%@ page import="entities.Prodotto"%>
<%@ page import="java.util.List"%>
<%
Regione regione = (Regione) request.getAttribute("regione");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="styleregione.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title><%=regione.getNome()%></title>
</head>
<body>
<div>
    <div class="home-container">
      <header data-role="Header" class="home-header">
        <h1 class="home-text">Winedustry</h1>
        <div class="home-icon-group">
          <div data-role="BurgerMenu" class="home-burger-menu">
            <svg viewBox="0 0 1024 1024" class="home-icon">
              <path
                d="M128 554.667h768c23.552 0 42.667-19.115 42.667-42.667s-19.115-42.667-42.667-42.667h-768c-23.552 0-42.667 19.115-42.667 42.667s19.115 42.667 42.667 42.667zM128 298.667h768c23.552 0 42.667-19.115 42.667-42.667s-19.115-42.667-42.667-42.667h-768c-23.552 0-42.667 19.115-42.667 42.667s19.115 42.667 42.667 42.667zM128 810.667h768c23.552 0 42.667-19.115 42.667-42.667s-19.115-42.667-42.667-42.667h-768c-23.552 0-42.667 19.115-42.667 42.667s19.115 42.667 42.667 42.667z"
              ></path>
            </svg>
          </div>
          
        </div>
        <div data-role="MobileMenu" class="home-mobile-menu">
          <nav class="home-nav">
            <div class="home-container1">
              <img
                alt="image"
                src="https://presentation-website-assets.teleporthq.io/logos/logo.png"
                class="home-image"
              />
              <div data-role="CloseMobileMenu" class="home-close-mobile-menu">
                <svg viewBox="0 0 1024 1024" class="home-icon08">
                  <path
                    d="M810 274l-238 238 238 238-60 60-238-238-238 238-60-60 238-238-238-238 60-60 238 238 238-238z"
                  ></path>
                </svg>
              </div>
            </div>
            <nav class="navigation-links-nav navigation-links-root-class-name13">
              <span class="navigation-links-text"><span>About</span></span>
              <span class="navigation-links-text1"><span>Features</span></span>
              <span class="navigation-links-text2"><span>Pricing</span></span>
              <span class="navigation-links-text3"><span>Team</span></span>
              <span class="navigation-links-text4"><span>Blog</span></span>
            </nav>
          </nav>
          <div>
          
          </div>
        </div>
      </header>
      <div class="home-container2">
        <div class="home-container-immagine">
          <img
            src="<%=regione.getImmagine()%>"
            alt="image"
            class="home-image1"
          />
        </div>
        <div class="home-container-testo">
          <div class="home-container-nome-regione">
            <svg viewBox="0 0 1024 1024" class="home-icon16">
              <path
                d="M512 0c-176.732 0-320 143.268-320 320 0 320 320 704 320 704s320-384 320-704c0-176.732-143.27-320-320-320zM512 512c-106.040 0-192-85.96-192-192s85.96-192 192-192 192 85.96 192 192-85.96 192-192 192z"
              ></path>
            </svg>
            <h2 class="home-text01"><%=regione.getNome()%></h2>
          </div>
          <span class="home-text02">
            <span>
				<%=regione.getDescrizione()%>
            </span>
          </span>
        </div>
        <div class="home-container-vini">
          <div class="home-container-titolo-vini">
            <svg viewBox="0 0 1024 1024" class="home-icon18">
              <path
                d="M777.784 16.856c-5.576-10.38-16.406-16.856-28.19-16.856h-475.188c-11.784 0-22.614 6.476-28.19 16.856-35.468 66.020-54.216 143.184-54.216 223.144 0 105.412 32.372 204.828 91.154 279.938 45.428 58.046 102.48 96.54 164.846 112.172v327.89h-96c-17.672 0-32 14.326-32 32s14.328 32 32 32h320c17.674 0 32-14.326 32-32s-14.326-32-32-32h-96v-327.89c62.368-15.632 119.418-54.124 164.846-112.172 58.782-75.11 91.154-174.526 91.154-279.938 0-79.96-18.748-157.122-54.216-223.144zM294.1 64h435.8c24.974 52.902 38.1 113.338 38.1 176 0 5.364-0.108 10.696-0.296 16h-511.406c-0.19-5.304-0.296-10.636-0.296-16-0.002-62.664 13.126-123.098 38.098-176z"
              ></path>
            </svg>
            <h2 class="home-text08">Vini</h2>
          </div>
          <div class="card" style="width: 18rem;">
  			<img src="..." class="card-img-top" alt="...">
  			<div class="card-body">
   			<h5 class="card-title">Card title</h5>
  			<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    		<a href="ProdottiServlet?prodottoID=2" class="btn btn-primary">Vino!</a>
  		</div>
		</div>
        </div>
      </div>
      <footer class="home-footer">
        <span class="home-text09">Winedustry</span>
        <span class="home-text10">© 2023 Winedustry, All Rights Reserved.</span>
        <div class="home-icon-group2">
        </div>
      </footer>
    </div>
  </div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>