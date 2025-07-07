package linkedlist;
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

class TaskManager {
    private Task head = null;
    private Task current = null;

    public void addAtBeginning(int id, String name, int priority, String date) {
        Task newTask = new Task(id, name, priority, date);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    public void addAtEnd(int id, String name, int priority, String date) {
        Task newTask = new Task(id, name, priority, date);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addAtPosition(int id, String name, int priority, String date, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(id, name, priority, date);
            return;
        }
        Task newTask = new Task(id, name, priority, date);
        Task temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void removeById(int id) {
        if (head == null) return;
        if (head.taskId == id && head.next == head) {
            head = null;
            current = null;
            return;
        }
        Task prev = null;
        Task temp = head;
        do {
            if (temp.taskId == id) {
                if (temp == head) {
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                if (temp == current) {
                    current = current.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentTask() {
        if (current != null) {
            System.out.println(current.taskId + ", " + current.taskName + ", " + current.priority + ", " + current.dueDate);
        }
    }

    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
        }
    }

    public void displayAllTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println(temp.taskId + ", " + temp.taskName + ", " + temp.priority + ", " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println(temp.taskId + ", " + temp.taskName + ", " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addAtEnd(1, "Design Module", 2, "2025-07-08");
        manager.addAtBeginning(2, "Fix Bugs", 1, "2025-07-07");
        manager.addAtPosition(3, "Write Report", 3, "2025-07-10", 2);
        manager.displayAllTasks();
        System.out.println("Current Task:");
        manager.viewCurrentTask();
        manager.moveToNextTask();
        System.out.println("After Next Task:");
        manager.viewCurrentTask();
        manager.removeById(2);
        System.out.println("After Removing Task 2:");
        manager.displayAllTasks();
        System.out.println("Search by Priority 3:");
        manager.searchByPriority(3);
    }
}
