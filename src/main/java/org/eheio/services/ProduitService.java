package org.eheio.services;

import org.eheio.Produit;

import java.util.List;

public class ProduitService {
    public static List<Produit> produits;

    public static void Create(long id, String nom, double prix, int quantite) throws Exception {
        Produit produit = new Produit(id, nom, prix, quantite);

        for (Produit p : produits) {
            if (p.getId() == produit.getId() || p.getNom().equalsIgnoreCase(produit.getNom())) {
                throw new Exception("Id ou nom est deja utilisé!");
            }
        }

        if (produit.getPrix() <= 0) {
            throw new Exception("Le prix doit etre positif!");
        }

        if (produit.getQuantite() < 0) {
            throw new Exception("La quantité doit etre positif!");
        }

        produits.add(produit);
    }
}
