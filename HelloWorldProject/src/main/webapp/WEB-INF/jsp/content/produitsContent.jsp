<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Produits de la catégorie sélectionnée</h2>
<div class="products-list">
<c:forEach items="${produits}" var="produit">
    <div class="product">
        <h3>${produit.nom}</h3>
        <p>${produit.description}</p>
        <p>Prix: ${produit.prix}€</p>
        
    <form action="PanierServlet" method="post">
    <input type="hidden" name="action" value="ajouterAuPanier" />
    <input type="hidden" name="produitId" value="${produit.id}" />
    <input type="hidden" name="quantite" value="1" />
    <input type="submit" value="Ajouter au panier" />
</form>

    </div>
</c:forEach>

</div>
