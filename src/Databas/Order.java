package Databas;

import java.sql.Timestamp;

public class Order {
    protected int id;
    protected int customerId;

    protected Timestamp purchaseDate;

    private Boolean test = false;



    public Order(){}

    public Order(int id, int customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
