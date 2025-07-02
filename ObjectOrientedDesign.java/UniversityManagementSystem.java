import java.util.*;

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    String name;

    Department(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Department: " + name);
    }
}

class University {
    String name;
    ArrayList<Department> departments;

    University(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }

    void addDepartment(Department d) {
        departments.add(d);
    }

    void showDepartments() {
        System.out.println("University: " + name);
        for (Department d : departments) {
            d.display();
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        University u = new University("XYZ University");

        Department d1 = new Department("Engineering");
        Department d2 = new Department("Management");

        Faculty f1 = new Faculty("Dr. Verma");
        Faculty f2 = new Faculty("Dr. Sharma");

        u.addDepartment(d1);
        u.addDepartment(d2);

        u.showDepartments();
        f1.display();
        f2.display();
    }
}
