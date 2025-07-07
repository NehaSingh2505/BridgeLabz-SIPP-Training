package linkedlist;

class Ticket {
    int ticketId;
    String customer, movie, seat, time;
    Ticket next;

    public Ticket(int ticketId, String customer, String movie, String seat, String time) {
        this.ticketId = ticketId;
        this.customer = customer;
        this.movie = movie;
        this.seat = seat;
        this.time = time;
    }
}

class TicketSystem {
    private Ticket head = null;

    public void addTicket(int id, String cust, String mov, String seat, String time) {
        Ticket t = new Ticket(id, cust, mov, seat, time);
        if (head == null) {
            head = t;
            t.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = t;
            t.next = head;
        }
    }

    public void removeTicket(int id) {
        if (head == null) return;
        if (head.ticketId == id && head.next == head) {
            head = null;
            return;
        }
        Ticket temp = head, prev = null;
        do {
            if (temp.ticketId == id) {
                if (temp == head) {
                    Ticket last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void displayTickets() {
        if (head == null) return;
        Ticket temp = head;
        do {
            System.out.println(temp.ticketId + ", " + temp.customer + ", " + temp.movie + ", " + temp.seat + ", " + temp.time);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByCustomer(String name) {
        if (head == null) return;
        Ticket temp = head;
        do {
            if (temp.customer.equalsIgnoreCase(name)) {
                System.out.println(temp.ticketId + ", " + temp.movie + ", " + temp.seat + ", " + temp.time);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByMovie(String name) {
        if (head == null) return;
        Ticket temp = head;
        do {
            if (temp.movie.equalsIgnoreCase(name)) {
                System.out.println(temp.ticketId + ", " + temp.customer + ", " + temp.seat + ", " + temp.time);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void totalTickets() {
        if (head == null) {
            System.out.println("Total: 0");
            return;
        }
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total: " + count);
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        TicketSystem ts = new TicketSystem();
        ts.addTicket(1, "Alice", "Oppenheimer", "A1", "6PM");
        ts.addTicket(2, "Bob", "Barbie", "B2", "7PM");
        ts.addTicket(3, "Charlie", "Oppenheimer", "C3", "9PM");
        ts.displayTickets();
        ts.searchByCustomer("Alice");
        ts.searchByMovie("Oppenheimer");
        ts.removeTicket(2);
        ts.displayTickets();
        ts.totalTickets();
    }
}
