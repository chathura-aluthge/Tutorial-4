package uk.ac.westminster.products_api;

import java.util.ArrayList;
import java.util.List;

/*
 * The IS-A question: is a BundleProduct really a Product?
 *
 * For IS-A: the shop sells a bundle exactly like any other item. It has an id, a name and its own
 * price (often a discount), it sits in the same catalogue, and a customer can buy it anywhere a
 * Product is expected. "A bundle is a product" sounds true in plain English.
 *
 * Against: most of what makes a bundle a bundle is the list of items inside it. That part is HAS-A
 * (composition), which is why `items` is a field and not another extends.
 *
 * Verdict: both are true at once. A bundle IS-A Product (it is sold as one) and HAS-A list of
 * Products (its contents). extends models the first, the field models the second, so this design
 * is defensible. If the shop never sold bundles as single items, a plain Bundle class with a
 * List<Product> field and no extends would be the better choice.
 */
public class BundleProduct extends Product {

    private List<Product> items = new ArrayList<>();

    public BundleProduct() {
    }

    public BundleProduct(Long id, String name, double price, List<Product> items) {
        super(id, name, price);
        this.items = new ArrayList<>(items);   // copy, so the caller's list cannot change ours
    }

    // Read-only view: callers can look at the items but not add or remove them directly
    public List<Product> getItems() {
        return List.copyOf(items);
    }
}
