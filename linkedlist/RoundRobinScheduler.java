
package linkedlist;

class Process {
    int id, burst, priority, remaining;
    Process next;

    public Process(int id, int burst, int priority) {
        this.id = id;
        this.burst = burst;
        this.remaining = burst;
        this.priority = priority;
    }
}

class RoundRobin {
    private Process head = null;

    public void addProcess(int id, int burst, int priority) {
        Process p = new Process(id, burst, priority);
        if (head == null) {
            head = p;
            p.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = p;
            p.next = head;
        }
    }

    public void simulate(int quantum) {
        if (head == null) return;
        int time = 0, completed = 0, totalWaiting = 0, totalTurnaround = 0;
        Process current = head, prev = null;
        int count = countProcesses();
        while (completed < count) {
            if (current.remaining > 0) {
                int exec = Math.min(current.remaining, quantum);
                time += exec;
                current.remaining -= exec;
                if (current.remaining == 0) {
                    completed++;
                    int turnaround = time;
                    int waiting = turnaround - current.burst;
                    totalWaiting += waiting;
                    totalTurnaround += turnaround;
                    prev = remove(current.id, prev);
                    current = (prev == null) ? head : prev.next;
                    continue;
                }
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Average Waiting Time: " + (totalWaiting / (double) count));
        System.out.println("Average Turnaround Time: " + (totalTurnaround / (double) count));
    }

    private int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    private Process remove(int id, Process prev) {
        if (head == null) return null;
        Process temp = head;
        if (head.id == id && head.next == head) {
            head = null;
            return null;
        }
        if (head.id == id) {
            Process last = head;
            while (last.next != head) last = last.next;
            head = head.next;
            last.next = head;
            return last;
        }
        do {
            if (temp.next.id == id) {
                temp.next = temp.next.next;
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        return temp;
    }

    public void display() {
        if (head == null) return;
        Process temp = head;
        do {
            System.out.println(temp.id + ", " + temp.burst + ", " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        RoundRobin rr = new RoundRobin();
        rr.addProcess(1, 6, 1);
        rr.addProcess(2, 8, 2);
        rr.addProcess(3, 7, 1);
        rr.addProcess(4, 3, 3);
        rr.display();
        rr.simulate(4);
    }
}
