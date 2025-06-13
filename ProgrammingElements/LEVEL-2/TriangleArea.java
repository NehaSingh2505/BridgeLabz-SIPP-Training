
import java.util.Scanner;
public class TriangleArea{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the base of the triangle in cm: ");
        float base = sc.nextFloat();
        
        System.out.print("Enter the height of the triangle in cm: ");
        float height = sc.nextFloat();
        
        float areaCm = 0.5f * base * height;
        
        float baseInches = base / 2.54f;
        float heightInches = height / 2.54f;
        
        float areaInches = 0.5f * baseInches * heightInches;
        
        System.out.printf("The Area of the triangle in sq in is : %.2f and sq cm is : %.2f%n", areaInches, areaCm);
        
        sc.close();
    }
}