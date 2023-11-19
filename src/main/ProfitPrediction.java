package main;

//
public class ProfitPrediction {

    public static double calculateProfit(int cost, int income, String shipmentType, String productType,
                                         int weight, Parcel parcel, boolean isExpress) {
        double profit = 0;
        TaxPredictor taxPredictor = new TaxPredictor();
        double tax = taxPredictor.getTax(productType);

        ShipmentCostPredictor shipmentCostPredictor = new ShipmentCostPredictor();
        double shipmentCost = shipmentCostPredictor.getShipmentCost(isExpress, weight, parcel, shipmentType);

        profit = income - cost - tax - shipmentCost;
        return profit;
    }

}
