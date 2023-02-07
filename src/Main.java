import Database.*;
import Program.CustomerHandler;
import Program.Library;
import Store.ProductStore;
import Store.StatisticsStore;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Customer activeCustomer;
        CustomerHandler cHandler = new CustomerHandler(false);
        ProductStore productStore = new ProductStore(false);

        Library lib = new Library();

        // Update/refresh data from dataBase
        lib.refreshLists();

        // Log in customer, return active customer
        activeCustomer = cHandler.welcomeCustomer(lib.getCustomerList());

        while (true) {
            // if test login, move skip this
            if (activeCustomer.getFirstName().equals("test")) {
                break;
            }

            // Shows customer product list, press 0 to exit
            productStore.generateStore(lib.getProductList());

            // Chose what item to buy then place it in cart.
            System.out.println("Chose product (press 0 to exit)");
            int choice = scanner.nextInt();
            if (choice == 0) break;
            productStore.shopItem(choice, activeCustomer, lib.getProductList(), lib.getOrderList());

            // Update list after every purchase.
            lib.refreshLists();
        }

        if (activeCustomer.getFirstName().equals("test")){

            System.out.println("What statistics would you like to run?");
            System.out.println("1. List customers that purchased item based on size, color, brand?");
            System.out.println("2. List how many orders every customer has placed.");
            System.out.println("3. Under construction");
            System.out.println("4. Under construction");
            System.out.println("5. List of items sold sorted by most sold items");


            StatisticsStore statisticsStore = new StatisticsStore(false);
            statisticsStore.runStatistics(scanner.nextInt());

        }


        }
}


