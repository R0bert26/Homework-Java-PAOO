import java.util.UUID;

public class Student extends Person{

    private final UUID id;
    private Integer year;

    public Student(String firstName, String lastName, Address address, Integer year) {
        super(firstName, lastName, address);
        this.id = UUID.randomUUID();
        this.year = year;
    }

    public UUID getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nAddress: " + address +
                "\nYear: " + year + "\n";

    }
}
