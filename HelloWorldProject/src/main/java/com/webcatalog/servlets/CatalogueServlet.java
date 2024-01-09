package com.webcatalog.servlets;

import com.webcatalog.ejb.accesCatalogueBeanRemote;
import com.webcatalog.entities.Categorie;
import com.webcatalog.entities.Produit;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CatalogueServlet")
public class CatalogueServlet extends HttpServlet {

    @EJB
    private accesCatalogueBeanRemote catalogueBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");

        if ("voirCategories".equals(action)) {
            List<Categorie> categories = catalogueBean.getListCategories();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/categories.jsp").forward(request, response);
        } else if ("voirProduits".equals(action)) {
            String categoryId = request.getParameter("id");
            int id = Integer.parseInt(categoryId);
            List<Produit> produits = catalogueBean.getListProduits(id);
            request.setAttribute("produits", produits);
            request.getRequestDispatcher("/produits.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
