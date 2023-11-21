package refactor;

import main.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainRefactor {
    public static void main(String[] args) {
        ArrayList<ProductRefactor> products = new ArrayList<ProductRefactor>();
        products.add(new ProductRefactor("Elso", 100, 20));
        products.add(new ProductRefactor("Masodik", 200, 30));
        products.add(new ProductRefactor("Harmadik", 300, 40));
        products.add(new ProductRefactor("Negyedik", 400, 50));

        products.get(0).incrementSold(1);
        products.get(1).incrementSold(2);
        products.get(2).incrementSold(1);
        products.get(3).incrementSold(2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Sentinel
                
                Összes termék megtekintése: 1
                Kelendő termékek megtekintése: 2
                Kilépés: exit
                """);
        String userInput = scanner.nextLine();
        while(!userInput.equals("exit")) {
            if (userInput.equals("1")){
                for (ProductRefactor product : products){
                    System.out.println(product.getName() + " " + product.getPrice() + " " + product.getStock());
                }
            }
            if (userInput.equals("2")){
                List<ProductRefactor> bestProducts = EvalutateTop3(products);
                for (ProductRefactor product : bestProducts){
                    System.out.println(product.getName() + " " + product.getPrice() + " " + product.getStock());
                }
            }
            userInput = scanner.nextLine();
        }
    }

    public static List<ProductRefactor> EvalutateTop3(ArrayList<ProductRefactor> products){
        int firstBestValue = 0;
        int secondaryBestValue = 0;
        int thirdBestValue = 0;
        ProductRefactor firstBestProduct = null;
        ProductRefactor secondaryBestProduct = null;
        ProductRefactor thirdBestProduct = null;

        for (ProductRefactor product : products){
            if (product.getValue() > firstBestValue){
                thirdBestValue = secondaryBestValue;
                thirdBestProduct = secondaryBestProduct;
                secondaryBestValue = firstBestValue;
                secondaryBestProduct = firstBestProduct;
                firstBestValue = product.getValue();
                firstBestProduct = product;
            }
            else if (product.getValue() > secondaryBestValue){
                thirdBestValue = secondaryBestValue;
                thirdBestProduct = secondaryBestProduct;
                secondaryBestValue = product.getValue();
                secondaryBestProduct = product;
            }
            else if (product.getValue() > thirdBestValue){
                thirdBestValue = product.getValue();
                thirdBestProduct = product;
            }
        }

        ArrayList<ProductRefactor> list = new ArrayList<>();
        if (firstBestProduct != null)
            list.add(firstBestProduct);
        if (secondaryBestProduct != null)
            list.add(secondaryBestProduct);
        if (thirdBestProduct != null)
            list.add(thirdBestProduct);

        return list;
    }

    @Test
    public void USDtoUSDTest(){
        Product testproduct = new Product("Elso", 100, 20);
        double resultValue = main.Main.Exchange(testproduct, "Dollár");

        assertEquals(100, resultValue);
    }

    @Test
    public void USDtoForintTest(){
        Product testproduct = new Product("Elso", 100, 20);
        double resultValue = main.Main.Exchange(testproduct, "Forint");

        assertEquals(40000, resultValue);
    }

    @Test
    public void USDtoEurTest(){
        Product testproduct = new Product("Elso", 100, 20);
        double resultValue = main.Main.Exchange(testproduct, "Euró");

        assertEquals(150, resultValue);
    }
}
