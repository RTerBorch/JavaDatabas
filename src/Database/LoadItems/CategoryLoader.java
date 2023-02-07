package Database.LoadItems;

import Database.Category;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CategoryLoader implements Loadable<Category> {
    final Properties p = new Properties();

    @Override
    public List<Category> load() {
        List<Category> categoryList = new ArrayList<>();

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
             ResultSet rs = stmt.executeQuery("select categoryMapping.id, productId, category from categoryMapping join category on categoryId = category.id")) {

            while (rs.next()) {


                int id = rs.getInt("id");
                int productId = rs.getInt("productId");
                String categoryName = rs.getString("category");

                Category category = new Category(id, categoryName, productId);
                categoryList.add(category);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoryList;
    }
}








