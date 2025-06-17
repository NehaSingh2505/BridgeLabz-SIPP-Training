import java.util.Scanner;
public class SmallestLargestNumber{
    public static int[] findSmallestAndLargest(int number1, int number2, int number3){
        int smallestNumber= Math.min(Math.min(number1, number2), number3);
        int largestNumber= Math.max(Math.max(number1, number2), number3);
        return new int[]{smallestNumber, largestNumber};


    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first number: ");
        int number1 = sc.nextInt(); 
        System.out.println("Enter second number: ");
        int number2 = sc.nextInt();
        System.out.println("Enter third number: ");
        int number3 = sc.nextInt();
        int[] result = SmallestLargestNumber.findSmallestAndLargest(number1, number2, number3);
        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);

    }

}