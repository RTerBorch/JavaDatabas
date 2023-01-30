package Databas;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Repository {

    private List<Product> productList;
    private List<Customer> customerList;

    private List<Order> orderList;

    final Properties p = new Properties();


    public List<Order> loadOrderList() {
        generateListFor("ORDER");
        return orderList;
    }

    public List<Customer> loadCustomerList() {
        generateListFor("CUSTOMER");
        return customerList;
    }

    public List<Product> loadProductList() {
        generateListFor("PRODUCT");
        return productList;
    }


    // Collects all customers into list.
    private void generateListFor(String type) {


        String sqlString = "";

        switch (type) {
            case "CUSTOMER" -> {
                sqlString =
                        "select id, firstName,customerPassWord,eMail from customer";
                customerList = new ArrayList<>();
            }
            case "PRODUCT" -> {
                sqlString =
                        "select product.id, productName, brand, price, quantity, color, size from product\n" +
                                "join color on colorId = color.id\n" +
                                "join size on sizeId = size.id;";
                productList = new ArrayList<>();
            }
            case "ORDER" -> {
                sqlString =
                        "select orders.id, customerId, purchaseDate from orders";
                orderList = new ArrayList<>();
            }

        }


        try {
            p.load(new FileInputStream("src/settings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));

             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sqlString)) {


            while (rs.next()) {


                if (type.equals("CUSTOMER")) {
                    Customer customer = new Customer();
                    int id = rs.getInt("id");
                    customer.setId(id);

                    String firstName = rs.getString("firstName");
                    customer.setFirstName(firstName);

                    String customerPassWord = rs.getString("customerPassWord");
                    customer.setCustomerPassWord(customerPassWord);

                    String eMail = rs.getString("eMail");
                    customer.seteMail(eMail);

                    customerList.add(customer);
                }


                if (type.equals("PRODUCT")) {

                    Product product = new Product();

                    int id = rs.getInt("id");
                    product.setId(id);

                    String productName = rs.getString("productName");
                    product.setProductName(productName);

                    String brand = rs.getString("brand");
                    product.setBrand(brand);

                    double price = rs.getDouble("price");
                    product.setPrice(price);

                    int quantity = rs.getInt("quantity");
                    product.setQuantity(quantity);

                    String color = rs.getString("color");
                    product.setColor(color);

                    String size = rs.getString("size");
                    product.setSize(size);

                    productList.add(product);
                }
                if (type.equals("ORDER")) {
                    Order order = new Order();
                    int id = rs.getInt("id");
                    order.setId(id);

                    int customerId = rs.getInt("customerId");
                    order.setCustomerId(customerId);

                    Timestamp purchaseDate = rs.getTimestamp("purchaseDate");
                    order.setPurchaseDate(purchaseDate);

                    orderList.add(order);
                }


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void callStoredProcedure(String procedure, int orderId, Customer customer, Product product) {

        // What procedure to call
        procedure = procedure.toLowerCase();

        // complete call string
        switch (procedure) {
            case "addtocart" -> {
                procedure = "call AddToCart(?,?,?)";
            }
        }


        try {
            p.load(new FileInputStream("src/settings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"));


            CallableStatement callableStatement = connection.prepareCall(procedure);

            if (procedure.equals("call AddToCart(?,?,?)")) {
                callableStatement.setInt(1, customer.getId()); //cart customerId
                callableStatement.setInt(2, orderId);//cart orderId
                callableStatement.setInt(3, product.getId()); // cart productId
            }


            resultSet = callableStatement.executeQuery();
            String errorMessage = "";

            /*
            Felhantering kolla upp hur det fungerar, behöver databasen en kolumn error?
            while(resultSet != null && resultSet.next()){
                errorMessage = resultSet.getString("error");
            }
            if (!errorMessage.equals("")) {
                return errorMessage;
            }

           */


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}