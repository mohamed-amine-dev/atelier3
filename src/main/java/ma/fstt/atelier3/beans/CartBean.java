package ma.fstt.atelier3.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import ma.fstt.atelier3.model.CartItem;
import ma.fstt.atelier3.model.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Named("cart")
@SessionScoped
public class CartBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public CartBean() {
        // Initialize empty map
        items = new LinkedHashMap<>();
    }

    private Map<Long, CartItem> items = new LinkedHashMap<>();

    public void add(Product product) {
        if (product == null || product.getId() == null) return;
        CartItem it = items.get(product.getId());
        if (it == null) {
            it = new CartItem(product, 1);
            items.put(product.getId(), it);
        } else {
            it.setQuantity(it.getQuantity() + 1);
        }
    }

    public void remove(Long productId) {
        items.remove(productId);
    }

    public void updateQuantity(Long productId, int qty) {
        CartItem it = items.get(productId);
        if (it != null) {
            if (qty <= 0) items.remove(productId);
            else it.setQuantity(qty);
        }
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items.values());
    }

    public BigDecimal getTotal() {
        return items.values().stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int getCount() {
        return items.values().stream().mapToInt(CartItem::getQuantity).sum();
    }
}
