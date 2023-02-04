import Databas.Cart;
import Databas.CartLoader;
import Databas.Category;
import Databas.CategoryLoader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LoaderTests {


    @Test
    public void doesTheCartListGetFilled(){
        List<Cart> cartList = new ArrayList<>();
        CartLoader cartLoader = new CartLoader();




        if (cartList == null) throw new AssertionError();
        cartList = cartLoader.load();
        assert cartList.size() > 0;
        System.out.println(cartList.size());

        cartList.forEach(c -> System.out.println(c.getId()));

        }


    @Test
    public void doesTheCategoryListGetFilled(){
        List<Category> categoryList = new ArrayList<>();
        CategoryLoader categoryLoader = new CategoryLoader();




        if (categoryList == null) throw new AssertionError();
        categoryList = categoryLoader.load();
        assert categoryList.size() > 0;
        System.out.println(categoryList.size());

        categoryList.forEach(c -> System.out.println(c.getCategoryName()));
    }





    }

