import Databas.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private List<Customer> customerList;
    private List<Product> productList;
    private List<Order> orderList;

    private List<Category> categoryList;
    private List<Cart> cartList;

    private Map<Integer, Customer> customerMap;
    private Map<Integer, Product> productMap;
    private Map<Integer, Order> orderMap;
    private Map<Integer, Category> categoryMap;



    public void refreshLists(List<Customer> customerList, List<Product> productList, List<Order> orderList,List<Cart> cartList, List<Category> categoryList) {
        // Refresh all lists and add customer to the right order.
        setCustomerList(customerList);
        setProductList(productList);
        setOrderList(orderList);
        setCartList(cartList);
        setCategoryList(categoryList);

        // Places customer object reference into order.
        customerObjectToOrder();

        // Mapping for Category
        productObjectToCategory();

        // Mapping for cart
        productObjectToCart();
        orderObjectToCart();
    }

        private void customerObjectToOrder(){

        setCustomerMap(mapCustomerList(this.customerList));

        this.orderList.forEach(order -> {
            order.setCustomer(getCustomerMap().get(order.getCustomerId()));
        });

    }

    private void orderObjectToCart(){
        setOrderMap(mapOrderList(this.orderList));

        this.cartList.forEach(cart -> {
            cart.setOrder(getOrderMap().get(cart.getOrderId()));

        });

    }

    private void productObjectToCart(){
        setProductMap(mapProductList(this.productList));

        this.cartList.forEach(cart -> {
            cart.setProduct(getProductMap().get(cart.getProductId()));
        });

    }

    private void productObjectToCategory(){
        setProductMap(mapProductList(this.productList));

        this.categoryList.forEach(category -> {
            category.setProduct(getProductMap().get(category.getProductId()));
        });

    }


        private Map<Integer, Customer> mapCustomerList(List<Customer> customerList){
        Map<Integer, Customer> map = new HashMap<>();
        for (Customer customer : customerList){
            map.put(customer.getId(), customer);
        }
        return map;
    }


    private Map<Integer, Order> mapOrderList(List<Order> orderList){
        Map<Integer, Order> map = new HashMap<>();
        for (Order order : orderList){
            map.put(order.getId(), order);
        }
        return map;
    }
    private Map<Integer, Product> mapProductList(List<Product> productList){
        Map<Integer, Product> map = new HashMap<>();
        for (Product product : productList){
            map.put(product.getId(), product);
        }
        return map;
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
