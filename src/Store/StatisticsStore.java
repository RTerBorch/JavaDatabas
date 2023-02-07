package Store;

import Database.Cart;
import Database.Order;
import Database.Product;
import Program.Library;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticsStore {

    public StatisticsStore(boolean test) {
        this.test = test;
    }

    boolean test;
    Scanner scanner = new Scanner(System.in);


    Library lib = new Library();

    StatisticsSearcher sizeFilter = (c, s) -> c.getSize().equalsIgnoreCase(s);
    StatisticsSearcher colorFilter = (c, s) -> c.getColor().equalsIgnoreCase(s);
    StatisticsSearcher brandFilter = (c, s) -> c.getBrand().equalsIgnoreCase(s);


/*
    I ditt huvudprogram, låt användaren välja vilken rapport som ska visas (detta kan göras genom att
            låta hen välja ett tal 1-5). Om användaren väljer 1 kan du be om en ytterligare inmatning där
    användaren får ange om hen vill söka på färg, storlek eller märke, och sedan värdet på storleken,
    färgen eller märket hen vill söka fram.

 */

    public void filterListByCart(String searchValue, StatisticsSearcher ss) {
        // Higher function, different outcome depending on String input and the use of the interface StatisticsSearcher

        List<Cart> filteredList = lib.getCartList().stream().filter(c -> ss.search(c.getProduct(), searchValue)).toList();
        filteredList.forEach(c ->
                System.out.println(c.productData() + c.customerData()));

        if (filteredList.size() == 0) System.out.println("No matching results");
    }


    public void runStatistics(int choice) {

        // refresh all lists from database
        lib.refreshLists();

        switch (choice) {

            case 1 -> {
                //1. En rapport som listar alla kunder, med namn och adress, som har handlat varor i en viss
                // storlek, av en viss färg eller av ett visst märke.
                String attribute;
                System.out.println("What attribute do you want to search for");
                System.out.println("Size, Color, Brand");
                if (!test) attribute = scanner.nextLine();
                else attribute = "brand";

                String searchValue;
                System.out.println("what input value?: ");
                if (!test) searchValue = scanner.nextLine();
                else searchValue = "ecco";


                if (attribute.equalsIgnoreCase("size")) {
                    filterListByCart(searchValue, sizeFilter);
                } else if (attribute.equalsIgnoreCase("color")) {
                    filterListByCart(searchValue, colorFilter);
                } else if (attribute.equalsIgnoreCase("brand")) {
                    filterListByCart(searchValue, brandFilter);
                }
            }
            case 2 -> {
                //2. En rapport som listar alla kunder och hur många ordrar varje kund har lagt. Skriv ut namn
                //och sammanlagda antalet ordrar för varje kund.

                Map<Integer, Long> countForCustomerId = lib.getOrderList().stream()
                        .collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting()));

                lib.getCustomerList().forEach(c -> {
                    System.out.println(c.customerData() + "Has shopped: " + countForCustomerId.get(c.getId()) + " Times");

                });

            }
            case 3 -> {
                System.out.println("3 Under construction");
            }
            case 4 -> {
                System.out.println("4 Under construction");
            }
            case 5 -> {
                //5. En topplista över de mest sålda produkterna som listar varje modell och hur många ex som
                //har sålts av den modellen. Skriv ut namn på modellen och hur många ex som sålts.

                List<Cart> cartList = lib.getCartList();
                Map<Integer, Long> countForProductId = cartList.stream()
                        .collect(Collectors.groupingBy(Cart::getProductId, Collectors.counting()));

                List<Product> productList = lib.getProductList();

                productList.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        // countForProductId.get(o1.getId())
                        if (countForProductId.get(o1.getId()) == countForProductId.get(o2.getId())) {
                            return 0;
                        } else if (countForProductId.get(o1.getId()) > countForProductId.get(o2.getId())) {
                            return -1;
                        }
                        return 1;
                    }
                });

                lib.getProductList().forEach(c -> {
                    System.out.println(c.productData() + "Sold: " + countForProductId.get(c.getId()) + " Times");
                });
            }
            case 0 -> {
                System.exit(0);
            }
            default -> {
                // TODO FIX LOOP
                System.out.println("invalid choice");
            }
        }

    }


}


