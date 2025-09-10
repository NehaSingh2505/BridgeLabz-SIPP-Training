import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	
	static Scanner sc = new Scanner(System.in);
	static Random rdm = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Think of a number between 1 and 100.");
		System.out.println("I will try to guess it!");
		
		int low = 1;
		int high = 100;
		boolean guessCorrectly = false;
		
		while(!guessCorrectly && low <= high) {
			int guess = generateGuess(low, high);
			System.out.println("Is this your number " + guess + " ?");
			String feedback = getUserFeedback();
			
			if(feedback.equalsIgnoreCase("correct")) {
				System.out.println("Yay! I guessed your number correctly.");
				guessCorrectly = true;
			} else if (feedback.equalsIgnoreCase("low")) {
				low = guess + 1;
			} else if (feedback.equalsIgnoreCase("high")) {
				high = guess - 1;
			} else {
				System.out.println("Invalid input.");
			}
		}
		
		if(!guessCorrectly) {
			System.out.println("Hmm... Something went wrong or you changed your number!");
		}
	}
	
	//Method to generate a random guess between the current range
	public static int generateGuess(int low, int high) {
		return low + rdm.nextInt(high - low + 1);
	}
	
	//Method to receive user feedback
	public static String getUserFeedback() {
		System.out.print("Enter feedback (high/low/correct) : ");
		return sc.nextLine().trim().toLowerCase();
	}

}
