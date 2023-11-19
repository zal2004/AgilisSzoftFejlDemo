package main;

import java.util.HashMap;

public class TaxPredictor {
    static HashMap<String, Double> taxMap;

    public TaxPredictor() {
        //fill up the taxMap
        taxMap = new HashMap<>();
        taxMap.put("Clothes", 27.0);
        taxMap.put("General Food", 27.0);
        taxMap.put("Books", 5.0);
        taxMap.put("Essential Food", 5.0);
    }

    public static double getTax(String name) {
        if(!taxMap.containsKey(name)) {
            return 27;
        }
        return taxMap.get(name);
    }
}
