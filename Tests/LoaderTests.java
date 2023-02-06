import Databas.*;
import Databas.LoadItems.CartLoader;
import Databas.LoadItems.CategoryLoader;
import Databas.LoadItems.CustomerLoader;
import Databas.LoadItems.DataLoader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LoaderTests {


    @Test
    public void doesTheCartListGetFilled() {
        List<Cart> cartList = new ArrayList<>();
        CartLoader cartLoader = new CartLoader();

        if (cartList == null) throw new AssertionError();
        cartList = cartLoader.load();
        assert cartList.size() > 0;

    }

    @Test
    public void doesTheCategoryListGetFilled() {
        List<Category> categoryList = new ArrayList<>();
        CategoryLoader categoryLoader = new CategoryLoader();

        if (categoryList == null) throw new AssertionError();
        categoryList = categoryLoader.load();
        assert categoryList.size() > 0;
    }

    @Test
    public void doesTheCustomerListGetFilled() {
        List<Customer> customerList = new ArrayList<>();
        CustomerLoader customerLoader = new CustomerLoader();

        if (customerList == null) throw new AssertionError();
        customerList = customerLoader.load();
        assert customerList.size() > 0;
    }

    @Test
    public void HigherFunctionDataLoaderTest(){
        CustomerLoader cl = new CustomerLoader();
        DataLoader dl = new DataLoader();

        List<Customer> customerList = null;
        customerList = dl.loadData(cl);
        assert customerList.size() > 0;

        customerList.forEach(c -> System.out.println(c.getFirstName()));

    }


}

