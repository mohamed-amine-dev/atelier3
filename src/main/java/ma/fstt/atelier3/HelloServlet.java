package ma.fstt.atelier3;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import ma.fstt.atelier3.model.Product;
import ma.fstt.atelier3.service.ProductService;

import java.io.*;
import java.util.List;

@WebServlet(name = "productApiServlet", value = "/api/products/*")
public class HelloServlet extends HttpServlet {
    
    @Inject
    private ProductService productService;
    
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        String pathInfo = request.getPathInfo();
        
        try (PrintWriter out = response.getWriter()) {
            if (pathInfo == null || pathInfo.equals("/")) {
                // List all products
                List<Product> products = productService.listAll();
                out.println(objectMapper.writeValueAsString(products));
            } else {
                // Get single product
                String[] splits = pathInfo.split("/");
                if (splits.length == 2) {
                    try {
                        Long id = Long.parseLong(splits[1]);
                        Product product = productService.find(id);
                        if (product != null) {
                            out.println(objectMapper.writeValueAsString(product));
                        } else {
                            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                            out.println("{\"error\": \"Product not found\"}");
                        }
                    } catch (NumberFormatException e) {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        out.println("{\"error\": \"Invalid product ID\"}");
                    }
                }
            }
        }
    }
    
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }
}