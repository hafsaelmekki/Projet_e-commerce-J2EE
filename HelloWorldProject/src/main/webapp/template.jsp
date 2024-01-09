<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Ma Boutique Vintage</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57P+QmMa+zafJ0pBVIK9PCp8TiVUJjz8dpTZNaglDpIkL6N" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    
</head>
<body>
    <div id="banner">
        <h1>Ma Boutique</h1> <!-- Remplacez par votre logo si nécessaire -->
    </div>
    <div id="menu">
        <a href="index.jsp">Accueil</a>
        <a href="${pageContext.request.contextPath}/CatalogueServlet?action=voirCategories">Catalogues</a>
        <a href="panier.jsp">Votre Panier</a>
    </div>
    <div id="content">
   		 <jsp:include page="${pageContent}" />
	</div>
    <div id="footer">
        <p>&copy; 2024 Ma Boutique Vintage</p>
    </div>
</body>
</html>
