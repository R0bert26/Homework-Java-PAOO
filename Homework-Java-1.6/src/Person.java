public class Person {

    protected String firstName;
    protected String lastName;
    protected Address address;

    public Person() {}

    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    void setAddress(Address address) {
        this.address = address;
    }
}
