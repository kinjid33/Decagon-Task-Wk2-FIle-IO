package store.interfaces;

import store.user.Cashier;
import store.user.PotentialCashier;

public interface ManagerInterface {
    void strikeCashier(Cashier cashier);
    void fireCashier(Cashier cashier);
    void hireCashier(PotentialCashier applicant);
}
