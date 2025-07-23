import java.util.ArrayList;
import java.util.List;
abstract class CourseType{
    private String courseName;
    public CourseType(String courseName){
        this.courseName=courseName;
    }
    public String getCourseName() {
        return courseName;
    }
    public abstract void showEvaluationMethod();
}
class ExamCourse extends CourseType{
    public ExamCourse(String courseName){
        super(courseName);
    }
    public void showEvaluationMethod() {
        System.out.println("Evaluation Method for " + getCourseName() + ": Written Exam");
    }
}
class AssignmentCourse extends CourseType{
    public AssignmentCourse(String courseName){
        super(courseName);
    }
    public void showEvaluationMethod() {
        System.out.println("Evaluation Method for " + getCourseName() + ": Assignments");
    }
}
class ResearchCourse extends CourseType{
    public ResearchCourse(String courseName){
        super(courseName);
    }
    public void showEvaluationMethod() {
        System.out.println("Evaluation Method for " + getCourseName() + ": Research Project");
    }
}
class Course <T extends CourseType>{
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseType.getCourseName());
        courseType.showEvaluationMethod();
    }
    public T getCourseType() {
        return courseType;
    }
}
public class UniversityCourseManagementSystem{
    public static void displayAllCourses(List<? extends CourseType> courseList) {
        for (CourseType course : courseList) {
            course.showEvaluationMethod();
        }
    }

    public static void main(String[] args) {
        List<Course<? extends CourseType>> allCourses = new ArrayList<>();

        allCourses.add(new Course<>(new ExamCourse("Mathematics")));
        allCourses.add(new Course<>(new AssignmentCourse("Software Engineering")));
        allCourses.add(new Course<>(new ResearchCourse("AI Research")));

       // ...existing code...
System.out.println("=== Course Evaluations ===");
for (Course<? extends CourseType> course : allCourses) {
    course.displayCourseDetails();
}
// ...existing code...
    }
}
