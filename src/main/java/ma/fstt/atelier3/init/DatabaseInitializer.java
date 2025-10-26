package ma.fstt.atelier3.init;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ma.fstt.atelier3.model.Product;
import java.math.BigDecimal;

@Singleton
@Startup
public class DatabaseInitializer {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        // Check if we already have products
        Long count = em.createQuery("SELECT COUNT(p) FROM Product p", Long.class)
                      .getSingleResult();
        
        if (count == 0) {
            // Add sample products
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
    }

    private void addProduct(String name, String description, double price) {
        Product product = new Product(name, description, BigDecimal.valueOf(price), 100); // Setting initial stock to 100
        em.persist(product);
    }
}