package uk.ac.westminster.products_api;

public class Customer {

    // static = one shared copy for the whole class, not one per Customer object
    private static int customerCount = 0;

    private Long id;
    private String name;
    private String email;
    private Address address;
    private String[] tags = new String[0];

    public Customer() {
        customerCount++;
    }

    public Customer(Long id, String name, String email, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        customerCount++;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public Address getAddress() { return address; }

    // Return a copy so callers cannot change the array inside this object
    public String[] getTags() { return tags.clone(); }

    public void setTags(String[] tags) {
        this.tags = (tags == null) ? new String[0] : tags.clone();
    }

    public static int getCustomerCount() { return customerCount; }
}
