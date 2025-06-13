import java.util.Scanner;
public class VotingAge{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        if(age >= 18){
            System.out.print("the person can vote.");
        } else {
            System.out.print("the person can't vote.");
        }
    }
}