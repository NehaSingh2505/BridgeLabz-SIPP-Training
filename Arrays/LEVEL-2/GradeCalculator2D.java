import java.util.Scanner;

public class GradeCalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3]; 
        double[] percentage = new double[n];
        String[] grade = new String[n];
        String[] remarks = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));
            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                System.out.print(subject + " marks: ");
                marks[i][j] = sc.nextInt();

                if (marks[i][j] < 0 || marks[i][j] > 100) {
                    System.out.println("Invalid marks, Enter again.");
                    j--; 
                }
            }

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = "A";
                remarks[i] = "Level 4, above agency-normalized standards";
            } else if (percentage[i] >= 70) {
                grade[i] = "B";
                remarks[i] = "Level 3, at agency-normalized standards";
            } else if (percentage[i] >= 60) {
                grade[i] = "C";
                remarks[i] = "Level 2, below, but approaching agency-normalized standards";
            } else if (percentage[i] >= 50) {
                grade[i] = "D";
                remarks[i] = "Level 1, well below agency-normalized standards";
            } else if (percentage[i] >= 40) {
                grade[i] = "E";
                remarks[i] = "Level 1-, too below agency-normalized standards";
            } else {
                grade[i] = "R";
                remarks[i] = "Remedial standards";
            }
        }

        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics: " + marks[i][0] + ", Chemistry: " + marks[i][1] + ", Maths: " + marks[i][2]);
            System.out.printf("Average: %.2f%%, Grade: %s, Remarks: %s\n\n", percentage[i], grade[i], remarks[i]);
        }

    }
}
