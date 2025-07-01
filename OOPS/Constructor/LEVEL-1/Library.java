public class Library {
    private String title;
    private String author;
    private double price;
    private boolean available;

    public Library(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have borrowed \"" + title + "\" by " + author);
        } else {
            System.out.println("Sorry, \"" + title + "\" is currently not available.");
        }
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: ₹" + price + ", Available: " + available);
    }
}
