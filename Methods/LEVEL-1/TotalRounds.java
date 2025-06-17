import java.util.Scanner;
public class TotalRounds{
    public static double TotalRoundsCalculator(int side1,int side2,int side3){
        int perimeter=side1+side2+side3;
        double totalDistance=5000.00; 
        double rounds=totalDistance/perimeter;
        return rounds;

}
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the first side of the triangular park (in meters):");
    int side1=sc.nextInt();
    System.out.println("enter the second side of the triangular park :");
    int side2=sc.nextInt();
    System.out.println("enter the third side of the triangular park :");
    int side3=sc.nextInt();
    double totalRounds=TotalRounds.TotalRoundsCalculator(side1,side2,side3);
    System.out.println("Total rounds possible in the triangular park : " + totalRounds);
}

}