package main;

public class ValutaChange {
    private String name;
    private double exchangerate;

    public ValutaChange(String name, double exchangerate){
        this.name = name;
        this.exchangerate=exchangerate;
    }

    public String getName(){return name;}
    public double getExchangerate(){return exchangerate;}
}
