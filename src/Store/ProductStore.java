package Store;

import Databas.Customer;
import Databas.Order;
import Databas.Product;
import Databas.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductStore {

    Scanner scanner = new Scanner(System.in);
    private List<Product> filteredProductList;
    private Boolean test = false;

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public List<Product> getFilteredProductList() {
        return filteredProductList;
    }

    public void setFilteredProductList(List<Product> filteredProductList) {
        this.filteredProductList = filteredProductList;
    }


    // Generates store with only products in stock and format them in a more orderly fashion.
    public void generateStore(List<Product> productList) {
        Formater formater = new Formater();

        final int[] rowNr = {1};
        filteredProductList = productList.stream().filter(e -> e.getQuantity() > 0).toList();
        filteredProductList.forEach(p -> p.setRowNr(rowNr[0]++));

        if (!test) {
            // Format and print the message if not test
            filteredProductList.forEach(p -> System.out.println(p.getRowNr() + " " + p.getProductName() +
                    formater.alignProducts(p.getProductName()) +
                    "(Q:" + p.getQuantity() +
                    "),(Price:" + p.getPrice() + ")"));
        }


    }


    public int generateOrderNr() {
        Repository repository = new Repository();
        boolean match = true;
        int orderNr = 1;

        List<Order> orderList = repository.loadOrderList();
        ArrayList<Integer> orderNrList = new ArrayList<>();

        // Put in int orderId into separate list
        orderList.forEach(order -> orderNrList.add(order.getId()));

        // Searching for orderNr match, if not found, this will be our new orderNr.
        while (match) {
            match = orderNrList.contains(orderNr);
            orderNr++;
        }

        return orderNr;
    }

    public void shopItem(int choice, Customer activeCustomer, List<Product> productList) {
        // rowNr = choice

        List<Product> filteredList = productList.stream().filter(e -> e.getRowNr() == choice).toList();
        System.out.println("Items: " + filteredList.size());

        Product chosenProduct = filteredList.get(0);

        System.out.println(chosenProduct.getProductName() + " Size" + chosenProduct.getSize() + " Color:" + chosenProduct.getColor());
        System.out.println("How many would you like to order? there is currently " + chosenProduct.getQuantity() + " left in stock.");

        int amount;
        while (true) {

            if (test) amount = 5;
            else amount = scanner.nextInt();

            if (amount <= chosenProduct.getQuantity() && amount >= 1) {
                break;
            } else {
                System.out.println("You have registered the wrong amount of items.");
            }
            System.out.println("Please try again");
            if (test) break;
        }

        // Runs the order as many times as the chosen amount to purchase
        int activeOrder = generateOrderNr();
        Repository repository = new Repository();
        System.out.println("You have registered " + amount + " " + chosenProduct.getProductName());
        for (int i = 0; i < amount; i++) {
            repository.callStoredProcedure("addtocart", activeOrder, activeCustomer, chosenProduct);
        }


    }


}
