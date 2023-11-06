package main;

public class Parcel extends Product {
    int a;
    int b;
    int c;
    int weight;

    public Parcel(String prodName, int price, int stock, int a, int b, int c, int weight) {
        super(prodName, 0, 0);
        this.a = a;
        this.b = b;
        this.c = c;
        this.weight = weight;
    }

    public Parcel(Product prod, int a, int b, int c, int weight){
        super(prod.getName(), prod.getPrice(), prod.getStock());
        this.a = a;
        this.b = b;
        this.c = c;
        this.weight = weight;
    }
    public int getVolume() {
        return a * b * c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getWeight() {
        return weight;
    }

}
