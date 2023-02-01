import Databas.*;
import Store.ProductStore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    @Test

    public void orderListTest() {
        Repository repository = new Repository();
        List<Order> orderList = new ArrayList<>();
        assert orderList.size() == 0;
        orderList = repository.loadOrderList();
        assert orderList.size() >= 1;

    }
    @Test
    public void cartListTest() {
        Repository repository = new Repository();
        List<Cart> cartList = new ArrayList<>();
        assert cartList.size() == 0;
        cartList = repository.loadCartList();
        assert cartList.size() >= 1;

    }

    @Test
    public void addToCartTest() {
        ProductStore productStore = new ProductStore(true);
        Repository repository = new Repository();

        Order order = new Order();
        Customer customer = new Customer();
        Product product = new Product();

        // Set customer Robin
        customer.setId(1);
        // Set product rainboots
        product.setId(5);

        int activeOrder = productStore.generateOrderNr(repository.loadOrderList());
        repository.callStoredProcedure("addtocart", activeOrder, customer, product);


    }

    @Test
    public void testShopItem() {

        ProductStore productStore = new ProductStore(true);
        Repository repository = new Repository();

        List<Product> productList = repository.loadProductList();
        List<Customer> customerList = repository.loadCustomerList();

        productList.get(0).setQuantity(10);
        productList.get(0).setRowNr(1);

        Customer activeCustomer = customerList.get(0);
        productStore.shopItem(1, activeCustomer, productList,repository.loadOrderList());

        // Gör test på att rätt item blev sålt sedan.

    }


}
