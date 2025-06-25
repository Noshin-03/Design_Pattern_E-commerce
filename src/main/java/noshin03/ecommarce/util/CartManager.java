package noshin03.ecommarce.util;

import noshin03.ecommarce.model.Product;
import java.util.HashMap;
import java.util.Map;

public class CartManager {
    private static CartManager instance;
    private final Map<Product, Integer> cartItems;

    private CartManager() {
        cartItems = new HashMap<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addToCart(Product product, int quantity) {
        cartItems.merge(product, quantity, Integer::sum);
    }

    public Map<Product, Integer> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }
}
