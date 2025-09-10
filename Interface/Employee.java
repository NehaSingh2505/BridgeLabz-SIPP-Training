interface BackupSerializable {
    // Marker Interface (no methods)
}

class Employee implements BackupSerializable {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Product {
    String code;
    double price;

    Product(String code, double price) {
        this.code = code;
        this.price = price;
    }
}

class BackupProcessor {
    public static void backup(Object obj) {
        if (obj instanceof BackupSerializable) {
            System.out.println("Backing up : " + obj.getClass().getSimpleName());
        } else {
            System.out.println("Cannot backup : " + obj.getClass().getSimpleName() + " (Not Serializable)");
        }
    }
}