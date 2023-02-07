package Store;

import Database.Product;

@FunctionalInterface
public interface StatisticsSearcher {
    boolean search(Product product, String searchValue);
}
