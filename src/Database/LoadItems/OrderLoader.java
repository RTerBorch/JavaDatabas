package Database.LoadItems;

import Database.Order;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrderLoader implements Loadable {

    final Properties p = new Properties();

    @Override
    public List<Order> load() {
        List<Order> orderList = new ArrayList<>();

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
             ResultSet rs = stmt.executeQuery("select orders.id, customerId, purchaseDate from orders")) {


            while (rs.next()) {
                int id = rs.getInt("id");
                int customerId = rs.getInt("customerId");
                Timestamp purchaseDate = rs.getTimestamp("purchaseDate");
                Order order = new Order(id, customerId, purchaseDate);
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

}


