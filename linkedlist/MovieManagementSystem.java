package linkedlist;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev, next;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

class MovieManager {
    private Movie head, tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void searchByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + ", " + temp.year + ", " + temp.rating);
            }
            temp = temp.next;
        }
    }

    public void searchByRating(double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + ", " + temp.director + ", " + temp.year);
            }
            temp = temp.next;
        }
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + ", " + temp.director + ", " + temp.year + ", " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayBackward() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + ", " + temp.director + ", " + temp.year + ", " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieManager manager = new MovieManager();
        manager.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        manager.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        manager.addAtPosition("The Dark Knight", "Christopher Nolan", 2008, 9.0, 2);
        manager.displayForward();
        System.out.println("Reverse:");
        manager.displayBackward();
        manager.updateRating("Interstellar", 9.1);
        manager.removeByTitle("Inception");
        System.out.println("After updates:");
        manager.displayForward();
        System.out.println("Search by Director:");
        manager.searchByDirector("Christopher Nolan");
        System.out.println("Search by Rating:");
        manager.searchByRating(9.1);
    }
}
