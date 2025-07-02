import java.util.*;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Employee: " + name);
    }
}

class Department {
    String name;
    ArrayList<Employee> employees;

    Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    void addEmployee(Employee e) {
        employees.add(e);
    }

    void showEmployees() {
        System.out.println("Department: " + name);
        for (Employee e : employees) {
            e.display();
        }
    }
}

class Company {
    String name;
    ArrayList<Department> departments;

    Company(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }

    void addDepartment(Department d) {
        departments.add(d);
    }

    void showCompanyStructure() {
        System.out.println("Company: " + name);
        for (Department d : departments) {
            d.showEmployees();
        }
    }
}

public class CompanyStructure {
    public static void main(String[] args) {
        Company c = new Company("TechCorp");

        Department d1 = new Department("IT");
        d1.addEmployee(new Employee("Amit"));
        d1.addEmployee(new Employee("Rahul"));

        Department d2 = new Department("HR");
        d2.addEmployee(new Employee("Sneha"));

        c.addDepartment(d1);
        c.addDepartment(d2);

        c.showCompanyStructure();
    }
}
