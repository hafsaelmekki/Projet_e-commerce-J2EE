package com.webcatalog.ejb;

import com.webcatalog.entities.CommandeClient;
import javax.ejb.Remote;
import java.util.List;

@Remote
public interface gestionCommandeBeanRemote {
    CommandeClient createCommande();
    void validerCommande(CommandeClient commande);
    // Ajoutez d'autres méthodes en fonction des besoins de votre application.
}
