class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    Manager(int id, String dept, double salary) {
        super(id, dept, salary);
    }

    void display() {
        System.out.println("Employee ID: " + employeeID + ", Department: " + department + ", Salary: ₹" + getSalary());
    }
}
