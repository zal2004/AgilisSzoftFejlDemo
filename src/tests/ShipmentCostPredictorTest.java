package tests;

import main.Paracel;
import main.ShipmentCostPredictor;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ShipmentCostPredictorTest {

        @org.junit.jupiter.api.Test
        void constructor() {
                ShipmentCostPredictor shipmentCostPredictor = new ShipmentCostPredictor();
                assertNotNull(shipmentCostPredictor);
        }

        @org.junit.jupiter.api.Test
        void getShipmentCost() {
                assertEquals(10050, ShipmentCostPredictor.getShipmentCost(true, 250,
                        new Paracel(10, 10, 10, 250), "Air" ), 0.0);
        }

}