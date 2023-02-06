import Databas.*;
import Databas.LoadItems.*;
import Databas.StoredProcedures.StoredProcedure;
import Program.Library;
import Store.ProductStore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    @Test
    public void orderListTest() {
        OrderLoader orderLoader = new OrderLoader();
        List<Order> orderList = new ArrayList<>();


        assert orderList.size() == 0;
        orderList = orderLoader.load();
        assert orderList.size() >= 1;
    }

    @Test
    public void cartListTest() {
        CartLoader cartLoader = new CartLoader();
        List<Cart> cartList = new ArrayList<>();

        assert cartList.size() == 0;
        cartList = cartLoader.load();
        assert cartList.size() >= 1;
    }

    @Test
    public void addToCartTest() {

        Library library = new Library();
        // Update list from database
        library.refreshLists();

        StoredProcedure sp = new StoredProcedure();


        int listSize = library.getCartList().size();

        int orderId = 1;

        Customer customer = new Customer();
        customer.setId(1);

        Product product = new Product();
        product.setId(1);

        sp.addToCart(orderId,customer,product);

        System.out.println("List size: " + listSize);

        library.refreshLists();

        assert listSize+1 == library.getCartList().size();

        System.out.println("List size: " + library.getCartList().size());

    }

    @Test
    public void testShopItem() {
        // Remake test
    }
}
