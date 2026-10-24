package uk.ac.westminster.products_api;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Parent of the product hierarchy: holds what EVERY product has.
 *
 * DEDUCTION lets Jackson pick the subclass for a POST body from its fields:
 * downloadUrl / fileSizeMB  -> DigitalProduct
 * weightKg / dimensions     -> PhysicalProduct
 * items                     -> BundleProduct (Tutorial 4 stretch)
 * only id / name / price    -> plain Product (defaultImpl)
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = Product.class)
@JsonSubTypes({
        @JsonSubTypes.Type(DigitalProduct.class),
        @JsonSubTypes.Type(PhysicalProduct.class),
        @JsonSubTypes.Type(BundleProduct.class)
})
public class Product {

    private Long id;
    private String name;
    private double price;

    public Product() {}

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public void setId(Long id)          { this.id = id; }
    public void setName(String name)    { this.name = name; }
    public void setPrice(double price)  { this.price = price; }
}
