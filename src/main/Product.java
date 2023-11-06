package main;

public class Product {
    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
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
}
