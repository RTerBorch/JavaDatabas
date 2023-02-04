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

        // TODO Lägg till felhantering i addToCart!! G - sidan

        // TODO FUNKTIONSGRÄNSSNITT ÄVEN FÖR G OCH HÖGRE ORDNINGEN

        // TODO Gränssnitt, formatera text. Använd detta för kund butiken även.



        // TODO VÄLJ RAPPORT MED METOD
        /* // TODO DETTA:
        I ditt huvudprogram, låt användaren välja vilken rapport som ska visas (detta kan göras genom att
                låta hen välja ett tal 1-5). Om användaren väljer 1 kan du be om en ytterligare inmatning där
        användaren får ange om hen vill söka på färg, storlek eller märke, och sedan värdet på storleken,
        färgen eller märket hen vill söka fram.

         */

        // En rapport som listar alla kunder, med namn och adress, som har handlat varor i en viss
        // storlek, av en viss färg eller av ett visst märke.

        // TODO GÖR DENNA I METOD OCH MED INTERFACE / HÖGRE ORDNING
        System.out.println("UPPGIFT 1");

        List<Cart> filterList;
        filterList = lib.getCartList().stream().filter(cart -> cart.getProduct().getSize().equals("39")).toList();
        filterList.forEach(c -> {
            System.out.print("Item: " + c.getProduct().getProductName() + ", \tCustomer: ");
            System.out.print(c.getOrder().getCustomer().getFirstName() + " ");
            System.out.println(c.getOrder().getCustomer().getAddress() + " ");
        });


        //2. En rapport som listar alla kunder och hur många ordrar varje kund har lagt. Skriv ut namn
        //och sammanlagda antalet ordrar för varje kund.

        System.out.println("UPPGIFT 2");
        List<Order> filterListOrder = lib.getOrderList();

        Map<Integer, Long> countForCustomerId = filterListOrder.stream()
                .collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting()));

        System.out.println("KEY SET " + countForCustomerId.keySet());
        System.out.println(countForCustomerId);


        //3. En rapport som listar alla kunder och hur mycket pengar varje kund, sammanlagt, har
        //beställt för. Skriv ut varje kunds namn och summa.

        //4. En rapport som listar beställningsvärde per ort. Skriv ut orternas namn och summa.

        //5. En topplista över de mest sålda produkterna som listar varje modell och hur många ex som
        //har sålts av den modellen. Skriv ut namn på modellen och hur många ex som sålts.


        // Så många som sålts av en produkt
        System.out.println("UPPGIFT 5");
        filterList = lib.getCartList();

        // TODO LÖSNINGEN!! ANTALET SÅLDA PER CART

        Map<Integer, Long> countForProductId = filterList.stream()
                .collect(Collectors.groupingBy(Cart::getProductId, Collectors.counting()));

        System.out.println("KEY SET " + countForProductId.keySet());
        System.out.println(countForProductId);




    }
}