package Store;

import Databas.Product;

@FunctionalInterface
public interface StatisticsSearcher {
    boolean search(Product product, String searchValue);
}
