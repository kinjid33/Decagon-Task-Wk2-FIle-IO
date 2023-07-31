import org.junit.Before;
import org.junit.Test;
import store.Store;
import store.user.Cashier;
import store.user.Customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CashierTest {
    Cashier cashier;
    Store store;
    Customer customer;
    @Before
    public void createCashier(){
        store = new Store();
        store.readProduct();
        cashier = new Cashier("Adebayo", store);
        customer = new Customer("Bamidele", store);
    }
    @Test
    public void testCashierCanMakeSales(){
        customer.buyProducts("Sprite", 2);
        cashier.makeSale(customer);
        assertTrue(cashier.isCheckOut());
    }
}
