package store.user;

import store.Store;
import store.interfaces.CustomerInterface;
import store.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User implements CustomerInterface {
//    description of entity
    private final Description description;
//    cash in customers hand, initialised to $20,000 in constructor
    private int cashInHand;
//    Store object related to the class
    private Store store;
//    array list of products in customer class
    private List<Product> productListInCustomer;

//    private String productToPurchase;
//    quantity of product customer wants to buy
    private int quantityToBuy;
//    array list of customers
    private List<Customer> customerList = new ArrayList<>();
//    private Customer customer;

    public Customer(String userName, Store store) {
        super(userName);
        this.description = Description.CUSTOMER;
        this.cashInHand = 20_000;
        this.productListInCustomer = new ArrayList<>();
        this.store = store;
    }

//    public List<Customer> getCustomerList() {
//        return customerList;
//    }

    @Override
    public void buyProducts(String productToBuy, int qtyToBuy){
//        Logic for buying products
//        Iterate through product list gotten from store class
        for(Product a: store.getProductList()){
//            If product name is found in product list gotten from store class
            if(a.getName().contains(productToBuy)) {
//                check if product is in stock
                if (a.getQtyInStock() < 1) {
                    System.out.println("OUT OF STOCK"); //product is out of stock
                }
//                check if quantity to buy is greater than quantity in stock
                else if (qtyToBuy > a.getQtyInStock()) {
                    System.out.println("Sorry only " + a.getQtyInStock() + " available"); //quantity to buy is more than quantity in stock
                } else{
                    System.out.println(productToBuy+" successfully added to cart."); //all checks passed
//                    Adds product customer wants to buy to product list
                    productListInCustomer.add(a);
//                    sets quantity to buy to the given value (passed as argument)
                    quantityToBuy = qtyToBuy;
                }
            }
        }
//        return customerList;
    }

//    getter for product to buy list (cart)
    public List<Product> getProductListInCustomer() {
        return productListInCustomer;
    }
//    getter for quantity to buy
    public int getQuantityToBuy() {
        return quantityToBuy;
    }
//    getter for cash in hand
    public int getCashInHand() {
        return cashInHand;
    }
//    setter for cash in hand. Subtracts amount of product, passed in cashier make sale method
    public void setCashInHand(int amount) {
        this.cashInHand -= amount;
    }
}
