package org.eheio.services;

import org.eheio.Produit;

import java.util.ArrayList;
import java.util.List;

public class ProduitService {
    public static List<Produit> produits;

    static {
        produits = new ArrayList<>();
    }

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

    public static Produit Read(long id) throws Exception {
        for (Produit p : produits) {
            if (p.getId() == id) {
                return p;
            }
        }

        throw new Exception("Produit non trouvé avec l'ID : " + id);
    }

    public static void Update(long id, String nom, double prix, int quantite) throws Exception {
        Produit produit = new Produit();

        for (Produit p : produits) {
            if (p.getId() == id) {
                produit = p;
                break;
            }
        }

        if (produit.getNom().isEmpty()) {
            throw new Exception("Aucun produit avec cette id n'a etait trouvé!");
        }

        for (Produit p : produits) {
            if (p.getId() != produit.getId() && p.getNom().equalsIgnoreCase(nom)) {
                throw new Exception("Ce nom est deja utilisé!");
            }
        }


        if (prix <= 0) {
            throw new Exception("Le prix doit etre positif!");
        }

        if (quantite < 0) {
            throw new Exception("La quantité doit etre positif!");
        }

        produit.setNom(nom);
        produit.setPrix(prix);
        produit.setQuantite(quantite);
    }

    public static void Delete(long id) throws Exception {
        for (Produit p : produits) {
            if (p.getId() == id) {
                produits.remove(p);
            }
        }

        throw new Exception("Produit non trouvé avec l'ID : " + id);
    }
}
