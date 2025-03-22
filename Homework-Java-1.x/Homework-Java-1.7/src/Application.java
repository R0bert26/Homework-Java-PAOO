import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        Company company = new Company("Microsoft", new ArrayList<>());
        Employee employee = new Employee(
                "Alexandru",
                "Cicaldau",
                new Address("Craiova", "Bulevardul 1"),
                company
        );

        addEmployeesExample(company, employee);

        changeCompanyExample(employee, company);
    }

    private static void changeCompanyExample(Employee employee, Company company) {
        Company newCompany = new Company("Google", new ArrayList<>());
        employee.changeCompany(newCompany);

        System.out.println("\n\n" + newCompany.getName());
        newCompany.listAllEmployees();
        System.out.println("\n" + company.getName());
        company.listAllEmployees();
    }

    private static void addEmployeesExample(Company company, Employee employee) {
        System.out.println(company.getName());
        company.addEmployee(employee);
        company.listAllEmployees();
    }
}
