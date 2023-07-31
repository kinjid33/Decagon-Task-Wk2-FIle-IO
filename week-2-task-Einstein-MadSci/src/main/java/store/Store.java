package store;

import store.interfaces.StoreInterface;
import store.product.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Store implements StoreInterface {
    List<Product> productList = new ArrayList<>();
    @Override
    public void readProduct() {
        String csvFilePath = "src/main/resources/Convenience-Store-Inventory-List (1).csv";
        String line = "";
        {
            try {
//                reads product data from csv file
                BufferedReader reader = new BufferedReader((new FileReader(csvFilePath)));
                while ((line = reader.readLine()) != null) {
//                    splits read data into a String array
                    String[] lines = line.split(",");
//                    creates and initialises a product object with the columns in the csv file Inventory number, product name, product description, product price, qty of product in stock, total value of product in stock
                    Product product = new Product(lines[0], lines[1], lines[2], Integer.parseInt(lines[3]), Integer.parseInt(lines[4]), Integer.parseInt(lines[5]));
//                    adds product object to product array list
                    productList.add(product);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    getter for the product list
    public List<Product> getProductList(){
        return productList;
    }
}