interface Worker {
    void performDuties();
}

class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    public void performDuties() {
        System.out.println("\nRole: Chef");
        displayInfo();
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Preparing dishes and managing kitchen.");
    }
}

class Waiter extends Person implements Worker {
    private int tablesAssigned;

    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    public void performDuties() {
        System.out.println("\nRole: Waiter");
        displayInfo();
        System.out.println("Tables Assigned: " + tablesAssigned);
        System.out.println("Duties: Taking orders and serving food.");
    }
}

public class RestaurantManagementDemo {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 1, "Italian Cuisine");
        Waiter waiter = new Waiter("John", 2, 5);

        chef.performDuties();
        waiter.performDuties();
    }
}
