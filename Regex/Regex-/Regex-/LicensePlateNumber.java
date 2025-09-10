import java.util.Scanner;

public class LicensePlateNumber {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter license plate number : ");
        String plate = sc.nextLine();
        
        String regex = "^[A-Z]{2}[0-9]{4}$";
        
        if (plate.matches(regex)) {
            System.out.println("\"" + plate + "\" → Valid");
        } else {
            System.out.println("\"" + plate + "\" → Invalid");
        }
    }
}