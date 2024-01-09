<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Votre panier</h2>

<c:if test="${not empty sessionScope.panier.articles}">
    <table>
      <tr>
        <th>Article</th>
        <th>Quantité</th>
        <th>Prix unitaire</th>
        <th>Total</th>
      </tr>
      <c:forEach var="entry" items="${sessionScope.panier.detailsProduits}">
    <tr>
        <td>${entry.value.nom}</td>
        <td>${sessionScope.panier.articles[entry.key]}</td>
        <td>${entry.value.prix}</td>
        <td>${panier.getTotalPrice(entry.key)}</td>
    </tr>
</c:forEach>

    </table>
</c:if>

<c:if test="${empty sessionScope.panier.articles}">
    <p>Votre panier est vide.</p>
</c:if>

<form action="CommandeServlet" method="post">
  <input type="submit" value="Valider la commande">
</form>
