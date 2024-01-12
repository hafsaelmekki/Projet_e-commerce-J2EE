package com.webcatalog.servlets;

import com.webcatalog.ejb.GestionUtilisateurBeanRemote;
import com.webcatalog.entities.Client;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @EJB
    private GestionUtilisateurBeanRemote gestionUtilisateurBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("password");

        Client client = gestionUtilisateurBean.verifierIdentifiants(email, motDePasse);

        if (client != null) {
            request.getSession().setAttribute("client", client);
            response.sendRedirect("index.jsp"); // Rediriger vers la page d'accueil 
        } else {
            request.setAttribute("erreur", "Email ou mot de passe incorrect");
            request.getRequestDispatcher("login.jsp").forward(request, response); // Rester sur la page de connexion
        }
    }
}
