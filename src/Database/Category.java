package Database;

public class Category {

    private int id;
    private String categoryName;
    private  int productId;
    private Product product;

    public Category() {
    }

    public Category(int id, String categoryName, int productId) {
        this.id = id;
        this.categoryName = categoryName;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
