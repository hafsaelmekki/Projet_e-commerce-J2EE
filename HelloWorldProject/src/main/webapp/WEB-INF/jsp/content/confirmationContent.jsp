<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container my-4">
    <h2 class="text-center">Confirmation de Commande</h2>
    <p>Merci pour votre commande !</p>
    <p>Numéro de commande : ${requestScope.orderNumber}</p>
    <p>Date de la commande : ${requestScope.orderDate}</p>
    <p>Montant total : ${requestScope.totalAmount}€</p>
    <a href="index.jsp" class="btn btn-primary">Retour à l'accueil</a>
</div>
