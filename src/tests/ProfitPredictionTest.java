package tests;

import main.Parcel;
import main.ProfitPrediction;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfitPredictionTest {
    @Test
    public void constructor() {
        ProfitPrediction profitPrediction = new ProfitPrediction();
        assertNotNull(profitPrediction);
    }

    @Test
    public void getProfit() {
        assertEquals(3265, ProfitPrediction.calculateProfit(6700, 10000,"Train",
                "Books", 20, new Parcel("TestProd",25, 2,10, 5, 20, 40), false), 0.0);
    }

}