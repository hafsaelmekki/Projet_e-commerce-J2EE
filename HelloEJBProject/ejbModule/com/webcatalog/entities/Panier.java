package com.webcatalog.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {
	
	private static final long serialVersionUID = 1L;
    private Map<Integer, Integer> articles; // Key is product ID, value is quantity
    private Map<Integer, Produit> detailsProduits; // Key is product ID, value is the Product object

    public Panier() {
        articles = new HashMap<>();
        detailsProduits = new HashMap<>();
    }

    public void ajouterArticle(Produit produit, int quantite) {
        int produitId = produit.getId();
        articles.merge(produitId, quantite, Integer::sum);
        if (!detailsProduits.containsKey(produitId)) {
            detailsProduits.put(produitId, produit);
        }
    }

    public void retirerArticle(int produitId) {
        articles.remove(produitId);
        detailsProduits.remove(produitId);
    }

    public Map<Integer, Integer> getArticles() {
        return articles;
    }

    public Map<Integer, Produit> getDetailsProduits() {
        return detailsProduits;
    }
    public BigDecimal getTotalPrice(int produitId) {
        if (articles.containsKey(produitId)) {
            // Assume detailsProduits is a map where you store the details of each product
            Produit produit = detailsProduits.get(produitId);
            BigDecimal price = produit.getPrix();
            int quantity = articles.get(produitId);
            return price.multiply(new BigDecimal(quantity));
        }
        return BigDecimal.ZERO;
    }


    // Add other necessary methods, like calculating the total price, etc.
}
