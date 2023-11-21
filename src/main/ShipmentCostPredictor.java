package main;

import java.util.HashMap;

public class ShipmentCostPredictor {

    static HashMap<String, Double> shipmentTypeCostMap;
    static HashMap<Integer, Integer> shipmentWeightMap;
    static HashMap<Integer, Integer> shipmentSizeAMap;
    static HashMap<Integer, Integer> shipmentSizeBMap;
    static HashMap<Integer, Integer> shipmentSizeCMap;

    public ShipmentCostPredictor(){

        shipmentTypeCostMap = new HashMap<>();
        shipmentTypeCostMap.put("Air", 20.0);
        shipmentTypeCostMap.put("Ship", 5.0);
        shipmentTypeCostMap.put("Train", 10.0);
        shipmentTypeCostMap.put("Truck", 16.0);

        shipmentWeightMap = new HashMap<>();
        shipmentWeightMap.put(100, 5);
        shipmentWeightMap.put(200, 10);
        shipmentWeightMap.put(500, 15);

        shipmentSizeAMap = new HashMap<>();
        shipmentSizeAMap.put(10, 5);
        shipmentSizeAMap.put(20, 10);
        shipmentSizeAMap.put(30, 15);

        shipmentSizeBMap = new HashMap<>();
        shipmentSizeBMap.put(20, 5);
        shipmentSizeBMap.put(40, 10);
        shipmentSizeBMap.put(60, 15);

        shipmentSizeCMap = new HashMap<>();
        shipmentSizeCMap.put(30, 5);
        shipmentSizeCMap.put(60, 10);
        shipmentSizeCMap.put(90, 15);
    }

    public static int getShipmentCost(boolean isExpress, int weight, Parcel parcel, String type){
        double cost = 0;
        if(isExpress){
            cost += 10000;
        }
        cost += shipmentTypeCostMap.get(type);
        if(weight <= 100){
            cost += shipmentWeightMap.get(100);
        }
        else if(weight <= 200){
            cost += shipmentWeightMap.get(200);
        }
        else if(weight <= 500){
            cost += shipmentWeightMap.get(500);
        }
        if(parcel.getA() <= 10){
            cost += shipmentSizeAMap.get(10);
        }
        else if(parcel.getA() <= 20){
            cost += shipmentSizeAMap.get(20);
        }
        else if(parcel.getA() <= 30){
            cost += shipmentSizeAMap.get(30);
        }
        if(parcel.getB() <= 20){
            cost += shipmentSizeBMap.get(20);
        }
        else if(parcel.getB() <= 40){
            cost += shipmentSizeBMap.get(40);
        }
        else if(parcel.getB() <= 60){
            cost += shipmentSizeBMap.get(60);
        }
        if(parcel.getC() <= 30){
            cost += shipmentSizeCMap.get(30);
        }
        else if(parcel.getC() <= 60){
            cost += shipmentSizeCMap.get(60);
        }
        else if(parcel.getC() <= 90){
            cost += shipmentSizeCMap.get(90);
        }
        return (int)cost;
    }
}
