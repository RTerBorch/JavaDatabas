import Databas.Customer;
import Databas.CustomerHandler;
import Databas.Order;
import Databas.Repository;
import org.junit.Test;

import java.util.List;

public class CustomerTest {



    @Test
    public void testCustomerLogIn() {
        CustomerHandler customerHandler = new CustomerHandler();
        customerHandler.setTest(true);
        Repository repository = new Repository();

        Customer activeCustomer = customerHandler.logIn(repository.loadCustomerList());

        assert activeCustomer.getLoggedIn();
        assert activeCustomer.getFirstName().equalsIgnoreCase("robin");
    }
}


