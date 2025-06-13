import java.util.Scanner;
public class SmallestCheck{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = sc.nextInt();
        System.out.println("Enter the second number: ");    
        int num2 = sc.nextInt();
        System.out.println("Enter the third number: ");
        int num3 = sc.nextInt();
        if(num1<num2 && num1 <num3){
            System.out.print("First number is the smallest among three numbers" );
        }   
        else{
            System.out.print("First number is not the smallest among three numbers" );
        }

    }
}