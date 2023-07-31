import org.junit.Before;
import org.junit.Test;
import store.Store;
import store.user.Cashier;
import store.user.Manager;
import store.user.PotentialCashier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ManagerTest {
    Store store;
    Manager manager;
    Cashier cashier;
    PotentialCashier applicant;
    @Before
    public void createManager() {
        store = new Store();
        manager = new Manager("dada", store);
        cashier = new Cashier("Olumide", store);
        applicant = new PotentialCashier("Olaide", 20,store);
    }
    @Test
    public void testManagerUsername(){
        assertEquals("dada", manager.getUserName());
    }
    @Test
    public void canStrikeCashier(){
        manager.strikeCashier(cashier);
        manager.strikeCashier(cashier);
        manager.strikeCashier(cashier);

        assertEquals(3, cashier.getStrikeCount());
    }
    @Test
    public void canHireCashier(){
        manager.hireCashier(applicant);
        assertTrue(applicant.isHired());
    }
    @Test
    public void canFireCashier(){
        manager.strikeCashier(cashier);
        manager.strikeCashier(cashier);
        manager.strikeCashier(cashier);
        manager.fireCashier(cashier);
        assertTrue(cashier.isFired());
    }
}
