<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container my-4">
    <h2 class="text-center">Votre panier</h2>

    <c:if test="${not empty sessionScope.panier.articles}">
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Article</th>
                    <th>Quantité</th>
                    <th>Prix unitaire</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="entry" items="${sessionScope.panier.detailsProduits}">
                    <tr>
                        <td>${entry.value.nom}</td>
                        <td>${sessionScope.panier.articles[entry.key]}</td>
                        <td>${entry.value.prix}</td>
                        <td>${panier.getTotalPrice(entry.key)}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty sessionScope.panier.articles}">
        <p>Votre panier est vide.</p>
    </c:if>

    <form action="CommandeServlet" method="post" class="text-center my-3">
        <input type="submit" class="btn btn-primary" value="Valider la commande">
    </form>
</div>
