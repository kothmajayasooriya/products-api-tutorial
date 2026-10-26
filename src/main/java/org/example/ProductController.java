package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/tutorial2/{id}")
    public Product getById(@PathVariable Long id) {
        return new PhysicalProduct(id, "Laptop", 999.99, 2.0, "35cm x 25cm x 2cm");
    }

    // ---------- Tutorial 3 ----------
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody DigitalProduct product) {
        // Product is abstract, so Jackson cannot build it from JSON.
        // Temporary fix: accept a concrete subclass.
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }

}