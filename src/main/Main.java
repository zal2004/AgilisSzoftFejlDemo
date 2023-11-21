package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Elso", 100, 20));
        products.add(new Product("Masodik", 200, 30));
        products.add(new Product("Harmadik", 300, 40));
        products.add(new Product("Negyedik", 400, 50));

        products.get(0).incrementSold(1);
        products.get(1).incrementSold(2);
        products.get(2).incrementSold(1);
        products.get(3).incrementSold(2);

        String displayPrice="Dollár";
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

        String userInput = scanner.nextLine();
        while(!userInput.equals("exit")) {
            switch (userInput) {
                case "1" -> {
                    for (Product product : products) {
                        System.out.println(product.getName() + " " + Exchange(product, displayPrice) + " " + product.getStock());
                    }
                }
                case "2" -> {
                    List<Product> bestProducts = Evalutate(products);
                    for (Product product : bestProducts) {
                        System.out.println(product.getName() + " " + Exchange(product, displayPrice) + " " + product.getStock());
                    }
                }
                case "3" -> displayPrice = "Forint";
                case "4" -> displayPrice = "Euró";
                case "5" -> displayPrice = "Dollár";
                default -> System.out.println("Nem megfelelő input");
            }
            userInput = scanner.nextLine();
        }
    }

    public static List<Product> Evalutate(List<Product> products){
        int firstBestValue = 0;
        Product firstBestProduct = null;
        int secondaryBestValue = 0;
        Product secondaryBestProduct = null;
        int thirdBestValue = 0;
        Product thirdBestProduct = null;
        for (Product product : products){
            int tempValue = product.getSold() * product.getPriceInUSD();
            if (tempValue > firstBestValue){
                thirdBestValue = secondaryBestValue;
                thirdBestProduct = secondaryBestProduct;
                secondaryBestValue = firstBestValue;
                secondaryBestProduct = firstBestProduct;
                firstBestValue = tempValue;
                firstBestProduct = product;
            }
            else if (tempValue > secondaryBestValue){
                thirdBestValue = secondaryBestValue;
                thirdBestProduct = secondaryBestProduct;
                secondaryBestValue = tempValue;
                secondaryBestProduct = product;
            }
            else if (tempValue > thirdBestValue){
                thirdBestValue = tempValue;
                thirdBestProduct = product;
            }
        }
        ArrayList<Product> list = new ArrayList<>();
        if (firstBestProduct != null)
            list.add(firstBestProduct);
        if (secondaryBestProduct != null)
            list.add(secondaryBestProduct);
        if (thirdBestProduct != null)
            list.add(thirdBestProduct);

        return list;
    }

    public static double Exchange(Product product, String displayPrice){
        ValutaChange forint, dollar, euro;

        dollar = new ValutaChange("Dollár", 1);
        forint = new ValutaChange("Forint", 400);
        euro = new ValutaChange("Euró", 1.5);

        switch (displayPrice){
            case "Forint":
                return product.getPriceInUSD()*forint.getExchangerate();
            case "Euró":
                return product.getPriceInUSD()*euro.getExchangerate();
            case "Dollár":
                return product.getPriceInUSD()*dollar.getExchangerate();
            default:
                return product.getPriceInUSD();
        }
    }
}
