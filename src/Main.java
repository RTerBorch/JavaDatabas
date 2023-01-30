import Databas.Customer;
import Databas.CustomerHandler;
import Databas.Product;
import Databas.Repository;
import Store.Formater;
import Store.PrintMessage;
import Store.ProductStore;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        boolean loggedIn = false;
        Customer activeCustomer = new Customer();

        Scanner scanner = new Scanner(System.in);

        Formater formater = new Formater();
        Repository repository = new Repository();
        CustomerHandler customerHandler = new CustomerHandler();
        ProductStore productStore = new ProductStore();
        PrintMessage printMessage = new PrintMessage();

        // Customer + Product list
        List<Customer> customerList = repository.loadCustomerList();
        List<Product> productList;
        // Store Loop inte än

        System.out.println("Welcome to the Shoeshop! \nplease login");
        while (!loggedIn) {
            activeCustomer = customerHandler.logIn(customerList);
            if (activeCustomer != null) {
                if (activeCustomer.getLoggedIn()) loggedIn = true;
            }
        }


        // Chose product to buy
        while (true) {
            // Produce customer store items
            productList = repository.loadProductList();
            productStore.generateStore(productList);

            System.out.println("Chose product (press 0 to exit)");
            int choice = scanner.nextInt();
            if (choice == 0) break;
            productStore.shopItem(choice, activeCustomer, productList);
        }





            //TODO
            // Between every update/cart etc list need to be retrieved from database

            // TODO
            // If there is time, remove test orders



    }
}