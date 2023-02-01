import Databas.*;
import Store.Formater;
import Store.PrintMessage;
import Store.ProductStore;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean loggedIn = false;
        Customer activeCustomer = new Customer();
        Library lib = new Library();

        Scanner scanner = new Scanner(System.in);

        Formater formater = new Formater();
        Repository r = new Repository();
        CustomerHandler customerHandler = new CustomerHandler();
        ProductStore productStore = new ProductStore();
        PrintMessage printMessage = new PrintMessage();

        // Customer + Product list
        lib.refreshLists(r.loadCustomerList(), r.loadProductList(), r.loadOrderList());

        List<Customer> customerList = r.loadCustomerList();
        List<Product> productList = r.loadProductList();
        List<Order> orderList = r.loadOrderList();

        // Store Loop inte än


        // TODO if admin, skip to staff screen ( admin in database customer? )
        System.out.println("Welcome to the Shoeshop! \nplease login");
        while (!loggedIn) {
            activeCustomer = customerHandler.logIn(lib.getCustomerList());
            if (activeCustomer != null) {
                if (activeCustomer.getLoggedIn()) loggedIn = true;
            }
        }

        // Chose product to buy
        while (true) {
            // Refresh all lists +
            // Produce customer store items
            lib.refreshLists(r.loadCustomerList(), r.loadProductList(), r.loadOrderList());
            productStore.generateStore(lib.getProductList());

            System.out.println("Chose product (press 0 to exit)");
            int choice = scanner.nextInt();
            if (choice == 0) break;

            productStore.shopItem(choice, activeCustomer, lib.getProductList(), lib.getOrderList());
        }

        // Uppdaterar lista
        lib.refreshLists(r.loadCustomerList(), r.loadProductList(), r.loadOrderList());

        // stoppa in kunder i order

        orderList.forEach(order -> System.out.println(order.getCustomer().getFirstName()));


        //TODO
        // Between every update/cart etc list need to be retrieved from database

        // TODO
        // If there is time, remove test orders


    }
}