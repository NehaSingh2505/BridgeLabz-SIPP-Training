import java.util.Scanner;

public class HexCodeColor {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter hex color code : ");
        String colorCode = sc.nextLine();
        
        String regex = "^#[A-Fa-f0-9]{6}$";
        
        if (colorCode.matches(regex)) {
            System.out.println("\"" + colorCode + "\" → Valid");
        } else {
            System.out.println("\"" + colorCode + "\" → Invalid");
        }
    }
}