import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id; this.name = name; this.department = department; this.salary = salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Neha", "IT", 50000),
            new Employee(2, "Rahul", "HR", 45000)
        );

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
            oos.writeObject(employees);
            System.out.println("Employees saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"))) {
            List<Employee> list = (List<Employee>) ois.readObject();
            list.forEach(emp -> System.out.println(emp.id + " " + emp.name + " " + emp.department + " " + emp.salary));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
