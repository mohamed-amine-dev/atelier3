package ma.fstt.atelier3.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import ma.fstt.atelier3.model.Product;
import ma.fstt.atelier3.service.ProductService;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ProductBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Inject
    private ProductService productService;

    private List<Product> products;

    public List<Product> getProducts() {
        if (products == null) {
            products = productService.listAll();
        }
        return products;
    }
}
