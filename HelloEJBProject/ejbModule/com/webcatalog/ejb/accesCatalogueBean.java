package com.webcatalog.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.webcatalog.entities.Categorie;
import com.webcatalog.entities.Produit;

import java.util.List;

@Stateless(name = "HelloJNDI2")
public class accesCatalogueBean implements accesCatalogueBeanRemote {

    @PersistenceContext(unitName = "managerBoutique")
    private EntityManager em;
    
    @Override
    public List<Categorie> getListCategories() {
        return em.createQuery("SELECT c FROM Categorie c", Categorie.class).getResultList();
    }
    
    @Override
    public List<Produit> getListProduits(int categorieId) {
        return em.createQuery("SELECT p FROM Produit p WHERE p.categorie.id = :categorieId", Produit.class)
                 .setParameter("categorieId", categorieId)
                 .getResultList();
    }
    
    @Override
    public Produit getProduitById(int id) {
        return em.find(Produit.class, id);
    }
}
