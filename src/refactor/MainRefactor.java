package refactor;

import main.ValutaChange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                Valutaváltás forint: 3
                Valutaváltás euró: 4
                Valutaváltás dollár: 5
                Kilépés: exit
                """);

        String displayPrice="Dollár";
        String userInput = scanner.nextLine();
        while(!userInput.equals("exit")) {
            switch (userInput) {
                case "1":
                    for (ProductRefactor product : products) {
                        System.out.println(product.getName() + " " + Exchange(product, displayPrice) + " " + product.getStock());
                    }
                    break;
                case "2":
                    List<ProductRefactor> bestProducts = EvalutateTop3(products);
                    for (ProductRefactor product : bestProducts) {
                        System.out.println(product.getName() + " " + Exchange(product, displayPrice) + " " + product.getStock());
                    }
                    break;
                case "3":
                    displayPrice = "Forint";
                    break;
                case "4":
                    displayPrice = "Euró";
                    break;
                case "5":
                    displayPrice = "Dollár";
                    break;
                default:
                    System.out.println("Nem megfelelő input");
                    break;
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

    public static double Exchange(ProductRefactor product, String displayPrice){
        ValutaChange forint, dollar, euro;

        dollar = new ValutaChange("Dollár", 1);
        forint = new ValutaChange("Forint", 400);
        euro = new ValutaChange("Euró", 1.5);

        return switch (displayPrice) {
            case "Forint" -> product.getPriceInUSD() * forint.getExchangerate();
            case "Euró" -> product.getPriceInUSD() * euro.getExchangerate();
            case "Dollár" -> product.getPriceInUSD() * dollar.getExchangerate();
            default -> product.getPriceInUSD();
        };
    }
}
