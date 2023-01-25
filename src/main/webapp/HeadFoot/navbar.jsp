<link href="<%=request.getContextPath()%>/HeadFoot/style.css" rel="stylesheet">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css'>
<nav class="navbar navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" style="flex-grow: 1; align-self: center; margin-right: 0px;" href="<%=request.getContextPath()%>">
                <h2 class="titolo">Winedustry</h2>
            </a>
            <div class="cerca">
                <form action="<%=request.getContextPath()%>/RicercaProdottiServlet" class="search" method="post">
                    <input class="search__input" type="search" placeholder="Cerca vino!" id="searchInput" name="pValue">
                    <div class="search__icon-container">
                        <label for="searchInput" class="search__label" aria-label="Search">
                            <svg viewBox="0 0 1000 1000" title="Search" class="icona-cerca">
                                <path fill="currentColor"
                                    d="M408 745a337 337 0 1 0 0-674 337 337 0 0 0 0 674zm239-19a396 396 0 0 1-239 80 398 398 0 1 1 319-159l247 248a56 56 0 0 1 0 79 56 56 0 0 1-79 0L647 726z" />
                            </svg>
                        </label>
                        <button class="search__submit navbar-toggler" aria-label="Search">
                            <svg viewBox="0 0 1000 1000" title="Search">
                                <path fill="currentColor"
                                    d="M408 745a337 337 0 1 0 0-674 337 337 0 0 0 0 674zm239-19a396 396 0 0 1-239 80 398 398 0 1 1 319-159l247 248a56 56 0 0 1 0 79 56 56 0 0 1-79 0L647 726z" />
                            </svg>
                        </button>
                    </div>
                </form>
            </div>
            <div class="area-user">
                <span data-tooltip="Entra nella tua area personale!" data-flow="left">
                <a href="<%=request.getContextPath()%>/UtentiServlet">
                    	<img src="<%=request.getContextPath()%>/HeadFoot/iconauser.png" class="icona-user" style="width: 35px;">
                    </a>
                </span>
            </div>
            <div class="menu">
                <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas"
                    data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar"
                    style="border: 0px; padding: 0px;">
                    <img src="<%=request.getContextPath()%>/HeadFoot/menu.png" style="width: 40px; height: 40px;" class="icona-menu">
                </button>
            </div>
            <!-- menu a tendina -->
            <div class="offcanvas offcanvas-end text-bg-dark questa-sidebar" tabindex="-1" id="offcanvasDarkNavbar"
                aria-labelledby="offcanvasDarkNavbarLabel" style="background-color: #2a2a2a !important;">
                <div class="offcanvas-header">
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas"
                        aria-label="Close">
                    </button>
                </div>
                <div class="offcanvas-body">
                    <ul class="navbar-nav justify-content-end flex-grow-1 pe-3" style="text-align: center;">
                        <li class="nav-item">
                            <a class="link" aria-current="page" href="<%=request.getContextPath()%>/home/home.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                        	<form action="<%=request.getContextPath()%>/ProdottiServlet" method="post">
                            	<button class="link" type="submit">Vini!</button>
                            </form>
                        </li>
                        <li class="nav-item">
                            <a class="link" href="<%=request.getContextPath()%>/CarrelliServlet">Carrello</a>
                        </li>
                        <li class="nav-item">
                            <a class="link" href="<%=request.getContextPath()%>/contattaci/contattaci.html">Contattaci</a>
                        </li>
                        <li>
                            <hr style="color: #b7ac7f; height: 3px;">
                        </li>
                        <li>
                            <span class="nav-link navbar-nav justify-content-end flex-grow-1 pe-3">
                                "Nel mezzo d'una damigian di nostra vigna, mi ritrovai in
                                una botte oscura, che di buon vin era riempita"<cite style="color: #ebebeb; font-size: 0.9rem;">Dante Alighieri</cite></span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>