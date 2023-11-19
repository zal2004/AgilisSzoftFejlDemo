package main;

import java.util.ArrayList;

public class Product {
    private String name;
    private int price;
    private int stock;
    private int sold;

    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.sold = 0;
    }

    public String List(){
        return "Name: " + name + "\tPrice: " + price + "\tStock: " + stock;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
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
}
