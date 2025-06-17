import java.util.Scanner;
public class MaximumHandshake{
    public static int MaximumHandshakeCalculator(int numberOfStudents){
        return(numberOfStudents*(numberOfStudents-1))/2;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of students: ");
        int numberOfStudents = sc.nextInt();
        int maximumHandshakes=MaximumHandshake.MaximumHandshakeCalculator(numberOfStudents);
        System.out.println("Maximum handshakes possible : " + maximumHandshakes);
    }
}