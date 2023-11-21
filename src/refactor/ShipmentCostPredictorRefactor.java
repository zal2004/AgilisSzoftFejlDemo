package refactor;

import main.Parcel;

import java.util.HashMap;
public class ShipmentCostPredictorRefactor {

    static HashMap<String, Double> shipmentTypeCostMap;
    static HashMap<Integer, Integer> shipmentWeightMap;
    static HashMap<Integer, Integer> shipmentSizeAMap;
    static HashMap<Integer, Integer> shipmentSizeBMap;
    static HashMap<Integer, Integer> shipmentSizeCMap;

    private static void loadInData(){
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



    public ShipmentCostPredictorRefactor(){
        loadInData();
        Limits limits = new Limits();
    }

    public static int getShipmentCost(boolean isExpress, int weight, Parcel parcel, String type){
        double cost = 0;
        if(isExpress){
            cost += 10000;
        }
        for(int i = 0; i < Limits.weightLimits.length; i++){
            if(weight <= Limits.weightLimits[i]){
                cost += shipmentWeightMap.get(Limits.weightLimits[i]);
                break;
            }
        }
        cost += shipmentTypeCostMap.get(type);
        for(int i = 0; i < Limits.sizeALimits.length; i++){
            if(parcel.getA() <= Limits.sizeALimits[i]){
                cost += shipmentSizeAMap.get(Limits.sizeALimits[i]);
                break;
            }
        }
        for(int i = 0; i < Limits.sizeBLimits.length; i++){
            if(parcel.getB() <= Limits.sizeBLimits[i]){
                cost += shipmentSizeBMap.get(Limits.sizeBLimits[i]);
                break;
            }
        }
        for(int i = 0; i < Limits.sizeCLimits.length; i++){
            if(parcel.getC() <= Limits.sizeCLimits[i]){
                cost += shipmentSizeCMap.get(Limits.sizeCLimits[i]);
                break;
            }
        }
        return (int)cost;
    }


}
