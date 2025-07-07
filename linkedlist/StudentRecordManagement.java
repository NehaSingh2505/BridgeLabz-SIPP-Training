class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    private Student head;

    public void addAtBeginning(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addAtPosition(int roll, String name, int age, char grade, int position) {
        Student newStudent = new Student(roll, name, age, grade);
        if (position <= 1 || head == null) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteByRollNumber(int roll) {
        if (head == null) return;
        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    public Student searchByRollNumber(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void updateGrade(int roll, char newGrade) {
        Student temp = searchByRollNumber(roll);
        if (temp != null) {
            temp.grade = newGrade;
        }
    }

    public void displayAll() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        list.addAtBeginning(101, "Alice", 20, 'A');
        list.addAtEnd(102, "Bob", 21, 'B');
        list.addAtPosition(103, "Charlie", 22, 'C', 2);
        list.displayAll();
        System.out.println("After deleting roll 102:");
        list.deleteByRollNumber(102);
        list.displayAll();
        System.out.println("Search for roll 103:");
        Student s = list.searchByRollNumber(103);
        if (s != null) {
            System.out.println("Found: " + s.name);
        }
        System.out.println("After updating grade of roll 103:");
        list.updateGrade(103, 'A');
        list.displayAll();
    }
}
