package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Owns the product catalogue and the rules about it.
 * No HTTP code here: no @GetMapping, no URLs, no status codes.
 */
@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    // Seed one of each subclass into the SAME List<Product> — no cast, no second list.
    public ProductService() {
        products.add(new DigitalProduct(
                nextId++, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2));

        products.add(new PhysicalProduct(
                nextId++, "27-inch Monitor", 249.99,
                5.4, "61cm x 41cm x 18cm"));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))   // .equals(), never == for Long
                .findFirst();
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);   // use the value, then add one
        products.add(product);
        return product;
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));   // safe: no for-loop removal
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))   // partial match
                .toList();
    }

    public List<Product> findCheaperThan(double price) {
        return products.stream()
                .filter(p -> p.getPrice() < price)
                .toList();
    }
}
