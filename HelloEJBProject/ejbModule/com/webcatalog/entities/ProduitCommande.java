package com.webcatalog.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Produit_Commande")
public class ProduitCommande implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    @JoinColumn(name = "commande_client_id", referencedColumnName = "id")
    private CommandeClient commandeClient;

    @Id
    @ManyToOne
    @JoinColumn(name = "produit_id", referencedColumnName = "id")
    private Produit produit;

    @Column(name = "quantité", nullable = false)
    private int quantite;

	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

    // Getters et setters
    // ...
    
    
}
