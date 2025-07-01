import java.util.Random;

public class StudentMarksEvaluation {
    public static void main(String[] args) {
        int students = 10;
        int[][] pcmMarks = generateMarks(students);
        double[][] performance = calculatePerformance(pcmMarks);
        String[] grades = calculateGrades(performance);
        displayResult(pcmMarks, performance, grades);
    }

    public static int[][] generateMarks(int n) {
        Random rand = new Random();
        int[][] marks = new int[n][3];
        for (int i = 0; i < n; i++) {
            marks[i][0] = rand.nextInt(100);
            marks[i][1] = rand.nextInt(100);
            marks[i][2] = rand.nextInt(100);
        }
        return marks;
    }

    public static double[][] calculatePerformance(int[][] marks) {
        double[][] result = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percent = Math.round((total / 300.0) * 10000.0) / 100.0;
            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percent;
        }
        return result;
    }

    public static String[] calculateGrades(double[][] performance) {
        String[] grades = new String[performance.length];
        for (int i = 0; i < performance.length; i++) {
            double percent = performance[i][2];
            if (percent >= 80) grades[i] = "A";
            else if (percent >= 70) grades[i] = "B";
            else if (percent >= 60) grades[i] = "C";
            else if (percent >= 50) grades[i] = "D";
            else if (percent >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    public static void displayResult(int[][] marks, double[][] performance, String[] grades) {
        System.out.println("ID\tPhy\tChem\tMath\tTotal\tAvg\tPercent\tGrade");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f%%\t%s\n",
                (i + 1),
                marks[i][0], marks[i][1], marks[i][2],
                performance[i][0], performance[i][1], performance[i][2],
                grades[i]);
        }
    }
}
