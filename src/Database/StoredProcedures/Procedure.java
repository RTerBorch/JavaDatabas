package Database.StoredProcedures;

import Database.Customer;
import Database.Product;

public interface Procedure {
    void addToCart(int orderId, Customer customer, Product product);
}
