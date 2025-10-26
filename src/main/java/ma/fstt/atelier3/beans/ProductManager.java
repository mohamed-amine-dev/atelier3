package ma.fstt.atelier3.beans;

import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.annotation.PostConstruct;
import ma.fstt.atelier3.model.Product;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import jakarta.transaction.Transactional;

@Named
@Stateless
@Transactional
public class ProductManager implements Serializable {
    
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    @PostConstruct
    public void init() {
        if (getAllProducts().isEmpty()) {
            initializeProducts();
        }
    }

    private void initializeProducts() {
        addProduct("Laptop Pro X1", "High-performance laptop with 16GB RAM and 512GB SSD", 1299.99);
        addProduct("Smartphone Y20", "Latest smartphone with 6.5\" display and 5G", 799.99);
        addProduct("Wireless Earbuds", "True wireless earbuds with noise cancellation", 149.99);
        addProduct("Smart Watch", "Fitness tracking smartwatch with heart rate monitor", 199.99);
        addProduct("4K Monitor", "27\" 4K Ultra HD Monitor with HDR", 399.99);
        addProduct("Gaming Mouse", "RGB gaming mouse with 16000 DPI sensor", 79.99);
        addProduct("Mechanical Keyboard", "RGB mechanical keyboard with Cherry MX switches", 129.99);
        addProduct("Tablet Pro", "10.9\" tablet with retina display", 599.99);
        addProduct("Wireless Charger", "15W fast wireless charging pad", 39.99);
        addProduct("Bluetooth Speaker", "Portable waterproof bluetooth speaker", 89.99);
    }

    private void addProduct(String name, String description, double price) {
        Product product = new Product(name, description, BigDecimal.valueOf(price), 100);
        em.persist(product);
    }

    public List<Product> getAllProducts() {
        return em.createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
    }

    public int getProductCount() {
        Long count = em.createQuery("SELECT COUNT(p) FROM Product p", Long.class)
                .getSingleResult();
        return count.intValue();
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }
}