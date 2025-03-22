import java.util.UUID;

public class Employee extends Person {

    private final UUID id;
    private Company company;

    public Employee(String firstName, String lastName, Address address, Company company) {
        super(firstName, lastName, address);
        this.id = UUID.randomUUID();
        this.company = company;
    }

    public UUID getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void changeCompany(Company newCompany) {
        company.getEmployees().remove(this);
        newCompany.addEmployee(this);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName + ", Address: " + address;
    }
}
