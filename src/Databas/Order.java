package Databas;

import java.sql.Timestamp;

public class Order {
    private int id;

    private int customerId;

    private Customer customer;

    private Timestamp purchaseDate;

    public Order(){}

    public Order(int id, int customerId, Timestamp purchaseDate) {
        this.id = id;
        this.customerId = customerId;
        this.purchaseDate = getPurchaseDate();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
