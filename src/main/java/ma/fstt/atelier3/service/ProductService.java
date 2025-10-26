package ma.fstt.atelier3.service;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import ma.fstt.atelier3.model.Product;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.List;

@Stateless
public class ProductService implements Serializable {
    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public List<Product> listAll() {
        TypedQuery<Product> q = em.createQuery("SELECT p FROM Product p ORDER BY p.id", Product.class);
        return q.getResultList();
    }

    public Product find(Long id) {
        return em.find(Product.class, id);
    }

    public Product save(Product p) {
        if (p.getId() == null) {
            em.persist(p);
            return p;
        } else {
            return em.merge(p);
        }
    }

    @PostConstruct
    private void initData() {
        // add sample data if table empty
        List<Product> current = em.createQuery("SELECT p FROM Product p", Product.class).setMaxResults(1).getResultList();
        if (current.isEmpty()) {
            save(new Product("Laptop", "Portable computer", new BigDecimal("799.99"), 10));
            save(new Product("Smartphone", "Latest model smartphone", new BigDecimal("499.99"), 25));
            save(new Product("Headphones", "Noise cancelling", new BigDecimal("149.99"), 50));
        }
    }
}
