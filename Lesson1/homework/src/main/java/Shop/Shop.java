package Shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        if(products == null) return null;
        products.sort((c,x)->c.getCost()-x.getCost());
        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        if(products == null || products.size() == 0) return null;        
        Product mostExpensiveProduct = products.get(0);
        for (Product product : products) {
            if(product.getCost() > mostExpensiveProduct.getCost())
                mostExpensiveProduct = product;
        }
        return mostExpensiveProduct;
    }

}