package Databas;

import java.util.ArrayList;
import java.util.List;

public class ProductLoader implements Loadable<Product>{
    @Override

    public List<Product> load() {
        List<Product> productList = new ArrayList<>();
        // Add logic to load product data and populate productList
        return productList;
    }
}
