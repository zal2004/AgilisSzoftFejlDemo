package main;

import java.util.ArrayList;

public class Product {
    private String name;
    private int priceInUSD;
    private int stock;
    private int sold;

    private String displayPrice;


    public Product(String name, int priceInUSD, int stock) {
        this.name = name;
        this.priceInUSD = priceInUSD;
        this.stock = stock;
        this.sold = 0;
        this.displayPrice = "Dollár";
    }

    public String List(){
        return "Name: " + name + "\tPrice: " + priceInUSD + "\tStock: " + stock;
    }
    public String getName(){
        return name;
    }
    public int getPriceInUSD(){
        return priceInUSD;
    }
    public int getStock(){
        return stock;
    }
    public void incrementSold(int soldCount){
        sold += soldCount;
        stock -= soldCount;
    }

    public int getSold() {
        return sold;
    }


    public String getInvaluta() {return displayPrice;}

    public void setInvaluta(String displayPrice) {
        this.displayPrice = displayPrice;
    }
}
