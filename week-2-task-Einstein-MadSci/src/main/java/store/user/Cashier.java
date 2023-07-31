package store.user;

import store.Store;
import store.interfaces.CashierInterface;
import store.product.Product;

public class Cashier extends User implements CashierInterface {
//    description of entity
    private final Description description;
//    store object related to this class
    private Store store;
//    number of strikes cashier has (3 == fired)
    private int strikeCount;
//    boolean indicating employment status
    private boolean isFired = false;
//    boolean recording whether a customer has been checked out
    private boolean checkOut;
//    constructor
    public Cashier(String userName, Store store) {
        super(userName);
        this.description = Description.CASHIER;
        this.store = store;
    }
// getter for strike count
    public int getStrikeCount() {
        return strikeCount;
    }
//  setter for strike count
    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }
//  getter for employment status boolean
    public boolean isFired() {
        return isFired;
    }
//  setter for employment status
    public void setFired(boolean fired) {
        isFired = fired;
    }
//    method for cashier to make sale
    @Override
    public void makeSale(Customer customer){
        int customerOriginalBalance = customer.getCashInHand();
        for(Product productInCustomer : customer.getProductListInCustomer()) {
            if ((customer.getCashInHand() > productInCustomer.getUnitPrice() * customer.getQuantityToBuy())) {
                customer.setCashInHand(productInCustomer.getUnitPrice() * customer.getQuantityToBuy());
                System.out.println("Customer bought: " + productInCustomer.getName()
                        + "\nQuantity: " + customer.getQuantityToBuy()
                        + "\n@ $" + productInCustomer.getUnitPrice() + " per unit"
                        + "\nCustomer paid: $" + customerOriginalBalance
                        + "\nChange: $" + customer.getCashInHand());
                checkOut = true;
            }
        }
    }

//    getter for checkout boolean
    public boolean isCheckOut() {
        return checkOut;
    }
}
