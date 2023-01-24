<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="test.entities.Indirizzo"%>
<%@ page import="test.entities.Utente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Area Personale</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet" href="personale/styleareapersonale.css"> <!-- CONTROLLARE !!!!!!!!!!!!!!!! -->
</head>
<body>
	<% Utente utente = (Utente)request.getAttribute("utente"); 
	Indirizzo indirizzo = (Indirizzo)request.getAttribute("indirizzo");%>
	<!-- qui inizia la finestra dell'area personale -->
	<div class="finestrona"
	    style="display: flex; align-items: center; justify-content: center; width: 100vw; height: 100vh;">
	    <div class="profile-container">
	        <!-- parte in alto -->
	        <div class="container text-center">
	            <div class="row justify-content-md-center">
	                <div class="col-sm-8">
	                    <h1 style="margin-top: 10px; margin-bottom: 10px; margin-left: 20px; text-align: start;">Area
	                        Personale </h1>
	                </div>
	                <div class="col-sm-2">
	                    <img src="personale/modifica.png" style="width: 70px; ">
	                </div>
	            </div>
	        </div>
	        <h5 style="text-align: start; margin-left: 18%;">Dati Utente</h5>
	        <div style="display: flex; justify-content: center; align-items: center;">
	            <div class="table">
	                <!-- tabella anagrafica-->
	                <table class="table">
	                    <tbody class="table-group-divider">
	                        <tr class="spaceUnder">
	                            <td>Email</td>
	                            <td><%=utente.getEmail()%></td>
	                        </tr>
	                        <tr class="spaceUnder">
	                            <td>Username</td>
	                            <td><%=utente.getUsername()%></td>
	                        </tr>
	                        <tr class="spaceUnder">
	                            <td>Nome</td>
	                            <td><%=utente.getNome()%></td>
	                        </tr>
	                        <tr class="spaceUnder">
	                            <td>Cognome</td>
	                            <td><%=utente.getCognome()%></td>
	                        </tr>
	                        <tr class="spaceUnder">
	                            <td>Codice Fiscale</td>
	                            <td><%=utente.getCf()%></td>
	                        </tr>
	                        <tr class="spaceUnder">
	                            <td>Data di nascita</td>
	                            <td><%=utente.getNascita().toString()%></td>
	                        </tr>
	                        <tr class="spaceUnder">
	                            <td>Telefono</td>
	                            <td><%=utente.getTelefono()%></td>
	                        </tr>
	                    </tbody>
	                </table>
	                <h5 style="text-align: start; margin-left: 18%;">Dati Spedizione</h5>
	                <div class="table">
	                    <!-- tabella indirizzo-->
	                    <table class="table">
	                        <tbody class="table-group-divider">
	                            <tr class="spaceUnder">
	                                <td>Via</td>
	                                <td><%=indirizzo.getVia()%></td>
	                            </tr>
	                            <tr class="spaceUnder">
	                                <td>Civico</td>
	                                <td><%=indirizzo.getCivico()%></td>
	                            </tr>
	                            <tr class="spaceUnder">
	                                <td>Cap</td>
	                                <td><%=indirizzo.getCap()%></td>
	                            </tr>
	                            <tr class="spaceUnder">
	                                <td>Città</td>
	                                <td><%=indirizzo.getCitta()%></td>
	                            </tr>
	                            <tr class="spaceUnder">
	                                <td>Provincia</td>
	                                <td><%=indirizzo.getProvincia()%></td>
	                            </tr>
	                            <tr class="spaceUnder">
	                                <td>Paese</td>
	                                <td><%=indirizzo.getPaese()%></td>
	                            </tr>
	                        </tbody>
	                    </table>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- questo div chiude finestrona -->
</body>
</html>