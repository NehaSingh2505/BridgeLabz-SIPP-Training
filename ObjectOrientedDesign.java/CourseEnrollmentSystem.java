import java.util.*;

class Course {
    String name;
    ArrayList<Student> students;

    Course(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    void enrollStudent(Student s) {
        students.add(s);
    }

    void showEnrolled() {
        System.out.println("Course: " + name);
        for (Student s : students) {
            System.out.println("Student: " + s.name);
        }
    }
}

class Student {
    String name;
    ArrayList<Course> courses;

    Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    void enroll(Course c) {
        courses.add(c);
        c.enrollStudent(this);
    }

    void showCourses() {
        System.out.println(name + " enrolled in:");
        for (Course c : courses) {
            System.out.println(c.name);
        }
    }
}

class School {
    String name;
    ArrayList<Student> students;

    School(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    void addStudent(Student s) {
        students.add(s);
    }
}

public class CourseEnrollmentSystem {
    public static void main(String[] args) {
        School school = new School("ABC School");
        Student s1 = new Student("Ravi");
        Student s2 = new Student("Priya");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        s1.enroll(c1);
        s1.enroll(c2);
        s2.enroll(c1);

        school.addStudent(s1);
        school.addStudent(s2);

        s1.showCourses();
        c1.showEnrolled();
    }
}
