import java.util.Scanner;

public class HeightOfTeamPlayers {
        
            public static void main(String[] args) {
                double[] heightOfPlayer = new double[11];
                double sum = 0.0;
                Scanner sc = new Scanner(System.in);
        
                System.out.println("Enter the heights of 11 football players : ");
                for (int i = 0; i < heightOfPlayer.length; i++) {
                    System.out.print("Player " + (i + 1) + ": ");
                    heightOfPlayer[i] = sc.nextDouble();
                    sum += heightOfPlayer[i];
                }
        
                double mean = sum / heightOfPlayer.length;
                System.out.printf("The mean height of the football team is: %.2f cm\n", mean);
        
            }
    }
