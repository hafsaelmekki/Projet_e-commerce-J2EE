package com.webcatalog.ejb;

import com.webcatalog.entities.Categorie;
import com.webcatalog.entities.Produit;
import javax.ejb.Remote;
import java.util.List;

@Remote
public interface accesCatalogueBeanRemote {
    List<Categorie> getListCategories();
    List<Produit> getListProduits(int categorieId);
	Produit getProduitById(int id);
}
