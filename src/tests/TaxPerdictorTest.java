package tests;


import main.TaxPerdictor;
import org.junit.Test;
import org.junit.Assert;

public class TaxPerdictorTest {

    @Test
    public void constructor() {
        TaxPerdictor taxPerdictor = new TaxPerdictor();
        Assert.assertNotNull(taxPerdictor);
    }

    @Test
    public void getTax() {
        Assert.assertEquals(27.0, TaxPerdictor.getTax("Clothes"), 0.0);
        Assert.assertEquals(5.0, TaxPerdictor.getTax("Essential Food"), 0.0);
        Assert.assertEquals(27.0, TaxPerdictor.getTax("General Food"), 0.0);
        Assert.assertEquals(5.0, TaxPerdictor.getTax("Books"), 0.0);
        Assert.assertEquals(27.0, TaxPerdictor.getTax("Unknown Item"), 0.0);
    }
}