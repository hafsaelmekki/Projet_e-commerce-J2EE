package com.webcatalog.ejb;

import com.webcatalog.entities.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class GestionUtilisateurBean implements GestionUtilisateurBeanRemote {

    @PersistenceContext(unitName = "managerBoutique")
    private EntityManager em;

    public Client verifierIdentifiants(String email, String motDePasse) {
        TypedQuery<Client> query = em.createQuery(
            "SELECT c FROM Client c WHERE c.email = :email AND c.motDePasse = :motDePasse", Client.class);
        query.setParameter("email", email);
        query.setParameter("motDePasse", motDePasse);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            // Gestion des exceptions, par exemple, aucun résultat correspondant ou plus d'un résultat
            return null;
        }
    }

    // Autres méthodes de gestion des utilisateurs
}
