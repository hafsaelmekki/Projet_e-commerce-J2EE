package com.webcatalog.ejb;

import com.webcatalog.entities.Client;
import com.webcatalog.entities.CommandeClient;
import com.webcatalog.entities.Produit;
import com.webcatalog.entities.ProduitCommande;
import com.webcatalog.entities.Panier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class gestionCommandeBean implements gestionCommandeBeanRemote {

    @PersistenceContext(unitName = "managerBoutique")
    private EntityManager em;

    public CommandeClient createAndPersistOrder(Panier panier, String email) {
        // Récupérer le client en utilisant l'email
        Client client = em.createQuery("SELECT c FROM Client c WHERE c.email = :email", Client.class)
                          .setParameter("email", email)
                          .getSingleResult();

        // Calculer le montant total pour la commande
        BigDecimal totalAmount = calculateTotalAmount(panier);

        // Créer une nouvelle entité CommandeClient
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setClient(client);
        commandeClient.setDateCreation(new Timestamp(System.currentTimeMillis()));
        commandeClient.setMontant(totalAmount);
        commandeClient.setNoConfirmation(generateConfirmationNumber()); // Implémentez cette méthode selon vos besoins

        em.persist(commandeClient);

        // Créer et persister les entités ProduitCommande pour chaque produit dans le panier
        for (Map.Entry<Integer, Integer> entry : panier.getArticles().entrySet()) {
            Produit produit = em.find(Produit.class, entry.getKey());
            ProduitCommande produitCommande = new ProduitCommande();
            produitCommande.setCommandeClient(commandeClient);
            produitCommande.setProduit(produit);
            produitCommande.setQuantite(entry.getValue());

            em.persist(produitCommande);
        }

        return commandeClient;
    }

    private BigDecimal calculateTotalAmount(Panier panier) {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Integer, Integer> entry : panier.getArticles().entrySet()) {
            Produit produit = em.find(Produit.class, entry.getKey());
            BigDecimal price = produit.getPrix();
            int quantity = entry.getValue();
            total = total.add(price.multiply(new BigDecimal(quantity)));
        }
        return total;
    }

    private int generateConfirmationNumber() {
        // Générer un numéro de confirmation pour la commande
        // Ceci est une implémentation provisoire, vous devrez remplacer cela par une logique réelle
        return (int) (Math.random() * 1000000);
    }


}
