package refactor;


import java.util.HashMap;



public class Limits {

    static int[] weightLimits;
    static int[] sizeALimits;
    static int[] sizeBLimits;
    static int[] sizeCLimits;

    private static void loadInData(){
        weightLimits = new int[]{100, 200, 500};
        sizeALimits = new int[]{10, 20, 30};
        sizeBLimits = new int[]{20, 40, 60};
        sizeCLimits = new int[]{30, 60, 90};
    }

    public Limits(){
        loadInData();
    }
}
