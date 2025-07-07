class Item {
    String name;
    int id, quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
}

class Inventory {
    private Item head;

    public void addAtBeginning(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newItem;
    }

    public void addAtPosition(String name, int id, int qty, double price, int pos) {
        if (pos <= 1 || head == null) {
            addAtBeginning(name, id, qty, price);
            return;
        }
        Item newItem = new Item(name, id, qty, price);
        Item temp = head;
        for (int i = 1; i < pos - 1 && temp.next != null; i++) temp = temp.next;
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    public void updateQuantity(int id, int qty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = qty;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) System.out.println(temp.name + ", " + temp.quantity + ", " + temp.price);
            temp = temp.next;
        }
    }

    public void searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) System.out.println(temp.id + ", " + temp.quantity + ", " + temp.price);
            temp = temp.next;
        }
    }

    public void displayTotalValue() {
        Item temp = head;
        double total = 0;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    public void sortByNameAsc() {
        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if (i.name.compareTo(j.name) > 0) {
                    swap(i, j);
                }
            }
        }
    }

    public void swap(Item a, Item b) {
        String tempName = a.name;
        int tempId = a.id, tempQty = a.quantity;
        double tempPrice = a.price;
        a.name = b.name; a.id = b.id; a.quantity = b.quantity; a.price = b.price;
        b.name = tempName; b.id = tempId; b.quantity = tempQty; b.price = tempPrice;
    }

    public void display() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.name + ", " + temp.id + ", " + temp.quantity + ", " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addAtEnd("Pen", 1, 100, 5.0);
        inv.addAtBeginning("Notebook", 2, 50, 15.0);
        inv.addAtPosition("Eraser", 3, 80, 3.0, 2);
        inv.display();
        inv.updateQuantity(1, 120);
        inv.removeById(2);
        System.out.println("Sorted by Name:");
        inv.sortByNameAsc();
        inv.display();
        inv.displayTotalValue();
    }
}
