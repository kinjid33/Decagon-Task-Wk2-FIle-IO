import org.junit.Before;
import org.junit.Test;
import store.Store;
import store.user.Cashier;
import store.user.Customer;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer customer;
    Store store;
    Cashier cashier;
    @Before
    public void createCustomer(){
        store = new Store();
        store.readProduct();
        customer = new Customer("Adetunji", store);
        cashier = new Cashier("Fadekemi", store);
    }

    @Test
    public void testCustomerHasName(){
        assertEquals("Adetunji", customer.getUserName());
    }
    @Test
    public void testCanBuyProducts(){
        customer.buyProducts("Electric Iron", 2);
        customer.buyProducts("Fanta", 2);
        assertEquals(2, customer.getProductListInCustomer().size());
    }
}
