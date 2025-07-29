import java.util.*;

public class VotingSystem {

    static HashMap<String, Integer> voteCount = new HashMap<>();
    static LinkedHashMap<String, String> voteLog = new LinkedHashMap<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeCandidates();

        int choice;
        do {
            System.out.println("\n=== Voting System Menu ===");
            System.out.println("1. Cast Vote");
            System.out.println("2. View Vote Log (Voter → Candidate)");
            System.out.println("3. View Results (Sorted by Candidate Name)");
            System.out.println("4. View Raw Vote Count (Unsorted)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> castVote();
                case 2 -> viewVoteLog();
                case 3 -> viewResultsSorted();
                case 4 -> viewRawResults();
                case 0 -> System.out.println("Exiting Voting System.");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    static void initializeCandidates() {
        voteCount.put("Alice", 0);
        voteCount.put("Bob", 0);
        voteCount.put("Charlie", 0);
    }

    static void castVote() {
        System.out.print("Enter Voter ID: ");
        String voter = sc.nextLine();

        if (voteLog.containsKey(voter)) {
            System.out.println("You have already voted!");
            return;
        }

        System.out.println("Candidates: " + voteCount.keySet());
        System.out.print("Enter Candidate Name: ");
        String candidate = sc.nextLine();

        if (!voteCount.containsKey(candidate)) {
            System.out.println("Invalid candidate.");
            return;
        }

        // Record vote
        voteLog.put(voter, candidate);
        voteCount.put(candidate, voteCount.get(candidate) + 1);
        System.out.println("Vote cast successfully!");
    }

    static void viewVoteLog() {
        if (voteLog.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }

        System.out.println("\n🗳️ Vote Log (in order of voting):");
        for (Map.Entry<String, String> entry : voteLog.entrySet()) {
            System.out.println("Voter " + entry.getKey() + " → " + entry.getValue());
        }
    }

    static void viewResultsSorted() {
        if (voteCount.isEmpty()) {
            System.out.println("No candidates.");
            return;
        }

        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCount);
        System.out.println("\n📊 Voting Results (sorted by candidate):");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " votes");
        }
    }

    static void viewRawResults() {
        System.out.println("\n📊 Raw Vote Count:");
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " votes");
        }
    }
}
