package main;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("Elso", 100, 20));
        products.add(new Product("Masodik", 200, 30));
        products.add(new Product("Harmadik", 300, 40));
        products.add(new Product("Negyedik", 400, 50));

        products.get(0).incrementSold(1);
        products.get(1).incrementSold(2);
        products.get(2).incrementSold(1);
        products.get(3).incrementSold(2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sentinel\n\n" +
                "Összes termék megtekintése: 1\n" +
                "Kelendő termékek megtekintése: 2\n" +
                "Kilépés: exit");
        String userInput = scanner.nextLine();
        while(!userInput.equals("exit")) {
            if (userInput.equals("1")){
                for (Product product : products){
                    System.out.println(product.getName() + " " + product.getPrice() + " " + product.getStock());
                }
            }
            if (userInput.equals("2")){
                ArrayList<Product> bestProducts = Evalutate(products);
                for (Product product : bestProducts){
                    System.out.println(product.getName() + " " + product.getPrice() + " " + product.getStock());
                }
            }
            userInput = scanner.nextLine();
        }
    }

    public static ArrayList<Product> Evalutate(ArrayList<Product> products){
        int firstBestValue = 0;
        Product firstBestProduct = null;
        int secondaryBestValue = 0;
        Product secondaryBestProduct = null;
        int thirdBestValue = 0;
        Product thirdBestProduct = null;
        for (Product product : products){
            int tempValue = product.getSold() * product.getPrice();
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
}
