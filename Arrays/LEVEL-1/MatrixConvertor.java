import java.util.Scanner;

public class MatrixConvertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of rows: ");
        int rowCount = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int colCount = sc.nextInt();

        
        int[][] matrix = new int[rowCount][colCount];

        System.out.println("Enter elements:");
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }

        int[] array = new int[rowCount * colCount];
        int index = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                array[index++] = matrix[i][j];
            }
        }

        System.out.println("\n1D Array elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Index " + i + ": " + array[i]);
        }

        sc.close();
    }
}
