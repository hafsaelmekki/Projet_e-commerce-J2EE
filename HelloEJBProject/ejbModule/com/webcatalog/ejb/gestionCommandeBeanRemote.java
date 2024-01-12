package com.webcatalog.ejb;

import com.webcatalog.entities.CommandeClient;
import com.webcatalog.entities.Panier;

import javax.ejb.Remote;

@Remote
public interface gestionCommandeBeanRemote {
    CommandeClient createAndPersistOrder(Panier panier, String email);
    
}
