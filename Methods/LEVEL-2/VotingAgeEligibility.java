import java.util.Scanner;

public class VotingAgeEligibility {

    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false; 
        }
        return age >= 18; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       VotingAgeEligibility checker = new VotingAgeEligibility();

        int[] studentAges = new int[10];

        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();

            if (checker.canStudentVote(studentAges[i])) {
                System.out.println("Student " + (i + 1) + " is eligible to vote. ");
            } else {
                System.out.println("Student " + (i + 1) + " is NOT eligible to vote. ");
            }
        }

        scanner.close();
    }
}
