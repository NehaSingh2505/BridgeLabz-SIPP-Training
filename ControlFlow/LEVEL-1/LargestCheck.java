import java.util.Scanner;
public class LargestCheck{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = sc.nextInt();    
        System.out.println("Enter the second number: ");
        int num2 = sc.nextInt();
        System.out.println("Enter the third number: ");
        int num3 = sc.nextInt();
        if(num1>num2 && num1 >num3){
            System.out.print("First number is the largest among three numbers" );
        }   
         if (num2>num1 && num2 >num3){
            System.out.print(" number is not the largest among three numbers" );
        }
        if (num3 > num1 && num3 > num2) {
            System.out.print("Third number is the largest among three numbers");
        } else {
            System.out.print("None of the numbers is the largest among three numbers");
        }


    }
}