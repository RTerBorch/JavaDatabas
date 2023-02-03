import Databas.*;
import Store.Formater;
import Store.PrintMessage;
import Store.ProductStore;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        boolean loggedIn = false;
        Customer activeCustomer = new Customer();
        Library lib = new Library();

        Scanner scanner = new Scanner(System.in);


        Repository r = new Repository();
        CustomerHandler customerHandler = new CustomerHandler();
        ProductStore productStore = new ProductStore(false);


        // Customer + Product list
        lib.refreshLists(r.loadCustomerList(), r.loadProductList(), r.loadOrderList(), r.loadCartList(), r.loadCategoryList());


        System.out.println("Welcome to the Shoeshop! \nplease login");
        while (!loggedIn) {

            activeCustomer = customerHandler.logIn(lib.getCustomerList());
            if (activeCustomer != null) {
                if (activeCustomer.getLoggedIn()) loggedIn = true;
                System.out.println("Welcome " + activeCustomer.getFirstName());
            }
        }

        // Chose product to buy
        while (true) {

            // if test login, move skip this
            if (activeCustomer.getFirstName().equals("test")) {
                break;
            }

            // Shows customer product list, press 0 to exit
            productStore.generateStore(lib.getProductList());
            System.out.println("Chose product (press 0 to exit)");
            int choice = scanner.nextInt();
            if (choice == 0) break;

            //
            productStore.shopItem(choice, activeCustomer, lib.getProductList(), lib.getOrderList());
            lib.refreshLists(r.loadCustomerList(), r.loadProductList(), r.loadOrderList(), r.loadCartList(), r.loadCategoryList());
        }

        // TODO VÄLJ RAPPORT MED METOD

        // En rapport som listar alla kunder, med namn och adress, som har handlat varor i en viss
        // storlek, av en viss färg eller av ett visst märke.

        // TODO GÖR DENNA I METOD OCH MED INTERFACE / HÖGRE ORDNING

        List<Cart> filterList;
        filterList = lib.getCartList().stream().filter(cart -> cart.getProduct().getSize().equals("39")).toList();
        filterList.forEach(c -> {
            System.out.print("Item: " + c.getProduct().getProductName() + ", \tCustomer: ");
            System.out.print(c.getOrder().getCustomer().getFirstName() + " ");
            System.out.println(c.getOrder().getCustomer().getAddress() + " ");
        });


        //2. En rapport som listar alla kunder och hur många ordrar varje kund har lagt. Skriv ut namn
        //och sammanlagda antalet ordrar för varje kund.


        //3. En rapport som listar alla kunder och hur mycket pengar varje kund, sammanlagt, har
        //beställt för. Skriv ut varje kunds namn och summa.

        //4. En rapport som listar beställningsvärde per ort. Skriv ut orternas namn och summa.

        //5. En topplista över de mest sålda produkterna som listar varje modell och hur många ex som
        //har sålts av den modellen. Skriv ut namn på modellen och hur många ex som sålts.


        // Så många som sålts av en produkt
        filterList = lib.getCartList();
        filterList = filterList.stream().filter(c -> c.getProductId() == 8).toList();

        System.out.println(filterList.size());
        filterList.forEach(cart -> System.out.println(cart.getProductId()));


        filterList = lib.getCartList();

      //  List<Thing> objects = new ArrayList<>(); // initalise as in the question


        // TODO LÖSNINGEN!! ANTALET SÅLDA PER CART

        Map<Integer, Long> countForProductId = filterList.stream()
                .collect(Collectors.groupingBy(Cart::getProductId, Collectors.counting()));

        System.out.println("KEY SET " + countForProductId.keySet());
        System.out.println(countForProductId);


                /*
        System.out.println("Test " + filterList.stream().mapToInt(Cart::getProductId).count());

        IntSummaryStatistics statistics = filterList.stream()
                .mapToInt(Cart::getProductId)
                .summaryStatistics();

        int min = statistics.getMin();
        long count = statistics.getSum();
        int max = statistics.getMax();

        System.out.println(min + " " + count + " " + max);

        long newStream = filterList.stream().map(Cart::getProductId).distinct().count();
        System.out.println(newStream);

                 */

    }
}