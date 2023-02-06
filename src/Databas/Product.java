package Databas;

import Store.Formater;

public class Product {

    private int loadOrder;

    Formater formater = new Formater();

    protected int id;
    protected String productName;
    protected String brand;
    protected double price;
    protected int quantity;
    protected String color;
    protected String size;

    protected int rowNr;

    private Boolean test = false;


    public Product() {
    }

    public Product(int id, String productName, String brand, double price, int quantity, String color, String size) {
        this.id = id;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.size = size;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public int getRowNr() {
        return rowNr;
    }

    public void setRowNr(int rowNr) {
        this.rowNr = rowNr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String productData(){
        return "Product: " + getProductName() + formater.alignProducts(getProductName()) + getBrand() + "/" + getColor() + "/" + getSize() +
                formater.alignProducts(getBrand() + "/" + getColor() + "/" + getSize());

    }

    public int getLoadOrder() {
        return loadOrder;
    }

    public void setLoadOrder(int loadOrder) {
        this.loadOrder = loadOrder;
    }
}
