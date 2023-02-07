package Program;

import Database.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerHandler {
    private Boolean test = false;
    private Boolean loggedIn = false;

    Customer activeCustomer;

    public CustomerHandler(Boolean test) {
        this.test = test;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


    public Customer welcomeCustomer(List<Customer> customerList) {

        if (!test) System.out.println("Welcome to the Shoeshop! \nplease login");
        while (!loggedIn) {

            activeCustomer = logIn(customerList);
            if (activeCustomer != null) {
                //Set customer as logged in if activeCustomer is returned from logIn.
                if (activeCustomer.getLoggedIn()) loggedIn = true;
                if (!test) System.out.println("Welcome " + activeCustomer.getFirstName());
            }
        }

        return activeCustomer;
    }

    public Customer logIn(List<Customer> customerList) {
        String eMail;
        String password;

        Scanner scanner = new Scanner(System.in);
        boolean isCustomer = false;

        if (test) {
            eMail = "testMail";
        } else {
            System.out.println("Enter your email: ");
            eMail = scanner.nextLine();
        }

        for (Customer customer : customerList) {

            if (customer.geteMail().equalsIgnoreCase(eMail)) {
                isCustomer = true;

                if (test) {
                    password = "testPass";
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