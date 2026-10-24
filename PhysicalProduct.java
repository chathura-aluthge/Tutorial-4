// A PhysicalProduct IS-A Product because it has everything every product has (id, name, price)
// and only adds shipping details; it can be used anywhere a Product is expected.
// A ShoppingCart would NOT pass this test: a cart is not a product, it HAS products (a field, not extends).
package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product {

    private double weightKg;
    private String dimensions;

    // (a) empty no-arg constructor for Jackson
    public PhysicalProduct() {
    }

    // (b) full constructor: super(...) first, then the two new fields
    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    // (c) getters for the two new fields only — getName(), getPrice() and getId() are inherited
    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}
