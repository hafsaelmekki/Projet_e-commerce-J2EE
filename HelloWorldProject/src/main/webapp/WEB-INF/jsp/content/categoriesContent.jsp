<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webcatalog.entities.Categorie" %>

<h2>Sélectionnez une catégorie de produits</h2>
<div id="categories-list">
    <%
        List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
        if (categories != null) {
            for (Categorie categorie : categories) {
                out.println("<div class='category'><a href='" + request.getContextPath() + "/CatalogueServlet?action=voirProduits&id=" + categorie.getId() + "'>" + categorie.getNom() + "</a></div>");
            }
        }
    %>
</div>
