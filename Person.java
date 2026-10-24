package uk.ac.westminster.products_api;

/**
 * Week 1 class: a simple JavaBean.
 *
 * JavaBean convention:
 *   - fields are private (encapsulation)
 *   - a public no-argument constructor exists (Jackson needs it later)
 *   - each field is read through getX() and changed through setX()
 */
public class Person {

    private String name;
    private String email;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
