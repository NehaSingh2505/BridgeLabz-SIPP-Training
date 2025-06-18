import java.util.Random;
import java.util.Scanner;

public class GradeCalculator {

    public static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            scores[i][0] = rand.nextInt(90) + 10; 
           scores[i][1] = rand.nextInt(90) + 10; 
            scores[i][2] = rand.nextInt(90) + 10; 
       }
        return scores;
    }

    public static Object[][] calculateResults(int[][] scores) {
        int n = scores.length;
        Object[][] results = new Object[n][6]; 

        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = Math.round((total / 3.0) * 100.0) / 100.0;
            double perc = Math.round((total / 300.0) * 10000.0) / 100.0;

            String grade, remark;

            if (perc >= 80) {
                grade = "A";
                remark = "Level 4, above agency-normalized standards";
            } else if (perc >= 70) {
                grade = "B";
                remark = "Level 3, at agency-normalized standards";
            } else if (perc >= 60) {
                grade = "C";
                remark = "Level 2, below but approaching standards";
            } else if (perc >= 50) {
                grade = "D";
                remark = "Level 1, well below standards";
            } else if (perc >= 40) {
                grade = "E";
                remark = "Level 1-, too below agency standards";
            } else {
                grade = "R";
                remark = "Remedial standards";
            }

            results[i][0] = total;
            results[i][1] = avg;
            results[i][2] = perc;
            results[i][3] = grade;
            results[i][4] = remark;
        }

        return results;
    }

    // Display the scorecard
    public static void displayScorecard(int[][] scores, Object[][] results) {
        System.out.println("S.No\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade\tRemarks");
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "\t" +
                    scores[i][0] + "\t" +
                    scores[i][1] + "\t\t" +
                    scores[i][2] + "\t" +
                    results[i][0] + "\t" +
                    results[i][1] + "\t" +
                    results[i][2] + "%\t\t" +
                    results[i][3] + "\t" +
                    results[i][4]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generateScores(n);
        Object[][] results = calculateResults(scores);
        displayScorecard(scores, results);

        sc.close();
    }
}
