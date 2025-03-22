import java.util.List;
import java.util.Optional;

public class Company {

    private String name;
    private List<Employee> employees;

    public Company(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void listAllEmployees() {
        employees.forEach(System.out::println);
    }

    public Optional<Company> findByName(String name, List<Company> companies) {
        return companies.stream().filter(company -> company.getName().equals(name)).findFirst();
    }
}
