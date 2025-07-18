import java.util.LinkedList;
//created abstract class Task
abstract class Task {
    String taskDescription;

    Task(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    abstract void execute();

    @Override
    public String toString() {
        return taskDescription;
    }
}
// Concrete classes for different types of tasks

class Meeting extends Task {
    Meeting(String taskDescription) {
        super(taskDescription);
    }

    @Override
    void execute() {
        System.out.println("Executing meeting task: " + taskDescription);
    }
}

class Workout extends Task {
    Workout(String taskDescription) {
        super(taskDescription);
    }

    @Override
    void execute() {
        System.out.println("Executing workout task: " + taskDescription);
    }
}

class CodingSession extends Task {
    CodingSession(String taskDescription) {
        super(taskDescription);
    }

    @Override
    void execute() {
        System.out.println("Executing coding session task: " + taskDescription);
    }
}
// DailyTaskPlanner class to manage tasks
public class DailyTaskPlanner {
    static LinkedList<Task> taskList = new LinkedList<>();

    public static void main(String[] args) {
        taskList.add(new Meeting("Team sync-up at 10 AM"));
        taskList.add(new Workout("Cardio session"));
        taskList.add(new CodingSession("Build Java project"));

        executeAllTasks();
        searchTask("java");
    }

    static void executeAllTasks() {
        for (Task task : taskList) {
            task.execute();
        }
    }

    static void searchTask(String keyword) {
        System.out.println("\nSearching for: " + keyword);
        for (Task t : taskList) {
            if (t.taskDescription.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found → " + t);
            }
        }
    }
}
