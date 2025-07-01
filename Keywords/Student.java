
class Student {
    static String universityName = "GLA University";
    static int totalStudents = 0;

    final int rollNumber;
    String name, grade;

    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void display() {
        if (this instanceof Student) {
            System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", Grade: " + grade);
        }
    }
}

