package main;

public class Parcel {
    int a;
    int b;
    int c;
    int weight;

    public Parcel(int a, int b, int c, int weight) {
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
