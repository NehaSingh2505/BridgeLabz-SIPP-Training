import java.util.*;

interface Reservable {
    void reserveItem(String borrowerName, String contact);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrowerName;
    private String contactInfo;
    private boolean isReserved;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected void setBorrowerInfo(String borrowerName, String contactInfo) {
        this.borrowerName = borrowerName;
        this.contactInfo = contactInfo;
        this.isReserved = true;
    }

    protected String getMaskedBorrowerInfo() {
        if (!isReserved) return "Not Reserved";
        return "Reserved by: " + borrowerName + ", Contact: ****" + contactInfo.substring(contactInfo.length() - 4);
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21;
    }

    @Override
    public void reserveItem(String borrowerName, String contact) {
        setBorrowerInfo(borrowerName, contact);
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem(String borrowerName, String contact) {
        setBorrowerInfo(borrowerName, contact);
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem(String borrowerName, String contact) {
        setBorrowerInfo(borrowerName, contact);
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }
}

public class LibraryManagementSystem {
    public static void displayLibraryItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.println("==================================");
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                r.reserveItem("Niharika", "9567883X10");
                System.out.println("Availability: " + (r.checkAvailability() ? "Available" : "Reserved"));
            }
            System.out.println(((LibraryItem) item).getMaskedBorrowerInfo());
        }
    }

    public static void main(String[] args) {
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(new Book("B001", "Java Programming", "James Gosling"));
        libraryItems.add(new Magazine("M001", "Tech Monthly edition ", "Editorial Board"));
        libraryItems.add(new DVD("D001", "crystal OOP Concepts ", "Oracle"));

        displayLibraryItems(libraryItems);
    }
}
