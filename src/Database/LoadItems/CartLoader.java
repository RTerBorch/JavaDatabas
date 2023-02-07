package Database.LoadItems;

import Database.Cart;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CartLoader implements Loadable<Cart> {
    final Properties p = new Properties();
    @Override
    public List<Cart> load() {
        List<Cart> cartList = new ArrayList<>();

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
             ResultSet rs = stmt.executeQuery("SELECT id, orderId, productId FROM cart")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int orderId = rs.getInt("orderId");
                int productId = rs.getInt("productId");
                Cart cart = new Cart(id, orderId, productId);
                cartList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartList;
    }
}

