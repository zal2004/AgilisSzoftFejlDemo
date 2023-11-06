package main;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> goodProducts = new ArrayList<Product>();
        goodProducts.add(new Product("Elso", 100, 20));
        goodProducts.add(new Product("Masodik", 200, 30));
        goodProducts.add(new Product("Harmadik", 300, 40));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sentinel\n\n" +
                "Kelendő termékek megtekintése: 1\n" +
                "Kilépés: exit");
        String userInput = scanner.nextLine();
        while(!userInput.equals("exit")) {
            if (userInput.equals("1")){
                for (Product product : goodProducts) {
                    System.out.println(product.List());
                }
            }
            userInput = scanner.nextLine();
        }
    }
}
