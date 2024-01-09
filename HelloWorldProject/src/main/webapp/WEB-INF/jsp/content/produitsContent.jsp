<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mt-4">
    <h2 class="text-center mb-4">Produits de la catégorie sélectionnée</h2>
    <div class="row">
        <c:forEach items="${produits}" var="produit">
            <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                <div class="card h-100">
                    <div class="card-body">
                        <h3 class="card-title">${produit.nom}</h3>
                        <p class="card-text">${produit.description}</p>
                        <p class="card-text">Prix: ${produit.prix}€</p>
                        <form action="PanierServlet" method="post" class="mt-3">
                            <input type="hidden" name="action" value="ajouterAuPanier" />
                            <input type="hidden" name="produitId" value="${produit.id}" />
                            <input type="hidden" name="quantite" value="1" />
                            <input type="submit" class="btn btn-primary" value="Ajouter au panier" />
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
