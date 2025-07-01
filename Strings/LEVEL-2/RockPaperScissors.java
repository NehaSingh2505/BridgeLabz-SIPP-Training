import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games to play: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[][] results = new String[n][3];
        int userWins = 0, computerWins = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("\nGame " + (i + 1) + " - Enter rock/paper/scissors: ");
            String userChoice = sc.nextLine().toLowerCase();
            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
            results[i][0] = userChoice;
            results[i][1] = computerChoice;
            results[i][2] = winner;
        }
        displayResults(results, userWins, computerWins, n);
    }

    public static String getComputerChoice() {
        int val = (int)(Math.random() * 3);
        if (val == 0) return "rock";
        else if (val == 1) return "paper";
        else return "scissors";
    }

    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("paper") && computer.equals("rock")) ||
            (user.equals("scissors") && computer.equals("paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    public static void displayResults(String[][] data, int userWins, int compWins, int totalGames) {
        System.out.println("\nGame\tUser\tComputer\tWinner");
        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + "\t" + data[i][0] + "\t" + data[i][1] + "\t\t" + data[i][2]);
        }
        int draws = totalGames - userWins - compWins;
        double userPercent = (userWins * 100.0) / totalGames;
        double compPercent = (compWins * 100.0) / totalGames;
        System.out.println("\nSummary:");
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + compWins);
        System.out.println("Draws: " + draws);
        System.out.printf("User Win %%: %.2f%%\n", userPercent);
        System.out.printf("Computer Win %%: %.2f%%\n", compPercent);
    }
}
