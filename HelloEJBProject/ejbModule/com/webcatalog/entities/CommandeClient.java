package com.webcatalog.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Commande_Client")
public class CommandeClient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "montant", nullable = false)
    private BigDecimal montant;

    @Column(name = "date_creation")
    private Timestamp dateCreation;

    @Column(name = "no_confirmation")
    private int noConfirmation;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "commandeClient")
    private List<ProduitCommande> produitCommandes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Timestamp getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}

	public int getNoConfirmation() {
		return noConfirmation;
	}

	public void setNoConfirmation(int noConfirmation) {
		this.noConfirmation = noConfirmation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ProduitCommande> getProduitCommandes() {
		return produitCommandes;
	}

	public void setProduitCommandes(List<ProduitCommande> produitCommandes) {
		this.produitCommandes = produitCommandes;
	}

    // Getters et setters
    // ...
    
}
