package Store;

import Database.Customer;
import Database.Order;
import Database.Product;

import Database.StoredProcedures.StoredProcedure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductStore {

    Scanner scanner = new Scanner(System.in);
    private List<Product> filteredProductList;
    private Boolean test;

    public ProductStore(Boolean test) {
        this.test = test;
    }

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

        // Generate rowNr for everyProduct that's not their databaseId. Skip items with 0 in stock.
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

    public int generateOrderNr(List<Order> orderList) {
        // This method will look for a match with orders, otherwise generate a new order with the number above last found
        // if empty.


        boolean match = true;
        int orderNr = 1;

        ArrayList<Integer> NewListOfOrderNr = new ArrayList<>();

        // Put in int orderId into separate list
        orderList.forEach(order -> NewListOfOrderNr.add(order.getId()));

        // Searching for orderNr match, if not found, this will be our new orderNr.
        while (match) {
            match = NewListOfOrderNr.contains(orderNr);
            if (match) {
                orderNr++;
            }
        }

        return orderNr;
    }

    public void shopItem(int choice, Customer activeCustomer, List<Product> productList, List<Order> orderList) {

        // Filter item from productList where chosen item then get this item as chosenProduct.
        List<Product> filteredList = productList.stream().filter(e -> e.getRowNr() == choice).toList();
        Product chosenProduct = filteredList.get(0);

        if (!test) {
            // If not test, ask how many to buy
            System.out.println(chosenProduct.getProductName() + " Size" + chosenProduct.getSize() + " Color:" + chosenProduct.getColor());
            System.out.println("How many would you like to order? there is currently " + chosenProduct.getQuantity() + " left in stock.");
        }
        int orderAmount;
        while (true) {

            // Order amount input
            if (test) orderAmount = 5;
            else orderAmount = scanner.nextInt();

            // If order amount is wrong the customer must write another amount.
            if (orderAmount <= chosenProduct.getQuantity() && orderAmount >= 1) {
                break;
            } else {
                System.out.println("You have registered the wrong amount of items.");
            }
            System.out.println("Please try again");
            if (test) break;
        }


        // Generate orderNumber
        int activeOrderNr = generateOrderNr(orderList);

        // Class that runs stored procedures
        StoredProcedure sp = new StoredProcedure();

        if (!test) System.out.println("You have registered " + orderAmount + " " + chosenProduct.getProductName());

        // Runs the order as many times as the chosen amount to purchase
        for (int i = 0; i < orderAmount; i++) {
            // AddToCart
            sp.addToCart(activeOrderNr,activeCustomer,chosenProduct);
        }


    }


}
