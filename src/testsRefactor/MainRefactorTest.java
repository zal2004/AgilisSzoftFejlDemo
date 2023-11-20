package testsRefactor;

import org.junit.Test;
import refactor.MainRefactor;
import refactor.ProductRefactor;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainRefactorTest {
    private ArrayList<ProductRefactor> initTest(){
        ArrayList<ProductRefactor> products = new ArrayList<>();
        products.add(new ProductRefactor("Elso", 200, 20));
        products.add(new ProductRefactor("Masodik", 300, 30));
        products.add(new ProductRefactor("Harmadik", 400, 40));
        products.add(new ProductRefactor("Negyedik", 500, 50));

        return products;
    }
    @Test
    public void ZeroProductTest() {
        ArrayList<ProductRefactor> products = initTest();

        ArrayList<ProductRefactor> testResult = MainRefactor.EvalutateTop3(products);
        ArrayList<ProductRefactor> expectedResult = new ArrayList<>();

        assertEquals(expectedResult, testResult);
    }

    @Test
    public void Only1ProductTest() {
        ArrayList<ProductRefactor> products = initTest();

        products.get(2).incrementSold(2);

        ArrayList<ProductRefactor> testResult = MainRefactor.EvalutateTop3(products);
        ArrayList<ProductRefactor> expectedResult = new ArrayList<>();
        expectedResult.add(products.get(2));

        assertEquals(expectedResult, testResult);

    }

    @Test
    public void AllProductOnlyGet3Test() {
        ArrayList<ProductRefactor> products = initTest();

        products.get(0).incrementSold(2);
        products.get(1).incrementSold(1);
        products.get(2).incrementSold(2);
        products.get(3).incrementSold(1);

        ArrayList<ProductRefactor> testResult = MainRefactor.EvalutateTop3(products);
        ArrayList<ProductRefactor> expectedResult = new ArrayList<>();
        expectedResult.add(products.get(2));
        expectedResult.add(products.get(3));
        expectedResult.add(products.get(0));

        assertEquals(expectedResult, testResult);
    }
}
