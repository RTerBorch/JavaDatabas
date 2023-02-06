package Databas;

import Store.Formater;

public class Cart {

    Formater formater = new Formater();

    public String customerData() {

        return "Customer: " + order.getCustomer().getFirstName() + " " +
                order.getCustomer().getLastName() +
                formater.alignProducts(order.getCustomer().getFirstName()+order.getCustomer().getLastName())
                +"Adress: " + order.getCustomer().getAddress();
    }

    public String productData(){
       return "Product: " + product.getProductName() + formater.alignProducts(product.getProductName()) + product.getBrand() + "/" + product.getColor() + "/" + product.getSize() +
               formater.alignProducts(product.getBrand() + "/" + product.getColor() + "/" + product.getSize());

    }

    private int id;
    private int orderId;
    private  int productId;

    private Product product;
    private Order order;

    public Cart() {
    }

    public Cart(int id, int orderId, int productId) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
