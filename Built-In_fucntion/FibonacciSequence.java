import java.util.*;

public class FibonacciSequence {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of terms for the Fibonacci sequence : ");
		int terms = sc.nextInt();
		
		if(terms <= 0) {
			System.out.println("Invalid integer.");
		} else {
			List<Integer> fibonacciList = generateFibonacci(terms);
			System.out.println("Fibonacci Sequence up to " + terms + " terms : ");
			System.out.println(fibonacciList);
		}
	}
	
	//Function using built-in List to store Fibonacci sequence
	public static List<Integer> generateFibonacci(int n) {
		List<Integer> sequence = new ArrayList<>();
		
		if (n >= 1) sequence.add(0);
		if (n >= 2) sequence.add(1);
		
		for(int i = 2; i < n; i++) {
			//Using built-in get() to access previous two numbers
			int next = sequence.get(i - 1) + sequence.get(i - 2);
			sequence.add(next);
		}
		return sequence;
	}

}
