class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name      : " + name);
        System.out.println("Salary    : Rs." + salary);
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Pragati Gupta", 101, 55000.50);
        emp.displayDetails();
    }
}
