package com.webcatalog.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webcatalog.ejb.gestionCommandeBeanRemote;
import com.webcatalog.entities.Panier;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    @EJB
    private gestionCommandeBeanRemote commandeBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get cart from session
        Panier panier = (Panier) request.getSession().getAttribute("panier");
        
        // Check if user is logged in
        boolean isLoggedIn = request.getUserPrincipal() != null; // or check session attribute
        
        if (isLoggedIn) {
            // Convert cart to order and persist
            if (panier != null) {
                commandeBean.createAndPersistOrder(panier, request.getUserPrincipal().getName());
            }
            
            // Redirect to order confirmation page
            response.sendRedirect("confirmation.jsp");
        } else {
            // Redirect to login page with a message
            response.sendRedirect("login.jsp?next=confirmation.jsp&message=Please log in to confirm your order");
        }
    }
}
