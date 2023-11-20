package refactor;

public class ProductRefactor {
    private String name;
    private int price;
    private int stock;
    private int sold;
    private int value;

    public ProductRefactor(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.sold = 0;
        this.value = 0;
    }

    public String List(){
        return "Name: " + name + "\tPrice: " + price + "\tStock: " + stock;
    }

    public void incrementSold(int soldCount){
        sold += soldCount;
        stock -= soldCount;
        value += soldCount*price;
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
    public int getSold() {
        return sold;
    }
    public int getValue() {
        return value;
    }
}
