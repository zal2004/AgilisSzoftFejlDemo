package main;

//
public class ProfitPrediction {

    public static double calculateProfit(int cost, int income, String shipmentType, String productType,
                                         int weight, Paracel paracel, boolean isExpress) {
        double profit = 0;
        TaxPerdictor taxPerdictor = new TaxPerdictor();
        double tax = taxPerdictor.getTax(productType);

        ShipmentCostPredictor shipmentCostPredictor = new ShipmentCostPredictor();
        double shipmentCost = shipmentCostPredictor.getShipmentCost(isExpress, weight, paracel, shipmentType);

        profit = income - cost - tax - shipmentCost;
        return profit;
    }

}
