package tests;


import main.TaxPredictor;
import org.junit.Test;
import org.junit.Assert;

public class TaxPredictorTest {

    @Test
    public void constructor() {
        TaxPredictor taxPredictor = new TaxPredictor();
        Assert.assertNotNull(taxPredictor);
    }

    @Test
    public void getTax() {
        Assert.assertEquals(27.0, TaxPredictor.getTax("Clothes"), 0.0);
        Assert.assertEquals(5.0, TaxPredictor.getTax("Essential Food"), 0.0);
        Assert.assertEquals(27.0, TaxPredictor.getTax("General Food"), 0.0);
        Assert.assertEquals(5.0, TaxPredictor.getTax("Books"), 0.0);
        Assert.assertEquals(27.0, TaxPredictor.getTax("Unknown Item"), 0.0);
    }
}