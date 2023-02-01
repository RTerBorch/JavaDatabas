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
        ProductStore productStore = new ProductStore(false);
        PrintMessage printMessage = new PrintMessage();

        // Customer + Product list
        lib.refreshLists(r.loadCustomerList(), r.loadProductList(), r.loadOrderList(),r.loadCartList(),r.loadCategoryList());

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
            lib.refreshLists(r.loadCustomerList(), r.loadProductList(), r.loadOrderList(),r.loadCartList(),r.loadCategoryList());
            productStore.generateStore(lib.getProductList());

            System.out.println("Chose product (press 0 to exit)");
            int choice = scanner.nextInt();
            if (choice == 0) break;

            productStore.shopItem(choice, activeCustomer, lib.getProductList(), lib.getOrderList());
        }

        // Uppdaterar lista
        lib.refreshLists(r.loadCustomerList(), r.loadProductList(), r.loadOrderList(),r.loadCartList(),r.loadCategoryList());

        // stoppa in kunder i order

        orderList.forEach(order -> System.out.println(order.getCustomer().getFirstName()));

        // TODO LÄGGA TILL KATEGORI TILL PRODUKT?

        //TODO
        // Between every update/cart etc list need to be retrieved from database

        // TODO

        // En rapport som listar alla kunder, med namn och adress, som har handlat varor i en viss
        //storlek, av en viss färg eller av ett visst märke.

        //2. En rapport som listar alla kunder och hur många ordrar varje kund har lagt. Skriv ut namn
        //och sammanlagda antalet ordrar för varje kund.

        //3. En rapport som listar alla kunder och hur mycket pengar varje kund, sammanlagt, har
        //beställt för. Skriv ut varje kunds namn och summa.

        //4. En rapport som listar beställningsvärde per ort. Skriv ut orternas namn och summa.

        //5. En topplista över de mest sålda produkterna som listar varje modell och hur många ex som
        //har sålts av den modellen. Skriv ut namn på modellen och hur många ex som sålts.


    }
}