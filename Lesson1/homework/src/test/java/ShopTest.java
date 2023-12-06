import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import Shop.Product;
import Shop.Shop;

public class ShopTest {
    private Shop shop;
    /*
     * 1. Напишите тесты, чтобы проверить, что магазин хранит верный список
     * продуктов (правильное количество продуктов, верное содержимое корзины).
     * 2. Напишите тесты для проверки корректности работы метода
     * getMostExpensiveProduct.
     * 3. Напишите тесты для проверки корректности работы метода sortProductsByPrice
     * (проверьте правильность сортировки).
     */

    @BeforeEach // метод будет выполняться каждый раз перед каждым тестом
    public void setup() {
        shop = new Shop();
    }

    @AfterEach // метод будет выполняться каждый раз после каждого теста
    public void teardown() {
        shop = null;
    }

    @Test
    @DisplayName("проверка на коррктность списка продуктов")
    public void testsListProducts() {
        int[] testPrices = { 10, 15, 20, 60, 80, 90, 9, 641, 44, 18 };
        String[] testTitle = { "shirt", "pants", "shoes", "dress", "hat", "jacket", "socks", "watch", "bag",
                "sunglasses" };
        // #region заполним магазин
        shop.setProducts(new ArrayList<>());
        for (int n = 0; n < testPrices.length; n++) {
            Product product = new Product();
            product.setCost(testPrices[n]);
            product.setTitle(testTitle[n]);
            shop.getProducts().add(product);
        }
        // #endregion

        assertEquals(testPrices.length, shop.getProducts().size()); // проверки соответствия количества продуктов

        // #region подсчитаем совпадающие продукты
        int trueCount = 0;
        for (int n = 0; n < testPrices.length; n++) {
            for (Product product : shop.getProducts()) {
                if (product.getCost() == testPrices[n] && product.getTitle().equals(testTitle[n])) {
                    trueCount++; // увеличим счетчик совпадающих продуктов
                    shop.getProducts().remove(product); // удалим продукт
                    break;
                }
            }
        }
        // #endregion

        assertEquals(testPrices.length, trueCount); // проверкa соответствия списка продуктов
    }

    @Test
    @DisplayName("проверка getMostExpensiveProduct()")
    public void testsGetMostExpensiveProduct() {
        int[] testPrices = { 10, 15, 20, 60, 80, 90, 9, 641, 44, 18 };
        String[] testTitle = { "shirt", "pants", "shoes", "dress", "hat", "jacket", "socks", "watch", "bag",
                "sunglasses" };
        // #region заполним магазин
        shop.setProducts(new ArrayList<>());
        for (int n = 0; n < testPrices.length; n++) {
            Product product = new Product();
            product.setCost(testPrices[n]);
            product.setTitle(testTitle[n]);
            shop.getProducts().add(product);
        }
        // #endregion

        // #region найдем максимальное значение цены
        int max = testPrices[0];
        String title = testTitle[0];
        for (int i = 1; i < testPrices.length; i++) {
            if (testPrices[i] > max) {
                max = testPrices[i];
                title = testTitle[i];
            }
        }
        // #endregion

        assertEquals(max, shop.getMostExpensiveProduct().getCost());
        assertEquals(title, shop.getMostExpensiveProduct().getTitle()); // проверим соответствие названия
    }

    @Test
    @DisplayName("проверка sortProductsByPrice()")
    public void testsSortProductsByPrice() {
        int[] testPrices = { 10, 15, 20, 60, 80, 90, 9, 641, 44, 18 };
        String[] testTitle = { "shirt", "pants", "shoes", "dress", "hat", "jacket", "socks", "watch", "bag",
                "sunglasses" };
        // #region заполним магазин
        shop.setProducts(new ArrayList<>());
        for (int n = 0; n < testPrices.length; n++) {
            Product product = new Product();
            product.setCost(testPrices[n]);
            product.setTitle(testTitle[n]);
            shop.getProducts().add(product);
        }
        // #endregion

        shop.sortProductsByPrice();

        // #region проверим что цены возрастают
        int lastPrice = shop.getProducts().get(0).getCost();
        for (int i = 1; i < testPrices.length; i++) {
            int curPrice = shop.getProducts().get(i).getCost();
            assertEquals(true, lastPrice <= curPrice);
            lastPrice = curPrice;
        }
        // #endregion
    }
}