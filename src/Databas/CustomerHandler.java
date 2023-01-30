package Databas;

import java.util.List;
import java.util.Scanner;

public class CustomerHandler {
    private Boolean test = false;

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public Customer logIn(List<Customer> customerList) {
        String eMail;
        String password;

        Scanner scanner = new Scanner(System.in);
        boolean isCustomer = false;

        if (test) {
            eMail = "robintb@gmail.com";
        } else {
            System.out.println("Enter your email: ");
            eMail = scanner.nextLine();
        }

        for (Customer customer : customerList) {

            if (customer.geteMail().equalsIgnoreCase(eMail)) {
                isCustomer = true;

                if (test) {
                    password = "lösenord1";
                } else {
                    System.out.println("Enter password: ");
                    password = scanner.nextLine();
                }

                if (customer.getCustomerPassWord().equals(password)) {
                    if (!test) System.out.println("Login successful");
                    customer.setLoggedIn(true);
                    return customer;
                } else {
                    System.out.println("Login failed. Password and email did not match");
                }
            }
        }
        if (!isCustomer) {
            System.out.println("This email is not in our system, please create an account to login");
        }

        return null;
    }
}