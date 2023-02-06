import Databas.*;
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

            StatisticsStore statisticsStore = new StatisticsStore(false);
            statisticsStore.runStatistics(scanner.nextInt());

        }





        }
}


        /*

        // TODO Lägg till felhantering i addToCart!! G - sidan

        // TODO FUNKTIONSGRÄNSSNITT ÄVEN FÖR G OCH HÖGRE ORDNINGEN

        // TODO Gränssnitt, formatera text. Använd detta för kund butiken även.



        // TODO VÄLJ RAPPORT MED METOD
         // TODO DETTA:
        I ditt huvudprogram, låt användaren välja vilken rapport som ska visas (detta kan göras genom att
                låta hen välja ett tal 1-5). Om användaren väljer 1 kan du be om en ytterligare inmatning där
        användaren får ange om hen vill söka på färg, storlek eller märke, och sedan värdet på storleken,
        färgen eller märket hen vill söka fram.



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



  */
