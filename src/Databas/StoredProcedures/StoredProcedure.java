package Databas.StoredProcedures;

import Databas.Customer;
import Databas.Product;
import Databas.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class StoredProcedure implements Procedure {
    Properties p = new Properties();


    @Override
    public void addToCart(int orderId, Customer customer, Product product) {

        try {
            p.load(new FileInputStream("C:\\Users\\robin\\Desktop\\IntelliJ\\JavaDatabas\\src\\settings.properties"));
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

            CallableStatement callableStatement = connection.prepareCall("call AddToCart(?,?,?)");
            callableStatement.setInt(1, customer.getId()); //cart customerId
            callableStatement.setInt(2, orderId);           //cart orderId
            callableStatement.setInt(3, product.getId()); // cart productId


            resultSet = callableStatement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
