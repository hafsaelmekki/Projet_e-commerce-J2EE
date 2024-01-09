package com.webcatalog.servlets;

import com.webcatalog.ejb.accesCatalogueBeanRemote;
import com.webcatalog.entities.Panier;
import com.webcatalog.entities.Produit;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PanierServlet")
public class PanierServlet extends HttpServlet {

    @EJB
    private accesCatalogueBeanRemote catalogueBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Panier panier = (Panier) request.getSession().getAttribute("panier");
        if (panier == null) {
            panier = new Panier();
            request.getSession().setAttribute("panier", panier);
        }

        String action = request.getParameter("action");
        if ("ajouterAuPanier".equals(action)) {
            int produitId = Integer.parseInt(request.getParameter("produitId"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));

            Produit produit = catalogueBean.getProduitById(produitId);
            if (produit != null) {
                panier.ajouterArticle(produit, quantite);
            }

            response.sendRedirect("panier.jsp");
        }

    }

    // Vous pouvez ajouter d'autres méthodes (comme doGet) si nécessaire
}
