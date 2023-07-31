import org.junit.Before;
import org.junit.Test;
import store.Store;
import store.product.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductTest {
    Store store;
    Product product;
    @Before
    public void createProduct(){
        store = new Store();
        store.readProduct();
    }
    @Test
    public void canReadProduct(){
        assertTrue(store.getProductList().size() > 0);
    }
}
