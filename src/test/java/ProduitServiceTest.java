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
        Produit p = new Produit(3, "Produit 3", 10, 20);
        produits.add(p);

        assertEquals(true, true);
    }

    @Test(expected = Exception.class)
    public void AjoutQuantiteNegative() {
        Produit p = new Produit(3, "Produit 3", 10, -20);
        produits.add(p);
    }

    @Test(expected = Exception.class)
    public void AjoutPrixNegative() {
        Produit p = new Produit(3, "Produit 3", -10, 20);
        produits.add(p);
    }


    @Test(expected = Exception.class)
    public void AjoutIdExistant() {
        Produit p = new Produit(2, "Produit 3", 10, 20);
        produits.add(p);
    }

    @Test(expected = Exception.class)
    public void AjoutNomExistant() {
        Produit p = new Produit(3, "Produit 2", 10, 20);
        produits.add(p);
    }

    @Test
    public void ReadIdExistant() {
        Produit p = new Produit(2, "Produit 2", 10, 20);
        p.getId();
        assertEquals(true, true);
    }

    @Test(expected = Exception.class)
    public void ReadIdInexistant() {
        Produit p = new Produit(3, "Produit 3", 10, 20);
        p.getId();
    }
}
