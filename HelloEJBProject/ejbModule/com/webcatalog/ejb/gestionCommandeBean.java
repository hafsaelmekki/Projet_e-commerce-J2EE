package com.webcatalog.ejb;

import com.webcatalog.entities.CommandeClient;
import com.webcatalog.entities.ProduitCommande;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "HelloJNDI1")
public class gestionCommandeBean implements gestionCommandeBeanRemote {

    @PersistenceContext(unitName = "managerBoutique")
    private EntityManager em;

    @Override
    public CommandeClient createCommande() {
        CommandeClient commande = new CommandeClient();
        em.persist(commande);
        return commande;
    }

    @Override
    public void validerCommande(CommandeClient commande) {
        // Vous pourriez vouloir valider ou compléter la commande ici.
        em.merge(commande);
    }

    // Vous pouvez ajouter des méthodes supplémentaires ici pour gérer les lignes de commande,
    // par exemple, ajouter une ligne de commande à une commande existante.
}
