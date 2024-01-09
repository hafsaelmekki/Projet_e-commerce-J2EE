<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webcatalog.entities.Categorie" %>

<div class="container_cat">
    <h2 class="text-center my-4">Sélectionnez une catégorie de produits</h2>
    <div id="categories-list" class="row">
        <%
            List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
            if (categories != null) {
                for (Categorie categorie : categories) {
                    out.println("<div class='col-md-4 mb-3'><div class='card'><div class='card-body text-center'><a href='" + request.getContextPath() + "/CatalogueServlet?action=voirProduits&id=" + categorie.getId() + "' class='card-link'>" + categorie.getNom() + "</a></div></div></div>");
                }
            }
        %>
    </div>
</div>
