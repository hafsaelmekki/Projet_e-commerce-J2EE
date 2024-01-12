package com.webcatalog.ejb;

import com.webcatalog.entities.Client;

import javax.ejb.Remote;

@Remote
public interface GestionUtilisateurBeanRemote {
    Client verifierIdentifiants(String email, String motDePasse);
    // Autres méthodes si nécessaire
}
