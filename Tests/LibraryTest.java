import org.junit.Test;

public class LibraryTest {


    @Test
    public void testRefreshList(){
        /*
        Library library = new Library();

        List<Customer> cL = new ArrayList<>();
        List<Product> pL = new ArrayList<>();
        List<Order> oL = new ArrayList<>();
        List<Category> ctgL = new ArrayList<>();
        List<Cart> cartL = new ArrayList<>();

        cL.add(new Customer());
        pL.add((new Product()));
        oL.add(new Order());
        oL.add(new Order());
        ctgL.add(new Category());
        cartL.add(new Cart());

        library.refreshLists(cL,pL,oL,cartL,ctgL);

        assert library.getCustomerList().size() == 1;
        assert library.getProductList().size() == 1;
        assert library.getOrderList().size() == 2;
        assert library.getCartList().size() == 1;
        assert library.getCategoryList().size() == 1;

         */



    }


    @Test
    public void testMappingOfCustomerList() {

        /*


        Library library = new Library();

        List<Customer> cL = new ArrayList<>();
        List<Product> pL = new ArrayList<>();
        List<Order> oL = new ArrayList<>();
        List<Category> ctgL = new ArrayList<>();
        List<Cart> cartL = new ArrayList<>();

        cL.add(
                new Customer(999, "Test", "","",
                        "", "", "",
                        "", ""));


        library.refreshLists(cL,pL,oL,cartL,ctgL);

        assert library.getCustomerMap().containsKey(999);
        Customer customer = library.getCustomerMap().get(999);
        assert customer.getFirstName().equalsIgnoreCase("Test");
    }

    @Test
    public void testCustomerObjectToOrder(){
        Library library = new Library();

        Timestamp ts = Timestamp.from(Instant.now());

        List<Customer> cL = new ArrayList<>();
        List<Product> pL = new ArrayList<>();
        List<Order> oL = new ArrayList<>();
        List<Category> ctgL = new ArrayList<>();
        List<Cart> cartL = new ArrayList<>();

        cL.add(
                new Customer(888, "Test2", "","",
                        "", "", "",
                        "", ""));
        cL.add(
                new Customer(999, "Test", "","",
                        "", "", "",
                        "", ""));

        pL.add (
                new Product(333,"TestProduct","",200,10,"","" ));


        ctgL.add(new Category(1,"TestCategory",333));




        Order order1 = new Order(1,888,ts);
        Order order2 = new Order(2,999,ts);

        cartL.add(
                new Cart(1,1,333));

        oL.add(order1);
        oL.add(order2);
        library.refreshLists(cL,pL,oL,cartL,ctgL);

        assert oL.get(0).getCustomer()!=null;

        assert ctgL.get(0).getCategoryName().equals("TestCategory");
        assert cartL.get(0).getProduct().getProductName().equals("TestProduct");

        assert order1.getCustomer().getFirstName().equalsIgnoreCase("Test2");
        assert order2.getCustomer().getFirstName().equalsIgnoreCase("Test");

        assert cartL.get(0).getOrder()!=null;
        assert cartL.get(0).getProduct()!=null;

        assert cartL.get(0).getProduct().getPrice() == 200;
        assert cartL.get(0).getProduct().getQuantity() == 10;

         */

    }

}
