package ma.fstt.atelier3.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {
    private Product product;
    private int quantity = 0;

    public CartItem() {}

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        if (product == null || product.getPrice() == null) return BigDecimal.ZERO;
        return product.getPrice().multiply(java.math.BigDecimal.valueOf(quantity));
    }
}
