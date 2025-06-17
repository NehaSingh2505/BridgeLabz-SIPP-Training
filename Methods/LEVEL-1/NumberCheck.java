import java.util.Scanner;
public class NumberCheck{
    public static int checkNumberNature(int number){
        if(number>0){
            return 1;
        }
        else if(number <0){
            return -1;
        }
        else{
            return 0;
        }
    

}
public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter a number: ");
    int number=sc.nextInt();
    int output=NumberCheck.checkNumberNature(number);
    System.out.println("Output: " + output);

}
}