<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Regione" %>
<%@ page import="entities.Prodotto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	<% //Regione regione = (Regione) request.getAttribute("regione"); 
// 	   out.println(regione.getDescrizione());
// 	   regione.getVini().forEach(vino -> out.println(vino.getVitigno()));
// 	   for(Prodotto prodotto : regione.getVini()){
// 		   out.println(prodotto.getVitigno());
// 	   }
	   
	   List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("prodotti");
	   for(Prodotto prodotto : prodotti){
		   out.print(prodotto.getCategoria());
	   }
	%>
	
	</body>
</html>