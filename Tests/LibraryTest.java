import Databas.Customer;
import Databas.Order;
import Databas.Product;
import Databas.Repository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryTest {


    @Test
    public void testRefreshList(){
        Library library = new Library();

        List<Customer> cL = new ArrayList<>();
        List<Product> pL = new ArrayList<>();
        List<Order> oL = new ArrayList<>();

        cL.add(new Customer());
        pL.add((new Product()));
        oL.add(new Order());
        oL.add(new Order());

        library.refreshLists(cL,pL,oL);

        assert library.getCustomerList().size() == 1;
        assert library.getProductList().size() == 1;
        assert library.getOrderList().size() == 2;

    }


    @Test
    public void testMappingOfCustomerList() {

        Library library = new Library();
        Repository r = new Repository();


        List<Customer> cL = new ArrayList<>();
        List<Product> pL = new ArrayList<>();
        List<Order> oL = new ArrayList<>();

        cL.add(
                new Customer(999, "Test", "","",
                        "", "", "",
                        "", ""));

        library.refreshLists(cL,pL,oL);
       // Map map = library.mapCustomerList(customerList);

        assert library.getCustomerMap().containsKey(999);
        Customer customer = library.getCustomerMap().get(999);
        assert customer.getFirstName().equalsIgnoreCase("Test");
    }

    @Test
    public void testCustomerObjectToOrder(){
        Library library = new Library();
        Repository r = new Repository();


        List<Customer> cL = new ArrayList<>();
        List<Product> pL = new ArrayList<>();
        List<Order> oL = new ArrayList<>();

        cL.add(
                new Customer(888, "Test2", "","",
                        "", "", "",
                        "", ""));
        cL.add(
                new Customer(999, "Test", "","",
                        "", "", "",
                        "", ""));

        Order order1 = new Order(1,888);
        Order order2 = new Order(2,999);

        oL.add(order1);
        oL.add(order2);

        library.refreshLists(cL,pL,oL);

        assert order1.getCustomer().getFirstName().equalsIgnoreCase("Test2");
        assert order2.getCustomer().getFirstName().equalsIgnoreCase("Test");

    }

}
