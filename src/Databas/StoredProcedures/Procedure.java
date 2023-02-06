package Databas.StoredProcedures;

import Databas.Customer;
import Databas.Product;

public interface Procedure {
    void addToCart(int orderId, Customer customer, Product product);
}
