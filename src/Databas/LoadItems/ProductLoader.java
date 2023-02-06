package Databas.LoadItems;

import Databas.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductLoader implements Loadable<Product> {

    Properties p = new Properties();

    @Override
    public List<Product> load() {
        List<Product> productList = new ArrayList<>();


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
             ResultSet rs = stmt.executeQuery("select product.id, productName, brand, price, quantity, color, size from product join color on colorId = color.id join size on sizeId = size.id;")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                String brand = rs.getString("brand");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String size = rs.getString("size");
                Product product = new Product(id, productName, brand, price, quantity, color, size);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}