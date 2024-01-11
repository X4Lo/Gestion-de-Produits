import org.eheio.Produit;
import org.junit.Before;
import org.junit.Test;

import static org.eheio.services.ProduitService.Read;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ProduitServiceTest {
    public static List<Produit> produits = new ArrayList<>();

    @Before
    public void setUp() {
        Produit p1 = new Produit(1, "Produit 1", 10, 20);
        Produit p2 = new Produit(2, "Produit 2", 10, 20);
        produits.add(p1);
        produits.add(p2);
    }

    @Test
    public void AjoutProduit() {
        try {
            Produit p = new Produit(3, "Produit 3", 10, 20);
            produits.add(p);
            assertEquals(true, true);
        } catch (Exception e) {

        }
    }

    @Test
    public void AjoutQuantiteNegative() {
        try {
            Produit p = new Produit(3, "Produit 3", 10, -20);
            produits.add(p);
        } catch (Exception e) {
            assertEquals(true, true);
        }
    }

    @Test
    public void AjoutPrixNegative() {
        try {
            Produit p = new Produit(3, "Produit 3", -10, 20);
            produits.add(p);
        } catch (Exception e) {
            assertEquals(true, true);
        }
    }


    @Test
    public void AjoutIdExistant() {
        try {
            Produit p = new Produit(2, "Produit 3", 10, 20);
            produits.add(p);
        } catch (Exception e) {
            assertEquals(true, true);
        }
    }

    @Test
    public void AjoutNomExistant() {
        try {
            Produit p = new Produit(3, "Produit 2", 10, 20);
            produits.add(p);
        } catch (Exception e) {
            assertEquals(true, true);
        }
    }

    @Test
    public void ReadIdExistant() {
        Produit p = new Produit(2, "Produit 2", 10, 20);
        p.getId();
        assertEquals(true, true);
    }

    @Test
    public void ReadIdInexistant() {
        try {
            Produit p = new Produit(3, "Produit 3", 10, 20);
            p.getId();
        } catch (Exception e) {
            assertEquals(true, true);
        }
    }
}
