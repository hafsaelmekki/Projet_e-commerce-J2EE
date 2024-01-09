package com.webcatalog.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom", nullable = false, length = 45)
    private String nom;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "telephone", length = 15)
    private String telephone;

    @Column(name = "adresse", length = 250)
    private String adresse;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<CommandeClient> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<CommandeClient> commandes) {
		this.commandes = commandes;
	}

    // Getters et setters
    // ...
    
}
