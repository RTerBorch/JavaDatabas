package Database;

public class Repository {
    /*

    private Loadable<Cart> cartLoader = new CartLoader();
    private Loadable<Category> categoryLoader = new CategoryLoader();
    private Loadable<Customer> customerLoader = new CustomerLoader();
    private Loadable<Order> orderLoader = new OrderLoader();
    private Loadable<Product> productLoader = new ProductLoader();


    public List<Cart> loadCartList() {
        return cartLoader.load();
    }

    public List<Category> loadCategoryList() {
        return categoryLoader.load();
    }


    public List<Customer> loadCustomerList() {
        return customerLoader.load();
    }

    public List<Order> loadOrderList() {
        return orderLoader.load();
    }

    public List<Product> loadProductList() {
        return productLoader.load();
    }

    private List<Product> productList;
    private List<Customer> customerList;
    private List<Order> orderList;
    private List<Cart> cartList;
    private List<Category> categoryList;

    final Properties p = new Properties();

    public <T> List<T> loadData(Loadable<T> loader) {
        return loader.load();
    }


    // Collects all customers into list.
    private void generateListFor(String type) {

        String sqlString = "";

        switch (type) {
            case "CUSTOMER" -> {
                sqlString =
                        "select id, firstName, lastName,address,district,zipCode," +
                                "phoneNr, customerPassWord,eMail from customer";
                customerList = new ArrayList<>();
            }
            case "PRODUCT" -> {
                sqlString =
                        "select product.id, productName, brand, price, quantity, color, size from product\n" +
                                "join color on colorId = color.id\n" +
                                "join size on sizeId = size.id;";
                productList = new ArrayList<>();
            }
            case "ORDER" -> {
                sqlString =
                        "select orders.id, customerId, purchaseDate from orders";
                orderList = new ArrayList<>();
            }
            case "CART" -> {
                sqlString =
                        "select cart.id, orderId, productId from cart";
                cartList = new ArrayList<>();
            }
            case "CATEGORY" -> {
                sqlString =
                        "select categoryMapping.id, productId, category from categoryMapping join category on categoryId = category.id";
                categoryList = new ArrayList<>();
            }
        }

        try {
            p.load(new FileInputStream("src/settings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));

             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sqlString)) {


            while (rs.next()) {


                if (type.equals("CUSTOMER")) {
                    Customer customer = new Customer();
                    int id = rs.getInt("id");
                    customer.setId(id);

                    String firstName = rs.getString("firstName");
                    customer.setFirstName(firstName);

                    String lastName = rs.getString("lastName");
                    customer.setLastName(lastName);

                    String address = rs.getString("address");
                    customer.setAddress(address);

                    String district = rs.getString("district");
                    customer.setDistrict(district);

                    String zipCode = rs.getString("zipCode");
                    customer.setZipCode(zipCode);

                    String phoneNr = rs.getString("phoneNr");
                    customer.setPhoneNr(phoneNr);

                    String customerPassWord = rs.getString("customerPassWord");
                    customer.setCustomerPassWord(customerPassWord);

                    String eMail = rs.getString("eMail");
                    customer.seteMail(eMail);

                    customerList.add(customer);
                }


                if (type.equals("PRODUCT")) {

                    Product product = new Product();

                    int id = rs.getInt("id");
                    product.setId(id);

                    String productName = rs.getString("productName");
                    product.setProductName(productName);

                    String brand = rs.getString("brand");
                    product.setBrand(brand);

                    double price = rs.getDouble("price");
                    product.setPrice(price);

                    int quantity = rs.getInt("quantity");
                    product.setQuantity(quantity);

                    String color = rs.getString("color");
                    product.setColor(color);

                    String size = rs.getString("size");
                    product.setSize(size);

                    productList.add(product);
                }
                if (type.equals("ORDER")) {
                    Order order = new Order();
                    int id = rs.getInt("id");
                    order.setId(id);

                    int customerId = rs.getInt("customerId");
                    order.setCustomerId(customerId);

                    Timestamp purchaseDate = rs.getTimestamp("purchaseDate");
                    order.setPurchaseDate(purchaseDate);

                    orderList.add(order);
                }
                if (type.equals("CART")) {
                    Cart cart = new Cart();
                    int id = rs.getInt("id");
                    cart.setId(id);

                    int orderId = rs.getInt("orderId");
                    cart.setOrderId(orderId);

                    int productId = rs.getInt("productId");
                    cart.setProductId(productId);

                    cartList.add(cart);
                }
                if (type.equals("CATEGORY")) {
                    Category category = new Category();
                    int id = rs.getInt("id");
                    category.setId(id);

                    int productId = rs.getInt("productId");
                    category.setProductId(productId);

                    String categoryName = rs.getString("category");
                    category.setCategoryName(categoryName);

                    categoryList.add(category);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void addToCart(int orderId, Customer customer, Product product) {


        try {
            p.load(new FileInputStream("src/settings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(
                    p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"));


            CallableStatement callableStatement = connection.prepareCall("call AddToCart(?,?,?)");
            callableStatement.setInt(1, customer.getId()); //cart customerId
            callableStatement.setInt(2, orderId);           //cart orderId
            callableStatement.setInt(3, product.getId()); // cart productId


            resultSet = callableStatement.executeQuery();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

 */
}
            /*
            Felhantering kolla upp hur det fungerar, behöver databasen en kolumn error?
            String errorMessage = "";

            while(resultSet != null && resultSet.next()){
                errorMessage = resultSet.getString("error");
            }
            if (!errorMessage.equals("")) {
                return errorMessage;
            }

           */

