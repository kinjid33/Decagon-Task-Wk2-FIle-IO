package store;

import store.product.Product;
import store.user.Cashier;
import store.user.Customer;
import store.user.Manager;
import store.user.PotentialCashier;

//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.readProduct();
        Manager manager = new Manager("Ade", store);
        Cashier cashier = new Cashier("Bola", store);
        Cashier cashier1 = new Cashier("Tobi", store);
        Customer customer = new Customer("Chris", store);




        List<Customer> customerList = new ArrayList<>();

        PotentialCashier applicant = new PotentialCashier("Kale", 20, store);
//        PotentialCashier applicant2 = new PotentialCashier("Femi", 16);

        manager.hireCashier(applicant);
//        manager.hireCashier(applicant2);

        manager.strikeCashier(cashier1);
        manager.strikeCashier(cashier1);
        manager.strikeCashier(cashier1);
        manager.fireCashier(cashier1);

        manager.strikeCashier(applicant);

        customer.buyProducts("7Up", 1);
        cashier.makeSale(customer);
//        System.out.println(customer.getCustomerList());
    }
}
