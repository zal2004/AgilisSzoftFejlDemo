package tests;

import main.Product;
import java.util.ArrayList;
import java.util.List;

import main.Main;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void ZeroProductTest() {
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("Elso", 100, 20));
        products.add(new Product("Masodik", 200, 30));
        products.add(new Product("Harmadik", 300, 40));
        products.add(new Product("Negyedik", 400, 50));

        List<Product> testResult = Main.Evalutate(products);
        ArrayList<Product> expectedResult = new ArrayList<>();

        assertEquals(expectedResult, testResult);
    }

    @Test
    public void Only1ProductTest() {
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("Elso", 100, 20));
        products.add(new Product("Masodik", 200, 30));
        products.add(new Product("Harmadik", 300, 40));
        products.add(new Product("Negyedik", 400, 50));

        products.get(2).incrementSold(1);

        List<Product> testResult = Main.Evalutate(products);
        ArrayList<Product> expectedResult = new ArrayList<>();
        expectedResult.add(products.get(2));

        assertEquals(expectedResult, testResult);

    }

    @Test
    public void AllProductOnlyGet3Test() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Elso", 100, 20));
        products.add(new Product("Masodik", 200, 30));
        products.add(new Product("Harmadik", 300, 40));
        products.add(new Product("Negyedik", 400, 50));

        products.get(0).incrementSold(1);
        products.get(1).incrementSold(2);
        products.get(2).incrementSold(1);
        products.get(3).incrementSold(2);

        List<Product> testResult = Main.Evalutate(products);
        ArrayList<Product> expectedResult = new ArrayList<>();
        expectedResult.add(products.get(3));
        expectedResult.add(products.get(1));
        expectedResult.add(products.get(2));

        assertEquals(expectedResult, testResult);
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
