package testsRefactor;

import main.Main;
import main.Product;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainRefactorTest {
    private ArrayList<Product> initTest(){
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("Elso", 200, 20));
        products.add(new Product("Masodik", 300, 30));
        products.add(new Product("Harmadik", 400, 40));
        products.add(new Product("Negyedik", 500, 50));

        return products;
    }
    @Test
    public void ZeroProductTest() {
        ArrayList<Product> products = initTest();

        ArrayList<Product> testResult = Main.Evalutate(products);
        ArrayList<Product> expectedResult = new ArrayList<>();

        assertEquals(expectedResult, testResult);
    }

    @Test
    public void Only1ProductTest() {
        ArrayList<Product> products = initTest();

        products.get(2).incrementSold(2);

        ArrayList<Product> testResult = Main.Evalutate(products);
        ArrayList<Product> expectedResult = new ArrayList<>();
        expectedResult.add(products.get(2));

        assertEquals(expectedResult, testResult);

    }

    @Test
    public void AllProductOnlyGet3Test() {
        ArrayList<Product> products = initTest();

        products.get(0).incrementSold(2);
        products.get(1).incrementSold(1);
        products.get(2).incrementSold(2);
        products.get(3).incrementSold(1);

        ArrayList<Product> testResult = Main.Evalutate(products);
        ArrayList<Product> expectedResult = new ArrayList<>();
        expectedResult.add(products.get(3));
        expectedResult.add(products.get(1));
        expectedResult.add(products.get(2));

        assertEquals(expectedResult, testResult);
    }
}
