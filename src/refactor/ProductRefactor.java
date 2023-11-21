package refactor;

public class ProductRefactor {
    private String name;
    private int priceInUSD;
    private int stock;
    private int sold;
    private int value;

    public ProductRefactor(String name, int priceInUSD, int stock) {
        this.name = name;
        this.priceInUSD = priceInUSD;
        this.stock = stock;
        this.sold = 0;
        this.value = 0;
    }

    public void incrementSold(int soldCount){
        sold += soldCount;
        stock -= soldCount;
        value += soldCount*priceInUSD;
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

    public int getSold() {
        return sold;
    }
    public int getValue() {
        return value;
    }
}
