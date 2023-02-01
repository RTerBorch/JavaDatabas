package Databas;

import java.sql.Timestamp;

public class Order {
    protected int id;

    protected int customerId;

    protected Customer customer;

    protected Timestamp purchaseDate;

    private Boolean test = false;



    public Order(){}

    public Order(int id, int customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
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
