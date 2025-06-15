import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age and height: ");
        int amarAge = sc.nextInt(); 
        double amarHeight = sc.nextDouble();
        System.out.print("Enter Akbar's age and height: ");
        int akbarAge = sc.nextInt();
         double akbarHeight = sc.nextDouble();
        System.out.print("Enter Anthony's age and height: ");
        int anthonyAge = sc.nextInt();
         double anthonyHeight = sc.nextDouble();

        String youngest = (amarAge <= akbarAge && amarAge<= anthonyAge) ? "Amar" : (akbarAge <= amarAge && akbarAge <= amarAge) ? "Akbar" : "Anthony";
        String tallest = ( amarHeight >= akbarHeight &&  amarHeight >= anthonyHeight) ? "Amar" : (akbarHeight >=  amarHeight && akbarHeight >= anthonyHeight) ? "Akbar" : "Anthony";

        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);

        sc.close();
    }
}

