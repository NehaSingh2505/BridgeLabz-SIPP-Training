import java.util.Scanner;

public class MaximumOfThreeNumbers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = getInput("Enter the first number : ");
		int num2 = getInput("Enter the second number : ");
		int num3 = getInput("Enter the third number : ");
		
		int max = findMaximum(num1, num2, num3);
		
		System.out.println("The maximum of three numbers is : " + max);
	}
	
	//Function to get an integer input from the user
	public static int getInput(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str);
		return sc.nextInt();
	}
	
	//Function to find the maximum of three numbers 
	public static int findMaximum(int a, int b, int c) {
		int max = a;
		if(b > max) {
			max = b;
		} 
		if (c > max) {
			max = c;
		}
		return max;
	}

}
