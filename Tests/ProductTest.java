import Databas.Category;
import Databas.CustomerHandler;
import Databas.Product;
import Databas.Repository;
import Store.ProductStore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductTest {


    @Test
    public void testProductLoading() {
        Repository repository = new Repository();
        List<Product> productList = new ArrayList<>();
        assert productList.size() == 0;
        productList = repository.loadProductList();
        assert productList.size() >= 1;

    }

    @Test
    public void testCategoryLoading() {
        Repository repository = new Repository();
        List<Category> categoryList = new ArrayList<>();
        assert categoryList.size() == 0;
        categoryList = repository.loadCategoryList();
        assert categoryList.size() >= 1;

    }

    @Test
    public void testRowNr() {
        Repository repository = new Repository();
        List<Product> productList = repository.loadProductList();

        ProductStore productStore = new ProductStore(true);
        productStore.setTest(true);
        productStore.generateStore(productList);

        // Correct rowNr
        assert productStore.getFilteredProductList().get(2).getRowNr() == 3;

        // Only products in stock
        for (Product p : productStore.getFilteredProductList()) {
            assert p.getQuantity() > 0;
        }


    }


}
