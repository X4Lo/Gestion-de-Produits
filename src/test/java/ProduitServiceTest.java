import org.eheio.Produit;
import org.eheio.services.ProduitService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.eheio.services.ProduitService.Read;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ProduitServiceTest {

    public static List<Produit> produits = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        ProduitService.Create(1, "Produit 1", 10, 20);
        ProduitService.Create(2, "Produit 2", 10, 20);
    }

    @Test
    public void AjoutProduit() throws Exception {
        ProduitService.Create(3, "Produit 3", 10, 20);
        assertEquals(true, true);
    }

    @Test(expected = Exception.class)
    public void AjoutQuantiteNegative() throws Exception {
        ProduitService.Create(4, "Produit 4", 10, -20);
    }

    @Test(expected = Exception.class)
    public void AjoutPrixNegative() throws Exception {
        ProduitService.Create(5, "Produit 5", -10, 20);
    }


    @Test(expected = Exception.class)
    public void AjoutIdExistant() throws Exception {
        ProduitService.Create(2, "Produit 55", 10, 20);
    }

    @Test(expected = Exception.class)
    public void AjoutNomExistant() throws Exception {
        ProduitService.Create(6, "Produit 2", 10, 20);
    }

    @Test
    public void ReadIdExistant() throws Exception {
        ProduitService.Read(2);
        assertEquals(true, true);
    }

    @Test(expected = Exception.class)
    public void ReadIdInexistant() throws Exception {
        ProduitService.Read(3);
    }

    @Test(expected = Exception.class)
    public void DeleteExistingProduit() throws Exception {
        ProduitService.Delete(2);
    }

    @Test(expected = Exception.class)
    public void DeleteNonExistingProduit() throws Exception {
        ProduitService.Delete(58);
    }


    @Test
    public void UpdateProduit() throws Exception {
        ProduitService.Update(1, "Produit 1", 10, 30);
        assertEquals(true, true);
    }

    @Test(expected = Exception.class)
    public void UpdateIdNonExistant() throws Exception {
        ProduitService.Update(3, "Produit 3", 10, 30);
    }

    @Test(expected = Exception.class)
    public void UpdatePrixNegative() throws Exception {
        ProduitService.Update(1, "Produit 1", -10, 30);
    }
    @Test(expected = Exception.class)
    public void UpdateQuantiteNegative() throws Exception {
        ProduitService.Update(1, "Produit 1", 10, -30);
    }

    @Test(expected = Exception.class)
    public void UpdateNomExistant() throws Exception {
        ProduitService.Update(1, "Produit 2", 10, -30);
    }

    @After
    public void CleanUp() {
        ProduitService.produits = new ArrayList<>();
    }


}
