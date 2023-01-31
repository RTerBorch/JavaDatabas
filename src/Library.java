import Databas.Customer;
import Databas.Order;
import Databas.Product;

import java.util.List;

public class Library {

    private List<Customer> customerList;
    private List<Product> productList;
    private List<Order> orderList;

    public void refreshLists(List<Customer> customerList, List<Product> productList, List<Order> orderList) {
        setCustomerList(customerList);
        setProductList(productList);
        setOrderList(orderList);

        // TODO MAPPA ALLA ORDERS OCH KUNDER!! -- För varje order matcha kundId med kund(id)



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
