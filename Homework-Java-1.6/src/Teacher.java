import java.util.UUID;

public class Teacher extends Person{

    private final UUID id;
    private String discipline;

    public Teacher(String firstName, String lastName, Address address, String discipline) {
        super(firstName, lastName, address);
        this.id = UUID.randomUUID();
        this.discipline = discipline;
    }

    public UUID getId() {
        return id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "ID: " + this.id +
                "\nFirst Name: " + this.firstName +
                "\nLast Name: " + this.lastName +
                "\nAddress: " + this.address +
                "\nDiscipline: " + this.discipline + "\n";
    }
}
