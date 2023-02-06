package Databas.LoadItems;

import Databas.Customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomerLoader implements Loadable {

    final Properties p = new Properties();

    @Override
    public List<Customer> load() {
        List<Customer> customerList = new ArrayList<>();

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
             ResultSet rs = stmt.executeQuery("select id, firstName, lastName,address,district,zipCode,phoneNr, customerPassWord,eMail from customer")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String district = rs.getString("district");
                String zipCode = rs.getString("zipCode");
                String phoneNr = rs.getString("phoneNr");
                String customerPassWord = rs.getString("customerPassWord");
                String eMail = rs.getString("eMail");
                Customer customer = new Customer(id, firstName, lastName, address, district, zipCode, phoneNr, eMail, customerPassWord);
                customerList.add(customer);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;

    }


}

