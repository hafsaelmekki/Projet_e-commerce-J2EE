package com.webcatalog.servlets;
import java.sql.Timestamp;


import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.webcatalog.ejb.gestionCommandeBeanRemote;
import com.webcatalog.entities.Client;
import com.webcatalog.entities.CommandeClient;
import com.webcatalog.entities.Panier;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    @EJB
    private gestionCommandeBeanRemote commandeBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer le panier de la session
        Panier panier = (Panier) request.getSession().getAttribute("panier");
        
        // Récupérer le client de la session
        Client client = (Client) request.getSession().getAttribute("client");
        if (client != null && panier != null) {
            // Convertir le panier en commande et le persister
            commandeBean.createAndPersistOrder(panier, client.getEmail());
            CommandeClient commandeCree = commandeBean.createAndPersistOrder(panier, client.getEmail());
            
         // Ajouter des détails de la commande aux attributs de la requête
            request.setAttribute("orderNumber", commandeCree.getId());
            request.setAttribute("orderDate", commandeCree.getDateCreation());
            request.setAttribute("totalAmount", commandeCree.getMontant());

         // Vider le panier après avoir passé la commande
            panier.getArticles().clear(); // Efface les articles du panier
            request.getSession().setAttribute("panier", panier); // Met à jour le panier dans la session
            // Redirection vers la page de confirmation de commande
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);
        } else {
            // Redirection vers la page de connexion avec un message
            response.sendRedirect("login.jsp?next=confirmation.jsp&message=Please log in to confirm your order");
        }
    }
}


