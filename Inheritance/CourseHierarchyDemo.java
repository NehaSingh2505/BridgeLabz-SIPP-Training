
class Course {
    protected String courseName;
    protected int duration; 

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Is Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; 

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double calculateFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee After Discount: $" + calculateFinalFee());
    }
}

public class CourseHierarchyDemo {
    public static void main(String[] args) {
        System.out.println("=== Course Example ===");
        Course course = new Course("Basic Java", 20);
        course.displayInfo();

        System.out.println("\n=== Online Course Example ===");
        OnlineCourse onlineCourse = new OnlineCourse("Advanced Java", 40, "Udemy", true);
        onlineCourse.displayInfo();

        System.out.println("\n=== Paid Online Course Example ===");
        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Fullstack Development", 100, "Coursera", true, 499.99, 15);
        paidOnlineCourse.displayInfo();
    }
}
