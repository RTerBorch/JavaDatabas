package Program;

import Database.*;
import Database.LoadItems.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    DataLoader dl = new DataLoader();

    CartLoader cartLoader = new CartLoader();
    CategoryLoader categoryLoader = new CategoryLoader();
    CustomerLoader customerLoader = new CustomerLoader();
    OrderLoader orderLoader = new OrderLoader();
    ProductLoader productLoader = new ProductLoader();




    private List<Customer> customerList;
    private List<Product> productList;
    private List<Order> orderList;

    private List<Category> categoryList;
    private List<Cart> cartList;

    private Map<Integer, Customer> customerMap;
    private Map<Integer, Product> productMap;
    private Map<Integer, Order> orderMap;
    private Map<Integer, Category> categoryMap;

    private Map<Integer, Cart> cartMap;


    public void refreshLists() {
        // Refresh all lists.
        setCustomerList(customerLoader.load());
        setProductList(productLoader.load());
        setOrderList(orderLoader.load());
        setCartList(cartLoader.load());
        setCategoryList(categoryLoader.load());

        // Placing objects where referred by a FK
        FkObjectIntoClass();
    }

    private void FkObjectIntoClass() {

        mapCustomerList(this.customerList);
        mapCategoryList(this.categoryList);
        mapProductList(this.productList);
        mapOrderList(this.orderList);
        mapCartList(this.cartList);


        this.orderList.forEach(order -> {
            order.setCustomer(getCustomerMap().get(order.getCustomerId()));
        });
        this.categoryList.forEach(category -> {
            category.setProduct(getProductMap().get(category.getProductId()));
        });
        this.cartList.forEach(cart -> {
            cart.setProduct(getProductMap().get(cart.getProductId()));
        });
        this.cartList.forEach(cart -> {
            cart.setOrder(getOrderMap().get(cart.getOrderId()));
        });

    }

    private void mapCustomerList(List<Customer> customerList) {
        Map<Integer, Customer> map = new HashMap<>();
        customerList.forEach(c->map.put(c.getId(),c));
        setCustomerMap(map);

    }
    private void mapOrderList(List<Order> orderList) {
        Map<Integer, Order> map = new HashMap<>();
        orderList.forEach(o-> map.put(o.getId(), o));
        setOrderMap(map);

    }
    private void mapProductList(List<Product> productList) {
        Map<Integer, Product> map = new HashMap<>();
        productList.forEach(p->map.put(p.getId(),p));
        setProductMap(map);

    }
    private void mapCartList(List<Cart> cartList) {
        Map<Integer, Cart> map = new HashMap<>();
        cartList.forEach(c->map.put(c.getId(),c));
        setCartMap(map);

    }

    private void mapCategoryList(List<Category> categoryList) {
        Map<Integer, Category> map = new HashMap<>();
       categoryList.forEach(c->map.put(c.getId(),c));
        setCategoryMap(map);

    }

    public Map<Integer, Cart> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map<Integer, Cart> cartMap) {
        this.cartMap = cartMap;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Integer, Product> productMap) {
        this.productMap = productMap;
    }

    public Map<Integer, Order> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<Integer, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public Map<Integer, Category> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(Map<Integer, Category> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public Map<Integer, Customer> getCustomerMap() {
        return customerMap;
    }

    public void setCustomerMap(Map<Integer, Customer> customerMap) {
        this.customerMap = customerMap;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
