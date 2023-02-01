import Databas.Customer;
import Databas.Order;
import Databas.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private List<Customer> customerList;
    private List<Product> productList;
    private List<Order> orderList;

    private Map<Integer, Customer> customerMap;



    public void refreshLists(List<Customer> customerList, List<Product> productList, List<Order> orderList) {
        // Refresh all lists and add customer to the right order.
        setCustomerList(customerList);
        setProductList(productList);
        setOrderList(orderList);

        CustomerObjectToOrder();

    }

        private void CustomerObjectToOrder(){

        setCustomerMap(mapCustomerList(this.customerList));

        this.orderList.forEach(order -> {
            order.setCustomer(getCustomerMap().get(order.getCustomerId()));
        });

    }

        private Map<Integer, Customer> mapCustomerList(List<Customer> customerList){
        Map<Integer, Customer> map = new HashMap<>();
        for (Customer customer : customerList){
            map.put(customer.getId(), customer);
        }
        return map;
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
