class Book {
    String title, author, genre;
    int id;
    boolean available;
    Book prev, next;

    public Book(String title, String author, String genre, int id, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.available = available;
    }
}

class Library {
    private Book head, tail;

    public void addAtBeginning(String t, String a, String g, int id, boolean status) {
        Book b = new Book(t, a, g, id, status);
        if (head == null) {
            head = tail = b;
        } else {
            b.next = head;
            head.prev = b;
            head = b;
        }
    }

    public void addAtEnd(String t, String a, String g, int id, boolean status) {
        Book b = new Book(t, a, g, id, status);
        if (tail == null) {
            head = tail = b;
        } else {
            tail.next = b;
            b.prev = tail;
            tail = b;
        }
    }

    public void addAtPosition(String t, String a, String g, int id, boolean status, int pos) {
        if (pos <= 1 || head == null) {
            addAtBeginning(t, a, g, id, status);
            return;
        }
        Book b = new Book(t, a, g, id, status);
        Book temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp == null || temp.next == null) {
            addAtEnd(t, a, g, id, status);
            return;
        }
        b.next = temp.next;
        b.prev = temp;
        temp.next.prev = b;
        temp.next = b;
    }

    public void removeById(int id) {
        Book temp = head;
        while (temp != null && temp.id != id) temp = temp.next;
        if (temp == null) return;
        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void updateAvailability(int id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.available = status;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println(temp.author + ", " + temp.genre + ", " + temp.available);
            }
            temp = temp.next;
        }
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println(temp.title + ", " + temp.genre + ", " + temp.available);
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.title + ", " + temp.author + ", " + temp.genre + ", " + temp.available);
            temp = temp.next;
        }
    }

    public void displayBackward() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.title + ", " + temp.author + ", " + temp.genre + ", " + temp.available);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books: " + count);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addAtBeginning("1984", "Orwell", "Dystopia", 1, true);
        lib.addAtEnd("Hamlet", "Shakespeare", "Drama", 2, false);
        lib.addAtPosition("The Alchemist", "Coelho", "Fiction", 3, true, 2);
        lib.displayForward();
        lib.updateAvailability(2, true);
        lib.removeById(1);
        lib.displayBackward();
        lib.countBooks();
    }
}
