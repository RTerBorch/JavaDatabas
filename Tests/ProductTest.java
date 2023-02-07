import Database.Category;
import Database.LoadItems.CategoryLoader;
import Database.LoadItems.ProductLoader;
import Database.Product;
import Store.ProductStore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductTest {


    @Test
    public void testProductLoading() {
        ProductLoader pl = new ProductLoader();

        List<Product> productList = new ArrayList<>();
        assert productList.size() == 0;
        productList = pl.load();
        assert productList.size() >= 1;

    }

    @Test
    public void testCategoryLoading() {
        CategoryLoader cl = new CategoryLoader();

        List<Category> categoryList = new ArrayList<>();
        assert categoryList.size() == 0;
        categoryList = cl.load();
        assert categoryList.size() >= 1;

    }

    @Test
    public void testRowNr() {
        ProductLoader pl = new ProductLoader();

        List<Product> productList = pl.load();

        ProductStore productStore = new ProductStore(true);
        productStore.generateStore(productList);

        // Correct rowNr
        assert productStore.getFilteredProductList().get(2).getRowNr() == 3;

        // Only products in stock
        for (Product p : productStore.getFilteredProductList()) {
            assert p.getQuantity() > 0;
        }


    }


}
