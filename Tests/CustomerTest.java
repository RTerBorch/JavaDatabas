import Database.*;
import Program.CustomerHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {



    @Test
    public void welcomeCustomer(){
        CustomerHandler customerHandler = new CustomerHandler(true);
        List<Customer> cl = new ArrayList<>();

        Customer customer = new Customer(1,"testName","",""
                ,"","","","testMail","testPass");

        cl.add(customer);

        customerHandler.welcomeCustomer(cl);

        assert customer.geteMail().equals("testMail");
        assert customer.getCustomerPassWord().equals("testPass");


    }


    @Test
    public void testCustomerLogIn() {
        CustomerHandler customerHandler = new CustomerHandler(true);
        List<Customer> cl = new ArrayList<>();

        Customer customer = new Customer(1,"testName","",""
                ,"","","","testMail","testPass");

        cl.add(customer);

        customerHandler.welcomeCustomer(cl);

        Customer activeCustomer = customerHandler.logIn(cl);

        assert activeCustomer.getLoggedIn();
        assert activeCustomer.getFirstName().equalsIgnoreCase("testName");
    }
}


