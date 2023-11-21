package testsRefactor;

import main.Parcel;
import refactor.ShipmentCostPredictorRefactor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ShipmentCostPredictorTestRefactor {

        @org.junit.jupiter.api.Test
        void constructor() {
                ShipmentCostPredictorRefactor shipmentCostPredictor = new ShipmentCostPredictorRefactor();
                assertNotNull(shipmentCostPredictor);
        }

        @org.junit.jupiter.api.Test
        void getShipmentCost() {
                assertEquals(10050, ShipmentCostPredictorRefactor.getShipmentCost(true, 250,
                        new Parcel("TestProd",25, 2, 10, 10, 10, 250), "Air" ),
                        0.0);
        }
}