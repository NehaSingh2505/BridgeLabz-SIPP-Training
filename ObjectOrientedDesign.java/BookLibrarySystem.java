import java.util.*;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println(title + " by " + author);
    }
}

class Library {
    String name;
    ArrayList<Book> books;

    Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void showBooks() {
        System.out.println("Books in " + name + ":");
        for (Book b : books) {
            b.display();
        }
    }
}

public class BookLibrarySystem{
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "Alice");
        Book b2 = new Book("OOP Concepts", "Bob");

        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("City Library");

        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b1);

        lib1.showBooks();
        lib2.showBooks();
    }
}
